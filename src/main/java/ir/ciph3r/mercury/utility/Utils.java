package ir.ciph3r.mercury.utility;

import ir.ciph3r.mercury.Mercury;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

    public static boolean isPlayerOnlineProxySide(String playerName) {
        try {
            CompletableFuture<List<String>> servers = Mercury.getInst().bungeeAPI.getServers();

            for (String s : servers.get()) {
                CompletableFuture<List<String>> players = Mercury.getInst().bungeeAPI.getPlayerList(s);
                for (String p : players.get()) {
                    if (p.equalsIgnoreCase(playerName)) {
                        return true;
                    }
                }
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getProxyTargetServerName(String playerName) {
        try {
            CompletableFuture<List<String>> servers = Mercury.getInst().bungeeAPI.getServers();


            for (String s : servers.get()) {
                CompletableFuture<List<String>> players = Mercury.getInst().bungeeAPI.getPlayerList(s);
                for (String p : players.get()) {
                    if (p.equalsIgnoreCase(playerName)) {
                        return s;
                    }
                }
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void connectToProxyPlayer(Player admin, String target) {
        String targetServer = getProxyTargetServerName(target);

        byte[] data = "mercury-crosstp".getBytes();
        Mercury.getInst().bungeeAPI.connect(admin, targetServer);
        Mercury.getInst().bungeeAPI.forward(targetServer, "mercury", data);
    }
}
