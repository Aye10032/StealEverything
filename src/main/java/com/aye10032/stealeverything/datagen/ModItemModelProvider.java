package com.aye10032.stealeverything.datagen;

import com.aye10032.stealeverything.StealEverything;
import com.aye10032.stealeverything.item.AllItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * @program: stealeverything
 * @description:
 * @author: Aye10032
 * @create: 2025-01-01 13:30
 **/

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StealEverything.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(AllItems.LIMESTONE_POWDER);
        simpleItem(AllItems.CREATIVE_TAB_TFMG);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StealEverything.MODID, "item/" + item.getId().getPath()));
    }
}
