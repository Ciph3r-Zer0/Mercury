package ir.ciph3r.mercury.modules;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.base.ModuleBase;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import ir.ciph3r.mercury.utility.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Gamemode extends ModuleBase {
    public Gamemode(Mercury mercury) {
        super("Gamemode", "Gamemode", Config.GAMEMODE_ENABLED, mercury);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        System.out.println("gamemode command executed");
        if (!(sender.hasPermission(Perms.GAMEMODE))) {
            Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
            return true;
        }
        System.out.println(1);
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
                return true;
            }
            Player player = (Player) sender;
            System.out.println(2);
            for (String alias : cmd.getAliases()) {
                System.out.println(3);
                if (alias.equalsIgnoreCase("GMC")) {
                    player.setGameMode(GameMode.CREATIVE);
                    Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", "Creative"));
                    return true;
                } else if (alias.equalsIgnoreCase("GMS")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", "Survival"));
                    return true;
                } else if (alias.equalsIgnoreCase("GMA")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", "Adventure"));
                    return true;
                } else if (alias.equalsIgnoreCase("GMSP")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    Utils.sendColorizedMessage(player, Messages.GAMEMODE_CHANGED.replace("{gamemode}", "Spectator"));
                    return true;
                }
            }
        }
        return true;
    }
}
