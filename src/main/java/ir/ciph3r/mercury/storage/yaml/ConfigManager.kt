package ir.ciph3r.mercury.storage.yaml

import github.scarsz.configuralize.DynamicConfig
import ir.ciph3r.mercury.Mercury
import ir.ciph3r.mercury.MercuryAPI
import java.io.File


class ConfigManager() {
    lateinit var config: DynamicConfig
    lateinit var values: ConfigValues
    lateinit var configUpgrades: ConfigUpgrades
    private val configFile = File(MercuryAPI.INSTANCE.getPlugin().dataFolder, "config.yml")
    private val messagesFile = File(MercuryAPI.INSTANCE.getPlugin().dataFolder, "messages.yml")
    private val globalFile = File(MercuryAPI.INSTANCE.getPlugin().dataFolder, "global.yml")

    init {
        load()
    }

    private fun load() {
        if (configFile.exists() && messagesFile.exists()) configUpgrades = ConfigUpgrades(configFile, messagesFile)

        MercuryAPI.INSTANCE.getPlugin().dataFolder.mkdirs()

        config = DynamicConfig()
        config.addSource(Mercury::class.java, "config", configFile)
        config.addSource(Mercury::class.java, "messages", messagesFile)
        config.addSource(Mercury::class.java, "global", globalFile)

        reload()
    }

    fun reload() {
        config.saveAllDefaults(false)
        config.loadAll()
        values = ConfigValues(DynamicConfig())
    }
}