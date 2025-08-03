package com.aye10032.stealeverything.datagen.recipes;

import com.aye10032.stealeverything.StealEverything;
import com.aye10032.stealeverything.datagen.recipes.values.StealMixingRecipeGen;
import net.minecraft.data.PackOutput;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.platform.CatnipServices;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @program: stealeverything
 * @description: recipegen
 * @author: Aye10032
 * @create: 2025-08-03 00:55
 **/

public abstract class StealProcessingRecipeGen extends StealRecipeProvider {

    protected static final List<StealProcessingRecipeGen> GENERATORS = new ArrayList<>();

    public static void registerAll(DataGenerator gen, PackOutput output) {

        GENERATORS.add(new StealMixingRecipeGen(output));


        gen.addProvider(true, new DataProvider() {

            @Override
            public String getName() {
                return "Steal's Processing Recipes";
            }

            @Override
            public CompletableFuture<?> run(CachedOutput dc) {
                return CompletableFuture.allOf(GENERATORS.stream()
                        .map(gen -> gen.run(dc))
                        .toArray(CompletableFuture[]::new));
            }
        });
    }


    public StealProcessingRecipeGen(PackOutput generator) {
        super(generator);
    }


    public <T extends ProcessingRecipe<?>> GeneratedRecipe create(
            String namespace,
            Supplier<ItemLike> singleIngredient,
            UnaryOperator<ProcessingRecipeBuilder<T>> transform
    ) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        GeneratedRecipe generatedRecipe = c -> {
            ItemLike itemLike = singleIngredient.get();
            transform
                    .apply(new ProcessingRecipeBuilder<>(serializer.getFactory(),
                            ResourceLocation.fromNamespaceAndPath(namespace, CatnipServices.REGISTRIES.getKeyOrThrow(itemLike.asItem())
                                    .getPath())).withItemIngredients(Ingredient.of(itemLike)))
                    .build(c);
        };
        all.add(generatedRecipe);
        return generatedRecipe;
    }


    public <T extends ProcessingRecipe<?>> GeneratedRecipe create(
            Supplier<ItemLike> singleIngredient,
            UnaryOperator<ProcessingRecipeBuilder<T>> transform
    ) {
        return create(StealEverything.MODID, singleIngredient, transform);
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe createWithDeferredId(
            Supplier<ResourceLocation> name,
            UnaryOperator<ProcessingRecipeBuilder<T>> transform
    ) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        GeneratedRecipe generatedRecipe = c ->
                transform.apply(new ProcessingRecipeBuilder<>(serializer.getFactory(), name.get()))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }


    public <T extends ProcessingRecipe<?>> GeneratedRecipe create(
            ResourceLocation name,
            UnaryOperator<ProcessingRecipeBuilder<T>> transform
    ) {
        return createWithDeferredId(() -> name, transform);
    }


    public <T extends ProcessingRecipe<?>> GeneratedRecipe create(
            String name,
            UnaryOperator<ProcessingRecipeBuilder<T>> transform
    ) {
        return create(StealEverything.asResource(name), transform);
    }

    protected abstract IRecipeTypeInfo getRecipeType();

    protected <T extends ProcessingRecipe<?>> ProcessingRecipeSerializer<T> getSerializer() {
        return getRecipeType().getSerializer();
    }
}
