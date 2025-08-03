package com.aye10032.stealeverything.datagen.recipes;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program: stealeverything
 * @description:
 * @author: Aye10032
 * @create: 2025-08-03 00:42
 **/

@ParametersAreNonnullByDefault
public class StealRecipeProvider extends RecipeProvider {

    protected final List<GeneratedRecipe> all = new ArrayList<>();

    public StealRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        all.forEach(recipe -> recipe.register(pWriter));
    }

    protected GeneratedRecipe register(GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }


    @FunctionalInterface
    public interface GeneratedRecipe {
        void register(Consumer<FinishedRecipe> consumer);
    }

    public static class Marker {
    }

    public static class I {

        public static ItemLike clayBall() {
            return Items.CLAY_BALL;
        }
    }
}
