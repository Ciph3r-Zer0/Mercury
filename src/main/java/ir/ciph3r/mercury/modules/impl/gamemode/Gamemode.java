package ir.ciph3r.mercury.modules.impl.gamemode;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Gamemode|GM")
public class Gamemode extends CommandModule {
    public Gamemode() {
        super("Gamemode", MercuryAPI.INSTANCE.getConfig().GAMEMODE_ENABLED);
        setCommandNameAndSyntax("/Gamemode", "<Creative, Survival, Adventure, Spectator> [player]");
    }

    @Default
    @Syntax("<Creative, Survival, Adventure, Spectator> [player]")
    @CommandPermission("mercury.commands.gamemode")
    @CommandCompletion("creative|survival|adventure|spectator")
    public void onA(CommandSender sender) {
        ChatUtils.sendColorizedMSG(sender, getCommandUsage());
    }

    @Syntax("[player]")
    @Subcommand("Creative|C")
    @CommandAlias("GMC")
    @CommandPermission("mercury.commands.gamemode.creative")
    @CommandCompletion("@players")
    public void onCreative(Player player) {
        player.setGameMode(GameMode.CREATIVE);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE.replace("{gamemode}", "Creative"));
    }

    @Syntax("[player]")
    @Subcommand("Creative|C")
    @CommandAlias("GMC")
    @CommandPermission("mercury.commands.gamemode.creative.others")
    @CommandCompletion("@players")
    public void onCreativeOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().setGameMode(GameMode.CREATIVE);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()).replace("{gamemode}", "Creative"));
    }

    @Syntax("[player]")
    @Subcommand("Survival|S")
    @CommandAlias("GMS")
    @CommandPermission("mercury.commands.gamemode.survival")
    @CommandCompletion("@players")
    public void onSurvival(Player player) {
        player.setGameMode(GameMode.SURVIVAL);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE.replace("{gamemode}", "Survival"));
    }

    @Syntax("[player]")
    @Subcommand("Survival|S")
    @CommandAlias("GMS")
    @CommandPermission("mercury.commands.gamemode.survival.others")
    @CommandCompletion("@players")
    public void onSurvivalOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().setGameMode(GameMode.SURVIVAL);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()).replace("{gamemode}", "Survival"));
    }

    @Syntax("[player]")
    @Subcommand("Adventure|A")
    @CommandAlias("GMA")
    @CommandPermission("mercury.commands.gamemode.adventure")
    @CommandCompletion("@players")
    public void onAdventure(Player player) {
        player.setGameMode(GameMode.ADVENTURE);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE.replace("{gamemode}", "Adventure"));
    }

    @Syntax("[player]")
    @Subcommand("Adventure|A")
    @CommandAlias("GMA")
    @CommandPermission("mercury.commands.gamemode.adventure.others")
    @CommandCompletion("@players")
    public void onAdventureOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().setGameMode(GameMode.ADVENTURE);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()).replace("{gamemode}", "Adventure"));
    }

    @Syntax("[player]")
    @Subcommand("Spectator|SP")
    @CommandAlias("GMSP")
    @CommandPermission("mercury.commands.gamemode.spectator")
    @CommandCompletion("@players")
    public void onSpectator(Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE.replace("{gamemode}", "Spectator"));
    }

    @Syntax("[player]")
    @Subcommand("Spectator|SP")
    @CommandAlias("GMSP")
    @CommandPermission("mercury.commands.gamemode.spectator.others")
    @CommandCompletion("@players")
    public void onSpectatorOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().setGameMode(GameMode.SPECTATOR);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().GAMEMODE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()).replace("{gamemode}", "Spectator"));
    }
}
