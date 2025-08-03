package com.aye10032.stealeverything.datagen.recipes.values;

import com.aye10032.stealeverything.datagen.recipes.StealProcessingRecipeGen;
import com.aye10032.stealeverything.registries.SBlocks;
import com.aye10032.stealeverything.registries.SItems;
import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import static com.aye10032.stealeverything.datagen.recipes.StealRecipeProvider.I.*;

/**
 * @program: stealeverything
 * @description: create mixin recipes
 * @author: Aye10032
 * @create: 2025-08-03 00:59
 **/

public class StealMixingRecipeGen extends StealProcessingRecipeGen {
    GeneratedRecipe CEMENT = create("cement", b -> b
            .require(clayBall())
            .require(SItems.LIMESTONE_POWDER)
            .output(SBlocks.CEMENT, 2)
    );
    GeneratedRecipe CONCRETE = create("concrete", b -> b
            .require(SBlocks.CEMENT)
            .require(SBlocks.CEMENT)
            .require(sand())
            .require(sand())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(water(), 1000)
            .output(SBlocks.CONCRETE, 8)
    );
    GeneratedRecipe WHITE_CONCRETE = create("white_concrete", b -> b
            .require(SBlocks.CEMENT)
            .require(SBlocks.CEMENT)
            .require(sand())
            .require(sand())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(whiteDye())
            .require(water(), 1000)
            .output(SBlocks.WHITE_CONCRETE, 8)
    );
    GeneratedRecipe GRAY_CONCRETE = create("gray_concrete", b -> b
            .require(SBlocks.CEMENT)
            .require(SBlocks.CEMENT)
            .require(sand())
            .require(sand())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(grayDye())
            .require(water(), 1000)
            .output(SBlocks.GRAY_CONCRETE, 8)
    );
    GeneratedRecipe LIGHT_GRAY_CONCRETE = create("light_gray_concrete", b -> b
            .require(SBlocks.CEMENT)
            .require(SBlocks.CEMENT)
            .require(sand())
            .require(sand())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(lightGrayDye())
            .require(water(), 1000)
            .output(SBlocks.LIGHT_GRAY_CONCRETE, 8)
    );
    GeneratedRecipe REBAR_CONCRETE = create("rebar_concrete", b -> b
            .require(SBlocks.CEMENT)
            .require(SBlocks.CEMENT)
            .require(sand())
            .require(sand())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(gravel())
            .require(ironBars())
            .require(water(), 1000)
            .output(SBlocks.REBAR_CONCRETE, 8)
    );

    public StealMixingRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}