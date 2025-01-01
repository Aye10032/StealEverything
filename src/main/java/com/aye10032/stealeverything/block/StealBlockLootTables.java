package com.aye10032.stealeverything.block;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
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
        this.dropSelf(AllBlocks.CEMENT.get());
        this.dropSelf(AllBlocks.CONCRETE.get());
        this.dropSelf(AllBlocks.WHITE_CONCRETE.get());
        this.dropSelf(AllBlocks.LIGHT_GRAY_CONCRETE.get());
        this.dropSelf(AllBlocks.GRAY_CONCRETE.get());
        this.dropSelf(AllBlocks.REBAR_CONCRETE.get());
        this.dropSelf(AllBlocks.CINDER_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AllBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
