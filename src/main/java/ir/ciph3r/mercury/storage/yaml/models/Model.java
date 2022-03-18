package ir.ciph3r.mercury.storage.yaml.models;

import ir.ciph3r.mercury.Mercury;
import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class Model {
	private Mercury mercury;
	private String fileName;
	private File file;
	@Getter
	private FileConfiguration fileConfig;

	public Model(Mercury core, String fileName) {
		this.mercury = core;
		this.fileName = fileName;
	}

	public void setup() {
		try {
			create();
			load();
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		init();
	}

	public abstract void init();

	public void create() {
			file = new File(mercury.getDataFolder(), fileName);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
			}
			mercury.saveResource(fileName, false);
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
