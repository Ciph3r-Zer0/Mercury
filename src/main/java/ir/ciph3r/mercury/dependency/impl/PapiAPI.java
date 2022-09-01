package ir.ciph3r.mercury.dependency.impl;

import ir.ciph3r.mercury.utility.Logger;
import lombok.Getter;
import org.bukkit.Bukkit;

@Getter
public class PapiAPI {
    private boolean enabled = false;

    public PapiAPI() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            this.enabled = true;
            Logger.log("&7Hooking into &apapiAPI&7.");
        } else {
            Logger.log("&7Hooking into &cpapiAPI&7.");
        }
    }
}
