package ir.ciph3r.mercury;

import com.jeff_media.updatechecker.UpdateCheckSource;
import com.jeff_media.updatechecker.UpdateChecker;
import io.github.leonardosnt.bungeechannelapi.BungeeChannelApi;
import ir.ciph3r.mercury.dependency.Depends;
import ir.ciph3r.mercury.modules.CommandManager;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import lombok.Getter;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public enum MercuryAPI {
    INSTANCE;

    private JavaPlugin plugin;
    private long startupTime;
    private Config config;
    private Messages messages;
    private BungeeChannelApi bungeeAPI;
    private Depends depends;
    private CommandManager commandManager;
    private UpdateChecker updateChecker;

    public void start(final JavaPlugin plugin) {
        this.plugin = plugin;

        this.startupTime = System.currentTimeMillis();
        this.config = new Config();
        this.messages = new Messages();
        this.bungeeAPI = BungeeChannelApi.of(getPlugin());
        this.depends = new Depends();
        this.commandManager = new CommandManager();

        updateChecker =  new UpdateChecker(plugin, UpdateCheckSource.CUSTOM_URL, "https://ez-pz.ir/updates/minecraft/Mercury/version.txt")
                .setNotifyByPermissionOnJoin("mercury.events.update.notify")
                .setNotifyOpsOnJoin(getConfig().UPDATE_CHECKER_NOTIFY_ON_JOIN)
                .checkEveryXHours(getConfig().UPDATE_CHECKER_CHECK_DELAY)
                .setDownloadLink("https://github.com/Ciph3r-Zer0/Mercury/releases")
                .setUsedVersion("3.0.0-DEV")
                .checkNow();

        new Metrics(getPlugin(), 14640);
    }

    public void stop() {
        plugin = null;
    }
}
