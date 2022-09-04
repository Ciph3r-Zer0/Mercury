package ir.ciph3r.mercury.modules.impl.quit.listeners;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitMessageListener implements Listener {

    @EventHandler
    public void onJoin(PlayerQuitEvent event) {
        event.setQuitMessage(ChatUtils.colorize(MercuryAPI.INSTANCE.getDepends().getPapiAPI().setPlaceHolders(event.getPlayer(), MercuryAPI.INSTANCE.getMessages().MESSAGES_QUIT)));
    }
}
