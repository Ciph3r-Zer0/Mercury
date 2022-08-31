package ir.ciph3r.mercury.modules.impl.messages;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.messages.listeners.JoinMessageListener;

public class Join extends CommandModule {
    public Join() {
        super("Join", MercuryAPI.INSTANCE.getConfig().MESSAGES_JOIN);
        addListeners(new JoinMessageListener());
    }
}
