package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.storage.yaml.models.YamlModel;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;

public class Config extends YamlModel {
	public Config() {
		super("config.yml");
		setup();
	}

	public boolean
			BROADCAST_ENABLED,

			CLEAR_INVENTORY_ENABLED,

			COORDINATES_ENABLED,

			CROSS_TELEPORT_ENABLED,

			FEED_ENABLED,

			FLY_ENABLED,

			GAMEMODE_ENABLED,

			HEAL_ENABLED,

			KILL_ENABLED,

			KNOCKBACK_ENABLED,

			LIGHTNING_ENABLED,

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
			SPAWN_LOCATION;

	@Override
	public void init() {
		BROADCAST_ENABLED = getFileConfig().getBoolean("modules.broadcast.enabled");

		CLEAR_INVENTORY_ENABLED = getFileConfig().getBoolean("modules.clear_inventory.enabled");

		COORDINATES_ENABLED = getFileConfig().getBoolean("modules.coordinates.enabled");

		CROSS_TELEPORT_ENABLED = getFileConfig().getBoolean("modules.cross_teleport.enabled");

		FEED_ENABLED = getFileConfig().getBoolean("modules.feed.enabled");

		FLY_ENABLED = getFileConfig().getBoolean("modules.fly.enabled");

		GAMEMODE_ENABLED = getFileConfig().getBoolean("modules.gamemode.enabled");

		HEAL_ENABLED = getFileConfig().getBoolean("modules.heal.enabled");

		KILL_ENABLED = getFileConfig().getBoolean("modules.kill.enabled");

		KNOCKBACK_ENABLED = getFileConfig().getBoolean("modules.knockback.enabled");

		LIGHTNING_ENABLED = getFileConfig().getBoolean("modules.lightning.enabled");

		PLUGIN_LIST_ENABLED = getFileConfig().getBoolean("modules.plugin_list.enabled");

		PRIVATE_CHAT_ENABLED = getFileConfig().getBoolean("modules.private_chat.enabled");

		ROTATE_ENABLED = getFileConfig().getBoolean("modules.rotate.enabled");

		SHUFFLE_ENABLED = getFileConfig().getBoolean("modules.shuffle.enabled");

		SPAWN_ENABLED = getFileConfig().getBoolean("modules.spawn.enabled");
		SPAWN_ON_JOIN = getFileConfig().getBoolean("modules.spawn.on_join");
		SPAWN_ON_VOID = getFileConfig().getBoolean("modules.spawn.on_void");
		SPAWN_ON_RESPAWN = getFileConfig().getBoolean("modules.spawn.on_respawn");
		SPAWN_LOCATION = getFileConfig().getString("modules.spawn.location");

		SPEED_ENABLED = getFileConfig().getBoolean("modules.speed.enabled");

		SUDO_ENABLED = getFileConfig().getBoolean("modules.sudo.enabled");

		TELEPORT_ENABLED = getFileConfig().getBoolean("modules.teleport.enabled");

		TIME_ENABLED = getFileConfig().getBoolean("modules.time.enabled");

		UPTIME_ENABLED = getFileConfig().getBoolean("modules.uptime.enabled");
	}

	public void reloadSpawnLocation() throws IOException, InvalidConfigurationException {
		load();
		SPAWN_LOCATION = getFileConfig().getString("modules.spawn.location");
	}
}
