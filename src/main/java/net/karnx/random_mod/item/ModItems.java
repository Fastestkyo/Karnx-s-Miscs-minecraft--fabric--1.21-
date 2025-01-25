package net.karnx.random_mod.item;

import com.example.myswordmod.items.LuckySword;

import net.karnx.random_mod.RandomMod;
import net.karnx.random_mod.entity.ModEntities;
import net.karnx.random_mod.item.custom.*;
import net.karnx.random_mod.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RandomMod.MOD_ID, name), item);
    }

    public static final Item FROZEN_SWORD = registerItem("frozen_sword",
            new FrozenSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item CONFIDENT_SWORD = registerItem("confident_sword",
            new ConfidentSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item NECRO_SWORD = registerItem("necro_sword",
            new NecroSword(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4f))));
    public static final Item SOUL_SWORD = registerItem("soul_sword",
            new SoulSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item VOLCANIC_SWORD = registerItem("volcanic_sword",
            new VolcanicSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item ENDER_SWORD = registerItem("ender_sword",
            new EnderSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item KATANA_SWORD = registerItem("katana_sword",
            new KatanaSword(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4f))));
    public static final Item SHADOW_SWORD = registerItem("shadow_sword",
            new ShadowSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item PHANTOM_SWORD = registerItem("phantom_sword",
            new PhantomSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item MAGNET_SWORD = registerItem("magnet_sword",
            new MagnetSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item GRAVITY_SWORD = registerItem("gravity_sword",
            new GravitySword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item ECLIPSE_SWORD = registerItem("eclipse_sword",
            new EclipseSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item PHEONIX_SWORD = registerItem("pheonix_sword",
            new PheonixSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item QUICK_SWORD = registerItem("quick_sword",
            new QuickSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item LUCKY_SWORD = registerItem("lucky_sword",
            new LuckySword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item DAGGER = registerItem("dagger",
            new Dagger(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4f))));
    public static final Item TNT_SWORD = registerItem("tnt_sword",
            new TntSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item MACHINE_GUN = registerItem("machine_gun",
            new MachineGun(new Item.Settings().maxDamage(500)));




    public static final Item SLIME_BOOTS = registerItem("slime_boots",
            new ModArmorItem(ModArmorMaterials.SLIME_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                   .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(1))));

    public static final Item SLIME_HELMET = registerItem("slime_helmet",
            new ModArmorItem(ModArmorMaterials.SLIME_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(1))));

    public static final Item SLIME_CHESTPLATE = registerItem("slime_chestplate",
            new ModArmorItem(ModArmorMaterials.SLIME_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(1))));

    public static final Item SLIME_LEGGINGS = registerItem("slime_leggings",
            new ModArmorItem(ModArmorMaterials.SLIME_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(1))));


    public static final Item KARNX_SMITHING_TEMPLATE = registerItem("karnx_smithing_template",
            SmithingTemplateItem.of(Identifier.of(RandomMod.MOD_ID, "karnx"), FeatureFlags.VANILLA));

    public static final Item DIAMOND_BOW = registerItem("diamond_bow",
            new BowItem(new Item.Settings().maxDamage(384)){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.random-mod.diamond_bow.tooltip"));
                }
            });

    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).maxCount(1)){
        @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.random-mod.bar_brawl_music_disc.tooltip"));
                }
            });

    public static final Item TOMAHAWK = registerItem("tomahawk",
            new TomahawkItem(new Item.Settings().maxCount(16)) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if(Screen.hasShiftDown()) {
                    tooltip.add(Text.translatable("tooltip.random-mod.tomahawk.tooltip.shift_down"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.random-mod.tomahawk.tooltip"));
                    }
                }
            });

    public static final Item MANTIS_SPAWN_EGG = registerItem("mantis_spawn_egg", new SpawnEggItem(ModEntities.MANTIS, 0x9dc783, 0xbfaf5f, new Item.Settings()));

    public static void registerModItems() {
        RandomMod.LOGGER.info("Registering Mod Items for " + RandomMod.MOD_ID);

    }
}