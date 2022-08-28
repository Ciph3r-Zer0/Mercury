package ir.ciph3r.mercury.modules.impl.shuffle;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import ir.ciph3r.mercury.utility.NumeralUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Shuffle")
public class Shuffle extends CommandModule {
    public Shuffle() {
        super("Shuffle", MercuryAPI.INSTANCE.getConfig().SHUFFLE_ENABLED);
        setCommandNameAndSyntax("/Shuffle", "<player>");
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.shuffle")
    @CommandCompletion("@players")
    public void onShuffle(CommandSender sender) {
        ChatUtils.sendColorizedMSG(sender, getCommandUsage());
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.shuffle")
    @CommandCompletion("@players")
    public void onShuffleOthers(CommandSender sender, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().getInventory().setHeldItemSlot(NumeralUtils.generateNonDupeRandomNumber(0, 8, target.getPlayer().getInventory().getHeldItemSlot()));
        ChatUtils.sendColorizedMSG(sender, MercuryAPI.INSTANCE.getMessages().SHUFFLE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()));
    }
}
