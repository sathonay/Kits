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
}
