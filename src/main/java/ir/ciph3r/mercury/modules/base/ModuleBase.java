package ir.ciph3r.mercury.modules.base;

import ir.ciph3r.mercury.Mercury;
import lombok.Getter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public abstract class ModuleBase implements Listener, CommandExecutor {
	@Getter
	private String moduleName;
	@Getter
	private String commandName;
	@Getter
	private boolean isEnabled;
	@Getter
	private Mercury mercury;

	public ModuleBase(String moduleName, String commandName, boolean isEnabled, Mercury mercury) {
		this.moduleName = moduleName;
		this.commandName = commandName;
		this.isEnabled = isEnabled;
		this.mercury = mercury;
	}

	public void register() {
		if (!isEnabled) return;
		mercury.getServer().getPluginManager().registerEvents(this,mercury);
		if (commandName != null) mercury.getCommand(commandName).setExecutor(this);
	}

//	public abstract void command(CommandSender sender, Command cmd, String label, String[] args);
//
//	@Override
//	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//		command(sender, cmd, label, args);
//		return true;
//	}
}