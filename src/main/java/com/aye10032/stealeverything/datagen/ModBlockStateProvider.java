package com.aye10032.stealeverything.datagen;

import com.aye10032.stealeverything.StealEverything;
import com.aye10032.stealeverything.block.StealBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * @program: stealeverything
 * @description:
 * @author: Aye10032
 * @create: 2025-01-01 13:29
 **/

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StealEverything.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(StealBlocks.CEMENT);
        blockWithItem(StealBlocks.CONCRETE);
        blockWithItem(StealBlocks.WHITE_CONCRETE);
        blockWithItem(StealBlocks.LIGHT_GRAY_CONCRETE);
        blockWithItem(StealBlocks.GRAY_CONCRETE);
        blockWithItem(StealBlocks.REBAR_CONCRETE);

        simpleBlockWithItem(
                StealBlocks.CINDER_BLOCK.get(),
                models().cubeBottomTop(
                        StealBlocks.CINDER_BLOCK.getId().getPath(),
                        ResourceLocation.tryBuild(StealEverything.MODID, "block/cinderblock"),
                        ResourceLocation.tryBuild(StealEverything.MODID, "block/cinderblock_top"),
                        ResourceLocation.tryBuild(StealEverything.MODID, "block/cinderblock_top")
                )
        );
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
