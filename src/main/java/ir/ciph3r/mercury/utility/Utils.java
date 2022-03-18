package ir.ciph3r.mercury.utility;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.libs.BungeeChannelApi;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

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

    public static String serializeLocation(Location loc) {
        return String.valueOf(loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ() + "," + loc.getYaw() + "," + loc.getPitch());
    }

    public static Location deSerializeLocation(String loc) {
        String[] args = loc.split(",");
        World world = Bukkit.getWorld(args[0]);
        double x = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double z = Double.parseDouble(args[3]);
        float yaw = Float.parseFloat(args[4]);
        float pitch = Float.parseFloat(args[5]);

        return new Location(world, x, y, z, yaw, pitch);
    }

    public static boolean isPlayerOnlineProxy(String playerName) {
        BungeeChannelApi bungeeAPI = Mercury.getInst().getBungeeAPI();

        CompletableFuture<List<String>> l = bungeeAPI.getPlayerList("ALL");
        if (l.isDone()) {
            try {
                if (l.get().contains(playerName)) return true;
            } catch (ExecutionException | InterruptedException e) {
                return false;
            }
        }
        return false;
//        bungeeAPI.getPlayerList("ALL").whenComplete((allPlayers, throwable) -> {
//            if (allPlayers.contains(playerName)) atomicBoolean.set(true);
//        });
    }

    public static String getProxyPlayerServerName(String playerName) {
        BungeeChannelApi bungeeAPI = Mercury.getInst().getBungeeAPI();
        boolean isOnline = isPlayerOnlineProxy(playerName);
        AtomicReference<String> serverName = new AtomicReference<>(null);

        if (isOnline) {
            bungeeAPI.getServers().whenComplete((allServers, throwable) -> {
                allServers.forEach(server -> {
                    bungeeAPI.getPlayerList(server).whenCompleteAsync((perServerPlayerList, throwable1) -> {
                        if (perServerPlayerList.contains(playerName)) {
                            serverName.set(String.valueOf(perServerPlayerList));
                        }
                    });
                });
            });
        }
        return serverName.get();
    }
}
