package com.aye10032.stealeverything.datagen;

import com.aye10032.stealeverything.datagen.recipes.StealProcessingRecipeGen;
import com.aye10032.stealeverything.datagen.recipes.StealRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @program: stealeverything
 * @description: data generator
 * @author: Aye10032
 * @create: 2025-08-03 00:41
 **/

public class StealDataGen {
    protected static final List<StealRecipeProvider> RECIPE_GENERATORS = new ArrayList<>();

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        if (event.includeServer()) {
            generator.addProvider(true, new DataProvider() {

                @Override
                public String getName() {
                    return "Steal's Recipes";
                }

                @Override
                public CompletableFuture<?> run(CachedOutput dc) {
                    return CompletableFuture.allOf(RECIPE_GENERATORS.stream()
                            .map(gen -> gen.run(dc))
                            .toArray(CompletableFuture[]::new));
                }
            });

            StealProcessingRecipeGen.registerAll(generator, output);
        }

    }
}
