package ir.ciph3r.mercury.modules.mercury;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.ModuleModel;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;

public class MercuryCMD extends ModuleModel {
    public MercuryCMD(Mercury mercury) {
        super(mercury, "Mercury", "Mercury", true);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            getUniversal().sendColorizedMessage(sender, "&5Mercury &8&k||&r &cMercury &7version &c" + getMercury().getDescription().getVersion() + " &7made by &cCiph3r");
        } else if (args.length == 1) {
            String arg1 = args[0];

            if (arg1.equalsIgnoreCase("Reload")) {
                if (!(sender.hasPermission(Perms.RELOAD))) {
                    getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.RELOAD));
                    return true;
                }
                try {
                    getMercury().getConfigFile().reload();
                    getMercury().getMessagesFile().reload();
                    getUniversal().sendColorizedMessage(sender, getMessages().RELOAD_SUCCESS);
                } catch (IOException | InvalidConfigurationException e) {
                    getUniversal().sendColorizedMessage(sender, getMessages().RELOAD_FAILED);
                }
            }
        }
        return true;
    }
}
