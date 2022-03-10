package ir.ciph3r.mercury.modules.tell;

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

import java.util.Arrays;

public class Tell extends Model {
    public Tell(Mercury mercury) {
        super("Tell", "Tell", Config.TELL_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.TELL))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            Utils.sendColorizedMessage(player, Messages.TELL_USAGE);
        } else if (args.length == 1) {
            Utils.sendColorizedMessage(player, Messages.TELL_USAGE);
        } else {
            Player receiver = Bukkit.getPlayer(args[0]);
            if (receiver == null) {
                Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                StringBuilder builder = new StringBuilder();
                for (String s : Arrays.copyOfRange(args, 1, args.length)) {
                    builder.append(s).append(" ");
                }

                Utils.sendColorizedMessage(receiver, Messages.TELL_MESSAGE_FORMAT
                        .replace("{player}", receiver.getName())
                        .replace("{receiver}", player.getName())
                        .replace("{message}", builder.toString()));

                Utils.sendColorizedMessage(player, Messages.TELL_SELF_MESSAGE_FORMAT
                        .replace("{player}", player.getName())
                        .replace("{receiver}", receiver.getName())
                        .replace("{message}", builder.toString()));
            }
        }
        return true;
    }
}