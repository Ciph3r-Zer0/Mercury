package ir.ciph3r.mercury.modules.spawn;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
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
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.SET_SPAWN));
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            Location playerLocation = player.getLocation();
            String serializedLocation = Utils.serializeLocation(playerLocation);

            getConfig().set("Modules.Spawn.location", serializedLocation);
            Utils.sendColorizedMessage(player, getMessages().SPAWN_SET_SUCCESSFUL);
        }
        return true;
    }
}
