package ir.ciph3r.mercury;

import ir.ciph3r.mercury.modules.Fly;
import ir.ciph3r.mercury.modules.GameMode;
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
		new Fly(this).register();
		new GameMode(this).register();
	}

	@Override
	public void onDisable() {
	}
}
