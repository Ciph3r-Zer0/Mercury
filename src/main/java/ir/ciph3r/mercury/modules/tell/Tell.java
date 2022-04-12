package ir.ciph3r.mercury.modules.tell;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.ModuleModel;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Tell extends ModuleModel {
    public Tell(Mercury mercury) {
        super(mercury, "Tell", "Tell", mercury.getConfigFile().TELL_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.TELL))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.TELL));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            getUniversal().sendColorizedMessage(player, getMessages().TELL_USAGE);
        } else if (args.length == 1) {
            getUniversal().sendColorizedMessage(player, getMessages().TELL_USAGE);
        } else {
            Player receiver = Bukkit.getPlayer(args[0]);
            if (receiver == null) {
                getUniversal().sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                StringBuilder builder = new StringBuilder();
                for (String s : Arrays.copyOfRange(args, 1, args.length)) {
                    builder.append(s).append(" ");
                }

                getUniversal().sendColorizedMessage(receiver, getMessages().TELL_MESSAGE_FORMAT
                        .replace("{sender}", player.getName())
                        .replace("{receiver}", receiver.getName())
                        .replace("{message}", builder.toString()));

                getUniversal().sendColorizedMessage(player, getMessages().TELL_SELF_MESSAGE_FORMAT
                        .replace("{sender}", player.getName())
                        .replace("{receiver}", receiver.getName())
                        .replace("{message}", builder.toString()));

                Reply.replyList.put(receiver.getUniqueId(), player.getUniqueId());
            }
        }
        return true;
    }
}