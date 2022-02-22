package ir.ciph3r.mercury;

import ir.ciph3r.mercury.modules.Fly;
import ir.ciph3r.mercury.modules.Gamemode;
import ir.ciph3r.mercury.modules.Nickname;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.sql.DataSource;
import ir.ciph3r.mercury.storage.sql.event.V_1_13_2;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mercury extends JavaPlugin {

	@Override
	public void onEnable() {
		new Config(this).setup();
		new Messages(this).setup();
		new Perms().init();
		getServer().getPluginManager().registerEvents(new V_1_13_2(),this);
		new DataSource(this).SQLite();
		new Fly(this).register();
		new Nickname(this).register();
		new Gamemode(this).register();
	}

	@Override
	public void onDisable() {
	}
}
