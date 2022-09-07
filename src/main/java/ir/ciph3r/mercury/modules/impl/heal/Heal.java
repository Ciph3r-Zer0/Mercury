package ir.ciph3r.mercury.modules.impl.heal;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Heal")
public class Heal extends CommandModule {
    public Heal() {
        super("Heal", MercuryAPI.INSTANCE.getConfigManager().getValues().HEAL_ENABLED);
        setCommandNameAndSyntax("/Heal", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.heal")
    @CommandCompletion("@players")
    public void onHeal(Player player) {
        player.setHealth(20);
        player.setFoodLevel(20);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().HEAL_MESSAGE);
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.heal.others")
    @CommandCompletion("@players")
    public void onHealOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().setHealth(20);
        target.getPlayer().setFoodLevel(20);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().HEAL_MESSAGE_OTHERS.replace("{target}", target.getPlayer().getName()));
    }
}
