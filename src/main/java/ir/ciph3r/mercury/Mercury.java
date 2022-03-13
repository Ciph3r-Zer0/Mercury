package ir.ciph3r.mercury;

import ir.ciph3r.mercury.libs.BungeeChannelApi;
import ir.ciph3r.mercury.modules.model.ModuleManager;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mercury extends JavaPlugin {
	private static Mercury mercury;
	public BungeeChannelApi bungeeAPI;

	@Override
	public void onEnable() {
		mercury = this;
		new Config(this).setup();
		new Messages(this).setup();
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
