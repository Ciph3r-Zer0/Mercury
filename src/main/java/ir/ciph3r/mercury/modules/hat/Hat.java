package ir.ciph3r.mercury.modules.hat;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Hat extends Model {
    public Hat(Mercury mercury) {
        super(mercury, "Hat", "Hat", mercury.getConfigFile().HAT_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.HAT))) {
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.HAT));
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            ItemStack held = player.getInventory().getItemInMainHand();
            ItemStack helm = player.getInventory().getHelmet();

            player.getInventory().setHelmet(held);
            player.getInventory().setItemInMainHand(helm);

            Utils.sendColorizedMessage(player, getMessages().HAT_UPDATED);
            return true;
        } else if (args.length == 1) {
            if (!(sender.hasPermission(Perms.HAT_OTHERS))) {
                Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.HAT_OTHERS));
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                Utils.sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
                return true;
            } else {
                ItemStack held = target.getInventory().getItemInMainHand();
                ItemStack helm = target.getInventory().getHelmet();

                target.getInventory().setHelmet(held);
                target.getInventory().setItemInMainHand(helm);

                Utils.sendColorizedMessage(player, getMessages().HAT_UPDATED_ADMIN.replace("{player}", target.getName()));
                Utils.sendColorizedMessage(target, getMessages().HAT_UPDATED);
                return true;
            }
        }
        return true;
    }
}
