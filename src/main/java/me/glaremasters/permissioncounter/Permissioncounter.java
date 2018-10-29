package me.glaremasters.permissioncounter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Permissioncounter extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new Placeholders(this).register();
        }
        getCommand("pcreload").setExecutor(new Reload(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
