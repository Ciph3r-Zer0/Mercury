package ir.ciph3r.mercury.modules.teleport;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport extends Model {
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
        Player player = (Player) sender;

        if (args.length == 0) {
            Utils.sendColorizedMessage(player, Messages.TELEPORT_USAGE);
            return true;
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND.replace("{player}", args[0]));
                return true;
            } else {
                player.teleport(target);
                Utils.sendColorizedMessage(player, Messages.TELEPORT_SUCCESS_PLAYER.replace("{player}", target.getName()));
                return true;
            }
        } else if (args.length == 2) {
            if (!(sender.hasPermission(Perms.TELEPORT_OTHERS))) {
                Utils.sendColorizedMessage(player, Messages.NO_PERMISSION);
                return true;
            }
            Player target1 = Bukkit.getPlayer(args[0]);
            Player target2 = Bukkit.getPlayer(args[1]);

            if (target1 == null) {
                Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND.replace("{player}", args[0]));
                return true;
            } else if (target2 == null) {
                Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND.replace("{player}", args[1]));
                return true;
            } else {
                target1.teleport(target2);
                Utils.sendColorizedMessage(player, Messages.TELEPORT_SUCCESS_OTHERS.replace("{player}", target1.getName()).replace("{target}", target2.getName()));
                return true;
            }
        } else if (args.length == 3) {
            if (!(Utils.isNumeric(args[0]) || Utils.isNumeric(args[1]) || Utils.isNumeric(args[2]))) {
                Utils.sendColorizedMessage(player, Messages.TELEPORT_ARGS_NOT_NUMBER);
                return true;
            }
            Location location = new Location(player.getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
            player.teleport(location);
            Utils.sendColorizedMessage(player, Messages.TELEPORT_SUCCESS_LOCATION.replace("{x}", args[0]).replace("{y}", args[1]).replace("{z}", args[2]));
            return true;
        } else if (args.length == 4) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND.replace("{player}", args[0]));
                return true;
            }
            if (!(Utils.isNumeric(args[1]) || Utils.isNumeric(args[2]) || Utils.isNumeric(args[3]))) {
                Utils.sendColorizedMessage(player, Messages.TELEPORT_ARGS_NOT_NUMBER);
                return true;
            }
            Location location = new Location(target.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
            target.teleport(location);
            Utils.sendColorizedMessage(player, Messages.TELEPORT_SUCCESS_OTHERS_LOCATION.replace("{player}", target.getName()).replace("{x}", args[1]).replace("{y}", args[2]).replace("{z}", args[3]));
            return true;
        }
        return true;
    }
}
