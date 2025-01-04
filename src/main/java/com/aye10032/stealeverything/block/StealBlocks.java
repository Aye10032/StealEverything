package com.aye10032.stealeverything.block;

import com.aye10032.stealeverything.StealEverything;
import com.aye10032.stealeverything.item.StealItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * @program: stealeverything
 * @description:
 * @author: Aye10032
 * @create: 2025-01-01 02:44
 **/

public class StealBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StealEverything.MODID);

    public static final RegistryObject<Block> CEMENT = registerBlock(
            "cement",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND))
    );
    public static final RegistryObject<Block> CONCRETE = registerBlock(
            "concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE))
    );
    public static final RegistryObject<Block> WHITE_CONCRETE = registerBlock(
            "white_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE))
    );
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE = registerBlock(
            "light_gray_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE))
    );
    public static final RegistryObject<Block> GRAY_CONCRETE = registerBlock(
            "gray_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE))
    );
    public static final RegistryObject<Block> REBAR_CONCRETE = registerBlock(
            "rebar_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS))
    );
    public static final RegistryObject<Block> CINDER_BLOCK = registerBlock(
            "cinder_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS))
    );

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return StealItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
