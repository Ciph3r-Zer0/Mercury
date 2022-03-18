package ir.ciph3r.mercury.modules.mercury;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;

public class MercuryCMD extends Model {
    public MercuryCMD(Mercury mercury) {
        super(mercury, "Mercury", "Mercury", true);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            Utils.sendColorizedMessage(sender, "&5Mercury &8&k||&r &cMercury &7version &c" + getMercury().getDescription().getVersion() + " &7made by &cCiph3r");
        } else if (args.length == 1) {
            String arg1 = args[0];

            if (arg1.equalsIgnoreCase("Reload")) {
                if (!(sender.hasPermission(Perms.RELOAD))) {
                    Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION);
                    return true;
                }
                try {
                    getMercury().getConfigFile().reload();
                    getMercury().getMessagesFile().reload();
                    Utils.sendColorizedMessage(sender, getMessages().RELOAD_SUCCESS);
                } catch (IOException | InvalidConfigurationException e) {
                    Utils.sendColorizedMessage(sender, getMessages().RELOAD_FAILED);
                }
            }
        }
        return true;
    }
}
