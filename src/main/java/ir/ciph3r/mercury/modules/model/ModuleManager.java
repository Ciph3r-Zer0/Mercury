package ir.ciph3r.mercury.modules.model;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.broadcast.Broadcast;
import ir.ciph3r.mercury.modules.clearinventory.ClearInventory;
import ir.ciph3r.mercury.modules.coordinates.Coordinates;
import ir.ciph3r.mercury.modules.crossteleport.CrossTeleport;
import ir.ciph3r.mercury.modules.feed.Feed;
import ir.ciph3r.mercury.modules.fly.Fly;
import ir.ciph3r.mercury.modules.gamemode.GameMode;
import ir.ciph3r.mercury.modules.hat.Hat;
import ir.ciph3r.mercury.modules.heal.Heal;
import ir.ciph3r.mercury.modules.knockback.Knockback;
import ir.ciph3r.mercury.modules.lightening.Lightning;
import ir.ciph3r.mercury.modules.mercury.MercuryCMD;
import ir.ciph3r.mercury.modules.pluginlist.PluginList;
import ir.ciph3r.mercury.modules.rotate.Rotate;
import ir.ciph3r.mercury.modules.shuffle.Shuffle;
import ir.ciph3r.mercury.modules.spawn.SetSpawn;
import ir.ciph3r.mercury.modules.spawn.Spawn;
import ir.ciph3r.mercury.modules.speed.Speed;
import ir.ciph3r.mercury.modules.sudo.Sudo;
import ir.ciph3r.mercury.modules.teleport.Teleport;
import ir.ciph3r.mercury.modules.tell.Reply;
import ir.ciph3r.mercury.modules.tell.Tell;

import java.util.ArrayList;

public class ModuleManager {
    private final Mercury mercury;
    private ArrayList<ModuleModel> modules;

    public ModuleManager(Mercury mercury) {
        this.mercury = mercury;
        modules = new ArrayList<ModuleModel>();
    }

    public void register() {
        modules.add(new MercuryCMD(mercury));
        modules.add(new Broadcast(mercury));
        modules.add(new ClearInventory(mercury));
        modules.add(new Coordinates(mercury));
        modules.add(new CrossTeleport(mercury));
        modules.add(new Feed(mercury));
        modules.add(new Fly(mercury));
        modules.add(new GameMode(mercury));
        modules.add(new Hat(mercury));
        modules.add(new Heal(mercury));
        modules.add(new Knockback(mercury));
        modules.add(new Lightning(mercury));
        modules.add(new PluginList(mercury));
        modules.add(new Rotate(mercury));
        modules.add(new Shuffle(mercury));
        modules.add(new Spawn(mercury));
        modules.add(new SetSpawn(mercury));
        modules.add(new Speed(mercury));
        modules.add(new Sudo(mercury));
        modules.add(new Teleport(mercury));
        modules.add(new Tell(mercury));
        modules.add(new Reply(mercury));

        for (ModuleModel base : modules) {
            base.register();
        }
    }
}