package ir.ciph3r.mercury.utility;

import ir.ciph3r.mercury.Mercury;
import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Universal {
    @Getter
    private final Mercury mercury;
    public Universal(Mercury mercury) {
        this.mercury = mercury;
    }

    public void sendColorizedMessage(Player player, String msg) {
        player.sendMessage(colorize(msg));
    }

    public void sendColorizedMessage(CommandSender sender, String msg) {
        sender.sendMessage(colorize(msg));
    }

    public void broadcastToServer(String msg) {
        Bukkit.getServer().broadcastMessage(colorize(msg));
    }

    private String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public int getRandomNumber(int min, int max, int current) {
        int generated = (int) ((Math.random() * (max - min)) + min);

        while (generated == current) {
            generated = (int) ((Math.random() * (max - min)) + min);
        }
        return generated;
    }

    public double getRandomNumber(double min, double max, double current) {
        double generated = (double) ((Math.random() * (max - min)) + min);

        while (generated == current) {
            generated = (double) ((Math.random() * (max - min)) + min);
        }
        return generated;
    }

    public boolean isDouble(String strNum) {
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

    public boolean isInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String serializeLocation(Location loc) {
        return String.valueOf(loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ() + "," + loc.getYaw() + "," + loc.getPitch());
    }

    public Location deSerializeLocation(String loc) {
        String[] args = loc.split(",");
        World world = Bukkit.getWorld(args[0]);
        double x = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double z = Double.parseDouble(args[3]);
        float yaw = Float.parseFloat(args[4]);
        float pitch = Float.parseFloat(args[5]);

        return new Location(world, x, y, z, yaw, pitch);
    }

    public String createStringFromArray(String[] args, int from, int to) {
        StringBuilder builder = new StringBuilder();
        for (String s : Arrays.copyOfRange(args, from, to)) {
            builder.append(s).append(" ");
        }
        return builder.toString();
    }
}
