package ir.ciph3r.mercury.utility.runnables;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CTPRunnable extends BukkitRunnable {
    private final String adminName;
    private final String targetName;
    private int timeOut = 0;

    public CTPRunnable(String adminName, String targetName) {
        this.adminName = adminName;
        this.targetName = targetName;
    }

    @Override
    public void run() {
        Player admin = Bukkit.getPlayer(adminName);
        Player target = Bukkit.getPlayer(targetName);
        if (admin == null) {
            timeOut++;
            System.out.println(timeOut);
        }  else {
            if (target == null) {
                ChatUtils.sendColorizedMSG(admin, MercuryAPI.INSTANCE.getMessages().NO_PLAYER_FOUND_SERVER.replace("{search}", targetName));
            } else {
                admin.teleport(target);
            }
            cancel();
        }

        if (timeOut == 60) {
            cancel();
        }
    }

    public synchronized void cancel() throws IllegalStateException{
        super.cancel();
    }
}
