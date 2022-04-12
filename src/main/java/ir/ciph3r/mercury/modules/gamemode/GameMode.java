package ir.ciph3r.mercury.modules.gamemode;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.model.ModuleModel;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GameMode extends ModuleModel {
    public GameMode(Mercury mercury) {
        super(mercury, "GameMode", "GameMode", mercury.getConfigFile().GAMEMODE_ENABLED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission(Perms.GAMEMODE))) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.GAMEMODE));
            return true;
        }
        if (!(sender instanceof Player)) {
            getUniversal().sendColorizedMessage(sender, getMessages().NO_CONSOLE);
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            if (label.equalsIgnoreCase("GameMode")) {
                getUniversal().sendColorizedMessage(sender, getMessages().GAMEMODE_USAGE);
            } else {
                updateGameMode(player, null, label);
            }
            return true;
        } else if (args.length == 1) {
            if (label.equalsIgnoreCase("GameMode")) {
                updateGameMode(player, null, args[0]);
            } else {
                if (!(sender.hasPermission(Perms.GAMEMODE_OTHERS))) {
                    getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.GAMEMODE_OTHERS));
                    return true;
                }
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    getUniversal().sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[0]));
                } else {
                    updateGameMode(target, player, label);
                }
            }
            return true;
        } else if (args.length == 2) {
            if (!(sender.hasPermission(Perms.GAMEMODE_OTHERS))) {
                getUniversal().sendColorizedMessage(sender, getMessages().NO_PERMISSION.replace("{permission}", Perms.GAMEMODE_OTHERS));
                return true;
            }
            if (label.equalsIgnoreCase("GameMode")) {
                Player target = Bukkit.getServer().getPlayerExact(args[1]);
                if (target == null) {
                    getUniversal().sendColorizedMessage(player, getMessages().PLAYER_NOT_FOUND.replace("{player}", args[1]));
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
            getUniversal().sendColorizedMessage(player, getMessages().GAMEMODE_CHANGED.replace("{gamemode}", gameMode.name()));
            if (admin != null) {
                getUniversal().sendColorizedMessage(admin, getMessages().GAMEMODE_CHANGED_ADMIN.replace("{gamemode}", gameMode.name()).replace("{player}", player.getName()));
            }
            return true;
        }
        return false;
    }
}
