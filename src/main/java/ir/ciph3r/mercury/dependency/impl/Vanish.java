package ir.ciph3r.mercury.dependency.impl;

import de.myzelyam.api.vanish.VanishAPI;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@Getter
public class Vanish {
    private boolean enabled = false;

    public Vanish() {
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish") || Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")) {
            this.enabled = true;
        }
    }

    public void teleport(Player player, Player target) {
        if (isEnabled()) {
            VanishAPI.hidePlayer(player);
            player.teleport(target);
        } else {
            player.teleport(target);
        }
    }
}
