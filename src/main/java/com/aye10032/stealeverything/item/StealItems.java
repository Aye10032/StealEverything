package com.aye10032.stealeverything.item;

import com.aye10032.stealeverything.StealEverything;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @program: stealeverything
 * @description:
 * @author: Aye10032
 * @create: 2025-01-01 02:00
 **/

public class StealItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StealEverything.MODID);

    public  static  final RegistryObject<Item> CREATIVE_TAB_TFMG = ITEMS.register(
            "icon_tfmg",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> LIMESTONE_POWDER = ITEMS.register(
            "limestone_powder",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}
