package ir.ciph3r.mercury.modules.impl.heal;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.entity.Player;

@CommandAlias("Heal")
public class Heal extends CommandModule {
    public Heal() {
        super("Heal", MercuryAPI.INSTANCE.getConfig().HEAL_ENABLED);
        setCommandNameAndSyntax("/Heal", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.heal")
    @CommandCompletion("@players")
    public void onDefault(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setHealth(20);
            player.setFoodLevel(20);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().HEAL_MESSAGE);
        } else {
            if (player.hasPermission("mercury.commands.heal.others")) {
                target.getPlayer().setHealth(20);
                target.getPlayer().setFoodLevel(20);
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().HEAL_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()));
            }
        }
    }
}