package ir.ciph3r.mercury.modules.spawn;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Universal;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn extends Model {
    public SetSpawn(Mercury mercury) {
        super(mercury, "SetSpawn", "SetSpawn", mercury.getConfigFile().SPAWN_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.SET_SPAWN))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.SET_SPAWN));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            Location playerLocation = player.getLocation();
            String serializedLocation = getUniversal().serializeLocation(playerLocation);

            getConfig().set("Modules.Spawn.location", serializedLocation);
            getUniversal().sendColorizedMessage(player, getMessages().SPAWN_SET_SUCCESSFUL);
        }
        return true;
    }
}
