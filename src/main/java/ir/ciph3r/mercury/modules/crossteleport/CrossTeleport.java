package ir.ciph3r.mercury.modules.crossteleport;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CrossTeleport extends Model {

    public CrossTeleport(Mercury mercury) {
        super(mercury, "CrossTeleport", "CrossTeleport", mercury.getConfigFile().CROSS_TELEPORT_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.GAMEMODE))) {
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION);
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            Utils.sendColorizedMessage(sender, getMessages().CROSS_TELEPORT_USAGE);
        } else if (args.length == 1) {
            String target = args[0];
            boolean targetOnline = Utils.isPlayerOnlineProxySide(target);

            if (!(targetOnline)) {
                Utils.sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND);
            } else {
                Utils.connectToProxyPlayer(player, target);
            }
        }
        return true;
    }
}
