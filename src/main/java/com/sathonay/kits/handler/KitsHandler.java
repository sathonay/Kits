package com.sathonay.kits.handler;

import com.sathonay.core.api.config.IConfig;
import com.sathonay.kits.model.Kit;

import java.util.HashMap;
import java.util.Objects;

public class KitsHandler extends HashMap<String, Kit> {

    private final IConfig config;

    public KitsHandler(IConfig config) {
        this.config = config;
    }

    @Override
    public Kit putIfAbsent(String key, Kit value) {
        Kit kit = super.putIfAbsent(key, value);
        if (Objects.isNull(kit)) saveUpdates();
        return kit;
    }

    @Override
    public Kit remove(Object key) {
        Kit kit = super.remove(key);
        if (Objects.nonNull(kit)) saveUpdates();
        return kit;
    }

    public void saveUpdates() {
        config.save();
    }
}
