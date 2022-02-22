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

public class GameMode extends ModuleBase {
    public GameMode(Mercury mercury) {
        super("GameMode", "GameMode", true, mercury);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender.hasPermission(Perms.GAMEMODE))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
                return true;
            }
            Player player = (Player) sender;

            if (label.equalsIgnoreCase("GMC")) {
                player.setGameMode(org.bukkit.GameMode.CREATIVE);
                Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", "Creative"));
                return true;
            } else if (label.equalsIgnoreCase("GMS")) {
                player.setGameMode(org.bukkit.GameMode.SURVIVAL);
                Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", "Survival"));
                return true;
            } else if (label.equalsIgnoreCase("GMA")) {
                player.setGameMode(org.bukkit.GameMode.ADVENTURE);
                Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", "Adventure"));
                return true;
            } else if (label.equalsIgnoreCase("GMSP")) {
                player.setGameMode(org.bukkit.GameMode.SPECTATOR);
                Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", "Spectator"));
                return true;
            } else {
                Utils.sendColorizedMessage(player, Messages.NOT_ENOUGH_ARGS);
            }
        }
        }
        return true;
    }
}
