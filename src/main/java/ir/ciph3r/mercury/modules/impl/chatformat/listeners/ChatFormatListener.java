package ir.ciph3r.mercury.modules.impl.chatformat.listeners;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = player.hasPermission("mercury.events.chat.color") ? ChatUtils.colorize(event.getMessage()) : ChatColor.stripColor(event.getMessage());
        event.setFormat(MercuryAPI.INSTANCE.getDepends().getPapiAPI().setPlaceHolders(player, ChatUtils.colorize(MercuryAPI.INSTANCE.getConfigManager().getValues().CHAT_FORMAT_MESSAGE).replace("{message}", message)));
    }
}
