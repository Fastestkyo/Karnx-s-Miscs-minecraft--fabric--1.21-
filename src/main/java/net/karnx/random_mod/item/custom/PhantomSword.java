package net.karnx.random_mod.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class PhantomSword extends SwordItem {
    public PhantomSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    private long lastused = 0;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return super.use(world, user, hand);
        long ticks = world.getTime();
        if (ticks - lastused < 100) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
        if (world instanceof ServerWorld) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 300, 1));
        }
        lastused = ticks;
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§l*screeeech*"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}

