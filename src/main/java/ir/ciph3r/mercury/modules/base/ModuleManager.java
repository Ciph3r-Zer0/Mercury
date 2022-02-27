package ir.ciph3r.mercury.modules.base;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.Fly;
import ir.ciph3r.mercury.modules.GameMode;
import ir.ciph3r.mercury.modules.Teleport;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final Mercury mercury;
    private List<ModuleBase> modules;

    public ModuleManager(Mercury mercury) {
        this.mercury = mercury;
        modules = new ArrayList();
    }

    public void register() {
        modules.add(new Fly(mercury));
        modules.add(new GameMode(mercury));
        modules.add(new Teleport(mercury));

        for (ModuleBase base : modules) {
            base.register();
        }
    }
}