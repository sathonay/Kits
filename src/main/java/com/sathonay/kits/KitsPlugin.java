package com.sathonay.kits;

import com.sathonay.core.api.ACore;
import com.sathonay.kits.configs.KitsConfig;

public class KitsPlugin extends ACore {

    @Override
    public void onEnable() {
        super.onEnable();
        getConfigs().addConfig(new KitsConfig(this));
        getConfigs().loadConfigs();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getConfigs().saveConfigs();
    }
}
