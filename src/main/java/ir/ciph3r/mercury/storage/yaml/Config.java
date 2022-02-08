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
	public static boolean CHAT_ENABLED;

	@Override
	public void init() {
		DATA_TYPE = getConfig().getString("DataType");
		NICK_NAME_ENABLED = getConfig().getBoolean("Modules.Nickname.enabled");
		NICK_NAME_RESET = new ArrayList<>(getConfig().getStringList("Modules.Nickname.reset"));
		CHAT_ENABLED = getConfig().getBoolean("Modules.Chat.enabled");
	}
}
