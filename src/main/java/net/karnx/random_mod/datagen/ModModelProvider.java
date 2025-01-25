package net.karnx.random_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.karnx.random_mod.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.FROZEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CONFIDENT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NECRO_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOUL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VOLCANIC_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KATANA_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADOW_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PHANTOM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAVITY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECLIPSE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PHEONIX_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.QUICK_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUCKY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TNT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MACHINE_GUN, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOD_SWORD, Models.HANDHELD);


        itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIME_HELMET);
            itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIME_CHESTPLATE);
            itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIME_BOOTS);
            itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIME_LEGGINGS);


        itemModelGenerator.register(ModItems.KARNX_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.MANTIS_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

    }
}
