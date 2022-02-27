package ir.ciph3r.mercury.modules;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.base.ModuleBase;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Shuffle extends ModuleBase {
    public Shuffle(Mercury mercury) {
        super("Shuffle", "Shuffle", Config.SHUFFLE_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.SHUFFLE))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }

        if (args.length == 0) {
            Utils.sendColorizedMessage(sender, Messages.SHUFFLE_USAGE);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                Utils.sendColorizedMessage(sender, Messages.PLAYER_NOT_FOUND);
            } else {
                target.getInventory().setHeldItemSlot(Utils.getRandomNumber(0, 9, target.getInventory().getHeldItemSlot()));
                Utils.sendColorizedMessage(sender, Messages.SHUFFLE_SUCCESS_ADMIN.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
