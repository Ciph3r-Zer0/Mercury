package ir.ciph3r.mercury.modules.crossteleport;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class CrossTeleport extends Model {

    public CrossTeleport(Mercury mercury) {
        super(mercury, "CrossTeleport", "CrossTeleport", mercury.getConfigFile().CROSS_TELEPORT_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.GAMEMODE))) {
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION);
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            Utils.sendColorizedMessage(sender, getMessages().CROSS_TELEPORT_USAGE);
        } else if (args.length == 1) {
            String targetName = args[0];

            System.out.println(Utils.isPlayerOnlineProxy(targetName));
            System.out.println(Utils.getProxyPlayerServerName(targetName));
        }
        return true;
    }
}
//    getMercury().bungeeAPI.getPlayerList("ALL").whenComplete((allPlayers, err) -> {
//                if (!(allPlayers.contains(targetName))) {
//
//                } else {
//                    getMercury().bungeeAPI.getServers().whenComplete((allServers, err1) -> {
//                        allServers.forEach(s -> {
//                            getMercury().bungeeAPI.getPlayerList(s).whenComplete((serverPlayers, err2) -> {
//                                if (serverPlayers.contains(targetName)) {
//                                    if (serverPlayers.contains(player.getName())) {
//                                        Player target = Bukkit.getPlayer(targetName);
//
//                                        player.teleport(target);
//                                    } else {
//                                        getMercury().bungeeAPI.connect(player, s);
//                                    }
//                                }
//                            });
//                        });
//                    });
//                }
//            });