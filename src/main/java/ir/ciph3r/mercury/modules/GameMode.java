package ir.ciph3r.mercury.modules;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.base.ModuleBase;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;


public class GameMode extends ModuleBase {
    public GameMode(Mercury mercury) {
        super("GameMode", "GameMode", Config.GAMEMODE_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender.hasPermission(Perms.GAMEMODE))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }

        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
            return true;
        }

        if (args.length == 0) {
            Player player = (Player) sender;
            updateGameMode(player, label);
        } else if (args.length == 1) {
            Player player = (Player) sender;
            updateGameMode(player, args[0]);
        } else if (args.length == 2) {
            Player target = Bukkit.getServer().getPlayerExact(args[1]);
            updateGameMode(target, args[0]);
        }
        return true;
    }

    public org.bukkit.GameMode findGameMode(String gameMode) {
        for (org.bukkit.GameMode each : org.bukkit.GameMode.values()) {
            if (each.name().compareToIgnoreCase(gameMode) == 0) {
                return each;
            }
        }
        if (gameMode.equalsIgnoreCase("gmc")) return org.bukkit.GameMode.CREATIVE;
        if (gameMode.equalsIgnoreCase("gms")) return org.bukkit.GameMode.SURVIVAL;
        if (gameMode.equalsIgnoreCase("gma")) return org.bukkit.GameMode.ADVENTURE;
        if (gameMode.equalsIgnoreCase("gmsp")) return org.bukkit.GameMode.SPECTATOR;
        return null;
    }

    public boolean updateGameMode(Player player, String chosenGameMode) {
        org.bukkit.GameMode gameMode = findGameMode(chosenGameMode);
        if (gameMode != null) {
            player.setGameMode(gameMode);
            Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", gameMode.name()));
            return true;
        }
        return false;
    }
}
