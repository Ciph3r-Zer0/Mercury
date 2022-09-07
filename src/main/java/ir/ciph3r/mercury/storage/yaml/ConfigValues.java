package ir.ciph3r.mercury.storage.yaml;

import github.scarsz.configuralize.DynamicConfig;

public class ConfigValues {
    public int
            CONFIG_VERSION,
            UPDATE_CHECKER_INTERVAL,
            CROSS_TELEPORT_SENDING_DELAY;

    public boolean
            UPDATE_CHECKER_NOTIFY_ON_JOIN,
            BROADCAST_ENABLED,
            CLEAR_INVENTORY_ENABLED,
            COORDINATED_ENABLED,
            CROSS_TELEPORT_ENABLED,
            FEED_ENABLED,
            FLY_ENABLED,
            GAMEMODE_ENABLED,
            HEAL_ENABLED,
            KILL_ENABLED,
            KNOCKBACK_ENABLED,
            LIGHTNING_ENABLED,
            JOIN_MESSAGE_ENABLED,
            QUIT_MESSAGE_ENABLED,
            PLUGIN_LIST_ENABLED,
            PRIVATE_CHAT_ENABLED,
            ROTATE_ENABLED,
            SHUFFLE_ENABLED,
            SPAWN_ENABLED,
            SPAWN_ON_JOIN,
            SPAWN_ON_VOID,
            SPAWN_ON_RESPAWN,
            SPEED_ENABLED,
            SUDO_ENABLED,
            TELEPORT_ENABLED,
            TIME_ENABLED,
            UPTIME_ENABLED;

    public String
            SPAWN_LOCATION,

    //messages.yml values
            PREFIX,

            PERMISSION_DENIED,
            NOT_ALLOWED_ON_CONSOLE,
            UNKNOWN_COMMAND,
            MULTIPLE_PLAYERS_MATCH,
            NO_PLAYER_FOUND_SERVER,
            NO_PLAYER_FOUND_OFFLINE,
            IS_NOT_A_VALID_NAME,
            NOT_TO_ADMIN,
            MUST_BE_A_NUMBER,
            ERROR_PERFORMING_COMMAND,
            PLEASE_SPECIFY_AT_MOST,
            PLEASE_SPECIFY_AT_LEAST,
            COMMAND_USAGE_SYNTAX,
            RELOAD_MESSAGE,

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
            KNOCKBACK_MESSAGE,
            LIGHTNING_MESSAGE,
            LIGHTNING_MESSAGE_OTHERS,
            JOIN_MESSAGE,
            JOIN_MESSAGE_FIRST_JOIN,
            QUIT_MESSAGE,
            PLUGIN_LIST_FIRST_LINE,
            PLUGIN_LIST_LIST_DESIGN,
            PLUGIN_LIST_LAST_LINE,
            PRIVATE_CHAT_MESSAGE,
            PRIVATE_CHAT_MESSAGE_SELF,
                    PRIVATE_CHAT_CAN_NOT_SEND_SELF,
                    PRIVATE_NO_ONE_TO_REPLY,
            ROTATE_MESSAGE,
            SHUFFLE_MESSAGE,
            SPAWN_NOT_SET,
            SPAWN_SET,
            SPAWN_MESSAGE,
            SPAWN_MESSAGE_OTHERS,
            SPEED_WALK,
            SPEED_WALK_OTHERS,
            SPEED_FLY,
            SPEED_FLY_OTHERS,
            SPEED_RESET,
            SPEED_RESET_OTHERS,
            SUDO_MESSAGE,
            TELEPORT_MESSAGE,
            TELEPORT_MESSAGE_OTHERS,
            TELEPORT_MESSAGE_LOCATION,
            TELEPORT_MESSAGE_LOCATION_OTHERS,
            TIME_MESSAGE,
            UPTIME_MESSAGE;

    public ConfigValues(DynamicConfig dynamicConfig) {
        CONFIG_VERSION = dynamicConfig.getInt("config-version");
        UPDATE_CHECKER_NOTIFY_ON_JOIN = dynamicConfig.getBoolean("update-checker.notify-on-join");
        UPDATE_CHECKER_INTERVAL = dynamicConfig.getInt("update-checker.check-interval");
        BROADCAST_ENABLED = dynamicConfig.getBoolean("modules-configs.broadcast.enabled");
        CLEAR_INVENTORY_ENABLED = dynamicConfig.getBoolean("modules-configs.clear-inventory.enabled");
        COORDINATED_ENABLED = dynamicConfig.getBoolean("modules-configs.coordinates.enabled");
        CROSS_TELEPORT_ENABLED = dynamicConfig.getBoolean("modules-configs.cross-teleport.enabled");
        CROSS_TELEPORT_SENDING_DELAY = dynamicConfig.getInt("modules-configs.cross-teleport.sending_delay");
        FEED_ENABLED = dynamicConfig.getBoolean("modules-configs.feed.enabled");
        FLY_ENABLED = dynamicConfig.getBoolean("modules-configs.fly.enabled");
        GAMEMODE_ENABLED = dynamicConfig.getBoolean("modules-configs.gamemode.enabled");
        HEAL_ENABLED = dynamicConfig.getBoolean("modules-configs.heal.enabled");
        KILL_ENABLED = dynamicConfig.getBoolean("modules-configs.kill.enabled");
        KNOCKBACK_ENABLED = dynamicConfig.getBoolean("modules-configs.knockback.enabled");
        LIGHTNING_ENABLED = dynamicConfig.getBoolean("modules-configs.lightning.enabled");
        JOIN_MESSAGE_ENABLED = dynamicConfig.getBoolean("modules-configs.join-message.enabled");
        QUIT_MESSAGE_ENABLED = dynamicConfig.getBoolean("modules-configs.quit-message.enabled");
        PLUGIN_LIST_ENABLED = dynamicConfig.getBoolean("modules-configs.plugin-list.enabled");
        PRIVATE_CHAT_ENABLED = dynamicConfig.getBoolean("modules-configs.private-chat.enabled");
        ROTATE_ENABLED = dynamicConfig.getBoolean("modules-configs.rotate.enabled");
        SHUFFLE_ENABLED = dynamicConfig.getBoolean("modules-configs.shuffle.enabled");
        SPAWN_ENABLED = dynamicConfig.getBoolean("modules-configs.spawn.enabled");
        SPAWN_ON_JOIN = dynamicConfig.getBoolean("modules-configs.spawn.on-join");
        SPAWN_ON_VOID = dynamicConfig.getBoolean("modules-configs.spawn.on-void");
        SPAWN_ON_RESPAWN = dynamicConfig.getBoolean("modules-configs.spawn.on-respawn");
        SPAWN_LOCATION = dynamicConfig.getString("modules-configs.spawn.location");
        SPEED_ENABLED = dynamicConfig.getBoolean("modules-configs.speed.enabled");
        SUDO_ENABLED = dynamicConfig.getBoolean("modules-configs.sudo.enabled");
        TELEPORT_ENABLED = dynamicConfig.getBoolean("modules-configs.teleport.enabled");
        TIME_ENABLED = dynamicConfig.getBoolean("modules-configs.time.enabled");
        UPTIME_ENABLED = dynamicConfig.getBoolean("modules-configs.uptime.enabled");

        //messages.yml values
        PREFIX = dynamicConfig.getString("prefix");
        PERMISSION_DENIED = dynamicConfig.getString("permission_denied").replace("{prefix}", PREFIX);
        NOT_ALLOWED_ON_CONSOLE = dynamicConfig.getString("not_allowed_on_console").replace("{prefix}", PREFIX);
        UNKNOWN_COMMAND = dynamicConfig.getString("unknown_command").replace("{prefix}", PREFIX);
        MULTIPLE_PLAYERS_MATCH = dynamicConfig.getString("multiple_players_match").replace("{prefix}", PREFIX);
        NO_PLAYER_FOUND_SERVER = dynamicConfig.getString("no_player_found_server").replace("{prefix}", PREFIX);
        NO_PLAYER_FOUND_OFFLINE = dynamicConfig.getString("no_player_found_offline").replace("{prefix}", PREFIX);
        IS_NOT_A_VALID_NAME = dynamicConfig.getString("is_not_a_valid_name").replace("{prefix}", PREFIX);
        NOT_TO_ADMIN = dynamicConfig.getString("not_to_admin").replace("{prefix}", PREFIX);
        MUST_BE_A_NUMBER = dynamicConfig.getString("must_be_a_number").replace("{prefix}", PREFIX);
        ERROR_PERFORMING_COMMAND = dynamicConfig.getString("error_performing_command").replace("{prefix}", PREFIX);
        PLEASE_SPECIFY_AT_MOST = dynamicConfig.getString("please_specify_at_most").replace("{prefix}", PREFIX);
        PLEASE_SPECIFY_AT_LEAST = dynamicConfig.getString("please_specify_at_least").replace("{prefix}", PREFIX);
        COMMAND_USAGE_SYNTAX = dynamicConfig.getString("command_usage_syntax").replace("{prefix}", PREFIX);
        RELOAD_MESSAGE = dynamicConfig.getString("reload_message").replace("{prefix}", PREFIX);

        BROADCAST_MESSAGE = dynamicConfig.getString("modules-messages.broadcast.message").replace("{prefix}", PREFIX);
        CLEAR_INVENTORY_MESSAGE = dynamicConfig.getString("modules-messages.clear-inventory.message").replace("{prefix}", PREFIX);
        CLEAR_INVENTORY_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.clear-inventory.message-others").replace("{prefix}", PREFIX);
        COORDINATES_MESSAGE = dynamicConfig.getString("modules-messages.coordinates.message").replace("{prefix}", PREFIX);
        COORDINATES_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.coordinates.message-others").replace("{prefix}", PREFIX);
        CROSS_TELEPORT_MESSAGE = dynamicConfig.getString("modules-messages.cross-teleport.message").replace("{prefix}", PREFIX);
        FEED_MESSAGE = dynamicConfig.getString("modules-messages.feed.message").replace("{prefix}", PREFIX);
        FEED_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.feed.message-others").replace("{prefix}", PREFIX);
        FLY_MESSAGE = dynamicConfig.getString("modules-messages.fly.message").replace("{prefix}", PREFIX);
        FLY_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.fly.message-others").replace("{prefix}", PREFIX);
        GAMEMODE_MESSAGE = dynamicConfig.getString("modules-messages.gamemode.message").replace("{prefix}", PREFIX);
        GAMEMODE_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.gamemode.message-others").replace("{prefix}", PREFIX);
        HEAL_MESSAGE = dynamicConfig.getString("modules-messages.heal.message").replace("{prefix}", PREFIX);
        HEAL_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.heal.message-others").replace("{prefix}", PREFIX);
        KILL_MESSAGE = dynamicConfig.getString("modules-messages.kill.message").replace("{prefix}", PREFIX);
        KNOCKBACK_MESSAGE = dynamicConfig.getString("modules-messages.knockback.message").replace("{prefix}", PREFIX);
        LIGHTNING_MESSAGE = dynamicConfig.getString("modules-messages.lightning.message").replace("{prefix}", PREFIX);
        LIGHTNING_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.lightning.message-others").replace("{prefix}", PREFIX);
        JOIN_MESSAGE = dynamicConfig.getString("modules-messages.join-message.message").replace("{prefix}", PREFIX);
        JOIN_MESSAGE_FIRST_JOIN = dynamicConfig.getString("modules-messages.join-message.first-join").replace("{prefix}", PREFIX);
        QUIT_MESSAGE = dynamicConfig.getString("modules-messages.quit-message.message").replace("{prefix}", PREFIX);
        PLUGIN_LIST_FIRST_LINE = dynamicConfig.getString("modules-messages.plugin-list.first-line").replace("{prefix}", PREFIX);
        PLUGIN_LIST_LIST_DESIGN = dynamicConfig.getString("modules-messages.plugin-list.list-design").replace("{prefix}", PREFIX);
        PLUGIN_LIST_LAST_LINE = dynamicConfig.getString("modules-messages.plugin-list.last-line").replace("{prefix}", PREFIX);
        PRIVATE_CHAT_MESSAGE = dynamicConfig.getString("modules-messages.private-chat.message").replace("{prefix}", PREFIX);
        PRIVATE_CHAT_MESSAGE_SELF = dynamicConfig.getString("modules-messages.private-chat.message-self").replace("{prefix}", PREFIX);
        PRIVATE_CHAT_CAN_NOT_SEND_SELF = dynamicConfig.getString("modules-messages.private-chat.can-not-send-self").replace("{prefix}", PREFIX);
        PRIVATE_NO_ONE_TO_REPLY = dynamicConfig.getString("modules-messages.private-chat.no-one-to-reply").replace("{prefix}", PREFIX);
        ROTATE_MESSAGE = dynamicConfig.getString("modules-messages.rotate.message").replace("{prefix}", PREFIX);
        SHUFFLE_MESSAGE = dynamicConfig.getString("modules-messages.shuffle.message").replace("{prefix}", PREFIX);
        SPAWN_NOT_SET = dynamicConfig.getString("modules-messages.spawn.not-set").replace("{prefix}", PREFIX);
        SPAWN_SET = dynamicConfig.getString("modules-messages.spawn.set").replace("{prefix}", PREFIX);
        SPAWN_MESSAGE = dynamicConfig.getString("modules-messages.spawn.message").replace("{prefix}", PREFIX);
        SPAWN_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.spawn.message-others").replace("{prefix}", PREFIX);
        SPEED_WALK = dynamicConfig.getString("modules-messages.speed.walk").replace("{prefix}", PREFIX);
        SPEED_WALK_OTHERS = dynamicConfig.getString("modules-messages.speed.walk-others").replace("{prefix}", PREFIX);
        SPEED_FLY = dynamicConfig.getString("modules-messages.speed.fly").replace("{prefix}", PREFIX);
        SPEED_FLY_OTHERS = dynamicConfig.getString("modules-messages.speed.fly-others").replace("{prefix}", PREFIX);
        SPEED_RESET = dynamicConfig.getString("modules-messages.speed.reset").replace("{prefix}", PREFIX);
        SPEED_RESET_OTHERS = dynamicConfig.getString("modules-messages.speed.reset-others").replace("{prefix}", PREFIX);
        SUDO_MESSAGE = dynamicConfig.getString("modules-messages.sudo.message").replace("{prefix}", PREFIX);
        TELEPORT_MESSAGE = dynamicConfig.getString("modules-messages.teleport.message").replace("{prefix}", PREFIX);
        TELEPORT_MESSAGE_OTHERS = dynamicConfig.getString("modules-messages.teleport.message-others").replace("{prefix}", PREFIX);
        TELEPORT_MESSAGE_LOCATION = dynamicConfig.getString("modules-messages.teleport.message-location").replace("{prefix}", PREFIX);
        TELEPORT_MESSAGE_LOCATION_OTHERS = dynamicConfig.getString("modules-messages.teleport.message-location-others").replace("{prefix}", PREFIX);
        TIME_MESSAGE = dynamicConfig.getString("modules-messages.time.message").replace("{prefix}", PREFIX);
        UPTIME_MESSAGE = dynamicConfig.getString("modules-messages.uptime.message").replace("{prefix}", PREFIX);
    }
}