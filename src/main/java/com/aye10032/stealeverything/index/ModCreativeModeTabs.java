package com.aye10032.stealeverything.index;

import com.aye10032.stealeverything.StealEverything;
import com.simibubi.create.AllCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @program: stealeverything
 * @description: 创造模式物品栏
 * @author: Aye10032
 * @create: 2025-01-01 02:30
 **/

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StealEverything.MODID);

//    public static final RegistryObject<CreativeModeTab> STEAL_TAB = CREATIVE_MODE_TABS.register(
//            "steal_tab",
//            () -> CreativeModeTab.builder()
//                    .icon(() -> new ItemStack(StealItems.CREATIVE_TAB_TFMG.get()))
//                    .title(Component.translatable("creativetab.steal_tab"))
//                    .displayItems((pParameters, pOutput) -> {
//                        pOutput.accept(StealItems.LIMESTONE_POWDER.get());
//
//                        pOutput.accept(StealBlocks.CEMENT.get());
//                        pOutput.accept(StealBlocks.CONCRETE.get());
//                        pOutput.accept(StealBlocks.WHITE_CONCRETE.get());
//                        pOutput.accept(StealBlocks.LIGHT_GRAY_CONCRETE.get());
//                        pOutput.accept(StealBlocks.GRAY_CONCRETE.get());
//                        pOutput.accept(StealBlocks.REBAR_CONCRETE.get());
//                        pOutput.accept(StealBlocks.CINDER_BLOCK.get());
//                    })
//                    .build()
//    );
    public static final RegistryObject<CreativeModeTab> MAIN_TAB = TAB_REGISTER.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.steal_tab"))
                    .icon(() -> new ItemStack(SItems.CREATIVE_TAB_TFMG.get()))
                    .displayItems(new RegistrateDisplayItemsGenerator())
                    .build());

    public static void register(IEventBus bus) {
        TAB_REGISTER.register(bus);
    }

    public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        private List<Item> collectBlocks(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();
            for (RegistryEntry<Block> entry : StealEverything.REGISTRATE.getAll(Registries.BLOCK)) {
                if (!StealEverything.REGISTRATE.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get().asItem();
                if (item == Items.AIR)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
            return items;
        }

        private List<Item> collectItems(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();


            for (RegistryEntry<Item> entry : StealEverything.REGISTRATE.getAll(Registries.ITEM)) {
                if (!StealEverything.REGISTRATE.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            return items;
        }

        private static void outputAll(CreativeModeTab.Output output, List<Item> items) {
            for (Item item : items) {
                output.accept(item);
            }
        }

        List<Item> exclude = List.of(SItems.CREATIVE_TAB_TFMG.get());


        @Override
        public void accept(CreativeModeTab.@NotNull ItemDisplayParameters params, CreativeModeTab.@NotNull Output output) {
            List<Item> items = new LinkedList<>();
            items.addAll(collectBlocks(MAIN_TAB, (item) -> {
//                if (item == CABlocks.DIGITAL_ADAPTER.asItem()) return !StealEverything.CC_ACTIVE;
                return false;
            }));
            items.addAll(collectItems(MAIN_TAB, (item) -> exclude.contains(item)));

            outputAll(output, items);
        }

    }
}
