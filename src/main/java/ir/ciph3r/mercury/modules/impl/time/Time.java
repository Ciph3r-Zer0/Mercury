package ir.ciph3r.mercury.modules.impl.time;

import co.aikar.commands.annotation.*;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Time")
public class Time extends CommandModule {
    public Time() {
        super("Time", MercuryAPI.INSTANCE.getConfigManager().getValues().TIME_ENABLED);
        setCommandNameAndSyntax("/Time", "<set> <Day, 1000, Night>");
    }

    @Default
    @Syntax("<set> <day, 1000, night>")
    @CommandPermission("mercury.commands.time")
    @CommandCompletion("set")
    public void onTime(CommandSender player) {
        ChatUtils.sendColorizedMSG(player, getCommandUsage());
    }

    @Syntax("<day, 1000, night>")
    @Subcommand("Set Day")
    @CommandAlias("Day")
    @CommandPermission("mercury.commands.time")
    @CommandCompletion("Day|Night")
    public void onTimeDay(Player player) {
        player.getWorld().setTime(1000);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().TIME_MESSAGE);
    }

    @Syntax("<day, 1000, night>")
    @Subcommand("Set Night")
    @CommandAlias("Night")
    @CommandPermission("mercury.commands.time")
    @CommandCompletion("Day|Night")
    public void onTimeNight(Player player) {
        player.getWorld().setTime(13000);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().TIME_MESSAGE);
    }

    @Syntax("<day, 1000, night>")
    @Subcommand("set")
    @CommandPermission("mercury.commands.time")
    @CommandCompletion("1000")
    public void onTimeSet(Player player, long time) {
        player.getWorld().setTime(time);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().TIME_MESSAGE);
    }
}
