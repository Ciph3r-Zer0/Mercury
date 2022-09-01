package ir.ciph3r.mercury.modules.impl.crossteleport.listeners;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class CrossTeleportListener implements Listener {
    public static HashMap<String, String> toBeTeleported = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!(toBeTeleported.containsKey(event.getPlayer().getName()))) return;
        Player player = event.getPlayer();
        Player target = Bukkit.getPlayer(toBeTeleported.get(player.getName()));

        if (target == null) {
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().NO_PLAYER_FOUND_OFFLINE.replace("{search}", toBeTeleported.get(player.getName())));
        } else {
            MercuryAPI.INSTANCE.getDepends().getVanish().teleport(player, target);
            toBeTeleported.remove(player.getName());
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().CROSS_TELEPORT_MESSAGE.replace("{player}", target.getName()));
        }
    }
}