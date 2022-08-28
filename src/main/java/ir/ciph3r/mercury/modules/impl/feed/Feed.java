package ir.ciph3r.mercury.modules.impl.feed;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Feed")
public class Feed extends CommandModule {
    public Feed() {
        super("Feed", MercuryAPI.INSTANCE.getConfig().FEED_ENABLED);
        setCommandNameAndSyntax("/Feed", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.feed")
    @CommandCompletion("@players")
    public void onFeed(Player player) {
        player.setFoodLevel(20);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().FEED_MESSAGE);
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.feed.others")
    @CommandCompletion("@players")
    public void onFeedOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().setFoodLevel(20);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().FEED_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()));
    }
}
