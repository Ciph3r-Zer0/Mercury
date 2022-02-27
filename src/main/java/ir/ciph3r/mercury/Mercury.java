package ir.ciph3r.mercury;

import ir.ciph3r.mercury.modules.base.ModuleManager;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mercury extends JavaPlugin {

	@Override
	public void onEnable() {
		new Config(this).setup();
		new Messages(this).setup();
		new Perms().init();

		new ModuleManager(this).register();
	}

	@Override
	public void onDisable() {
	}
}
