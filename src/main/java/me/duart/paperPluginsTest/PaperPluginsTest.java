package me.duart.paperPluginsTest;

import io.papermc.paper.command.brigadier.BasicCommand;
import me.duart.paperPluginsTest.AnimalFeeding.AnimalFeedingEvent;
import me.duart.paperPluginsTest.UnequippableEquippableItem.UnequippablePlayerHead;
import me.duart.paperPluginsTest.commands.GiveItemCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperPluginsTest extends JavaPlugin {

    @Override
    public void onEnable() {
        BasicCommand giveItemCommand = new GiveItemCommand(new UnequippablePlayerHead());
        registerCommand("giveitem", giveItemCommand);

        getServer().getPluginManager().registerEvents(new AnimalFeedingEvent(), this);
        this.getLogger().info("Test Plugin Initialized!");
        this.getLogger().info("Hi ^-^!");
    }

}
