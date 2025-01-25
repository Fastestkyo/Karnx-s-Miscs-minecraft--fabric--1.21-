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

        offerSmithingTrimRecipe(exporter, ModItems.KARNX_SMITHING_TEMPLATE, Identifier.of(RandomMod.MOD_ID, "karnx"));





}}
