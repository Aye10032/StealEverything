package com.aye10032.stealeverything.block;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

/**
 * @program: stealeverything
 * @description: 方块掉落物
 * @author: Aye10032
 * @create: 2025-01-01 17:38
 **/

public class StealBlockLootTables extends BlockLootSubProvider {
    public StealBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(StealBlocks.CEMENT.get());
        this.dropSelf(StealBlocks.CONCRETE.get());
        this.dropSelf(StealBlocks.WHITE_CONCRETE.get());
        this.dropSelf(StealBlocks.LIGHT_GRAY_CONCRETE.get());
        this.dropSelf(StealBlocks.GRAY_CONCRETE.get());
        this.dropSelf(StealBlocks.REBAR_CONCRETE.get());
        this.dropSelf(StealBlocks.CINDER_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return StealBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
