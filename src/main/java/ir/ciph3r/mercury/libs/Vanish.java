package ir.ciph3r.mercury.libs;

import de.myzelyam.api.vanish.VanishAPI;
import ir.ciph3r.mercury.Mercury;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Vanish {
    public Vanish() {
        exists();
    }

    private boolean enabled = false;

    public void exists() {
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish") || Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")) {
            enabled = true;
        }
    }

    public void vanishForward(Player player, String targetName, String serverName) {
        String data = player.getName() + "-" + targetName + "-" + serverName;
        Mercury.getInst().bungeeAPI.forward(serverName, "mercury", data.getBytes());
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
