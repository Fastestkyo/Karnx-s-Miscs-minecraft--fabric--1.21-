package net.karnx.random_mod.effect;

import net.karnx.random_mod.RandomMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(RandomMod.MOD_ID, "slimey"), -0.25f,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> FROZEN = registerStatusEffect("frozen",
            new FrozenEffect(StatusEffectCategory.HARMFUL, 0xADD8E6).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of(RandomMod.MOD_ID, "frozen"), -0.25f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(RandomMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        RandomMod.LOGGER.info("Registering Effects For " + RandomMod.MOD_ID);
    }
}
