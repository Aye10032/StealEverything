package com.aye10032.stealeverything.datagen;

import com.aye10032.stealeverything.StealEverything;
import com.aye10032.stealeverything.block.StealBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * @program: stealeverything
 * @description: 标签
 * @author: Aye10032
 * @create: 2025-01-01 17:05
 **/

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(output, lookupProvider, StealEverything.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                StealBlocks.CONCRETE.get(),
                StealBlocks.WHITE_CONCRETE.get(),
                StealBlocks.GRAY_CONCRETE.get(),
                StealBlocks.LIGHT_GRAY_CONCRETE.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                StealBlocks.REBAR_CONCRETE.get()
        );
    }
}
