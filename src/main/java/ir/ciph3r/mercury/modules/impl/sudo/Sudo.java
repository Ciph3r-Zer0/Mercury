package ir.ciph3r.mercury.modules.impl.sudo;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ArrayUtils;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.entity.Player;

@CommandAlias("Sudo")
public class Sudo extends CommandModule {
    public Sudo() {
        super("Sudo", MercuryAPI.INSTANCE.getConfig().SUDO_ENABLED, null);
        setCommandNameAndSyntax("/Sudo", "<player> [c:]<message>");
    }

    @Default
    @Syntax("<player> [c:]<message>")
    @CommandPermission("mercury.commands.sudo")
    @CommandCompletion("@players")
    public void onDefault(Player player, @Conditions("noAdmin") OnlinePlayer target, String[] args) {
        if (args.length == 0)  {
            ChatUtils.sendColorizedMSG(player, getCommandUsage());
            return;
        }
        String argsMessage = ArrayUtils.createStringFromArray(args, 0, args.length);
        boolean isCommand = !(argsMessage.startsWith("c:"));

        if (isCommand) {
            target.getPlayer().performCommand(argsMessage);
        } else {
            target.getPlayer().chat(argsMessage.substring(2));
        }
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SUDO_MESSAGE.replace("{player}", target.getPlayer().getName()));
    }
}
