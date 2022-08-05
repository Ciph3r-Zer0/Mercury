package ir.ciph3r.mercury;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mercury extends JavaPlugin {

	//TODO: fix permission for mercury.commands.***.others to send message

	@Override
	public void onEnable() {
		MercuryAPI.INSTANCE.start(this);
	}

	@Override
	public void onDisable() {
		MercuryAPI.INSTANCE.stop();
	}
}
