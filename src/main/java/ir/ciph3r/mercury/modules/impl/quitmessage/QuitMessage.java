package ir.ciph3r.mercury.modules.impl.quitmessage;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.quitmessage.listeners.QuitMessageListener;

public class QuitMessage extends CommandModule {
    public QuitMessage() {
        super("QuitMessage", MercuryAPI.INSTANCE.getConfigManager().getValues().QUIT_MESSAGE_ENABLED);
        addListeners(new QuitMessageListener());
    }
}
