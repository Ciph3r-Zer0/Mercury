package ir.ciph3r.mercury.modules.heal;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.ModuleModel;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal extends ModuleModel {
    public Heal(Mercury mercury) {
        super(mercury, "Heal", "Heal", mercury.getConfigFile().HEAL_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.HEAL))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.HEAL));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0 ) {
            player.setHealth(20);
            player.setFoodLevel(20);
            getUniversal().sendColorizedMessage(player, getMessages().HEAL_SUCCESS);
        } else if (args.length == 1) {
            if (!(sender.hasPermission(Perms.HEAL_OTHERS))) {
                getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.HEAL_OTHERS));
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                getUniversal().sendColorizedMessage(sender, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                target.setHealth(20);
                target.setFoodLevel(20);
                getUniversal().sendColorizedMessage(player, getMessages().HEAL_SUCCESS_OTHERS.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
