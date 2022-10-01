package ir.ciph3r.mercury.modules.impl.motd.listeners;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MotdListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!(MercuryAPI.INSTANCE.getConfigManager().getValues().MOTD_ON_JOIN)) return;
        if (!(event.getPlayer().hasPermission("mercury.commands.motd"))) return;

        String msg = MercuryAPI.INSTANCE.getDepends().getPapiAPI().setPlaceHolders(event.getPlayer(), MercuryAPI.INSTANCE.getConfigManager().getValues().MOTD_MESSAGE);
        ChatUtils.sendColorizedMSG(event.getPlayer(), msg);
    }
}
