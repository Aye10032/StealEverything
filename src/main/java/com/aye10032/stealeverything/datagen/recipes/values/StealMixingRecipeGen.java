package com.aye10032.stealeverything.datagen.recipes.values;

import com.aye10032.stealeverything.datagen.recipes.StealProcessingRecipeGen;
import com.aye10032.stealeverything.registries.SBlocks;
import com.aye10032.stealeverything.registries.SItems;
import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.PackOutput;

import static com.aye10032.stealeverything.datagen.recipes.StealRecipeProvider.I.*;

/**
 * @program: stealeverything
 * @description: create mixin recipes
 * @author: Aye10032
 * @create: 2025-08-03 00:59
 **/

public class StealMixingRecipeGen extends StealProcessingRecipeGen {
    GeneratedRecipe
            CEMENT = create("cement", b -> b
            .require(clayBall())
            .require(SItems.LIMESTONE_POWDER)
            .output(SBlocks.CEMENT, 2)
    );

    public StealMixingRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}