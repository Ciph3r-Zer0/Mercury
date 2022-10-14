package ir.ciph3r.mercury.modules.impl.teleportask;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.teleportask.listeners.TeleportAskListener;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("TeleportAskAccept|TPAccept|TPYes")
public class TeleportAskAccept extends CommandModule {
    public TeleportAskAccept() {
        super("TeleportAskAccept", MercuryAPI.INSTANCE.getConfigManager().getValues().TELEPORT_ASK_ENABLED);
        setCommandNameAndSyntax("/TeleportAskAccept", null);
    }

    @Default
    @CommandPermission("mercury.commands.teleportaskaccept")
    public void onTeleportAskAccept(Player player) {
        if (!(TeleportAskListener.pendingTeleports.containsValue(player.getUniqueId()))) ChatUtils.sendColorizedMSG(player, "");

//        Player target = Bukkit.getPlayer(TeleportAskListener.pendingTeleports.entrySet())
//
//        if (TeleportAskListener.pendingTeleports.containsKey(player.getUniqueId())) {
//            if (target != null) {
//                target.teleport(player);
//            }
//        }
    }
}
