package net.karnx.random_mod.potion;

import net.karnx.random_mod.RandomMod;
import net.karnx.random_mod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));
    public static final RegistryEntry<Potion> FROZEN_POTION = registerPotion("frozen_potion",
            new Potion(new StatusEffectInstance(ModEffects.FROZEN, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(RandomMod.MOD_ID, name), potion);
    }


    public static void registerPotions() {
        RandomMod.LOGGER.info("Registering Potions For " + RandomMod.MOD_ID);
    }
}
