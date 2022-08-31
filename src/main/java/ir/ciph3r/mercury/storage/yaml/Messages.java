package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.storage.yaml.models.YamlModel;

public class Messages extends YamlModel {
	public Messages() {
		super("messages.yml");
		setup();
	}

	public String
			PREFIX,
			PERMISSION_DENIED,
			UNKNOWN_COMMAND,
			MULTIPLE_PLAYERS_MATCH,
			IS_NOT_A_VALID_NAME,
			NO_PLAYER_FOUND_SERVER,
			NO_PLAYER_FOUND_OFFLINE,
			NOT_TO_ADMIN,
			NOT_ALLOWED_ON_CONSOLE,
			MUST_BE_A_NUMBER,
			ERROR_PERFORMING_COMMAND,
			PLEASE_SPECIFY_AT_MOST,
			PLEASE_SPECIFY_AT_LEAST,
			COMMAND_USAGE_SYNTAX,

			BROADCAST_MESSAGE,

			CLEAR_INVENTORY_MESSAGE,
			CLEAR_INVENTORY_MESSAGE_OTHERS,

			COORDINATES_MESSAGE,
			COORDINATES_MESSAGE_OTHERS,

			CROSS_TELEPORT_MESSAGE,

			FEED_MESSAGE,
			FEED_MESSAGE_OTHERS,

			FLY_MESSAGE,
			FLY_MESSAGE_OTHERS,

			GAMEMODE_MESSAGE,
			GAMEMODE_MESSAGE_OTHERS,

			HEAL_MESSAGE,
			HEAL_MESSAGE_OTHERS,

			KILL_MESSAGE,

			KNOCKBACK_MESSAGE_OTHERS,

			LIGHTNING_MESSAGE,
			LIGHTNING_MESSAGE_OTHERS,

			MESSAGES_JOIN,
			MESSAGES_FIRST_JOIN,
			MESSAGES_QUIT,

			PLUGIN_LIST_FIRST_LINE,
			PLUGIN_LIST_LIST_DESIGN,
			PLUGIN_LIST_LAST_LINE,

			PRIVATE_CHAT_MESSAGE,
			PRIVATE_CHAT_MESSAGE_SELF,
			PRIVATE_CHAT_MESSAGE_CAN_NOT_SEND_SELF,
			PRIVATE_CHAT_MESSAGE_NO_ONE_TO_REPLY,

			RELOAD_MESSAGE,

			ROTATE_MESSAGE_OTHERS,

			SHUFFLE_MESSAGE_OTHERS,

			SPAWN_MESSAGE_NOT_SET,
			SPAWN_MESSAGE_SET,
			SPAWN_MESSAGE,
			SPAWN_MESSAGE_OTHERS,

			SPEED_WALK_MESSAGE,
			SPEED_WALK_MESSAGE_OTHERS,
			SPEED_FLY_MESSAGE,
			SPEED_FLY_MESSAGE_OTHERS,
			SPEED_RESET_MESSAGE,
			SPEED_RESET_MESSAGE_OTHERS,

			SUDO_MESSAGE,

			TELEPORT_MESSAGE,
			TELEPORT_MESSAGE_OTHERS,
			TELEPORT_MESSAGE_LOCATION,
			TELEPORT_MESSAGE_LOCATION_OTHERS,

			TIME_MESSAGE,

			UPTIME_MESSAGE;

	@Override
	public void init() {
		PREFIX = getFileConfig().getString("prefix");
		PERMISSION_DENIED = getFileConfig().getString("permission_denied").replace("{prefix}", PREFIX);
		UNKNOWN_COMMAND = getFileConfig().getString("unknown_command").replace("{prefix}", PREFIX);
		MULTIPLE_PLAYERS_MATCH = getFileConfig().getString("multiple_players_match").replace("{prefix}", PREFIX);
		IS_NOT_A_VALID_NAME = getFileConfig().getString("is_not_a_valid_name").replace("{prefix}", PREFIX);
		NO_PLAYER_FOUND_SERVER = getFileConfig().getString("no_player_found_server").replace("{prefix}", PREFIX);
		NO_PLAYER_FOUND_OFFLINE = getFileConfig().getString("no_player_found_offline").replace("{prefix}", PREFIX);
		NOT_TO_ADMIN = getFileConfig().getString("not_to_admin").replace("{prefix}", PREFIX);
		NOT_ALLOWED_ON_CONSOLE = getFileConfig().getString("not_allowed_on_console").replace("{prefix}", PREFIX);
		MUST_BE_A_NUMBER = getFileConfig().getString("must_be_a_number").replace("{prefix}", PREFIX);
		ERROR_PERFORMING_COMMAND = getFileConfig().getString("error_performing_command").replace("{prefix}", PREFIX);
		PLEASE_SPECIFY_AT_MOST = getFileConfig().getString("please_specify_at_most").replace("{prefix}", PREFIX);
		PLEASE_SPECIFY_AT_LEAST = getFileConfig().getString("please_specify_at_least").replace("{prefix}", PREFIX);
		COMMAND_USAGE_SYNTAX =  getFileConfig().getString("command_usage_syntax").replace("{prefix}", PREFIX);

		BROADCAST_MESSAGE = getFileConfig().getString("modules.broadcast.broadcast_message").replace("{prefix}", PREFIX);

		CLEAR_INVENTORY_MESSAGE = getFileConfig().getString("modules.clear_inventory.message").replace("{prefix}", PREFIX);
		CLEAR_INVENTORY_MESSAGE_OTHERS = getFileConfig().getString("modules.clear_inventory.message_others").replace("{prefix}", PREFIX);

		COORDINATES_MESSAGE = getFileConfig().getString("modules.coordinates.message").replace("{prefix}", PREFIX);
		COORDINATES_MESSAGE_OTHERS = getFileConfig().getString("modules.coordinates.message_others").replace("{prefix}", PREFIX);

		CROSS_TELEPORT_MESSAGE = getFileConfig().getString("modules.cross_teleport.message").replace("{prefix}", PREFIX);

		FEED_MESSAGE = getFileConfig().getString("modules.feed.message").replace("{prefix}", PREFIX);
		FEED_MESSAGE_OTHERS = getFileConfig().getString("modules.feed.message_others").replace("{prefix}", PREFIX);

		FLY_MESSAGE = getFileConfig().getString("modules.fly.message").replace("{prefix}", PREFIX);
		FLY_MESSAGE_OTHERS = getFileConfig().getString("modules.fly.message_others").replace("{prefix}", PREFIX);

		GAMEMODE_MESSAGE = getFileConfig().getString("modules.gamemode.message").replace("{prefix}", PREFIX);
		GAMEMODE_MESSAGE_OTHERS = getFileConfig().getString("modules.gamemode.message_others").replace("{prefix}", PREFIX);

		HEAL_MESSAGE = getFileConfig().getString("modules.heal.message").replace("{prefix}", PREFIX);
		HEAL_MESSAGE_OTHERS = getFileConfig().getString("modules.heal.message_others").replace("{prefix}", PREFIX);

		KILL_MESSAGE = getFileConfig().getString("modules.kill.message").replace("{prefix}", PREFIX);

		KNOCKBACK_MESSAGE_OTHERS = getFileConfig().getString("modules.knockback.message_others").replace("{prefix}", PREFIX);

		LIGHTNING_MESSAGE = getFileConfig().getString("modules.lightning.message").replace("{prefix}", PREFIX);
		LIGHTNING_MESSAGE_OTHERS = getFileConfig().getString("modules.lightning.message_others").replace("{prefix}", PREFIX);

		MESSAGES_JOIN = getFileConfig().getString("modules.messages.join.message").replace("{prefix}", PREFIX);
		MESSAGES_FIRST_JOIN = getFileConfig().getString("modules.messages.join.message_first_join").replace("{prefix}", PREFIX);
		MESSAGES_QUIT = getFileConfig().getString("modules.messages.quit.message").replace("{prefix}", PREFIX);

		PLUGIN_LIST_FIRST_LINE = getFileConfig().getString("modules.plugin_list.first_line").replace("{prefix}", PREFIX);
		PLUGIN_LIST_LIST_DESIGN = getFileConfig().getString("modules.plugin_list.list_design").replace("{prefix}", PREFIX);
		PLUGIN_LIST_LAST_LINE = getFileConfig().getString("modules.plugin_list.last_line").replace("{prefix}", PREFIX);

		PRIVATE_CHAT_MESSAGE = getFileConfig().getString("modules.private_chat.message").replace("{prefix}", PREFIX);
		PRIVATE_CHAT_MESSAGE_SELF = getFileConfig().getString("modules.private_chat.message_self").replace("{prefix}", PREFIX);
		PRIVATE_CHAT_MESSAGE_CAN_NOT_SEND_SELF = getFileConfig().getString("modules.private_chat.message_can_not_send_self").replace("{prefix}", PREFIX);
		PRIVATE_CHAT_MESSAGE_NO_ONE_TO_REPLY = getFileConfig().getString("modules.private_chat.message_no_one_to_reply").replace("{prefix}", PREFIX);

		RELOAD_MESSAGE = getFileConfig().getString("modules.reload.message").replace("{prefix}", PREFIX);

		ROTATE_MESSAGE_OTHERS = getFileConfig().getString("modules.rotate.message_others").replace("{prefix}", PREFIX);

		SHUFFLE_MESSAGE_OTHERS = getFileConfig().getString("modules.shuffle.message_others").replace("{prefix}", PREFIX);

		SPAWN_MESSAGE_NOT_SET = getFileConfig().getString("modules.spawn.message_not_set").replace("{prefix}", PREFIX);
		SPAWN_MESSAGE_SET = getFileConfig().getString("modules.spawn.message_set").replace("{prefix}", PREFIX);
		SPAWN_MESSAGE = getFileConfig().getString("modules.spawn.message").replace("{prefix}", PREFIX);
		SPAWN_MESSAGE_OTHERS = getFileConfig().getString("modules.spawn.message_others").replace("{prefix}", PREFIX);

		SPEED_WALK_MESSAGE = getFileConfig().getString("modules.speed.message_walk").replace("{prefix}", PREFIX);
		SPEED_WALK_MESSAGE_OTHERS = getFileConfig().getString("modules.speed.message_walk_others").replace("{prefix}", PREFIX);
		SPEED_FLY_MESSAGE = getFileConfig().getString("modules.speed.message_fly").replace("{prefix}", PREFIX);
		SPEED_FLY_MESSAGE_OTHERS = getFileConfig().getString("modules.speed.message_fly_others").replace("{prefix}", PREFIX);
		SPEED_RESET_MESSAGE = getFileConfig().getString("modules.speed.message_reset").replace("{prefix}", PREFIX);
		SPEED_RESET_MESSAGE_OTHERS = getFileConfig().getString("modules.speed.message_reset_others").replace("{prefix}", PREFIX);

		SUDO_MESSAGE = getFileConfig().getString("modules.sudo.message").replace("{prefix}", PREFIX);

		TELEPORT_MESSAGE = getFileConfig().getString("modules.teleport.message").replace("{prefix}", PREFIX);
		TELEPORT_MESSAGE_OTHERS = getFileConfig().getString("modules.teleport.message_others").replace("{prefix}", PREFIX);
		TELEPORT_MESSAGE_LOCATION = getFileConfig().getString("modules.teleport.message_location").replace("{prefix}", PREFIX);
		TELEPORT_MESSAGE_LOCATION_OTHERS = getFileConfig().getString("modules.teleport.message_location_others").replace("{prefix}", PREFIX);

		TIME_MESSAGE = getFileConfig().getString("modules.time.message").replace("{prefix}", PREFIX);

		UPTIME_MESSAGE = getFileConfig().getString("modules.uptime.message").replace("{prefix}", PREFIX);
	}
}