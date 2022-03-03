package ir.ciph3r.mercury.modules.clearinventory;

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

public class ClearInventory extends Model {
    public ClearInventory(Mercury mercury) {
        super("ClearInventory", "ClearInventory", Config.CLEAR_INVENTORY_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.CLEAR_INVENTORY))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            player.getInventory().clear();
            Utils.sendColorizedMessage(player, Messages.CLEAR_INVENTORY_SUCCESS);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                target.getInventory().clear();
                Utils.sendColorizedMessage(player, Messages.CLEAR_INVENTORY_SUCCESS_OTHERS.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
