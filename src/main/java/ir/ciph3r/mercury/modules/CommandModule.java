package ir.ciph3r.mercury.modules;

import co.aikar.commands.BaseCommand;
import ir.ciph3r.mercury.MercuryAPI;
import lombok.Getter;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Collections;

@Getter
public abstract class CommandModule extends BaseCommand {
    private final String moduleName;
    private final boolean enabled;
    private final ArrayList<Listener> listeners = new ArrayList<>();
    private String commandName = null;
    private String commandSyntax = null;

    public CommandModule(String moduleName, boolean enabled) {
        this.moduleName = moduleName;
        this.enabled = enabled;
    }

    public void setCommandNameAndSyntax(String commandName, String commandSyntax) {
        this.commandName = commandName;
        this.commandSyntax = commandSyntax;
    }

    public String getCommandUsage() {
        return MercuryAPI.INSTANCE.getConfigManager().getValues().COMMAND_USAGE_SYNTAX.replace("{command}", getCommandName()).replace("{syntax}", getCommandSyntax());
    }

    public void addListeners(Listener... listeners) {
        Collections.addAll(this.listeners, listeners);
    }
}