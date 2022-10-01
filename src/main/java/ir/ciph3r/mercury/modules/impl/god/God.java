package ir.ciph3r.mercury.modules.impl.god;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.god.listeners.GodListener;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("God")
public class God extends CommandModule {
    public God() {
        super("God", MercuryAPI.INSTANCE.getConfigManager().getValues().GOD_ENABLED);

        setCommandNameAndSyntax("/God", "[player]");
        addListeners(new GodListener());
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.god")
    @CommandCompletion("@players")
    public void onGod(Player player) {
        if (GodListener.godPlayers.contains(player.getUniqueId())) {
            GodListener.godPlayers.remove(player.getUniqueId());
        } else {
            GodListener.godPlayers.add(player.getUniqueId());
        }
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().GOD_MESSAGE.replace("{status}", handleGodStatus(player)));
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.god.others")
    @CommandCompletion("@players")
    public void onGodOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        if (GodListener.godPlayers.contains(target.getPlayer().getUniqueId())) {
            GodListener.godPlayers.remove(target.getPlayer().getUniqueId());
        } else {
            GodListener.godPlayers.add(target.getPlayer().getUniqueId());
        }
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().GOD_MESSAGE_OTHERS
                .replace("{target}", target.getPlayer().getName())
                .replace("{status}", handleGodStatus(target.getPlayer())));
    }

    private String handleGodStatus(Player player) {
        if (GodListener.godPlayers.contains(player.getUniqueId())) {
            return "&aEnabled";
        } else {
            return "&cDisabled";
        }
    }
}
