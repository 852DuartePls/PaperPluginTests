package me.duart.paperPluginsTest.AnimalFeeding;

import org.bukkit.entity.Animals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AnimalFeedingEvent implements Listener {

    @EventHandler
    public void onAnimalFeed(@NotNull PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Animals animal)) return;
        if (animal.isLoveMode()) return; // Supposedly fed

        ItemStack mainHandItem = event.getPlayer().getInventory().getItemInMainHand();
        ItemStack offHandItem = event.getPlayer().getInventory().getItemInOffHand();

        ItemStack handItem = mainHandItem.getType().isAir() ? offHandItem : mainHandItem;
        if (!animal.isBreedItem(handItem)) return;

        event.getPlayer().sendMessage("1");
    }
}
