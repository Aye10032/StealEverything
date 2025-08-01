package com.aye10032.stealeverything.index;

import com.aye10032.stealeverything.StealEverything;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

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

//    public static final RegistryObject<Item> CREATIVE_TAB_TFMG = ITEMS.register(
//            "icon_tfmg",
//            () -> new Item(new Item.Properties())
//    );

    public static final ItemEntry<Item> CREATIVE_TAB_TFMG = StealEverything.REGISTRATE.item("icon_tfmg", Item::new).register();
    public static final ItemEntry<Item> LIMESTONE_POWDER = StealEverything.REGISTRATE.item("limestone_powder", Item::new).register();

    public static void register() {
    }
}
