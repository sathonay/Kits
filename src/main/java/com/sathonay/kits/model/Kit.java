package com.sathonay.kits.model;

import com.sathonay.core.api.util.CC;
import com.sathonay.core.api.util.ItemBuilder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public class Kit {

    private ItemStack icon = new ItemStack(Material.DIAMOND_SWORD, 1);
    private ItemStack[] /*armorContents,*/ contents;

    public Kit(ItemStack icon/*, ItemStack[] armorContents*/, ItemStack[] contents) {
        this.icon = icon;
        /*this.armorContents = armorContents;*/
        this.contents = contents;
    }

    public Kit(/*, ItemStack[] armorContents*/ ItemStack[] contents) {
        /*this.armorContents = armorContents;*/
        this.contents = contents;
    }

    public void setIcon(ItemStack icon) {
        if (this.icon.hasItemMeta()) {
            ItemMeta newIconMeta = icon.getItemMeta();
            String displayName = this.icon.getItemMeta().getDisplayName();
            if (Objects.nonNull(displayName)) newIconMeta.setDisplayName(displayName);
            icon.setItemMeta(newIconMeta);
        }
        this.icon = icon;
    }

    public Kit setDisplayName(String displayName) {
        ItemMeta newIconMeta = icon.getItemMeta();
        newIconMeta.setDisplayName(displayName);
        icon.setItemMeta(newIconMeta);
        return this;
    }

    public void giveToPlayer(Player player) {
        PlayerInventory inventory = player.getInventory();

        /*inventory.clear();
        inventory.setArmorContents(this.armorContents);
        inventory.setContents(this.contents);*/

        for (ItemStack item : this.contents) {
            if (item == null) continue;
            inventory.addItem(item);
        }

        player.updateInventory();
    }
}
