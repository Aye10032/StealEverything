package com.aye10032.stealeverything.registries;

import com.aye10032.stealeverything.StealEverything;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

/**
 * @program: stealeverything
 * @description: block class
 * @author: Aye10032
 * @create: 2025-08-01 22:56
 **/

public class SBlocks {
    static {
        StealEverything.REGISTRATE.setCreativeTab(ModCreativeModeTabs.MAIN_TAB);
    }

    public static final BlockEntry<Block> CEMENT = StealEverything.REGISTRATE.block("cement", Block::new)
            .initialProperties(() -> Blocks.SAND)
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CONCRETE = StealEverything.REGISTRATE.block("concrete", Block::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .tag(BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> WHITE_CONCRETE = StealEverything.REGISTRATE.block("white_concrete", Block::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .tag(BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> GRAY_CONCRETE = StealEverything.REGISTRATE.block("gray_concrete", Block::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .tag(BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LIGHT_GRAY_CONCRETE = StealEverything.REGISTRATE.block("light_gray_concrete", Block::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .tag(BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();


    public static final BlockEntry<Block> REBAR_CONCRETE = StealEverything.REGISTRATE.block("rebar_concrete", Block::new)
            .initialProperties(() -> Blocks.WHITE_CONCRETE)
            .tag(BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CINDER_BLOCK = StealEverything.REGISTRATE.block("cinder_block", Block::new)
            .initialProperties(() -> Blocks.BRICKS)
            .tag(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate((ctx, prov) -> prov.simpleBlock(
                    ctx.getEntry(),
                    prov.models().cubeBottomTop(
                            ctx.getId().getPath(),
                            StealEverything.asResource("block/cinderblock"),
                            StealEverything.asResource("block/cinderblock_top"),
                            StealEverything.asResource("block/cinderblock_top")
                    )
            ))
            .simpleItem()
            .register();

    public static void register() {
    }
}
