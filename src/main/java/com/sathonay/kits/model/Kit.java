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

@Data
@RequiredArgsConstructor
public class Kit {

    private String displayName;
    private ItemStack icon = new ItemStack(Material.DIAMOND_SWORD, 1);
    private ItemStack[] /*armorContents,*/ contents;

    public Kit(String displayName, ItemStack icon/*, ItemStack[] armorContents*/, ItemStack[] contents) {
        this.icon = icon;
        this.setDisplayName(displayName);
        /*this.armorContents = armorContents;*/
        this.contents = contents;
    }

    public Kit(String displayName/*, ItemStack[] armorContents*/, ItemStack[] contents) {
        /*this.armorContents = armorContents;*/
        this.setDisplayName(displayName);
        this.contents = contents;
    }

    public void setIcon(ItemStack icon) {
        this.icon = icon;
        this.setDisplayName(this.displayName);
    }

    public void setDisplayName(String displayName) {
        this.displayName = CC.translate(displayName);
        this.icon = new ItemBuilder(this.icon).setName(this.displayName).toItemStack();
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
