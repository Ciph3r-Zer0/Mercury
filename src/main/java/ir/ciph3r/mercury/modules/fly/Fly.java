package ir.ciph3r.mercury.modules.fly;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly extends Model {
    public Fly(Mercury mercury) {
        super("Fly", "Fly", Config.FLY_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.FLY))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }

        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
                return true;
            }
            Player player = (Player) sender;
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                Utils.sendColorizedMessage(player, Messages.FLY_DISABLED);
                return true;
            } else {
                player.setAllowFlight(true);
                Utils.sendColorizedMessage(player, Messages.FLY_ENABLED);
                return true;
            }
        }
        if (args.length == 1) {
            if (!(sender.hasPermission(Perms.FLY_OTHERS))) {
                Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(sender, Messages.PLAYER_NOT_FOUND.replace("{player}", args[0]));
                return true;
            }
            if (target.getAllowFlight()) {
                target.setAllowFlight(false);
                Utils.sendColorizedMessage(sender, Messages.FLY_DISABLED_ADMIN.replace("{player}", target.getName()));
                Utils.sendColorizedMessage(target, Messages.FLY_ENABLED);
            } else {
                target.setAllowFlight(true);
                Utils.sendColorizedMessage(sender, Messages.FLY_ENABLED_ADMIN.replace("{player}", target.getName()));
                Utils.sendColorizedMessage(target, Messages.FLY_DISABLED);
            }
            return true;
        }
        return true;
    }
}
