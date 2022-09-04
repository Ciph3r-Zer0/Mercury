package ir.ciph3r.mercury.modules.impl.messages.listeners;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessageListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!(event.getPlayer().hasPlayedBefore())) {
            event.setJoinMessage(ChatUtils.colorize(MercuryAPI.INSTANCE.getMessages().MESSAGES_FIRST_JOIN.replace("{player}", event.getPlayer().getName())));
        } else {
            event.setJoinMessage(ChatUtils.colorize(MercuryAPI.INSTANCE.getMessages().MESSAGES_JOIN.replace("{player}", event.getPlayer().getName())));
        }
    }
}
