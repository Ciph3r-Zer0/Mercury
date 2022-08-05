package ir.ciph3r.mercury.modules;

import co.aikar.commands.BaseCommand;
import ir.ciph3r.mercury.MercuryAPI;
import lombok.Getter;
import org.bukkit.event.Listener;

@Getter
public abstract class CommandModule extends BaseCommand {
    private final String moduleName;
    private final boolean enabled;
    private final Listener listener;
    private String commandName = null;
    private String commandSyntax = null;

    public CommandModule(String moduleName, boolean enabled, Listener listener) {
        this.moduleName = moduleName;
        this.enabled = enabled;
        this.listener = listener;
    }

    public void setCommandNameAndSyntax(String commandName, String commandSyntax) {
        this.commandName = commandName;
        this.commandSyntax = commandSyntax;
    }

    public String getCommandUsage() {
        return MercuryAPI.INSTANCE.getMessages().COMMAND_USAGE_SYNTAX.replace("{command}", getCommandName()).replace("{syntax}", getCommandSyntax());
    }
}