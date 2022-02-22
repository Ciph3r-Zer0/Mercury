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

import java.util.Arrays;
import java.util.List;


public class GameMode extends ModuleBase {
    public GameMode(Mercury mercury) {
        super("GameMode", "GameMode", Config.GAMEMODE_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.GAMEMODE))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }

        if (!(sender instanceof Player)) {
            Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (label.equalsIgnoreCase("GameMode")) {
                Utils.sendColorizedMessage(sender, Messages.NOT_ENOUGH_ARGS);
            } else {
                updateGameMode(player, null, label);
            }
            return true;
        } else if (args.length == 1) {
            if (label.equalsIgnoreCase("GameMode")) {
                updateGameMode(player, null, args[0]);
            } else {
                if (!(sender.hasPermission(Perms.GAMEMODE_OTHERS))) {
                    Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
                    return true;
                }
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND);
                } else {
                    updateGameMode(target, player, label);
                }
            }
            return true;
        } else if (args.length == 2) {
            if (!(sender.hasPermission(Perms.GAMEMODE_OTHERS))) {
                Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
                return true;
            }
            if (label.equalsIgnoreCase("GameMode")) {
                Player target = Bukkit.getServer().getPlayerExact(args[1]);
                if (target == null) {
                    Utils.sendColorizedMessage(player, Messages.PLAYER_NOT_FOUND);
                } else {
                    updateGameMode(target, player, args[0]);
                }
            }
            return true;
        }
        return true;
    }

    private org.bukkit.GameMode findGameMode(String gameMode) {
        for (org.bukkit.GameMode each : org.bukkit.GameMode.values()) {
            if (each.name().compareToIgnoreCase(gameMode) == 0) {
                return each;
            }
        }
        if (gameMode.equalsIgnoreCase("gmc") || gameMode.equalsIgnoreCase("c")) return org.bukkit.GameMode.CREATIVE;
        if (gameMode.equalsIgnoreCase("gms") || gameMode.equalsIgnoreCase("s")) return org.bukkit.GameMode.SURVIVAL;
        if (gameMode.equalsIgnoreCase("gma") || gameMode.equalsIgnoreCase("a")) return org.bukkit.GameMode.ADVENTURE;
        if (gameMode.equalsIgnoreCase("gmsp") || gameMode.equalsIgnoreCase("sp")) return org.bukkit.GameMode.SPECTATOR;
        return null;
    }

    private boolean updateGameMode(Player player, Player admin, String chosenGameMode) {
        org.bukkit.GameMode gameMode = findGameMode(chosenGameMode);
        if (gameMode != null) {
            player.setGameMode(gameMode);
            Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", gameMode.name()));
            if (admin != null) {
                Utils.sendColorizedMessage(admin, Messages.GAMEMODE_CHANGED_ADMIN.replace("{gamemode}", gameMode.name()).replace("{player}", player.getName()));
            }
            return true;
        }
        return false;
    }
}
