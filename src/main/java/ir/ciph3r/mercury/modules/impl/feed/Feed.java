package ir.ciph3r.mercury.modules.impl.feed;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.entity.Player;

@CommandAlias("Feed")
public class Feed extends CommandModule {
    public Feed() {
        super("Feed", MercuryAPI.INSTANCE.getConfig().FEED_ENABLED, null);
        setCommandNameAndSyntax("/Feed", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.feed")
    @CommandCompletion("@players")
    public void onDefault(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setFoodLevel(20);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().FEED_MESSAGE);
        } else {
            if (player.hasPermission("mercury.commands.feed.others")) {
                target.getPlayer().setFoodLevel(20);
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().FEED_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()));
            }
        }
    }
}
