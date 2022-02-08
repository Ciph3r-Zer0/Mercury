package ir.ciph3r.mercury.modules;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.base.ModuleBase;
import ir.ciph3r.mercury.storage.Permissions.Perms;
import ir.ciph3r.mercury.storage.sql.models.PlayerModel;
import ir.ciph3r.mercury.storage.yaml.Config;
import ir.ciph3r.mercury.storage.yaml.Messages;
import ir.ciph3r.mercury.utilities.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Nickname extends ModuleBase {

	public Nickname(Mercury mercury) {
		super("Nickname", "Nickname", Config.NICK_NAME_ENABLED, mercury);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender.hasPermission(Perms.NICKNAME))) {
			Utils.sendColorizedMessage(sender, Messages.NO_PERMISSION);
			return true;
		}

		if (args.length == 0) {
			Utils.sendColorizedMessage(sender, Messages.NICK_NAME_USAGE);
			return true;
		} else if (args.length == 1) {
			if (!(sender instanceof Player)) {
				Utils.sendColorizedMessage(sender, Messages.NO_CONSOLE);
				return true;
			}
			Player player = (Player) sender;
			PlayerModel model = PlayerModel.queryByUUID(player.getUniqueId().toString());
			if (model == null) model = new PlayerModel(player).create();

			List<String> resets = Config.NICK_NAME_RESET;
			for (String s : resets) {
				if (args[0].equalsIgnoreCase(s)) {
					model.setNick(null);
					Utils.sendColorizedMessage(player, Messages.NICK_NAME_RESET);
					return true;
				}
			}
			model.setNick(args[0]);
			Utils.sendColorizedMessage(sender, Messages.NICK_NAME_CHANGED);
			return true;
		} else if (args.length == 2) {
			if (!(sender.hasPermission(Perms.NICKNAME_OTHERS))) {
				Utils.sendColorizedMessage(sender,Messages.NO_PERMISSION);
				return true;
			}
			Player player = (Player) Bukkit.getPlayer(args[1]);
			if (player == null) {
				Utils.sendColorizedMessage(sender,Messages.PLAYER_NOT_FOUND);
				return true;
			}
			PlayerModel model = PlayerModel.queryByUUID(player.getUniqueId().toString());
			if (model == null) model = new PlayerModel(player).create();
			model.setNick(args[0]);
			Utils.sendColorizedMessage(sender, Messages.NICK_NAME_CHANGED_OTHERS);
		}
		return true;
	}

//	@Override
//	public void command(CommandSender sender, Command cmd, String label, String[] args) {
//		if (!(sender.hasPermission(Permissions.NICKNAME))) {
//			sender.sendMessage(" ");
//			return;
//		}
//		if (args.length == 0) {
//			//TODO: send usage
//		} else if (args.length == 1) {
//			//TODO: change nick name
//			if (!(sender instanceof Player)) {
//				sender.sendMessage("not a player");
//				return;
//			}
//			Player player = (Player) sender;
//			PlayerModel model = PlayerModel.queryByName(player.getUniqueId().toString());
//			model.setNickName(args[0]);
//		} else if (args.length == 2) {
//			//TODO: change nick name for others
//		} else {
//			//TODO: send usage
//		}
//	}
}