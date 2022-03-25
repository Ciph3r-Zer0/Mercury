package ir.ciph3r.mercury.modules.rotate;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Universal;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rotate extends Model {
    public Rotate(Mercury mercury) {
        super(mercury, "Rotate", "Rotate", mercury.getConfigFile().ROTATE_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.ROTATE))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.ROTATE));
            return true;
        }

        if (args.length == 0) {
            getUniversal().sendColorizedMessage(sender, getMessages().ROTATE_USAGE);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                getUniversal().sendColorizedMessage(sender, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                double generatedPitch = getUniversal().getRandomNumber(-90, 90, target.getLocation().getPitch());
                double generatedYaw = getUniversal().getRandomNumber(-179.9, 180.0, target.getLocation().getYaw());

                Location loc = target.getLocation();
                loc.setPitch((float) generatedPitch);
                loc.setYaw((float) generatedYaw);
                target.teleport(loc);
                getUniversal().sendColorizedMessage(sender, getMessages().ROTATE_SUCCESS_ADMIN.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
