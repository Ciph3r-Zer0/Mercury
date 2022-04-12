package ir.ciph3r.mercury.modules.feed;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.ModuleModel;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed extends ModuleModel {
    public Feed(Mercury mercury) {
        super(mercury, "Feed", "Feed", mercury.getConfigFile().FEED_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.FEED))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.FEED));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0 ) {
            player.setFoodLevel(20);
            getUniversal().sendColorizedMessage(player, getMessages().FEED_SUCCESS);
        } else if (args.length == 1) {
            if (!(sender.hasPermission(Perms.FEED_OTHERS))) {
                getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.FEED_OTHERS));
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                getUniversal().sendColorizedMessage(sender, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                target.setFoodLevel(20);
                getUniversal().sendColorizedMessage(player, getMessages().FEED_SUCCESS_OTHERS.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
