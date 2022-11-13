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

package de.rafael.mods.universe.matter.registry.feature;

//------------------------------
//
// This class was developed by Rafael K.
// On 11/12/2022 at 11:27 PM
// In the project universe-matter
//
//------------------------------

import de.rafael.mods.universe.matter.registry.ModRegistry;
import de.rafael.mods.universe.matter.world.feature.ModOreGen;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static final Supplier<ConfiguredFeature<?, ?>> OSMIUM_ORE = register("osmium_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ModOreGen.OVERWORLD.get(), 6)));

    public static void init() {

    }

    private static <T extends ConfiguredFeature<?, ?>> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, object);
    }

}
