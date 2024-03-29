package ir.ciph3r.mercury.modules.impl.mercurycmd;

import co.aikar.commands.annotation.*;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;
import java.util.Locale;

@CommandAlias("mercury|merc")
public class MercuryCMD extends CommandModule {
    public MercuryCMD() {
        super("Mercury", true);
        setCommandNameAndSyntax("/Mercury", "[Reload, GUI]");
    }

    @Default
    @Syntax("[Reload, GUI]")
    @CommandCompletion("reload|gui")
    public void onMercury(CommandSender sender) {
        ChatUtils.sendColorizedMSG(sender, "&5Mercury &8&k||&r &cMercury &7version &c" + MercuryAPI.INSTANCE.getPlugin().getDescription().getVersion() + " &7made by &cCiph3r");
    }

    @Subcommand("Reload")
    @CommandPermission("mercury.commands.reload")
    public void onReload(CommandSender sender) {
        try {
            MercuryAPI.INSTANCE.getConfigManager().reload();
            MercuryAPI.INSTANCE.getCommandManager().commandManager.getLocales().loadYamlLanguageFile("messages.yml", Locale.ENGLISH);
            MercuryAPI.INSTANCE.getCommandManager().registerPlaceHolders();

            ChatUtils.sendColorizedMSG(sender, MercuryAPI.INSTANCE.getConfigManager().getValues().RELOAD_MESSAGE.replace("{status}", "&aSuccess"));
        } catch (IOException | InvalidConfigurationException e) {
            ChatUtils.sendColorizedMSG(sender, MercuryAPI.INSTANCE.getConfigManager().getValues().RELOAD_MESSAGE.replace("{status}", "&cFail"));
            e.printStackTrace();
        }
    }

//    @Subcommand("gui")
//    @CommandPermission("mercury.commands.gui")
//    public void onGUI(Player player) {
//    }
}
