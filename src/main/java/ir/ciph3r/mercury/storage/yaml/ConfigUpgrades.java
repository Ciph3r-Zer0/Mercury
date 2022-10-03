package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.MercuryAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ConfigUpgrades {
    private final File configFile;
    private String configString;
    private final File messagesFile;
    private String messagesString;
    private int configVersion;

    public ConfigUpgrades(File configFile, File messagesFile) throws IOException {
        this.configFile = configFile;
        this.configString = new String(Files.readAllBytes(configFile.toPath()));
        this.messagesFile = messagesFile;
        this.messagesString = new String(Files.readAllBytes(messagesFile.toPath()));

        handleConfigVersion();
    }

    private void handleMissingEntries() throws IOException {
        if (configVersion < 2) {
            addClearChat();
            addGod();
            addMotd();
        }
    }

    private void handleConfigVersion() throws IOException {
        configVersion = configString.indexOf("config-version: ");

        if (configVersion != -1) {
            String configStringVersion = configString.substring(configVersion + "config-version: ".length());
            configStringVersion = configStringVersion.substring(0, !configStringVersion.contains("\n") ? configStringVersion.length() : configStringVersion.indexOf("\n"));
            configStringVersion = configStringVersion.replaceAll("\\D", "");

            configVersion = Integer.parseInt(configStringVersion);
            configString = configString.replaceAll("config-version: " + configStringVersion, "config-version: 2");
            Files.write(configFile.toPath(), configString.getBytes());

            handleMissingEntries();
        } else {
            //Reset config.yml file if there is no config-version entry as it is legacy
            Files.move(configFile.toPath(), new File(MercuryAPI.INSTANCE.getPlugin().getDataFolder(), "config.old.yml").toPath());
        }

    }

    public void addClearChat() throws IOException {
        configString += "\n" +
                "  clear-chat:\n" +
                "    enabled: true";

        messagesString += "\n" +
                "  clear-chat:\n" +
                "    message: \"{prefix} &7chat has been cleared.\"\n" +
                "    message-others: \"{prefix} &7chat has been cleared for &c{target}&7.\"";

        Files.write(configFile.toPath(), configString.getBytes());
        Files.write(messagesFile.toPath(), messagesString.getBytes());
    }

    public void addGod() throws IOException {
        configString += "\n" +
                "  god:\n" +
                "    enabled: true";

        messagesString += "\n" +
                "  god:\n" +
                "    message: \"{prefix} &7God mode {status}\"\n" +
                "    message-others: \"{prefix} &7God mode {status} &7for &c{target}\"";

        Files.write(configFile.toPath(), configString.getBytes());
        Files.write(messagesFile.toPath(), messagesString.getBytes());
    }

    public void addMotd() throws IOException {
        configString += "\n" +
                "  motd:\n" +
                "    enabled: true\n" +
                "    on-join: true";

        messagesString += "\n" +
                "      &8<>&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m&8<>\n" +
                "                              &7Welcome &c&l%player_name%\n" +
                "      \n" +
                "              &7There are currently &c&l%server_online% &7players online\n" +
                "      &8<>&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m-&b&l&m-&8&l&m&8<>";

        Files.write(configFile.toPath(), configString.getBytes());
        Files.write(messagesFile.toPath(), messagesString.getBytes());
    }
}
