package ir.ciph3r.mercury.modules;

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

public class Rotate extends Model {
    public Rotate(Mercury mercury) {
        super("Rotate", "Rotate", Config.ROTATE_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.ROTATE))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }

        if (args.length == 0) {
            Utils.sendColorizedMessage(sender, Messages.ROTATE_USAGE);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(sender, Messages.PLAYER_NOT_FOUND);
            } else {
                double generatedPitch = Utils.getRandomNumber(-180.0, 180.0, target.getLocation().getPitch());
                double generatedYaw = Utils.getRandomNumber(-90.0, 90.0, target.getLocation().getYaw());

                Location loc = target.getLocation();
                loc.setPitch((float) generatedPitch);
                loc.setYaw((float) generatedYaw);
                target.teleport(loc);
                Utils.sendColorizedMessage(sender, Messages.ROTATE_SUCCESS_ADMIN.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
