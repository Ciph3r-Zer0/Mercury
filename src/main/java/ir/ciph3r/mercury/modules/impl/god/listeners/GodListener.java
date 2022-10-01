package ir.ciph3r.mercury.modules.impl.god.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GodListener implements Listener {
    public static List<UUID> godPlayers = new ArrayList<>();

    @EventHandler
    public void onDMG(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (!(godPlayers.contains(event.getEntity().getUniqueId()))) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onDMGOthers(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player || event.getDamager() instanceof Player)) return;
        if (!(godPlayers.contains(event.getEntity().getUniqueId()) || godPlayers.contains(event.getDamager().getUniqueId()))) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityTarget(EntityTargetLivingEntityEvent event) {
        if (!(event.getTarget() instanceof Player)) return;
        if (!(godPlayers.contains(event.getTarget().getUniqueId()))) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onStarve(FoodLevelChangeEvent event) {
        if (!(godPlayers.contains(event.getEntity().getUniqueId()))) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        godPlayers.remove(event.getPlayer().getUniqueId());
    }
}
