package ir.ciph3r.mercury.modules;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.base.ModuleBase;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport extends ModuleBase {
    public Teleport(Mercury mercury) {
        super("Teleport", "Teleport", Config.TELEPORT_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.TELEPORT))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
            return true;
        }

        if (args.length == 0) {
            Utils.sendColorizedMessage(sender, Messages.TELEPORT_USAGE);
            return true;
        } else if (args.length == 1) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND);
                return true;
            } else {
                player.teleport(target);
                Utils.sendColorizedMessage(player, Messages.TELEPORT_SUCCESS_PLAYER.replace("{player}", target.getName()));
                return true;
            }
        } else if (args.length == 2) {
            if (!(sender.hasPermission(Perms.TELEPORT_OTHERS))) {
                Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
                return true;
            }
            Player target1 = Bukkit.getPlayer(args[0]);
            Player target2 = Bukkit.getPlayer(args[1]);

            if (target1 == null || target2 == null) {
                Utils.sendColorizedMessage(sender, Messages.PLAYER_NOT_FOUND);
                return true;
            } else {
                target1.teleport(target2);
                Utils.sendColorizedMessage(sender, Messages.TELEPORT_SUCCESS_OTHERS.replace("{player}", target1.getName()).replace("{target}", target2.getName()));
                return true;
            }
        } else if (args.length == 3) {
            Player player = (Player) sender;
            if (!(Utils.isNumeric(args[0]) || Utils.isNumeric(args[1]) || Utils.isNumeric(args[2]))) {
                Utils.sendColorizedMessage(player, Messages.TELEPORT_ARGS_NOT_NUMBER);
                return true;
            }
            Location location = new Location(player.getWorld(), Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            player.teleport(location);
            Utils.sendColorizedMessage(player, Messages.TELEPORT_SUCCESS_LOCATION.replace("{x}", args[0]).replace("{y}", args[1]).replace("{z}", args[2]));
            return true;
        } else if (args.length == 4) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(sender, Messages.PLAYER_NOT_FOUND);
                return true;
            }
            if (!(Utils.isNumeric(args[1]) || Utils.isNumeric(args[2]) || Utils.isNumeric(args[3]))) {
                Utils.sendColorizedMessage(sender, Messages.TELEPORT_ARGS_NOT_NUMBER);
                return true;
            }
            Location location = new Location(target.getWorld(), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            target.teleport(location);
            Utils.sendColorizedMessage(sender, Messages.TELEPORT_SUCCESS_OTHERS_LOCATION.replace("{player}", target.getName()).replace("{x}", args[1]).replace("{y}", args[2]).replace("{z}", args[3]));
            return true;
        }
        return true;
    }
}
