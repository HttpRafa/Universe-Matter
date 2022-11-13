/*
 * MIT License
 *
 * Copyright (c) 2022.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.rafael.mods.universe.matter.registry.forge;

//------------------------------
//
// This class was developed by Rafael K.
// On 11/11/2022 at 8:11 PM
// In the project universe-matter
//
//------------------------------

import de.rafael.mods.universe.matter.UniverseMatter;
import de.rafael.mods.universe.matter.utils.TripleValue;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModRegistryImpl {

    public static final Map<Registry<?>, DeferredRegister<?>> REGISTRIES = new HashMap<>();

    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
        return new CreativeModeTab(location.getNamespace() + "." + location.getPath()) {
            @Override
            public @NotNull ItemStack makeIcon() {
                return icon.get();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static <T> DeferredRegister<T> getOrCreateRegistry(Registry<T> registry) {
        if(REGISTRIES.containsKey(registry)) return (DeferredRegister<T>) REGISTRIES.get(registry);
        DeferredRegister<T> deferredRegister = DeferredRegister.create(registry.key(), UniverseMatter.MOD_ID);
        REGISTRIES.put(registry, deferredRegister);
        return deferredRegister;
    }

    public static <V, T extends V> TripleValue<Supplier<T>, ResourceKey<T>, ResourceLocation> registerFull(Registry<V> registry, String id, Supplier<T> object) {
        var registered = getOrCreateRegistry(registry).register(id, object);
        return TripleValue.of(registered, registered.getKey(), registered.getId());
    }

}
