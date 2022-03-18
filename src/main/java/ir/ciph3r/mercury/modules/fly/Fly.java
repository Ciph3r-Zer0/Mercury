package ir.ciph3r.mercury.modules.fly;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly extends Model {
    public Fly(Mercury mercury) {
        super(mercury, "Fly", "Fly", mercury.getConfigFile().FLY_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.FLY))) {
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION);
            return true;
        }
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                Utils.sendColorizedMessage(sender, getMessages().NO_CONSOLE);
                return true;
            }
            Player player = (Player) sender;

            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                Utils.sendColorizedMessage(player, getMessages().FLY_DISABLED);
                return true;
            } else {
                player.setAllowFlight(true);
                Utils.sendColorizedMessage(player, getMessages().FLY_ENABLED);
                return true;
            }
        }
        if (args.length == 1) {
            if (!(sender.hasPermission(Perms.FLY_OTHERS))) {
                Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(sender, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
                return true;
            }
            if (target.getAllowFlight()) {
                target.setAllowFlight(false);
                Utils.sendColorizedMessage(sender, getMessages().FLY_DISABLED_ADMIN.replace("{player}", target.getName()));
                Utils.sendColorizedMessage(target, getMessages().FLY_ENABLED);
            } else {
                target.setAllowFlight(true);
                Utils.sendColorizedMessage(sender, getMessages().FLY_ENABLED_ADMIN.replace("{player}", target.getName()));
                Utils.sendColorizedMessage(target, getMessages().FLY_DISABLED);
            }
            return true;
        }
        return true;
    }
}
