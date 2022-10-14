package ir.ciph3r.mercury.modules.impl.teleportask;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.teleportask.listeners.TeleportAskListener;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("TeleportAsk|TeleportA|TAsk|TPA")
public class TeleportAsk extends CommandModule {
    public TeleportAsk() {
        super("TeleportAsk", MercuryAPI.INSTANCE.getConfigManager().getValues().TELEPORT_ASK_ENABLED);
        setCommandNameAndSyntax("/TeleportAsk", "<player>");
        addListeners(new TeleportAskListener());
        addSubModules(new TeleportAskAccept());
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.teleportask")
    @CommandCompletion("@players")
    public void onTeleportAsk(CommandSender sender) {
        ChatUtils.sendColorizedMSG(sender, getCommandUsage());
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.teleportask")
    @CommandCompletion("@players")
    public void onTeleportAsk(Player player, OnlinePlayer target) {
        TeleportAskListener.pendingTeleports.put(player.getUniqueId(), target.getPlayer().getUniqueId());
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().TELEPORT_ASK_MESSAGE.replace("{target}", target.getPlayer().getName()));
        ChatUtils.sendColorizedMSG(target.getPlayer(), MercuryAPI.INSTANCE.getConfigManager().getValues().TELEPORT_ASK_MESSAGE_OTHERS.replace("{target}", player.getName()));
    }
}
