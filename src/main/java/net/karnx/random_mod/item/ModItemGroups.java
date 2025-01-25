package net.karnx.random_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.karnx.random_mod.RandomMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup KARNX_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RandomMod.MOD_ID, "karnx_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.DIAMOND))
                    .displayName(Text.translatable("itemgroup.random-mod.karnx_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.TOMAHAWK);
                        entries.add(ModItems.FROZEN_SWORD);
                        entries.add(ModItems.CONFIDENT_SWORD);
                        entries.add(ModItems.NECRO_SWORD);
                        entries.add(ModItems.SOUL_SWORD);
                        entries.add(ModItems.VOLCANIC_SWORD);
                        entries.add(ModItems.ENDER_SWORD);
                        entries.add(ModItems.KATANA_SWORD);
                        entries.add(ModItems.SHADOW_SWORD);
                        entries.add(ModItems.PHANTOM_SWORD);
                        entries.add(ModItems.MAGNET_SWORD);
                        entries.add(ModItems.GRAVITY_SWORD);
                        entries.add(ModItems.ECLIPSE_SWORD);
                        entries.add(ModItems.PHEONIX_SWORD);
                        entries.add(ModItems.QUICK_SWORD);
                        entries.add(ModItems.LUCKY_SWORD);
                        entries.add(ModItems.DAGGER);
                        entries.add(ModItems.TNT_SWORD);
                        entries.add(ModItems.MACHINE_GUN);
                        entries.add(ModItems.GOD_SWORD);





                        entries.add(ModItems.SLIME_HELMET);
                        entries.add(ModItems.SLIME_CHESTPLATE);
                        entries.add(ModItems.SLIME_LEGGINGS);
                        entries.add(ModItems.SLIME_BOOTS);



                        entries.add(ModItems.DIAMOND_BOW);
                        entries.add(ModItems.KARNX_SMITHING_TEMPLATE);
                        entries.add(ModItems.BAR_BRAWL_MUSIC_DISC);



                        entries.add(ModItems.MANTIS_SPAWN_EGG);

                    }).build());
    public static void registerModItemGroups() {
        RandomMod.LOGGER.info("Registering Mod Item Groups for " + RandomMod.MOD_ID);
    }
}
