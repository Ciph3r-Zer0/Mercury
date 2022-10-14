package ir.ciph3r.mercury.modules.impl.teleportask.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TeleportAskListener implements Listener {
    public static Map<UUID, UUID> pendingTeleports = new HashMap<>();

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        pendingTeleports.remove(player.getUniqueId());
        pendingTeleports.values().remove(player.getUniqueId());
    }
}
