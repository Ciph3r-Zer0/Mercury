package ir.ciph3r.mercury.modules.impl.broadcast;

import co.aikar.commands.annotation.*;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ArrayUtils;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;

@CommandAlias("Broadcast|BC")
public class Broadcast extends CommandModule {
    public Broadcast() {
        super("Broadcast", MercuryAPI.INSTANCE.getConfigManager().getValues().BROADCAST_ENABLED);
        setCommandNameAndSyntax("/Broadcast", "<message>");
    }

    @Default
    @Syntax("<message>")
    @CommandPermission("mercury.commands.broadcast")
    @CommandCompletion("@players")
    public void onBroadcast(CommandSender sender, String[] args) {
        if (args.length == 0) {
            ChatUtils.sendColorizedMSG(sender, getCommandUsage());
        } else {
            ChatUtils.broadcastToServer(MercuryAPI.INSTANCE.getConfigManager().getValues().BROADCAST_MESSAGE.replace("{message}", ArrayUtils.createStringFromArray(args, 0, args.length)));
        }
    }
}
