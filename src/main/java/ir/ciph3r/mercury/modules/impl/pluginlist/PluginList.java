package ir.ciph3r.mercury.modules.impl.pluginlist;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@CommandAlias("PluginList")
public class PluginList extends CommandModule {
    public PluginList() {
        super("PluginList", MercuryAPI.INSTANCE.getConfigManager().getValues().PLUGIN_LIST_ENABLED);
        setCommandNameAndSyntax("/PluginList", null);
    }

    @Default
    @CommandPermission("mercury.commands.pluginlist")
    public void onPluginList(CommandSender sender) {
        Plugin[] plugins = Bukkit.getServer().getPluginManager().getPlugins();
        String list = MercuryAPI.INSTANCE.getConfigManager().getValues().PLUGIN_LIST_MESSAGE.replace("{amount}", String.valueOf(plugins.length));
        StringBuilder pluginList = new StringBuilder();

        for (Plugin p: plugins) {
            pluginList.append(MercuryAPI.INSTANCE.getConfigManager().getValues().PLUGIN_LIST_LIST_DESIGN
                    .replace("{plugin}", handlePluginActivity(p))
                    .replace("{version}", p.getDescription().getVersion())).append("\n");
        }

        ChatUtils.sendColorizedMSG(sender, list.replace("{list_design}", pluginList.toString()));
    }

    private String handlePluginActivity(Plugin plugin) {
        if (plugin.isEnabled()) {
            return "&a" + plugin.getName();
        } else {
            return "&c" + plugin.getName();
        }
    }
}
