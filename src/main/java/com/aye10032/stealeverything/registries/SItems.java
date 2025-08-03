package com.aye10032.stealeverything.registries;

import com.aye10032.stealeverything.StealEverything;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Item;

/**
 * @program: stealeverything
 * @description: Item class
 * @author: Aye10032
 * @create: 2025-08-01 21:23
 **/

public class SItems {
    static {
        StealEverything.REGISTRATE.setCreativeTab(ModCreativeModeTabs.MAIN_TAB);
    }

    public static final ItemEntry<Item> CREATIVE_TAB_TFMG = StealEverything.REGISTRATE.item("icon_tfmg", Item::new).register();
    public static final ItemEntry<Item> LIMESTONE_POWDER = StealEverything.REGISTRATE.item("limestone_powder", Item::new)
            .recipe((ctx, prov) -> prov.smelting(
                    DataIngredient.items(AllPaletteStoneTypes.LIMESTONE.getBaseBlock().get().asItem()),
                    RecipeCategory.BUILDING_BLOCKS,
                    ctx,
                    0.35f,
                    200
            ))
            .register();

    public static void register() {
    }
}
