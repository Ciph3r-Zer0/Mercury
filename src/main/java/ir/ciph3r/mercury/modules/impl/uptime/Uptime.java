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
        super(" Uptime", MercuryAPI.INSTANCE.getConfig().UPTIME_ENABLED);
    }

    @Default
    @CommandPermission("mercury.commands.uptime")
    public void onDefault(CommandSender sender) {
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - MercuryAPI.INSTANCE.getStartupTime());
        long seconds = duration.getSeconds();

        long h = seconds / 3600;
        long m = (seconds % 3600) / 60;
        long s = seconds % 60;


        ChatUtils.sendColorizedMSG(sender, MercuryAPI.INSTANCE.getMessages().UPTIME_MESSAGE
                .replace("{hour}", String.valueOf(h))
                .replace("{minute}", String.valueOf(m))
                .replace("{second}", String.valueOf(s)));
    }
}
