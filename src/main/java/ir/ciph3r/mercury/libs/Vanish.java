package ir.ciph3r.mercury.libs;

import de.myzelyam.api.vanish.VanishAPI;
import ir.ciph3r.mercury.Mercury;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicBoolean;

public class Vanish {
    private boolean enabled = false;
    public void exists() {
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish") || Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")) {
            enabled = true;
        }
    }

    public void vanishTeleport(Player player, Player target) {
        if (enabled) {
            VanishAPI.hidePlayer(player);
            player.teleport(target);
        } else {
            player.teleport(target);
        }
    }
}
