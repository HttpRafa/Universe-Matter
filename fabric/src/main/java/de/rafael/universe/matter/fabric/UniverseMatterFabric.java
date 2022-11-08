package de.rafael.universe.matter.fabric;

import de.rafael.universe.matter.UniverseMatter;
import net.fabricmc.api.ModInitializer;

public class UniverseMatterFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        UniverseMatter.init();
    }

}
