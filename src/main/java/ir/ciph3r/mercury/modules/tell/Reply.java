package ir.ciph3r.mercury.modules.tell;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Reply extends Model {
    public Reply(Mercury mercury) {
        super(mercury, "Reply", "Reply", mercury.getConfigFile().TELL_ENABLED);
    }

    public static Map<UUID, UUID> replyList = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.REPLY))) {
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.REPLY));
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            Utils.sendColorizedMessage(player, getMessages().REPLY_USAGE);
        } else {
            if (!(replyList.containsKey(player.getUniqueId()))) {
                Utils.sendColorizedMessage(player, getMessages().REPLY_NO_RECEIVER);
                return true;
            }
            Player receiver = Bukkit.getPlayer(replyList.get(player.getUniqueId()));

            if (receiver == null) {
                Utils.sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND);
            } else {
                StringBuilder builder = new StringBuilder();
                for (String s : args) {
                    builder.append(s).append(" ");
                }

                Utils.sendColorizedMessage(receiver, getMessages().REPLY_MESSAGE_FORMAT
                        .replace("{sender}", player.getName())
                        .replace("{receiver}", receiver.getName())
                        .replace("{message}", builder.toString()));

                Utils.sendColorizedMessage(player, getMessages().REPLY_SELF_MESSAGE_FORMAT
                        .replace("{sender}", player.getName())
                        .replace("{receiver}", receiver.getName())
                        .replace("{message}", builder.toString()));

                replyList.put(receiver.getUniqueId(), player.getUniqueId());
            }

        }
        return true;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        replyList.remove(player.getUniqueId());
        replyList.values().remove(player.getUniqueId());
    }
}
