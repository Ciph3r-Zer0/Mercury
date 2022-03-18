package ir.ciph3r.mercury.modules.spawn;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.Model;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Spawn extends Model {
    public Spawn(Mercury mercury) {
        super(mercury, "Spawn", "Spawn", mercury.getConfigFile().SPAWN_ENABLED);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!(getConfig().SPAWN_ON_JOIN)) return;

        Player player = event.getPlayer();
        String serializedLocation = getConfig().getFileConfig().getString("Modules.Spawn.location");

        if (serializedLocation.equalsIgnoreCase("")) {
            return;
        } else {
            Location spawnLocation = Utils.deSerializeLocation(serializedLocation);
            player.teleport(spawnLocation);
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if (!(getConfig().SPAWN_ON_RESPAWN)) return;

        Player player = event.getPlayer();
        String serializedLocation = getConfig().getFileConfig().getString("Modules.Spawn.location");

        if (serializedLocation.equalsIgnoreCase("")) {
            return;
        } else {
            Location spawnLocation = Utils.deSerializeLocation(serializedLocation);
            event.setRespawnLocation(spawnLocation);
        }
    }

    @EventHandler
    public void onVoid(EntityDamageEvent event) {
        if (!(getConfig().SPAWN_ON_VOID)) return;
        if (!(event.getEntity() instanceof Player)) return;
        if (!(event.getCause() == EntityDamageEvent.DamageCause.VOID)) return;

        Player player = (Player) event.getEntity();
        String serializedLocation = getConfig().getFileConfig().getString("Modules.Spawn.location");

        if (serializedLocation.equalsIgnoreCase("")) {
            return;
        } else {
            Location spawnLocation = Utils.deSerializeLocation(serializedLocation);
            player.setNoDamageTicks(60);
            player.teleport(spawnLocation);
            event.setCancelled(true);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.SPAWN))) {
            Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION);
            return true;
        }
        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            String serializedLocation = getConfig().getFileConfig().getString("Modules.Spawn.location");

            if (serializedLocation.equalsIgnoreCase("")) {
                Utils.sendColorizedMessage(player, getMessages().SPAWN_NOT_SET);
            } else {
                Location spawnLocation = Utils.deSerializeLocation(serializedLocation);
                player.teleport(spawnLocation);
                Utils.sendColorizedMessage(player, getMessages().SPAWN_SUCCESSFUL);
            }
        } else if (args.length == 1) {
            if (!(player.hasPermission(Perms.SPAWN_OTHERS))) {
                Utils.sendColorizedMessage(sender, getMessages().NO_PERMISSION);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                Utils.sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
            } else {
                String serializedLocation = getConfig().getFileConfig().getString("Modules.Spawn.location");

                if (serializedLocation.equalsIgnoreCase("")) {
                    Utils.sendColorizedMessage(player, getMessages().SPAWN_NOT_SET);
                } else {
                    Location spawnLocation = Utils.deSerializeLocation(serializedLocation);
                    target.teleport(spawnLocation);
                    Utils.sendColorizedMessage(player, getMessages().SPAWN_SUCCESSFUL_OTHERS.replace("{player}", target.getName()));
                }
            }
        }
        return true;
    }
}
