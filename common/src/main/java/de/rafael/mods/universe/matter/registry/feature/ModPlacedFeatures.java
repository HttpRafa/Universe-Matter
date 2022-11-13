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
// On 11/13/2022 at 12:03 AM
// In the project universe-matter
//
//------------------------------

import de.rafael.mods.universe.matter.registry.ModRegistry;
import de.rafael.mods.universe.matter.utils.TripleValue;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.function.Supplier;

public class ModPlacedFeatures {

    public static final TripleValue<Supplier<PlacedFeature>, ResourceKey<PlacedFeature>, ResourceLocation> OSMIUM_ORE_PLACED = register("osmium_ore_placed", () -> new PlacedFeature(Holder.direct(ModConfiguredFeatures.OSMIUM_ORE.get()),
            commonOrePlacement(5,
                    HeightRangePlacement.triangle(
                            VerticalAnchor.absolute(-45),
                            VerticalAnchor.absolute(45)))));

    public static void init() {

    }

    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier2) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(i), placementModifier);
    }

    private static List<PlacementModifier> rareOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(i), placementModifier);
    }

    private static <T extends PlacedFeature> TripleValue<Supplier<T>, ResourceKey<T>, ResourceLocation> register(String id, Supplier<T> object) {
        return ModRegistry.registerFull(BuiltinRegistries.PLACED_FEATURE, id, object);
    }

}
