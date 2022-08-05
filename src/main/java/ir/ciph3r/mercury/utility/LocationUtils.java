package ir.ciph3r.mercury.utility;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.text.DecimalFormat;

public class LocationUtils {
    public static String serializeLocation(Location loc) {
        final DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return String.valueOf(loc.getWorld().getName() + "," +
                loc.getX() + "," +
                loc.getY() + "," +
                loc.getZ() + "," +
                loc.getYaw() + "," +
                loc.getPitch());
    }

    public static Location deserializeLocation(String loc) {
        String[] args = loc.split(",");
        World world = Bukkit.getWorld(args[0]);
        double x = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double z = Double.parseDouble(args[3]);
        float yaw = Float.parseFloat(args[4]);
        float pitch = Float.parseFloat(args[5]);

        return new Location(world, x, y, z, yaw, pitch);
    }
}
