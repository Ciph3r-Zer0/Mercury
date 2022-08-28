package ir.ciph3r.mercury;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mercury extends JavaPlugin {

	//TODO: apply * for commands (* stands for all online players of the server)
	//TODO: find a clean and good way to implement dependencies such as vanish plugins and permission plugins
	//TODO: try to refactor CrossTeleport module and make it compatible with vanish plugins
	//TODO: add setMaxPlayers module
	//TODO: add join/quit message module

	@Override
	public void onEnable() {
		MercuryAPI.INSTANCE.start(this);
	}

	@Override
	public void onDisable() {
		MercuryAPI.INSTANCE.stop();
	}
}
