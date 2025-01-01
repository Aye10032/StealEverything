package com.aye10032.stealeverything.datagen;

import com.aye10032.stealeverything.block.StealBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

/**
 * @program: stealeverything
 * @description: 凋落物
 * @author: Aye10032
 * @create: 2025-01-01 17:02
 **/

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput output){
        return new LootTableProvider(output, Set.of(),List.of(
                new LootTableProvider.SubProviderEntry(StealBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
