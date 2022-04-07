package ir.ciph3r.mercury.modules.speed;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Speed extends Model {
    public Speed(Mercury mercury) {
        super(mercury, "Speed", "Speed", mercury.getConfigFile().SPEED_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.SPEED))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.SPEED));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            getUniversal().sendColorizedMessage(player, getMessages().SPEED_USAGE);
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reset")) {
                player.setFlySpeed(0.1f);
                player.setWalkSpeed(0.2f);
                getUniversal().sendColorizedMessage(player, getMessages().SPEED_RESET);
            } else {
                getUniversal().sendColorizedMessage(player, getMessages().SPEED_USAGE);
            }
        } else if (args.length == 2) {
            if (!(getUniversal().isDouble(args[1]))) {
                getUniversal().sendColorizedMessage(player, getMessages().ARGS_NOT_NUMBER);
                return true;
            }
            if (!(Double.parseDouble(args[1]) >= 0) || !(Double.parseDouble(args[1]) <= 10)) {
                getUniversal().sendColorizedMessage(player, getMessages().SPEED_USAGE);
                return true;
            }
            float amount = Float.parseFloat(args[1]) / 10;

            if (args[0].equalsIgnoreCase("Walk")) {
                player.setWalkSpeed(amount);
                getUniversal().sendColorizedMessage(player, getMessages().SPEED_WALK_SUCCESS.replace("{amount}", args[1]));
            } else if (args[0].equalsIgnoreCase("Fly")) {
                player.setFlySpeed(amount);
                getUniversal().sendColorizedMessage(player, getMessages().SPEED_FLY_SUCCESS.replace("{amount}", args[1]));
            } else {
                getUniversal().sendColorizedMessage(player, getMessages().SPEED_USAGE);
            }
        }
        return true;
    }
}
