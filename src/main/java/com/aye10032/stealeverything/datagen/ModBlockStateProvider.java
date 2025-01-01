package com.aye10032.stealeverything.datagen;

import com.aye10032.stealeverything.StealEverything;
import com.aye10032.stealeverything.block.AllBlocks;
import net.minecraft.data.PackOutput;
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
        blockWithItem(AllBlocks.CEMENT);
        blockWithItem(AllBlocks.CONCRETE);
        blockWithItem(AllBlocks.WHITE_CONCRETE);
        blockWithItem(AllBlocks.LIGHT_GRAY_CONCRETE);
        blockWithItem(AllBlocks.GRAY_CONCRETE);
        blockWithItem(AllBlocks.REBAR_CONCRETE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
