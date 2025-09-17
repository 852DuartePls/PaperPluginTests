package me.duart.paperPluginsTest.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import me.duart.paperPluginsTest.UnequippableEquippableItem.UnequippablePlayerHead;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

public class GiveItemCommand implements BasicCommand {

    private final UnequippablePlayerHead unequippablePlayerHead;

    public GiveItemCommand(UnequippablePlayerHead unequippablePlayerHead) {
        this.unequippablePlayerHead = unequippablePlayerHead;
    }

    @Override
    public void execute(@NotNull CommandSourceStack commandSourceStack, String @NotNull [] args) {
        CommandSender sender = commandSourceStack.getSender();
        if (!(sender instanceof Player player)) {
            sender.sendMessage("You must be a player to use this command!");
            return;
        }
        player.getInventory().addItem(unequippablePlayerHead.somePlayerHead());
        player.sendMessage("Nice Head!");
    }

    @Override
    public @Nullable String permission() {
        return "testplugin.admin";
    }
}
