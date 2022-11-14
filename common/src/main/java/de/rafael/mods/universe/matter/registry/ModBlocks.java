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

package de.rafael.mods.universe.matter.registry;

//------------------------------
//
// This class was developed by Rafael K.
// On 11/11/2022 at 8:07 PM
// In the project universe-matter
//
//------------------------------

import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModBlocks {

    // Machines
    // public static final Supplier<Block> ELECTRIC_HEAT_COMPRESSOR = register("electric_heat_compressor", () -> new ElectricHeatCompressor(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)));

    // Casings
    public static final Supplier<Block> STEEL_CASING = register("steel_casing", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> REINFORCED_STEEL_CASING = register("reinforced_steel_casing", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> REINFORCED_GLASS = register("reinforced_glass", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    // Osmium
    public static final Supplier<Block> OSMIUM_BLOCK = register("osmium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));
    public static final Supplier<Block> RAW_OSMIUM_BLOCK = register("raw_osmium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK)));

    // Ores
    public static final Supplier<Block> OSMIUM_ORE = register("osmium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE), UniformInt.of(0, 2)));
    public static final Supplier<Block> DEEPSLATE_OSMIUM_ORE = register("deepslate_osmium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE), UniformInt.of(0, 2)));

    public static void init() {

    }

    private static <T extends Block> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistry.register(Registry.BLOCK, id, object);
    }

}
