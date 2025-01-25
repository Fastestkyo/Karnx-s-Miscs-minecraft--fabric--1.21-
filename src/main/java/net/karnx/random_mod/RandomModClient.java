package net.karnx.random_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.karnx.random_mod.block.ModBlocks;

import net.karnx.random_mod.entity.ModEntities;
import net.karnx.random_mod.entity.client.MantisModel;
import net.karnx.random_mod.entity.client.MantisRenderer;
import net.karnx.random_mod.entity.client.TomahawkProjectileModel;
import net.karnx.random_mod.entity.client.TomahawkProjectileRenderer;
import net.karnx.random_mod.util.ModModelPredicates;
import net.minecraft.client.render.RenderLayer;

public class RandomModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);
    }
}