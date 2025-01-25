package net.karnx.random_mod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class FrozenEffect extends StatusEffect {
    protected FrozenEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isOnGround()) {
            entity.setVelocity(entity.getVelocity().x, 0, entity.getVelocity().z);
        }
        if (entity instanceof PlayerEntity plr) {
            plr.setSprinting(false);
        }
        entity.velocityModified = true;
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
