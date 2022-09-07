package ir.ciph3r.mercury.modules.impl.chatformat;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.chatformat.listeners.ChatFormatListener;

public class ChatFormat extends CommandModule {
    public ChatFormat() {
        super("ChatFormat", MercuryAPI.INSTANCE.getConfigManager().getValues().CHAT_FORMAT_ENABLED);
        addListeners(new ChatFormatListener());
    }
}
