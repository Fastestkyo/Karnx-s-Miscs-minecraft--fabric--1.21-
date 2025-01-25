package net.karnx.random_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.karnx.random_mod.RandomMod;
import net.karnx.random_mod.block.ModBlocks;
import net.karnx.random_mod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOMAHAWK, 16)
                .pattern("CPR")
                .pattern("CFR")
                .pattern(" F ")
                .input('R', Items.POLISHED_ANDESITE)
                .input('C', Items.COPPER_INGOT)
                .input('F', Items.LIGHTNING_ROD)
                .input('P', Items.BREEZE_ROD)
                .criterion(hasItem(Items.POLISHED_ANDESITE), conditionsFromItem(Items.POLISHED_ANDESITE))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_BOOTS)
                .pattern("   ")
                .pattern("R R")
                .pattern("RBR")
                .input('R', Items.SLIME_BALL)
                .input('B',Items.LEATHER_BOOTS)
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_CHESTPLATE)
                .pattern("R R")
                .pattern("RBR")
                .pattern("RRR")
                .input('R', Items.SLIME_BALL)
                .input('B',Items.LEATHER_CHESTPLATE)
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_LEGGINGS)
                .pattern("RRR")
                .pattern("RBR")
                .pattern("R R")
                .input('R', Items.SLIME_BALL)
                .input('B',Items.LEATHER_LEGGINGS)
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_HELMET)
                .pattern("RBR")
                .pattern("R R")
                .pattern("   ")
                .input('R', Items.SLIME_BALL)
                .input('B',Items.LEATHER_HELMET)
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_BOW)
                .pattern("FDD")
                .pattern("SFD")
                .pattern("SSF")
                .input('S', Items.STRING)
                .input('D', Items.DIAMOND)
                .input('F', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CONFIDENT_SWORD)
                .pattern(" D ")
                .pattern("DFD")
                .pattern(" S ")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.BLACK_CARPET)
                .input('F', Items.BLAZE_ROD)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DAGGER)
                .pattern("S")
                .pattern("D")
                .input('S', Items.IRON_INGOT)
                .input('D', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ECLIPSE_SWORD)
                .pattern(" F ")
                .pattern("DFD")
                .pattern(" S ")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.BLAZE_POWDER)
                .input('F', Items.RABBIT_FOOT)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDER_SWORD)
                .pattern("D")
                .pattern("D")
                .pattern("S")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.ENDER_PEARL)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FROZEN_SWORD)
                .pattern(" D ")
                .pattern("DDD")
                .pattern(" S ")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.SNOWBALL)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GRAVITY_SWORD)
                .pattern("D")
                .pattern("F")
                .pattern("S")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.BLACK_CARPET)
                .input('F', Items.PURPLE_BANNER)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KATANA_SWORD)
                .pattern("  F")
                .pattern(" D ")
                .pattern("S  ")
                .input('S', Items.IRON_SWORD)
                .input('D', Items.IRON_INGOT)
                .input('F', Items.RAW_IRON)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUCKY_SWORD)
                .pattern("EDG")
                .pattern("LFJ")
                .pattern("RSR")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.GLISTERING_MELON_SLICE)
                .input('F', Items.FERMENTED_SPIDER_EYE)
                .input('E', Items.STRING)
                .input('G', Items.EGG)
                .input('L', Items.SUGAR)
                .input('J', Items.GUNPOWDER)
                .input('R', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MACHINE_GUN)
                .pattern("DFF")
                .pattern("DFF")
                .pattern("S  ")
                .input('S', Items.BOW)
                .input('D', Items.IRON_BLOCK)
                .input('F', Items.IRON_INGOT)
                .criterion(hasItem(Items.BOW), conditionsFromItem(Items.BOW))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGNET_SWORD)
                .pattern("DD")
                .pattern("DD")
                .pattern("S ")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.IRON_INGOT)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NECRO_SWORD)
                .pattern("FDF")
                .pattern(" D ")
                .pattern(" S ")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.WITHER_SKELETON_SKULL)
                .input('F', Items.BLACK_CANDLE)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PHEONIX_SWORD)
                .pattern("FFF")
                .pattern(" D ")
                .pattern(" S ")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.BLAZE_ROD)
                .input('F', Items.BLAZE_POWDER)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.QUICK_SWORD)
                .pattern("D")
                .pattern("D")
                .pattern("S")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.RABBIT_FOOT)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PHANTOM_SWORD)
                .pattern("D")
                .pattern("D")
                .pattern("S")
                .input('S', Items.DIAMOND_SWORD)
                .input('D', Items.PHANTOM_MEMBRANE)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHADOW_SWORD)
                .pattern("D")
                .pattern("R")
                .pattern("S")
                .input('S', Items.DIAMOND_SWORD)
                .input('R', Items.POLISHED_BLACKSTONE)
                .input('D', Items.BLACK_CANDLE)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOUL_SWORD)
                .pattern("PDP")
                .pattern("PDP")
                .pattern(" S ")
                .input('S', Items.DIAMOND_SWORD)
                .input('P', Items.SPIDER_EYE)
                .input('D', Items.ROTTEN_FLESH)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TNT_SWORD)
                .pattern("GTG")
                .pattern("GTG")
                .pattern(" S ")
                .input('T', Items.TNT).input('G', Items.GUNPOWDER)
                .input('S', Items.DIAMOND_SWORD)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VOLCANIC_SWORD)
                .pattern("GTG")
                .pattern("GTG")
                .pattern(" S ")
                .input('G', Items.MAGMA_CREAM).input('T', Items.MAGMA_BLOCK)
                .input('S', Items.DIAMOND_SWORD)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOD_SWORD)
                .pattern("T")
                .pattern("T")
                .pattern("T")
                .input('T', Items.NETHER_STAR)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter);


        offerSmithingTrimRecipe(exporter, ModItems.KARNX_SMITHING_TEMPLATE, Identifier.of(RandomMod.MOD_ID, "karnx"));





}}
