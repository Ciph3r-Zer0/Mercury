package ir.ciph3r.mercury.modules.crossteleport;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Universal;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CrossTeleport extends Model {

    public CrossTeleport(Mercury mercury) {
        super(mercury, "CrossTeleport", "CrossTeleport", mercury.getConfigFile().CROSS_TELEPORT_ENABLED);
        if (mercury.getConfigFile().CROSS_TELEPORT_ENABLED) handleConnect();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.CROSS_TELEPORT))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.CROSS_TELEPORT));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            getUniversal().sendColorizedMessage(sender, getMessages().CROSS_TELEPORT_USAGE);
        } else if (args.length == 1) {
            String targetName = args[0];

            getMercury().bungeeAPI.getPlayerList("ALL").whenComplete((allPlayers, err) -> {
                if (allPlayers.stream().noneMatch(targetName::equalsIgnoreCase)) {
                    getUniversal().sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
                } else {
                    getMercury().bungeeAPI.getServers().whenComplete((allServers, err1) -> {
                        allServers.forEach(s -> {
                            getMercury().bungeeAPI.getPlayerList(s).whenComplete((serverPlayers, err2) -> {
                                if (serverPlayers.stream().anyMatch(targetName::equalsIgnoreCase)) {
                                    if (serverPlayers.contains(player.getName())) {
                                        Player target = Bukkit.getPlayer(targetName);
                                        getMercury().vanish.vanishTeleport(player, target);

                                    } else {
                                        getMercury().bungeeAPI.connect(player, s);
                                        getMercury().vanish.vanishForward(player, targetName, s);
                                    }
                                }
                            });
                        });
                    });
                }
            });
        }
        return true;
    }

    private void handleConnect() {
        getMercury().bungeeAPI.registerForwardListener("mercury", (channelName, player, data) -> {
            String[] info = new String(data).split("-");
            Bukkit.getScheduler().runTaskLater(getMercury(), new Runnable() {
                @Override
                public void run() {
                    Player admin = Bukkit.getPlayer(info[0]);
                    Player target = Bukkit.getPlayer(info[1]);
                    if (!(admin == null)) {
                        if (target == null) {
                            getUniversal().sendColorizedMessage(admin, getMessages().PLAYER_NOT_FOUND.replace("{player}", info[1]));
                        } else {
                            getMercury().vanish.vanishTeleport(admin, target);
                        }
                    }
                }
            }, 20);
        });
    }
}
