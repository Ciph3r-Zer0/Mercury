package ir.ciph3r.mercury.modules.clearinventory;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearInventory extends Model {
    public ClearInventory(Mercury mercury) {
        super(mercury, "ClearInventory", "ClearInventory", mercury.getConfigFile().CLEAR_INVENTORY_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.CLEAR_INVENTORY))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.CLEAR_INVENTORY));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            player.getInventory().clear();
            getUniversal().sendColorizedMessage(player, getMessages().CLEAR_INVENTORY_SUCCESS);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                getUniversal().sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                target.getInventory().clear();
                getUniversal().sendColorizedMessage(player, getMessages().CLEAR_INVENTORY_SUCCESS_OTHERS.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
