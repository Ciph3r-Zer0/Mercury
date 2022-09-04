package ir.ciph3r.mercury.modules.impl.quit;

import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.quit.listeners.QuitMessageListener;

public class Quit extends CommandModule {
    public Quit() {
        super("Quit", MercuryAPI.INSTANCE.getConfig().MESSAGES_QUIT);
        addListeners(new QuitMessageListener());
    }
}
