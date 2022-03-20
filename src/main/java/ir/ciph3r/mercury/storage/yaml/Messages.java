package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.yaml.models.Model;

public class Messages extends Model {
	public Messages(Mercury mercury) {
		super(mercury, "messages.yml");
		setup();
	}

	public String
			PREFIX
			,NO_PERMISSION
			,NO_CONSOLE
			,PLAYER_NOT_FOUND
			,ARGS_NOT_NUMBER

			,RELOAD_SUCCESS
			,RELOAD_FAILED

			,FLY_ENABLED
			,FLY_DISABLED
			,FLY_ENABLED_ADMIN
			,FLY_DISABLED_ADMIN

			,GAMEMODE_USAGE
			,GAMEMODE_CHANGED
			,GAMEMODE_CHANGED_ADMIN

			,TELEPORT_USAGE
			,TELEPORT_SUCCESS_PLAYER
			,TELEPORT_SUCCESS_OTHERS
			,TELEPORT_SUCCESS_LOCATION
			,TELEPORT_SUCCESS_OTHERS_LOCATION

			,HAT_UPDATED
			,HAT_UPDATED_ADMIN

			,SHUFFLE_USAGE
			,SHUFFLE_SUCCESS_ADMIN

			,ROTATE_USAGE
			,ROTATE_SUCCESS_ADMIN

			,KNOCKBACK_USAGE
			,KNOCKBACK_SUCCESS_ADMIN

			,CLEAR_INVENTORY_SUCCESS
			,CLEAR_INVENTORY_SUCCESS_OTHERS
			,SPEED_USAGE,SPEED_WALK_SUCCESS
			,SPEED_FLY_SUCCESS
			,SPEED_RESET

			,TELL_USAGE
			,TELL_MESSAGE_FORMAT
			,TELL_SELF_MESSAGE_FORMAT
			,REPLY_USAGE,REPLY_MESSAGE_FORMAT
			,REPLY_SELF_MESSAGE_FORMAT
			,REPLY_NO_RECEIVER

			,CROSS_TELEPORT_USAGE
			,CROSS_TELEPORT_SUCCESS

			,SUDO_USAGE
			,SUDO_SUCCESS

			,SPAWN_NOT_SET
			,SPAWN_SET_SUCCESSFUL
			,SPAWN_SUCCESSFUL
			,SPAWN_SUCCESSFUL_OTHERS

			,LIGHTNING_SUCCESS
			,LIGHTNING_SUCCESS_OTHERS

			,COORDINATES_MESSAGE
			,COORDINATES_MESSAGE_OTHERS;

	@Override
	public void init() {
		PREFIX = getFileConfig().getString("Prefix");
		NO_PERMISSION = getFileConfig().getString("NoPermission").replace("{prefix}", PREFIX);
		NO_CONSOLE = getFileConfig().getString("NoConsole").replace("{prefix}", PREFIX);
		PLAYER_NOT_FOUND = getFileConfig().getString("PlayerNotFound").replace("{prefix}", PREFIX);
		ARGS_NOT_NUMBER = getFileConfig().getString("ArgsNotNumber").replace("{prefix}", PREFIX);

		RELOAD_SUCCESS = getFileConfig().getString("Modules.Reload.Success").replace("{prefix}", PREFIX);
		RELOAD_FAILED = getFileConfig().getString("Modules.Reload.Failed").replace("{prefix}", PREFIX);

		FLY_ENABLED = getFileConfig().getString("Modules.Fly.Enabled").replace("{prefix}", PREFIX);
		FLY_DISABLED = getFileConfig().getString("Modules.Fly.Disabled").replace("{prefix}", PREFIX);
		FLY_ENABLED_ADMIN = getFileConfig().getString("Modules.Fly.EnabledAdmin").replace("{prefix}", PREFIX);
		FLY_DISABLED_ADMIN = getFileConfig().getString("Modules.Fly.DisabledAdmin").replace("{prefix}", PREFIX);

		GAMEMODE_USAGE = getFileConfig().getString("Modules.Gamemode.Usage").replace("{prefix}", PREFIX);
		GAMEMODE_CHANGED = getFileConfig().getString("Modules.Gamemode.Change").replace("{prefix}", PREFIX);
		GAMEMODE_CHANGED_ADMIN = getFileConfig().getString("Modules.Gamemode.ChangeAdmin").replace("{prefix}", PREFIX);

		TELEPORT_USAGE = getFileConfig().getString("Modules.Teleport.Usage").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_PLAYER = getFileConfig().getString("Modules.Teleport.SuccessPlayer").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_OTHERS = getFileConfig().getString("Modules.Teleport.SuccessOthers").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_LOCATION = getFileConfig().getString("Modules.Teleport.SuccessLocation").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_OTHERS_LOCATION = getFileConfig().getString("Modules.Teleport.SuccessOthersLocation").replace("{prefix}", PREFIX);

		HAT_UPDATED = getFileConfig().getString("Modules.Hat.Updated").replace("{prefix}", PREFIX);
		HAT_UPDATED_ADMIN = getFileConfig().getString("Modules.Hat.UpdatedAdmin").replace("{prefix}", PREFIX);

		SHUFFLE_USAGE = getFileConfig().getString("Modules.Shuffle.Usage").replace("{prefix}", PREFIX);
		SHUFFLE_SUCCESS_ADMIN = getFileConfig().getString("Modules.Shuffle.SuccessAdmin").replace("{prefix}", PREFIX);

		ROTATE_USAGE = getFileConfig().getString("Modules.Rotate.Usage").replace("{prefix}", PREFIX);
		ROTATE_SUCCESS_ADMIN = getFileConfig().getString("Modules.Rotate.SuccessAdmin").replace("{prefix}", PREFIX);

		KNOCKBACK_USAGE = getFileConfig().getString("Modules.Knockback.Usage").replace("{prefix}", PREFIX);
		KNOCKBACK_SUCCESS_ADMIN = getFileConfig().getString("Modules.Knockback.SuccessAdmin").replace("{prefix}", PREFIX);

		CLEAR_INVENTORY_SUCCESS = getFileConfig().getString("Modules.ClearInventory.Success").replace("{prefix}", PREFIX);
		CLEAR_INVENTORY_SUCCESS_OTHERS = getFileConfig().getString("Modules.ClearInventory.SuccessOthers").replace("{prefix}", PREFIX);

		SPEED_USAGE = getFileConfig().getString("Modules.Speed.Usage").replace("{prefix}", PREFIX);
		SPEED_WALK_SUCCESS = getFileConfig().getString("Modules.Speed.SuccessWalk").replace("{prefix}", PREFIX);
		SPEED_FLY_SUCCESS = getFileConfig().getString("Modules.Speed.SuccessFly").replace("{prefix}", PREFIX);
		SPEED_RESET = getFileConfig().getString("Modules.Speed.Reset").replace("{prefix}", PREFIX);

		TELL_USAGE = getFileConfig().getString("Modules.Tell.Usage").replace("{prefix}", PREFIX);
		TELL_MESSAGE_FORMAT = getFileConfig().getString("Modules.Tell.MessageFormat").replace("{prefix}", PREFIX);
		TELL_SELF_MESSAGE_FORMAT = getFileConfig().getString("Modules.Tell.SelfMessageFormat").replace("{prefix}", PREFIX);
		REPLY_USAGE = getFileConfig().getString("Modules.Reply.Usage").replace("{prefix}", PREFIX);
		REPLY_MESSAGE_FORMAT = getFileConfig().getString("Modules.Reply.MessageFormat").replace("{prefix}", PREFIX);
		REPLY_SELF_MESSAGE_FORMAT = getFileConfig().getString("Modules.Reply.SelfMessageFormat").replace("{prefix}", PREFIX);
		REPLY_NO_RECEIVER = getFileConfig().getString("Modules.Reply.NoReceiver").replace("{prefix}", PREFIX);

		CROSS_TELEPORT_USAGE = getFileConfig().getString("Modules.CrossTeleport.Usage").replace("{prefix}", PREFIX);
		CROSS_TELEPORT_SUCCESS = getFileConfig().getString("Modules.CrossTeleport.Success").replace("{prefix}", PREFIX);

		SUDO_USAGE = getFileConfig().getString("Modules.Sudo.Usage").replace("{prefix}", PREFIX);
		SUDO_SUCCESS = getFileConfig().getString("Modules.Sudo.Success").replace("{prefix}", PREFIX);

		SPAWN_NOT_SET = getFileConfig().getString("Modules.Spawn.SpawnNotSet").replace("{prefix}", PREFIX);
		SPAWN_SET_SUCCESSFUL =getFileConfig().getString("Modules.Spawn.SetSuccessful").replace("{prefix}", PREFIX);
		SPAWN_SUCCESSFUL = getFileConfig().getString("Modules.Spawn.Successful").replace("{prefix}", PREFIX);
		SPAWN_SUCCESSFUL_OTHERS = getFileConfig().getString("Modules.Spawn.SuccessfulOthers").replace("{prefix}", PREFIX);

		LIGHTNING_SUCCESS = getFileConfig().getString("Modules.Lightning.Success").replace("{prefix}", PREFIX);
		LIGHTNING_SUCCESS_OTHERS = getFileConfig().getString("Modules.Lightning.SuccessOthers").replace("{prefix}", PREFIX);

		COORDINATES_MESSAGE = getFileConfig().getString("Modules.Coordinates.Message").replace("{prefix}", PREFIX);
		COORDINATES_MESSAGE_OTHERS = getFileConfig().getString("Modules.Coordinates.MessageOthers").replace("{prefix}", PREFIX);
	}
}
