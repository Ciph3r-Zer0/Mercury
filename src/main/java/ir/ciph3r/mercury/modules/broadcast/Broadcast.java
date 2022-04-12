package ir.ciph3r.mercury.modules.broadcast;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.ModuleModel;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Broadcast extends ModuleModel {
    public Broadcast(Mercury mercury) {
        super(mercury, "Broadcast", "Broadcast", mercury.getConfigFile().BROADCAST_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.BROADCAST))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.BROADCAST));
            return true;
        }

        if (args.length == 0) {
            getUniversal().sendColorizedMessage(sender, getMessages().BROADCAST_USAGE);
        } else {
            String msgToBroadcast = getUniversal().createStringFromArray(args, 0, args.length);

            getUniversal().broadcastToServer(msgToBroadcast);
        }
        return true;
    }
}
