package ir.ciph3r.mercury.utility;

import org.bukkit.Bukkit;

public class Logger {

    public static void log(String msg) {
        Bukkit.getServer().getConsoleSender().sendMessage(msg.replace('&', '§'));
    }
}
