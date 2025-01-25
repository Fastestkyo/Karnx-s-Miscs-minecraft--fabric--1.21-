package net.karnx.random_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.karnx.random_mod.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.SWORDS)

                .add(ModItems.CONFIDENT_SWORD)
                .add(ModItems.FROZEN_SWORD)
                .add(ModItems.VOLCANIC_SWORD)
                .add(ModItems.NECRO_SWORD)
                .add(ModItems.SOUL_SWORD)
                .add(ModItems.ENDER_SWORD)
                .add(ModItems.KATANA_SWORD)
                .add(ModItems.TNT_SWORD).add(ModItems.DAGGER).add(ModItems.ECLIPSE_SWORD).add(ModItems.GRAVITY_SWORD).add(ModItems.LUCKY_SWORD).add(ModItems.MACHINE_GUN).add(ModItems.MAGNET_SWORD).add(ModItems.PHANTOM_SWORD).add(ModItems.PHEONIX_SWORD).add(ModItems.QUICK_SWORD)
                .add(ModItems.SHADOW_SWORD).add(ModItems.TOMAHAWK);




        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.KARNX_SMITHING_TEMPLATE);




    }
}
