package ir.ciph3r.mercury.storage.yaml

import java.io.File
import java.nio.file.Files

class ConfigUpgrades constructor(configFile: File, messagesFile: File) {
    private var configFile: File
    private var configString: String
    private var messagesFile: File
    private var messagesString: String

    init {
        this.configFile = configFile
        this.messagesFile = messagesFile
        this.configString = Files.readAllBytes(configFile.toPath()).toString()
        this.messagesString = Files.readAllBytes(messagesFile.toPath()).toString()
    }
}