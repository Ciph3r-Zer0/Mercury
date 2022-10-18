package ir.ciph3r.mercury

import org.bukkit.plugin.java.JavaPlugin

class Mercury : JavaPlugin() {

    override fun onEnable() {
        MercuryAPI.INSTANCE.start(this)
    }


    override fun onDisable() {
        MercuryAPI.INSTANCE.stop()
    }
}