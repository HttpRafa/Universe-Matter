package de.rafael.universe.matter.forge;

import dev.architectury.platform.forge.EventBuses;
import de.rafael.universe.matter.UniverseMatter;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UniverseMatter.MOD_ID)
public class UniverseMatterForge {

    public UniverseMatterForge() {
        EventBuses.registerModEventBus(UniverseMatter.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        UniverseMatter.init();
    }

}
