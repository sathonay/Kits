package com.sathonay.kits.configs;

import com.sathonay.core.api.ACore;
import com.sathonay.core.api.config.Config;
import com.sathonay.core.api.util.CC;
import com.sathonay.kits.commands.KitCommand;
import com.sathonay.kits.commands.KitsCommand;
import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.menu.KitsMenu;
import com.sathonay.kits.model.Kit;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
public class KitsConfig extends Config {
    private final ACore core;
    private final KitsManager kitsManager;

    public KitsConfig(ACore plugin) {
        super(plugin, "kits.yml");
        this.core = plugin;
        this.kitsManager = new KitsManager(this);
    }

    @Override
    public Config loadConfig() {

        Config config = super.loadConfig();

        core.getMenus().registerMenus(new KitsMenu("Kits", 6, kitsManager));

        core.registerCommands(
                new KitsCommand(core.getMenus()),
                new KitCommand(kitsManager)
        );

        return config;
    }

    @Override
    public void load(File file) throws IOException, InvalidConfigurationException {
        super.load(file);

        getKeys(false).forEach(kitName -> {
            //String displayName = getChatColorTranslateString(kitName + ".displayname");
            ItemStack icon = (ItemStack) get(kitName + ".icon");
            //ItemStack[] armorContents = getList(kitName + ".armor").toArray(new ItemStack[0]);
            ItemStack[] contents = getList(kitName + ".contents").toArray(new ItemStack[0]);

            kitsManager.put(kitName, new Kit(icon/*, armorContents*/, contents));
        });
    }

    @Override
    public boolean save() {

        clear(); // clear config before saving

        kitsManager.forEach((key, kit) -> {
            String path = key + ".";
            //set(path + "displayname", CC.revertTranslate(kit.getDisplayName()));
            set(path + "icon", kit.getIcon());
            //set(path + "armor", kit.getArmorContents());
            set(path + "contents", kit.getContents());
        });

        return super.save();
    }
}
