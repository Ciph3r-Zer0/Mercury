package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.yaml.models.Model;

import java.util.ArrayList;
import java.util.List;

public class Config extends Model {
	public Config(Mercury mercury) {
		super(mercury, "config.yml");
	}

	public static String DATA_TYPE;
	public static boolean NICK_NAME_ENABLED;
	public static List<String> NICK_NAME_RESET;
	public static boolean FLY_ENABLED;
	public static boolean GAMEMODE_ENABLED;

	@Override
	public void init() {
		DATA_TYPE = getConfig().getString("DataType");
		NICK_NAME_ENABLED = getConfig().getBoolean("Modules.Nickname.Enabled");
		NICK_NAME_RESET = new ArrayList<>(getConfig().getStringList("Modules.Nickname.Reset"));
		FLY_ENABLED = getConfig().getBoolean("Modules.Fly.Enabled");
		GAMEMODE_ENABLED = getConfig().getBoolean("Modules.Gamemode.Enabled");
	}
}
