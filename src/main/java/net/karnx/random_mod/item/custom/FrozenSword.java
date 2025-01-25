package net.karnx.random_mod.item.custom;

import net.karnx.random_mod.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

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

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§bbrrrrrrrrrr"));

        super.appendTooltip(stack, context, tooltip, type);
    }
}
