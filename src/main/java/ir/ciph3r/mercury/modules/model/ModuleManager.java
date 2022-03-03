package ir.ciph3r.mercury.modules.model;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.clearinventory.ClearInventory;
import ir.ciph3r.mercury.modules.fly.Fly;
import ir.ciph3r.mercury.modules.gamemode.GameMode;
import ir.ciph3r.mercury.modules.hat.Hat;
import ir.ciph3r.mercury.modules.rotate.Rotate;
import ir.ciph3r.mercury.modules.shuffle.Shuffle;
import ir.ciph3r.mercury.modules.teleport.Teleport;

import java.util.ArrayList;

public class ModuleManager {
    private final Mercury mercury;
    private ArrayList<Model> modules;

    public ModuleManager(Mercury mercury) {
        this.mercury = mercury;
        modules = new ArrayList<Model>();
    }

    public void register() {
        modules.add(new Fly(mercury));
        modules.add(new GameMode(mercury));
        modules.add(new Teleport(mercury));
        modules.add(new Hat(mercury));
        modules.add(new Shuffle(mercury));
        modules.add(new Rotate(mercury));
        modules.add(new ClearInventory(mercury));

        for (Model base : modules) {
            base.register();
        }
    }
}