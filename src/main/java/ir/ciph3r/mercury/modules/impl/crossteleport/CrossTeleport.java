package ir.ciph3r.mercury.modules.impl.crossteleport;

import co.aikar.commands.annotation.*;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.crossteleport.listeners.CrossTeleportListener;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("CrossTeleport|CrossTP|CTeleport|CTP")
public class CrossTeleport extends CommandModule {
    public CrossTeleport() {
        super("CrossTeleport", MercuryAPI.INSTANCE.getConfig().CROSS_TELEPORT_ENABLED);
        setCommandNameAndSyntax("/CrossTeleport", "<player>");
        addListeners(new CrossTeleportListener());

        if (MercuryAPI.INSTANCE.getConfig().CROSS_TELEPORT_ENABLED) registerBungeeListener();
    }

    private final String channelName = "mercury-ctp";

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.crossteleport")
    @CommandCompletion("@players")
    public void onCrossTeleport(Player player, String target) {
        Player onlineTarget = Bukkit.getPlayer(target);

        if (onlineTarget != null) {
            MercuryAPI.INSTANCE.getDepends().getVanish().teleport(player, onlineTarget);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().CROSS_TELEPORT_MESSAGE.replace("{player}", onlineTarget.getName()));
        } else {
            MercuryAPI.INSTANCE.getBungeeAPI().getPlayerList("ALL").whenCompleteAsync((playerList, err1) -> {
                if (playerList.stream().noneMatch(target::equalsIgnoreCase)) {
                    ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().NO_PLAYER_FOUND_SERVER.replace("{search}", target));
                } else {
                    MercuryAPI.INSTANCE.getBungeeAPI().getServers().whenCompleteAsync((serverList, err2) -> {
                        serverList.forEach(server -> {
                            MercuryAPI.INSTANCE.getBungeeAPI().getPlayerList(server).whenCompleteAsync((serverPlayers, err3) -> {
                                if (serverPlayers.stream().anyMatch(target::equalsIgnoreCase)) {
                                    Bukkit.getScheduler().runTaskLaterAsynchronously(MercuryAPI.INSTANCE.getPlugin(), () -> {
                                        byte[] data = (player.getName() + "," + target).getBytes();
                                        MercuryAPI.INSTANCE.getBungeeAPI().forward(server, channelName, data);
                                        MercuryAPI.INSTANCE.getBungeeAPI().connect(player, server);
                                    } , MercuryAPI.INSTANCE.getConfig().CROSS_TELEPORT_SEND_DELAY);
                                }
                            });
                        });
                    });
                }
            });
        }
    }

    private void registerBungeeListener() {
        MercuryAPI.INSTANCE.getBungeeAPI().registerForwardListener(channelName, (s, player, bytes) -> {
            String[] data = new String(bytes).split(",");
            String admin = data[0];
            String target = data[1];

            CrossTeleportListener.toBeTeleported.put(admin, target);
        });
    }
}
