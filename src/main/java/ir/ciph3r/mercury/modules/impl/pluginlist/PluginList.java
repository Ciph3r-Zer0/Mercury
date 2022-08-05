package ir.ciph3r.mercury.modules.impl.pluginlist;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@CommandAlias("PluginList")
public class PluginList extends CommandModule {
    public PluginList() {
        super("PluginList", MercuryAPI.INSTANCE.getConfig().PLUGIN_LIST_ENABLED, null);
    }

    @Default
    @CommandPermission("mercury.commands.pluginlist")
    public void onDefault(Player player) {
        Plugin[] plugins = Bukkit.getServer().getPluginManager().getPlugins();

        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().PLUGIN_LIST_FIRST_LINE.replace("{amount}", String.valueOf(plugins.length)));

        for (Plugin pl : plugins) {
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().PLUGIN_LIST_LIST_DESIGN
                    .replace("{plugin}", handlePluginActivity(pl))
                    .replace("{version}", pl.getDescription().getVersion()));
        }

        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().PLUGIN_LIST_LAST_LINE.replace("{amount}", String.valueOf(plugins.length)));
    }

    private String handlePluginActivity(Plugin plugin) {
        if (plugin.isEnabled()) {
            return "&a" + plugin.getName();
        } else {
            return "&c" + plugin.getName();
        }
    }
}
