package net.karnx.random_mod.entity;

import net.karnx.random_mod.RandomMod;
import net.karnx.random_mod.entity.custom.MantisEntity;
import net.karnx.random_mod.entity.custom.TomahawkProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE, Identifier.of(RandomMod.MOD_ID, "mantis"), EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2.5f).build());

    public static final EntityType<TomahawkProjectileEntity> TOMAHAWK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RandomMod.MOD_ID,  "tomahawk"),
            EntityType.Builder.<TomahawkProjectileEntity>create(TomahawkProjectileEntity::new, SpawnGroup.MISC).dimensions(0.5f, 1.15f).build());

    public static void registerModEntities() {
        RandomMod.LOGGER.info("Registering Mod Entities For " + RandomMod.MOD_ID);
    }
}
