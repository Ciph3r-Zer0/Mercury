package ir.ciph3r.mercury;

import ir.ciph3r.mercury.libs.BungeeChannelApi;
import ir.ciph3r.mercury.modules.model.ModuleManager;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mercury extends JavaPlugin {
	private static Mercury mercury;
	@Getter
	public BungeeChannelApi bungeeAPI;
	@Getter
	private Config configFile;
	@Getter
	private Messages messagesFile;

	@Override
	public void onEnable() {
		mercury = this;
		configFile = new Config(this);
		messagesFile = new Messages(this);
		new Perms().init();
		bungeeAPI = BungeeChannelApi.of(this);

		new ModuleManager(this).register();
	}

	@Override
	public void onDisable() {
		mercury = null;
	}

	public static Mercury getInst() {
		return mercury;
	}
}
