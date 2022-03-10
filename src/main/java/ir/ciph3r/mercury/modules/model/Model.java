package ir.ciph3r.mercury.modules.model;

import ir.ciph3r.mercury.Mercury;
import lombok.Getter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public abstract class Model implements Listener, CommandExecutor {
	@Getter
	private String moduleName;
	@Getter
	private String commandName;
	@Getter
	private boolean Enabled;
	@Getter
	private Mercury mercury;

	public Model(String moduleName, String commandName, boolean Enabled, Mercury mercury) {
		this.moduleName = moduleName;
		this.commandName = commandName;
		this.Enabled = Enabled;
		this.mercury = mercury;
	}

	public void register() {
		if (!isEnabled()) return;
		getMercury().getServer().getPluginManager().registerEvents(this, getMercury());
		if (getCommandName() == null) return;
		getMercury().getCommand(getCommandName()).setExecutor(this);
	}
}