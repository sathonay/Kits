package com.sathonay.kits.menu;

import com.sathonay.core.menu.Menu;
import com.sathonay.core.menu.actions.Action;
import com.sathonay.core.menu.actions.PlayerAction;
import com.sathonay.kits.handler.KitsHandler;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class KitsMenu extends Menu {

    private final KitsHandler kitsHandler;

    public KitsMenu(String title, int rows, KitsHandler kitsHandler) {
        super(title, rows);
        this.kitsHandler = kitsHandler;
    }

    @Override
    public void onOpen() {
        setBorder();
        update();
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        super.onClick(event);
        event.getWhoClicked().closeInventory();
        update();
    }

    @Override
    public void update() {
        kitsHandler.values().forEach(kit -> addItem(kit.getIcon(), (PlayerAction) kit::giveToPlayer));
    }

    public void addItem(ItemStack itemStack) {
        addItem(itemStack, null);
    }

    public void addItem(ItemStack itemStack, Action action) {
        Inventory inventory = getInventory();
        if (inventory == null) return;

        int firstValidSlot = getRows() * 9  + 1;

        ItemStack[] contents = inventory.getContents();

        for (int slot = 0; slot < contents.length; slot++) {
            ItemStack stack = contents[slot];
            if (stack == null || stack.getType() == Material.AIR) {
                firstValidSlot = slot;
                break;
            }
        }

        if (!isInInventory(firstValidSlot)) return;
        if (Objects.isNull(action)) setItem(firstValidSlot, itemStack);
        else setItem(firstValidSlot, itemStack, action);
    }
}
