package me.usainsrht.enchgui;

import org.bukkit.plugin.java.JavaPlugin;

public final class EnchGUI extends JavaPlugin {

    private static EnchGUI instance;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();


    }

    @Override
    public void onDisable() {

    }

    public static EnchGUI getInstance() {
        return instance;
    }

    public void reload() {
        reloadConfig();

        loadConfig();
    }

    public void loadConfig() {
        saveDefaultConfig();


    }
}
