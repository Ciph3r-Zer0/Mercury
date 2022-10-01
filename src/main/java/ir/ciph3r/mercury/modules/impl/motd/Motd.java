package ir.ciph3r.mercury.modules.impl.motd;

import co.aikar.commands.annotation.*;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.motd.listeners.MotdListener;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.entity.Player;

@CommandAlias("Motd")
public class Motd extends CommandModule {
    public Motd() {
        super("Motd", MercuryAPI.INSTANCE.getConfigManager().getValues().MOTD_ENABLED);
        setCommandNameAndSyntax("/Motd", null);
        addListeners(new MotdListener());
    }

    @Default
    @CommandPermission("mercury.commands.motd")
    public void onShuffle(Player player) {
        String msg = MercuryAPI.INSTANCE.getDepends().getPapiAPI().setPlaceHolders(player, MercuryAPI.INSTANCE.getConfigManager().getValues().MOTD_MESSAGE);
        ChatUtils.sendColorizedMSG(player, msg);
    }
}
