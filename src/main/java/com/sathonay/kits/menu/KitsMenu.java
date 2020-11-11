package com.sathonay.kits.menu;

import com.sathonay.core.menu.Menu;
import com.sathonay.core.menu.actions.Action;
import com.sathonay.core.menu.actions.PlayerAction;
import com.sathonay.kits.handler.KitsHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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
    }

    @Override
    public void update() {
        kitsHandler.values().forEach(kit -> addItem(kit.getIcon(), (KitMenuAction) kit::giveToPlayer));
    }

    public interface KitMenuAction extends PlayerAction {
        @Override
        default void onClick(InventoryClickEvent event) {
            event.setCancelled(true); // precautionary measure (thanks google trad) ^^
            Player player = (Player) event.getWhoClicked();
            player.closeInventory();
            onClick(player);
        }
    }
}
