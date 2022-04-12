package ir.ciph3r.mercury.modules.pluginlist;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.ModuleModel;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class PluginList extends ModuleModel {
    public PluginList(Mercury mercury) {
        super(mercury, "PluginList", "PluginList", mercury.getConfigFile().PLUGIN_LIST_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.PLUGIN_LIST))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.PLUGIN_LIST));
            return true;
        }
        List<List<Plugin>> plugins = chopped(new ArrayList<>(List.of(Bukkit.getPluginManager().getPlugins())), getConfig().PLUGIN_LIST_PLUGIN_PER_PAGE);
        int pluginPerPage = getConfig().PLUGIN_LIST_PLUGIN_PER_PAGE;
        int pluginCount = Bukkit.getPluginManager().getPlugins().length;

        if (args.length == 0) {
            getUniversal().sendColorizedMessage(sender, getMessages().PLUGIN_LIST_HEAD_FORMAT.replace("{plugincount}", String.valueOf(pluginCount)));
            if (!(pluginCount == 0)) {
                for (Plugin plugin : plugins.get(0)) {
                    getUniversal().sendColorizedMessage(sender, getMessages().PLUGIN_LIST_LINE_FORMAT
                            .replace("{plugin}", plugin.getName())
                            .replace("{version}", plugin.getDescription().getVersion())
                            .replace("{status}", getPluginStatusWithColor(plugin))
                            .replace("{description}", getPluginDescription(plugin)));
                }
                if (plugins.size() - 1 > 1) getUniversal().sendColorizedMessage(sender, getMessages().NEXT_PAGE_AVAILABLE.replace("{nextpage}", String.valueOf(2)));
            }
        } else if (args.length == 1) {
            if (!(getUniversal().isInt(args[0]))) {
                getUniversal().sendColorizedMessage(sender, getMessages().ARGS_NOT_NUMBER);
                return true;
            }
            int pageNumber = Integer.parseInt(args[0]) - 1;

            try {
                for (Plugin plugin : plugins.get(pageNumber)) {
                    getUniversal().sendColorizedMessage(sender, getMessages().PLUGIN_LIST_LINE_FORMAT
                            .replace("{plugin}", plugin.getName())
                            .replace("{version}", plugin.getDescription().getVersion())
                            .replace("{status}", getPluginStatusWithColor(plugin))
                            .replace("{description}", getPluginDescription(plugin)));
                }
                if (pageNumber < plugins.size() - 1) getUniversal().sendColorizedMessage(sender, getMessages().NEXT_PAGE_AVAILABLE.replace("{nextpage}", String.valueOf(pageNumber + 2)));
            } catch (IndexOutOfBoundsException e) {
                getUniversal().sendColorizedMessage(sender, getMessages().PAGE_NOT_FOUND);
            }
        }
        return true;
    }

    private String getPluginStatusWithColor(Plugin plugin) {
        if (plugin.isEnabled()) {
            return "&aEnabled";
        } else {
            return "&4Disabled";
        }
    }

    private String getPluginDescription(Plugin plugin) {
        if (!(plugin.getDescription().getDescription() == null)) {
            return plugin.getDescription().getDescription();
        }
        return "null";
    }

    private <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }
}
