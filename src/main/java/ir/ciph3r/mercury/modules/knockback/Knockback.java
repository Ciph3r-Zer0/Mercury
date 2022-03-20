package ir.ciph3r.mercury.modules.knockback;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Knockback extends Model {
    public Knockback(Mercury mercury) {
        super(mercury, "Knockback", "Knockback", mercury.getConfigFile().KNOCKBACK_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.KNOCKBACK))) {
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.KNOCKBACK));
            return true;
        }

        if (args.length == 0) {
            Utils.sendColorizedMessage(sender, getMessages().SHUFFLE_USAGE);
        }
        return true;
    }
}
