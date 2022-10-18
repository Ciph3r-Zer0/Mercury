package ir.ciph3r.mercury

import ir.ciph3r.mercury.storage.yaml.ConfigManager
import org.bukkit.plugin.java.JavaPlugin

enum class MercuryAPI {
    INSTANCE;

    private lateinit var plugin: JavaPlugin
    private lateinit var configManager: ConfigManager

    fun start(plugin: JavaPlugin) {
        this.plugin = plugin
        configManager = ConfigManager()
    }

    fun stop() {
    }

    fun getPlugin() : JavaPlugin{
        return plugin
    }
    fun getConfigManager() : ConfigManager{
        return configManager
    }
}