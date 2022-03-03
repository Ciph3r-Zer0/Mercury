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

	public static int getRandomNumber(int min, int max, int current) {
		int generated = (int) ((Math.random() * (max - min)) + min);

		while (generated == current) {
			generated = (int) ((Math.random() * (max - min)) + min);
		}
		return generated;
	}

	public static double getRandomNumber(double min, double max, double current) {
		double generated = (double) ((Math.random() * (max - min)) + min);

		while (generated == current) {
			generated = (double) ((Math.random() * (max - min)) + min);
		}
		return generated;
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
