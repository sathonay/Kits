package com.sathonay.kits.menu;

import com.sathonay.core.menu.Menu;
import com.sathonay.core.menu.actions.Action;
import com.sathonay.core.menu.actions.PlayerAction;
import com.sathonay.kits.manager.KitsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KitsMenu extends Menu {

    private final KitsManager kitsManager;

    public KitsMenu(String title, int rows, KitsManager kitsManager) {
        super(title, rows);
        this.kitsManager = kitsManager;
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
        kitsManager.values().forEach(kit -> addItem(kit.getIcon(), (KitMenuAction) kit::giveToPlayer));
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
