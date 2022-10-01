package ir.ciph3r.mercury;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mercury extends JavaPlugin {

	//TODO: apply * for commands (* stands for all online players of the server)
	//TODO: add setMaxPlayers module
	//TODO: add TPA module
	//TODO: add CommandSpy module
	//TODO: add Weather module
	//TODO: add ClearChat module [done]

	@Override
	public void onEnable() {
		MercuryAPI.INSTANCE.start(this);
	}

	@Override
	public void onDisable() {
		MercuryAPI.INSTANCE.stop();
	}
}
