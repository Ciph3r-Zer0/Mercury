package ir.ciph3r.mercury.modules.impl.spawn.listener;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.ChatUtils;
import ir.ciph3r.mercury.utility.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!(MercuryAPI.INSTANCE.getConfig().SPAWN_ON_JOIN)) return;
        if (MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION.equalsIgnoreCase("")) {
            if (event.getPlayer().hasPermission("mercury.events.spawn.notify")) {
                ChatUtils.sendColorizedMSG(event.getPlayer(), MercuryAPI.INSTANCE.getMessages().SPAWN_MESSAGE_NOT_SET);
            }
            return;
        }

        Player player = event.getPlayer();
        Location spawnLocation = LocationUtils.deserializeLocation(MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION);

        player.teleport(spawnLocation);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if (!(MercuryAPI.INSTANCE.getConfig().SPAWN_ON_RESPAWN)) return;
        if (MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION.equalsIgnoreCase("")) return;

        Player player = event.getPlayer();
        Location spawnLocation = LocationUtils.deserializeLocation(MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION);

        event.setRespawnLocation(spawnLocation);
    }

    @EventHandler
    public void onVoid(EntityDamageEvent event) {
        if (!(MercuryAPI.INSTANCE.getConfig().SPAWN_ON_VOID)) return;
        if (MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION.equalsIgnoreCase("")) return;
        if (!(event.getCause() == EntityDamageEvent.DamageCause.VOID)) return;
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Location spawnLocation = LocationUtils.deserializeLocation(MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION);

        event.setCancelled(true);

        //Using a task timer because teleporting player instantly when taking void damage in 1.19+ servers causes
        //Players being stuck in one place and unable to move and also unable to see other players
        Bukkit.getScheduler().runTaskLater(MercuryAPI.INSTANCE.getPlugin(), () -> {
            player.teleport(spawnLocation);
            player.setFallDistance(0);
        } ,1L);
    }
}
