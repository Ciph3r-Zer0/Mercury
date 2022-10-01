package ir.ciph3r.mercury.storage.yaml;

import github.scarsz.configuralize.DynamicConfig;
import github.scarsz.configuralize.ParseException;
import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.Logger;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Getter
public class ConfigManager {
    private DynamicConfig config;
    private ConfigValues values;
    private ConfigUpgrades configUpgrades;
    private final File configFile = new File(MercuryAPI.INSTANCE.getPlugin().getDataFolder(), "config.yml");
    private final File messagesFile = new File(MercuryAPI.INSTANCE.getPlugin().getDataFolder(), "messages.yml");
    private final File globalFile = new File(MercuryAPI.INSTANCE.getPlugin().getDataFolder(), "global.yml");

    public ConfigManager() {
        load();
    }

    public void load() {
        upgrade();

        MercuryAPI.INSTANCE.getPlugin().getDataFolder().mkdirs();

        config = new DynamicConfig();
        config.addSource(Mercury.class, "config", getConfigFile());
        config.addSource(Mercury.class, "messages", getMessagesFile());
        config.addSource(Mercury.class, "global", getGlobalFile());
        Logger.log("&7Loading &aconfig &7files...");

        reload();
        cacheValues();
        Logger.log("&7Caching &aconfig &7values...");
    }

    public void cacheValues() {
        this.values = new ConfigValues(config);
    }

    public void reload() {
        try {
            config.saveAllDefaults(false);
            config.loadAll();
            cacheValues();
        } catch (IOException | ParseException e) {
            Logger.log("&cAn error occured while loading config files.");
            e.printStackTrace();
        }
    }

    public void setSpawnPoint(String location) {
        //File config = new File(MercuryAPI.INSTANCE.getPlugin().getDataFolder(), "config.yml");
        String configString;
        if (configFile.exists()) {
            try {
                configString = new String(Files.readAllBytes(configFile.toPath()));
                configString = configString.replaceAll("location: .*", "location: \"" + location + "\"");
                Files.write(configFile.toPath(), configString.getBytes());
            } catch (IOException ignored) {}
        }
    }

    private void upgrade() {
        try {
            if (configFile.exists() && messagesFile.exists()) {
                this.configUpgrades = new ConfigUpgrades(configFile, messagesFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
