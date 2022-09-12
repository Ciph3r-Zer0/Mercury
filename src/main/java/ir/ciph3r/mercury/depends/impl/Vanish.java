package ir.ciph3r.mercury.depends.impl;

import de.myzelyam.api.vanish.VanishAPI;
import ir.ciph3r.mercury.utility.Logger;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@Getter
public class Vanish {
    private boolean enabled = false;

    public Vanish() {
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish") || Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")) {
            this.enabled = true;
            Logger.log("&7Found &aVanishAPI&7, Hooking....");
        } else {
            Logger.log("&7Cloud not find &cVanishAPI&7 &7skipping...");
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
