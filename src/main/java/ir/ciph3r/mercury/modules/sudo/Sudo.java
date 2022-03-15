package ir.ciph3r.mercury.modules.sudo;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Sudo extends Model {
    public Sudo(Mercury mercury) {
        super(mercury, "Sudo", "Sudo", mercury.getConfigFile().SUDO_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.SUDO))) {
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION);
            return true;
        }

        if (args.length == 0) {
            Utils.sendColorizedMessage(sender, getMessages().SUDO_USAGE);
        } else if (args.length == 1) {
            Utils.sendColorizedMessage(sender, getMessages().SUDO_USAGE);
        } else {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                Utils.sendColorizedMessage(sender, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                boolean isCommand = !(args[1].toLowerCase().startsWith("c:"));
                StringBuilder builder = new StringBuilder();
                for (String s : Arrays.copyOfRange(args, 1, args.length)) {
                    builder.append(s).append(" ");
                }

                if (isCommand) {
                    target.performCommand(builder.toString());
                } else {
                    target.chat(builder.toString().substring(2));
                }
                Utils.sendColorizedMessage(sender, getMessages().SUDO_SUCCESS.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
