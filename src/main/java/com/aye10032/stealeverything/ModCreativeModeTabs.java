package com.aye10032.stealeverything;

import com.aye10032.stealeverything.block.AllBlocks;
import com.aye10032.stealeverything.item.AllItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * @program: stealeverything
 * @description: 创造模式物品栏
 * @author: Aye10032
 * @create: 2025-01-01 02:30
 **/

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StealEverything.MODID);

    public static final RegistryObject<CreativeModeTab> STEAL_TAB = CREATIVE_MODE_TABS.register(
            "steal_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(AllItems.LIMESTONE_POWDER.get()))
                    .title(Component.translatable("creativetab.steal_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(AllItems.LIMESTONE_POWDER.get());

                        pOutput.accept(AllBlocks.CEMENT.get());
                        pOutput.accept(AllBlocks.CONCRETE.get());
                        pOutput.accept(AllBlocks.WHITE_CONCRETE.get());
                        pOutput.accept(AllBlocks.LIGHT_GRAY_CONCRETE.get());
                        pOutput.accept(AllBlocks.GRAY_CONCRETE.get());
                        pOutput.accept(AllBlocks.REBAR_CONCRETE.get());
                        pOutput.accept(AllBlocks.CINDER_BLOCK.get());
                    })
                    .build()
    );

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
