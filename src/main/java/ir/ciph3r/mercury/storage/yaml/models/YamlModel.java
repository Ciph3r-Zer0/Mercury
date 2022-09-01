package ir.ciph3r.mercury.storage.yaml.models;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.Logger;
import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
public abstract class YamlModel {
    private final String fileName;
    private File file;
    private FileConfiguration fileConfig;

    public YamlModel(String fileName) {
        this.fileName = fileName;
    }

    public void setup() {
        try {
            create();
            load();
            Logger.log("&7Loading &a" + fileName + "&7.");
        } catch (IOException | InvalidConfigurationException e) {
            Logger.log("&7Loading &c" + fileName + "&7.");
            e.printStackTrace();
        }
        init();
    }

    public abstract void init();

    public void create() {
        file = new File(MercuryAPI.INSTANCE.getPlugin().getDataFolder(), fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            MercuryAPI.INSTANCE.getPlugin().saveResource(fileName, false);
        }
    }

    public void load() throws IOException, InvalidConfigurationException {
        fileConfig = new YamlConfiguration();
        fileConfig.load(file);
    }

    public void set(String path, Object value) {
        fileConfig.set(path, value);
        save();
    }

    public void save() {
        try {
            fileConfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() throws IOException, InvalidConfigurationException {
        load();
        init();
    }
}
