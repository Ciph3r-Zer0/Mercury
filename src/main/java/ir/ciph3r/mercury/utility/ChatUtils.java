package ir.ciph3r.mercury.utility;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChatUtils {
    public static String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void sendColorizedMSG(Player player, String msg) {
        player.sendMessage(colorize(msg));
    }

    public static void sendColorizedMSG(CommandSender sender, String msg) {
        sender.sendMessage(colorize(msg));
    }

    public static void sendColorizedMSG(ConsoleCommandSender sender, String msg) {
        sender.sendMessage(colorize(msg));
    }

    public static void broadcastToServer(String msg) {
        Bukkit.getServer().broadcastMessage(colorize(msg));
    }

    public static void broadcastToWorld(Player player, String msg) {
        player.getWorld().getPlayers().forEach(p -> {
            sendColorizedMSG(p, msg);
        });
    }
}
