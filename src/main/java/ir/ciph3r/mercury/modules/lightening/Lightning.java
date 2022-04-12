package ir.ciph3r.mercury.modules.lightening;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.ModuleModel;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lightning extends ModuleModel {
    public Lightning(Mercury mercury) {
        super(mercury, "Lightning", "Lightning", mercury.getConfigFile().LIGHTNING_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.LIGHTENING))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.LIGHTENING));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            Location loc = player.getTargetBlock(null, 50).getLocation();
            player.getWorld().strikeLightning(loc);
            getUniversal().sendColorizedMessage(player, getMessages().LIGHTNING_SUCCESS);

        } else if (args.length == 1) {
            if (!(sender.hasPermission(Perms.LIGHTENING_OTHERS))) {
                getUniversal().sendColorizedMessage(player, getMessages().NO_PERMISSION.replace("{permission}", Perms.LIGHTENING_OTHERS));
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                getUniversal().sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                Location loc = target.getLocation();
                target.getWorld().strikeLightning(loc);
                getUniversal().sendColorizedMessage(player, getMessages().LIGHTNING_SUCCESS_OTHERS.replace("{player}", target.getName()));
            }
        }
        return true;
    }
}
