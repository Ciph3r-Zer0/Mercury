package ir.ciph3r.mercury.modules.impl.joinmessage;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.joinmessage.listeners.JoinMessageListener;

public class JoinMessage extends CommandModule {
    public JoinMessage() {
        super("JoinMessage", MercuryAPI.INSTANCE.getConfigManager().getValues().JOIN_MESSAGE_ENABLED);
        addListeners(new JoinMessageListener());
    }
}
