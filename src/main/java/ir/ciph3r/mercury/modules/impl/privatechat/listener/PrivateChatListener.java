package ir.ciph3r.mercury.modules.impl.privatechat.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class PrivateChatListener implements org.bukkit.event.Listener {
    public static HashMap<String, String> replyList = new HashMap<>();

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        replyList.remove(event.getPlayer().getName());
        replyList.values().remove(event.getPlayer().getName());
    }
}
