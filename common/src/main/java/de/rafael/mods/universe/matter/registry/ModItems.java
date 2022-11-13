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
// On 11/11/2022 at 8:36 PM
// In the project universe-matter
//
//------------------------------

import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModItems {

    // ----------------

    // Ingots
    public static final Supplier<Item> REFINED_IRON_INGOT = registerItem("refined_iron_ingot", ModCreativeTabs.MAIN_ITEM_GROUP);
    public static final Supplier<Item> OSMIUM_INGOT = registerItem("osmium_ingot", ModCreativeTabs.MAIN_ITEM_GROUP);

    // Raw
    public static final Supplier<Item> RAW_OSMIUM = registerItem("raw_osmium", ModCreativeTabs.MAIN_ITEM_GROUP);

    public static final Supplier<Item> RAW_OSMIUM_BLOCK = registerBlockItem("raw_osmium_block", ModBlocks.RAW_OSMIUM_BLOCK, ModCreativeTabs.MAIN_ITEM_GROUP);
    public static final Supplier<Item> OSMIUM_ORE = registerBlockItem("osmium_ore", ModBlocks.OSMIUM_ORE, ModCreativeTabs.MAIN_ITEM_GROUP);
    public static final Supplier<Item> DEEPSLATE_OSMIUM_ORE = registerBlockItem("deepslate_osmium_ore", ModBlocks.DEEPSLATE_OSMIUM_ORE, ModCreativeTabs.MAIN_ITEM_GROUP);
    public static final Supplier<Item> OSMIUM_BLOCK = registerBlockItem("osmium_block", ModBlocks.OSMIUM_BLOCK, ModCreativeTabs.MAIN_ITEM_GROUP);
    // ----------------

    public static void init() {
    }

    private static Supplier<Item> registerBlockItem(String id, Supplier<Block> block, CreativeModeTab creativeModeTab) {
        Supplier<Item> item = () -> new BlockItem(block.get(), new Item.Properties().tab(creativeModeTab));
        return register(id, item);
    }

    private static Supplier<Item> registerItem(String id, CreativeModeTab creativeModeTab) {
        return register(id, () -> new Item(new Item.Properties().tab(creativeModeTab)));
    }

    private static <T extends Item> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistry.register(Registry.ITEM, id, object);
    }

}
