package me.duart.paperPluginsTest.UnequippableEquippableItem;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.UUID;

/**
 * Creates a dummy example item that is normally equippable by default,
 * but is modified to be unequippable using a simple trick: restricting
 * it to only be wearable in the player's HAND slot, which invalidates
 * all other equipment slots.
 */
public class UnequippablePlayerHead {

    String skinURL = "http://textures.minecraft.net/texture/a9f43a59f8cfa3436c21ea8053fee373092b5980f53fa33bd9e488977cbd512e";

    @SuppressWarnings("UnstableApiUsage")
    public ItemStack somePlayerHead() {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta head = (SkullMeta) item.getItemMeta();

        if (head == null) return item;

        EquippableComponent equippableComponent = head.getEquippable();
        equippableComponent.setSlot(EquipmentSlot.HAND);

        head.setEquippable(equippableComponent);
        head.setPlayerProfile(fetchDummyProfile()); // Only relatable to PlayerHeads
        item.setItemMeta(head);
        return item;
    }

    // Attaches a name and a skin to the player head
    private @NotNull PlayerProfile fetchDummyProfile() {
        PlayerProfile profile = Bukkit.createProfile(UUID.randomUUID(), "UnequipableHead");

        PlayerTextures textures = profile.getTextures();
        try {
            textures.setSkin(URI.create(skinURL).toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        profile.setTextures(textures);

        return profile;
    }

    // Of course, you should also prevent the player from placing the head in the world in order
    // to prevent the head from losing its equipable metadata.
}
