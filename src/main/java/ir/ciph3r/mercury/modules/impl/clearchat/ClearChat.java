package ir.ciph3r.mercury.modules.impl.clearchat;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("ClearChat")
public class ClearChat extends CommandModule {
    public ClearChat() {
        super("ClearChat", MercuryAPI.INSTANCE.getConfigManager().getValues().CLEAR_CHAT_ENABLED);
        setCommandNameAndSyntax("/ClearChat", "[player]");
    }


    //TODO: not done yet
    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.clearchat")
    @CommandCompletion("@players")
    public void onClearChat(CommandSender player) {

        for (Player p : Bukkit.getOnlinePlayers()) {
           if (p.hasPermission("mercury.commands.exempt")) continue;
           ChatUtils.sendColorizedMSG(player, ChatUtils.repeat(" \n", 100));
        }
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().CLEAR_CHAT_MESSAGE);
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.clearchat.others")
    @CommandCompletion("@players")
    public void onClearChatOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        ChatUtils.sendColorizedMSG(target.getPlayer(), ChatUtils.repeat(" \n", 100));
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().CLEAR_CHAT_MESSAGE_OTHERS.replace("{target}", target.getPlayer().getName()));
    }
}
