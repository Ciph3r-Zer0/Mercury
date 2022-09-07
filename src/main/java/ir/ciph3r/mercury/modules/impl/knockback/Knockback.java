package ir.ciph3r.mercury.modules.impl.knockback;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.util.Vector;

@CommandAlias("Knockback|Knock")
public class Knockback extends CommandModule {
    public Knockback() {
        super("Knockback", MercuryAPI.INSTANCE.getConfigManager().getValues().KNOCKBACK_ENABLED);
        setCommandNameAndSyntax("/Knockback", "<player>");
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.knockback")
    @CommandCompletion("@players")
    public void onKnockback(CommandSender sender) {
        ChatUtils.sendColorizedMSG(sender, getCommandUsage());
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.knockback")
    @CommandCompletion("@players")
    public void onKnockbackOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().setVelocity(new Vector(2, 2, 2).normalize());
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().KNOCKBACK_MESSAGE.replace("{target}", target.getPlayer().getName()));
    }
}
