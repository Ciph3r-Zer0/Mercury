package ir.ciph3r.mercury.modules.impl.kill;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.entity.Player;

@CommandAlias("Kill")
public class Kill extends CommandModule {
    public Kill() {
        super("Kill", MercuryAPI.INSTANCE.getConfig().KILL_ENABLED);
        setCommandNameAndSyntax("Kill", "<player>");
    }

    @Default
    @CommandPermission("mercury.commands.kill")
    @CommandCompletion("@players")
    public void onDefault(Player player, @Conditions("noAdmin")OnlinePlayer target) {
        target.getPlayer().setHealth(0);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().KILL_MESSAGE.replace("{player}", target.getPlayer().getName()));
    }
}