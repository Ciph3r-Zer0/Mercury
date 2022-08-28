package ir.ciph3r.mercury.modules.impl.crossteleport;

import co.aikar.commands.annotation.*;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import ir.ciph3r.mercury.utility.runnables.CTPRunnable;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@CommandAlias("CrossTeleport|CrossTP|CTP")
public class CrossTeleport extends CommandModule {

    private final String channelName = "mercury-ctp";

    public CrossTeleport() {
        super("CrossTeleport", MercuryAPI.INSTANCE.getConfig().CROSS_TELEPORT_ENABLED);
        setCommandNameAndSyntax("/CrossTeleport", "<player>");

        if (MercuryAPI.INSTANCE.getConfig().CROSS_TELEPORT_ENABLED) registerBungeeListener();
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.crossteleport")
    @CommandCompletion("")
    public void onCrossTeleport(Player player, String target){
        MercuryAPI.INSTANCE.getBungeeAPI().getServers().whenComplete((servers, error) -> {
           for (String server : servers) {
               MercuryAPI.INSTANCE.getBungeeAPI().getPlayerList(server).whenComplete((players, error2) -> {
                  if (players.stream().anyMatch(target::equalsIgnoreCase)) {
                      byte[] data = (player.getName() + "," + target).getBytes();
                      MercuryAPI.INSTANCE.getBungeeAPI().connect(player, server);
                      MercuryAPI.INSTANCE.getBungeeAPI().forward(server, channelName, data);
                  } else {
                      ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().NO_PLAYER_FOUND_SERVER.replace("{search}", target));
                  }
               });
           }
        });
    }

    private void registerBungeeListener() {
        MercuryAPI.INSTANCE.getBungeeAPI().registerForwardListener(channelName, (s, player, bytes) -> {
            String[] data = Arrays.toString(bytes).split(",");
            String admin = data[0];
            String target = data[1];

            new CTPRunnable(admin, target).runTaskTimer(MercuryAPI.INSTANCE.getPlugin(), 0, 10);
        });
    }
}
