package ir.ciph3r.mercury.utility;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {

	public static void sendColorizedMessage(Player player, String msg) {
		player.sendMessage(colorize(msg));
	}

	public static void sendColorizedMessage(CommandSender sender, String msg) {
		sender.sendMessage(colorize(msg));
	}

	private static String colorize(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}
