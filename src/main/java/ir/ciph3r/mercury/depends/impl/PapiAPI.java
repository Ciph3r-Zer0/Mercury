package ir.ciph3r.mercury.depends.impl;

import ir.ciph3r.mercury.utility.Logger;
import lombok.Getter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@Getter
public class PapiAPI {
    private boolean enabled = false;

    public PapiAPI() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            this.enabled = true;
            Logger.log("&7Found &apapiAPI&7, Hooking....");
        } else {
            Logger.log("&7Cloud not find &cpapiAPI&7 &7skipping...");
        }
    }

    public String setPlaceHolders(Player player, String message) {
        if (isEnabled()) {
            return PlaceholderAPI.setPlaceholders(player, message.replace("{player}", player.getName()));
        } else {
            return message
                    .replace("{player}", player.getName())
                    .replace("%player_name%", player.getName());
        }
    }
}
