package ir.ciph3r.mercury.modules;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.base.ModuleBase;
import ir.ciph3r.mercury.storage.yaml.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat extends ModuleBase {
	public Chat(Mercury mercury) {
		super("Chat", null, Config.CHAT_ENABLED, mercury);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		//TODO: permission based chat colors
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
		return false;
	}
}
