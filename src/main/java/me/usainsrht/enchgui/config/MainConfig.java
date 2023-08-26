package me.usainsrht.enchgui.config;

import me.usainsrht.enchgui.command.CommandHandler;
import me.usainsrht.enchgui.command.EnchGUICommand;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainConfig {

    private static Component prefix;
    private static HashMap<String, List<String>> messages = new HashMap<>();
    private static HashMap<String, List<Sound>> sounds = new HashMap<>();
    private static String cmdName;
    private static String cmdDesc;
    private static String cmdUsage;
    private static String cmdPerm;
    private static List<String> cmdAliases;

    public void create(FileConfiguration config) {

        MiniMessage mm = MiniMessage.miniMessage();

        if (config.getString("prefix", "").length() > 0) {
            prefix = mm.deserialize(config.getString("prefix"));
        }

        messages = new HashMap<>();
        if (config.isSet("messages")) {
            ConfigurationSection messagesSection = config.getConfigurationSection("messages");
            for (String key : messagesSection.getKeys(false)) {
                if (messagesSection.isList(key)) {
                    messages.put(key, messagesSection.getStringList(key));
                } else {
                    messages.put(key, new ArrayList<>(Arrays.asList(messagesSection.getString(key))));
                }
            }
        }

        cmdName = config.getString("command.name", "enchgui");
        cmdDesc = config.getString("command.description", "");
        cmdUsage = config.getString("command.usage", "");
        cmdPerm = config.getString("command.permission", "");
        cmdAliases = config.getStringList("command.aliases");
        CommandHandler.register(new EnchGUICommand(cmdName, cmdDesc, cmdUsage, cmdAliases));

    }

    public static Component getPrefix() {
        return prefix;
    }

    public static List<String> getMessage(String key) {
        return messages.get(key);
    }

    public static List<Sound> getSound(String key) {
        return sounds.get(key);
    }

    public static String getCmdDesc() {
        return cmdDesc;
    }

    public static List<String> getCmdAliases() {
        return cmdAliases;
    }

    public static String getCmdUsage() {
        return cmdUsage;
    }

    public static String getCmdName() {
        return cmdName;
    }

    public static String getCmdPerm() {
        return cmdPerm;
    }
}
