package ir.ciph3r.mercury.modules.coordinates;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Universal;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class Coordinates extends Model {
    public Coordinates(Mercury mercury) {
        super(mercury, "Coordinates", "Coordinates", mercury.getConfigFile().COORDINATES_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.COORDINATES))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.COORDINATES));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            Location loc = player.getLocation();
            getUniversal().sendColorizedMessage(player, getMessages().COORDINATES_MESSAGE
                    .replace("{world}", loc.getWorld().getName())
                    .replace("{x}", new DecimalFormat("##.#").format(loc.getX()))
                    .replace("{y}", new DecimalFormat("##.#").format(loc.getY()))
                    .replace("{z}", new DecimalFormat("##.#").format(loc.getZ())));
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                getUniversal().sendColorizedMessage(sender, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                Location loc = target.getLocation();
                getUniversal().sendColorizedMessage(player, getMessages().COORDINATES_MESSAGE_OTHERS
                        .replace("{player}", target.getName())
                        .replace("{world}", loc.getWorld().getName())
                        .replace("{x}", new DecimalFormat("##.#").format(loc.getX()))
                        .replace("{y}", new DecimalFormat("##.#").format(loc.getY()))
                        .replace("{z}", new DecimalFormat("##.#").format(loc.getZ())));
            }
        }
        return true;
    }
}
