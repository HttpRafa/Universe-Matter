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

package de.rafael.mods.universe.matter.registry.fabric;

//------------------------------
//
// This class was developed by Rafael K.
// On 11/11/2022 at 8:11 PM
// In the project universe-matter
//
//------------------------------

import de.rafael.mods.universe.matter.UniverseMatter;
import de.rafael.mods.universe.matter.utils.Data3v;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModRegistryImpl {

    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(location, icon);
    }

    @SuppressWarnings("unchecked")
    public static <V, T extends V> Data3v<Supplier<T>, ResourceKey<T>, ResourceLocation> registerFull(Registry<V> registry, String id, Supplier<T> object) {
        T register = Registry.register(registry, new ResourceLocation(UniverseMatter.MOD_ID, id), object.get());
        return Data3v.of(() -> register, (ResourceKey<T>)ResourceKey.create(registry.key(), new ResourceLocation(UniverseMatter.MOD_ID, id)), new ResourceLocation(UniverseMatter.MOD_ID, id));
    }

}
