package ir.ciph3r.mercury.modules.impl.uptime;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;

import java.time.Duration;

@CommandAlias("Uptime")
public class Uptime extends CommandModule {
    public Uptime() {
        super(" Uptime", MercuryAPI.INSTANCE.getConfigManager().getValues().UPTIME_ENABLED);
        setCommandNameAndSyntax("/Uptime", null);

        this.startupTime = System.currentTimeMillis();
    }

    private final long startupTime;

    @Default
    @CommandPermission("mercury.commands.uptime")
    public void onUptime(CommandSender sender) {
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - startupTime);
        long seconds = duration.getSeconds();

        long h = seconds / 3600;
        long m = (seconds % 3600) / 60;
        long s = seconds % 60;


        ChatUtils.sendColorizedMSG(sender, MercuryAPI.INSTANCE.getConfigManager().getValues().UPTIME_MESSAGE
                .replace("{hour}", String.valueOf(h))
                .replace("{minute}", String.valueOf(m))
                .replace("{second}", String.valueOf(s)));
    }
}
