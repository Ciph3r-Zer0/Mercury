package ir.ciph3r.mercury.modules.impl.lightning;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Lightning")
public class Lightning extends CommandModule {
    public Lightning() {
        super("Lightning", MercuryAPI.INSTANCE.getConfig().LIGHTNING_ENABLED);
        setCommandNameAndSyntax("/Lightning", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.lightning")
    @CommandCompletion("@players")
    public void onLightning(Player player) {
        player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().LIGHTNING_MESSAGE);
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.lightning.others")
    @CommandCompletion("@players")
    public void onLightningOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().getWorld().strikeLightning(target.getPlayer().getLocation());
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().LIGHTNING_MESSAGE_OTHERS.replace("{target}", target.getPlayer().getName()));
    }
}
