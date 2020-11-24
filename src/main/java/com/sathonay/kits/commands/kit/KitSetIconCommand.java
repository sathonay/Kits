package com.sathonay.kits.commands.kit;

import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitSetIconCommand extends KitSubCommand{
    public KitSetIconCommand(KitsManager kitsManager) {
        super("kit seticon <kit>", kitsManager, "seticon");
    }

    @Override
    public void execute(Player player, String[] args, String label, Kit kit) {
        ItemStack item = player.getItemInHand();

        if (item == null || item.getType() == Material.AIR) {
            player.sendMessage(ChatColor.RED + "Take an item in your hand");
            return;
        }

        kit.setIcon(item.clone());
        kitsManager.saveUpdates();
        player.sendMessage(ChatColor.GREEN + "The icon of the kit was updated.");
    }
}
