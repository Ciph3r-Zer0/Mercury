package ir.ciph3r.mercury.modules;

import co.aikar.commands.ConditionFailedException;
import co.aikar.commands.MessageKeys;
import co.aikar.commands.MinecraftMessageKeys;
import co.aikar.commands.PaperCommandManager;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.impl.broadcast.Broadcast;
import ir.ciph3r.mercury.modules.impl.chatformat.ChatFormat;
import ir.ciph3r.mercury.modules.impl.clearinventory.ClearInventory;
import ir.ciph3r.mercury.modules.impl.coordinates.Coordinates;
import ir.ciph3r.mercury.modules.impl.crossteleport.CrossTeleport;
import ir.ciph3r.mercury.modules.impl.feed.Feed;
import ir.ciph3r.mercury.modules.impl.fly.Fly;
import ir.ciph3r.mercury.modules.impl.gamemode.Gamemode;
import ir.ciph3r.mercury.modules.impl.heal.Heal;
import ir.ciph3r.mercury.modules.impl.kill.Kill;
import ir.ciph3r.mercury.modules.impl.knockback.Knockback;
import ir.ciph3r.mercury.modules.impl.lightning.Lightning;
import ir.ciph3r.mercury.modules.impl.mercurycmd.MercuryCMD;
import ir.ciph3r.mercury.modules.impl.joinmessage.JoinMessage;
import ir.ciph3r.mercury.modules.impl.quitmessage.QuitMessage;
import ir.ciph3r.mercury.modules.impl.pluginlist.PluginList;
import ir.ciph3r.mercury.modules.impl.privatechat.Reply;
import ir.ciph3r.mercury.modules.impl.rotate.Rotate;
import ir.ciph3r.mercury.modules.impl.shuffle.Shuffle;
import ir.ciph3r.mercury.modules.impl.spawn.SetSpawn;
import ir.ciph3r.mercury.modules.impl.spawn.Spawn;
import ir.ciph3r.mercury.modules.impl.speed.Speed;
import ir.ciph3r.mercury.modules.impl.sudo.Sudo;
import ir.ciph3r.mercury.modules.impl.teleport.Teleport;
import ir.ciph3r.mercury.modules.impl.privatechat.Tell;
import ir.ciph3r.mercury.modules.impl.time.Time;
import ir.ciph3r.mercury.modules.impl.uptime.Uptime;
import ir.ciph3r.mercury.utility.Logger;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.Listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class CommandManager {
    public ArrayList<CommandModule> modules = new ArrayList<>();
    public final PaperCommandManager commandManager = new PaperCommandManager(MercuryAPI.INSTANCE.getPlugin());
    private int registeredCount = 0;

    public CommandManager() {
        register();
    }

    public void register() {
        try {
            commandManager.getLocales().loadYamlLanguageFile("messages.yml", Locale.ENGLISH);

            registerConditions();
            registerPlaceHolders();

            modules.add(new MercuryCMD());
            modules.add(new Broadcast());
            modules.add(new ChatFormat());
            modules.add(new ClearInventory());
            modules.add(new Coordinates());
            modules.add(new CrossTeleport());
            modules.add(new Feed());
            modules.add(new Fly());
            modules.add(new Gamemode());
            modules.add(new Heal());
            modules.add(new Kill());
            modules.add(new Knockback());
            modules.add(new Lightning());
            modules.add(new JoinMessage());
            modules.add(new QuitMessage());
            modules.add(new PluginList());
            modules.add(new Tell());
            modules.add(new Reply());
            modules.add(new Rotate());
            modules.add(new Shuffle());
            modules.add(new SetSpawn());
            modules.add(new Spawn());
            modules.add(new Speed());
            modules.add(new Sudo());
            modules.add(new Teleport());
            modules.add(new Time());
            modules.add(new Uptime());

            Logger.log("&7Registering &aModules&7...");

            for (CommandModule module : modules) {
                registerModule(module);
            }

            Logger.log("&a" + registeredCount + "&7/" + "&a" + modules.size() + " &7Modules registered.");
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void registerModule(CommandModule module) {
        if (module.isEnabled()) {
            commandManager.registerCommand(module);
            if (!(module.getListeners().size() == 0)) {
                for (Listener listener : module.getListeners()) {
                    Bukkit.getServer().getPluginManager().registerEvents(listener, MercuryAPI.INSTANCE.getPlugin());
                }
            }
            registeredCount++;
        }
    }

    private void registerConditions() {
        commandManager.getCommandConditions().addCondition(OnlinePlayer.class, "noAdmin", (context, execContext, value) -> {
            if (value == null) return;
            if ((!context.getIssuer().hasPermission("mercury.admin")) && value.getPlayer().hasPermission("mercury.commands.exempt")) {
                throw new ConditionFailedException(MercuryAPI.INSTANCE.getConfigManager().getValues().NOT_TO_ADMIN);
            }
        });

        commandManager.getCommandConditions().addCondition(OnlinePlayer.class, "notYourSelf", (context, execContext, value) -> {
            if (value == null) return;
            if (value.getPlayer().getUniqueId().equals(context.getIssuer().getUniqueId())) {
                throw new ConditionFailedException(MercuryAPI.INSTANCE.getConfigManager().getValues().PRIVATE_CHAT_CAN_NOT_SEND_SELF);
            }
        });

        commandManager.getCommandConditions().addCondition(Float.class, "limits", (c, exec, value) -> {
            if (value == null) {
                return;
            }
            if (c.hasConfig("min") && c.getConfigValue("min", 0) > value) {
                throw new ConditionFailedException(MercuryAPI.INSTANCE.getConfigManager().getValues().PLEASE_SPECIFY_AT_LEAST.replace("{min}", String.valueOf(c.getConfigValue("min", 0))));
            }
            if (c.hasConfig("max") && c.getConfigValue("max", 3) < value) {
                throw new ConditionFailedException(MercuryAPI.INSTANCE.getConfigManager().getValues().PLEASE_SPECIFY_AT_MOST.replace("{max}", String.valueOf(c.getConfigValue("max", 3))));
            }
        });
    }

    public void registerPlaceHolders() {
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.PERMISSION_DENIED, commandManager.getLocales().getMessage(null, MessageKeys.PERMISSION_DENIED)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.PERMISSION_DENIED_PARAMETER, commandManager.getLocales().getMessage(null, MessageKeys.PERMISSION_DENIED_PARAMETER)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.ERROR_GENERIC_LOGGED, commandManager.getLocales().getMessage(null, MessageKeys.ERROR_GENERIC_LOGGED)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.UNKNOWN_COMMAND, commandManager.getLocales().getMessage(null, MessageKeys.UNKNOWN_COMMAND)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.INVALID_SYNTAX, MercuryAPI.INSTANCE.getConfigManager().getValues().COMMAND_USAGE_SYNTAX
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.ERROR_PREFIX, "{message}"
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.ERROR_PERFORMING_COMMAND, commandManager.getLocales().getMessage(null, MessageKeys.ERROR_PERFORMING_COMMAND)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.INFO_MESSAGE, commandManager.getLocales().getMessage(null, MessageKeys.INFO_MESSAGE)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.PLEASE_SPECIFY_ONE_OF, commandManager.getLocales().getMessage(null, MessageKeys.PLEASE_SPECIFY_ONE_OF)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.MUST_BE_A_NUMBER, commandManager.getLocales().getMessage(null, MessageKeys.MUST_BE_A_NUMBER)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.MUST_BE_MIN_LENGTH, commandManager.getLocales().getMessage(null, MessageKeys.MUST_BE_MIN_LENGTH)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.MUST_BE_MAX_LENGTH, commandManager.getLocales().getMessage(null, MessageKeys.MUST_BE_MAX_LENGTH)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.PLEASE_SPECIFY_AT_MOST, commandManager.getLocales().getMessage(null, MessageKeys.PLEASE_SPECIFY_AT_MOST)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.PLEASE_SPECIFY_AT_LEAST, commandManager.getLocales().getMessage(null, MessageKeys.PLEASE_SPECIFY_AT_LEAST)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.NOT_ALLOWED_ON_CONSOLE, commandManager.getLocales().getMessage(null, MessageKeys.NOT_ALLOWED_ON_CONSOLE)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.COULD_NOT_FIND_PLAYER, commandManager.getLocales().getMessage(null, MessageKeys.COULD_NOT_FIND_PLAYER)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.NO_COMMAND_MATCHED_SEARCH, commandManager.getLocales().getMessage(null, MessageKeys.NO_COMMAND_MATCHED_SEARCH)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.HELP_PAGE_INFORMATION, commandManager.getLocales().getMessage(null, MessageKeys.HELP_PAGE_INFORMATION)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.HELP_NO_RESULTS, commandManager.getLocales().getMessage(null, MessageKeys.HELP_NO_RESULTS)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.HELP_HEADER, commandManager.getLocales().getMessage(null, MessageKeys.HELP_HEADER)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.HELP_FORMAT, commandManager.getLocales().getMessage(null, MessageKeys.HELP_FORMAT)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.HELP_DETAILED_HEADER, commandManager.getLocales().getMessage(null, MessageKeys.HELP_DETAILED_HEADER)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.HELP_DETAILED_COMMAND_FORMAT, commandManager.getLocales().getMessage(null, MessageKeys.HELP_DETAILED_COMMAND_FORMAT)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.HELP_DETAILED_PARAMETER_FORMAT, commandManager.getLocales().getMessage(null, MessageKeys.HELP_DETAILED_PARAMETER_FORMAT)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MessageKeys.HELP_SEARCH_HEADER, commandManager.getLocales().getMessage(null, MessageKeys.HELP_SEARCH_HEADER)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));

//        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.INVALID_WORLD, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.INVALID_WORLD)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.YOU_MUST_BE_HOLDING_ITEM, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.YOU_MUST_BE_HOLDING_ITEM)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.PLAYER_IS_VANISHED_CONFIRM, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.PLAYER_IS_VANISHED_CONFIRM)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.USERNAME_TOO_SHORT, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.USERNAME_TOO_SHORT)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.IS_NOT_A_VALID_NAME, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.IS_NOT_A_VALID_NAME)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.MULTIPLE_PLAYERS_MATCH, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.MULTIPLE_PLAYERS_MATCH)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.NO_PLAYER_FOUND_SERVER, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.NO_PLAYER_FOUND_SERVER)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.NO_PLAYER_FOUND_OFFLINE, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.NO_PLAYER_FOUND_OFFLINE)
                .replace("{prefix}", MercuryAPI.INSTANCE.getConfigManager().getValues().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.NO_PLAYER_FOUND, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.NO_PLAYER_FOUND)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.LOCATION_PLEASE_SPECIFY_WORLD, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.LOCATION_PLEASE_SPECIFY_WORLD)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.LOCATION_PLEASE_SPECIFY_XYZ, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.LOCATION_PLEASE_SPECIFY_XYZ)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
//        commandManager.getLocales().addMessage(Locale.ENGLISH, MinecraftMessageKeys.LOCATION_CONSOLE_NOT_RELATIVE, commandManager.getLocales().getMessage(null, MinecraftMessageKeys.LOCATION_CONSOLE_NOT_RELATIVE)
//                .replace("{prefix}", MercuryAPI.INSTANCE.getMessages().PREFIX));
    }
}
