package ir.ciph3r.mercury.modules.knockback;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Universal;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Knockback extends Model {
    public Knockback(Mercury mercury) {
        super(mercury, "Knockback", "Knockback", mercury.getConfigFile().KNOCKBACK_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.KNOCKBACK))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.KNOCKBACK));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            getUniversal().sendColorizedMessage(sender, getMessages().KNOCKBACK_USAGE);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                getUniversal().sendColorizedMessage(sender, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                Vector velocity = new Vector();
                velocity.setX(2);
                velocity.setY(2);
                velocity.setZ(2);
                velocity.normalize();

                target.setVelocity(velocity);
                getUniversal().sendColorizedMessage(player, getMessages().KNOCKBACK_SUCCESS_ADMIN.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
