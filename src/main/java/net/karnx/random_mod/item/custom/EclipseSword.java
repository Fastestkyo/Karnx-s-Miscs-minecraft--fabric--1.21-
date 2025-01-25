package net.karnx.random_mod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class EclipseSword extends SwordItem {
    public EclipseSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();

        if (!world.isClient) {
            if (world instanceof ServerWorld serverWorld) {
                boolean isDay = serverWorld.isDay();

                if (isDay) {
                    target.setOnFireFor(100);
                } else if (serverWorld.isNight()) {
                    attacker.heal(stack.getDamage() * 0.5f);
                }

            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§6sun §7and §8moon?"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
