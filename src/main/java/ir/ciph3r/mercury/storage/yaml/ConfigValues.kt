package ir.ciph3r.mercury.storage.yaml

import github.scarsz.configuralize.DynamicConfig

class ConfigValues constructor(dynamicConfig: DynamicConfig) {
    var CONFIG_VERSION: String

    init {
        CONFIG_VERSION = dynamicConfig.getString("config-version")
    }
}