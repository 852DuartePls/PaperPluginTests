package me.duart.paperPluginsTest;

import org.bukkit.plugin.java.JavaPlugin;

public final class PaperPluginsTest extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("Test Plugin Initialized!");
        this.getLogger().info("Hi ^-^!");
    }

}
