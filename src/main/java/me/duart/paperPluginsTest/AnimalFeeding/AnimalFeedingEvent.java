package me.duart.paperPluginsTest.AnimalFeeding;

import org.bukkit.entity.Animals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AnimalFeedingEvent implements Listener {

    /**
     * Mocks an AnimalFeedingEvent when a player feeds an animal.
     * Only triggers if the animal is not in love mode and the player
     * is holding a valid breeding item.
     * <p>
     * Unlike the standard EntityBreedEvent, this does not require a second
     * animal to fire; it is triggered purely by the player feeding a single animal.
     * </p>
     *
     * @param event the player interaction event
     */
    @EventHandler
    public void onAnimalFeed(@NotNull PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Animals animal)) return;
        if (animal.isLoveMode()) return; // Supposedly fed

        ItemStack handItem = event.getHand() == EquipmentSlot.HAND
                ? event.getPlayer().getInventory().getItemInMainHand()
                : event.getPlayer().getInventory().getItemInOffHand();

        if (handItem.getType().isAir() || !animal.isBreedItem(handItem)) return;

        event.getPlayer().sendMessage("1");
    }
}
