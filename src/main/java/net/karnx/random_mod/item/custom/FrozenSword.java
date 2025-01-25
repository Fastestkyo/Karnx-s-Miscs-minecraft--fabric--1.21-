package net.karnx.random_mod.item.custom;

import net.karnx.random_mod.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class FrozenSword extends SwordItem {
    public FrozenSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target!=null && target.isAlive()) {
            target.addStatusEffect(new StatusEffectInstance(ModEffects.FROZEN, 100, 0));
        }
        return super.postHit(stack, target, attacker);
    }
}
