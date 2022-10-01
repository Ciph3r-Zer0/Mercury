package ir.ciph3r.mercury;

import com.jeff_media.updatechecker.UpdateCheckSource;
import com.jeff_media.updatechecker.UpdateChecker;
import ir.ciph3r.mercury.depends.Depends;
import ir.ciph3r.mercury.modules.CommandManager;
import ir.ciph3r.mercury.storage.yaml.ConfigManager;
import ir.ciph3r.mercury.utility.ChatUtils;
import ir.ciph3r.mercury.utility.Logger;
import lombok.Getter;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public enum MercuryAPI {
    INSTANCE;

    private JavaPlugin plugin;
    private ConfigManager configManager;
    private Depends depends;
    private CommandManager commandManager;
    private UpdateChecker updateChecker;

    public void start(final JavaPlugin plugin) {
        ChatUtils.printSplashScreen();
        this.plugin = plugin;

        this.configManager = new ConfigManager();
        this.depends = new Depends();
        this.commandManager = new CommandManager();

        updateChecker =  new UpdateChecker(plugin, UpdateCheckSource.CUSTOM_URL, "https://ez-pz.ir/updates/minecraft/Mercury/version.txt")
                .setNotifyByPermissionOnJoin("mercury.events.update.notify")
                .setNotifyOpsOnJoin(getConfigManager().getValues().UPDATE_CHECKER_NOTIFY_ON_JOIN)
                .checkEveryXHours(getConfigManager().getValues().UPDATE_CHECKER_INTERVAL)
                .setDownloadLink("https://github.com/Ciph3r-Zer0/Mercury/releases")
                .setUsedVersion(getPlugin().getDescription().getVersion())
                .checkNow();

        new Metrics(getPlugin(), 14640);
        Logger.log("");
    }

    public void stop() {
        plugin = null;
    }
}
