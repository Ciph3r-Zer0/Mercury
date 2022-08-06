package ir.ciph3r.mercury.modules.impl.gamemode;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Gamemode")
public class Gamemode extends CommandModule {
    public Gamemode() {
        super("Gamemode", MercuryAPI.INSTANCE.getConfig().GAMEMODE_ENABLED);
        setCommandNameAndSyntax("/Gamemode", "<Creative, Survival, Adventure, Spectator> [player]");
    }
    @Default
    @Syntax("<Creative, Survival, Adventure, Spectator> [player]")
    @CommandPermission("mercury.commands.gamemode")
    @CommandCompletion("creative|survival|adventure|spectator")
    public void onDefault(CommandSender sender) {
        ChatUtils.sendColorizedMSG(sender, getCommandUsage());
    }

    @Syntax("[player]")
    @Subcommand("Creative|C")
    @CommandAlias("GMC")
    @CommandPermission("mercury.commands.gamemode.creative")
    @CommandCompletion("@players")
    public void onCreative(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setGameMode(GameMode.CREATIVE);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE.replace("{gamemode}", "Creative"));
        } else {
            if (player.hasPermission("mercury.commands.gamemode.others.creative")) {
                target.getPlayer().setGameMode(GameMode.CREATIVE);
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()).replace("{gamemode}", "Creative"));
            }
        }
    }

    @Syntax("[player]")
    @Subcommand("Survival|S")
    @CommandAlias("GMS")
    @CommandPermission("mercury.commands.gamemode.survival")
    @CommandCompletion("@players")
    public void onSurvival(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setGameMode(GameMode.SURVIVAL);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE.replace("{gamemode}", "Survival"));
        } else {
            if (player.hasPermission("mercury.commands.gamemode.others.survival")) {
                target.getPlayer().setGameMode(GameMode.SURVIVAL);
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()).replace("{gamemode}", "Survival"));
            }
        }
    }

    @Syntax("[player]")
    @Subcommand("Adventure|A")
    @CommandAlias("GMA")
    @CommandPermission("mercury.commands.gamemode.adventure")
    @CommandCompletion("@players")
    public void onAdventure(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setGameMode(GameMode.ADVENTURE);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE.replace("{gamemode}", "Adventure"));
        } else {
            if (player.hasPermission("mercury.commands.gamemode.others.adventure")) {
                target.getPlayer().setGameMode(GameMode.ADVENTURE);
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()).replace("{gamemode}", "Adventure"));
            }
        }
    }

    @Syntax("[player]")
    @Subcommand("Spectator|SP")
    @CommandAlias("GMSP")
    @CommandPermission("mercury.commands.gamemode.spectator")
    @CommandCompletion("@players")
    public void onSpectator(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setGameMode(GameMode.SPECTATOR);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE.replace("{gamemode}", "Spectator"));
        } else {
            if (player.hasPermission("mercury.commands.gamemode.others.spectator")) {
                target.getPlayer().setGameMode(GameMode.SPECTATOR);
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()).replace("{gamemode}", "Spectator"));
            }
        }
    }
}
