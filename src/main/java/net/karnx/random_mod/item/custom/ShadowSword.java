package net.karnx.random_mod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ShadowSword extends SwordItem {
    public ShadowSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            Vec3d direction = user.getRotationVector().normalize();
            Vec3d start = user.getPos();
            Vec3d end = start.add(direction.multiply(5.0));
            Box dashBox = new Box(start, end).expand(1.0);
            world.getOtherEntities(user, dashBox).forEach(entity -> {
                if (entity instanceof LivingEntity livingEntity) {
                    livingEntity.damage(livingEntity.getDamageSources().generic(), 8f);
                }
            });
            user.requestTeleport(end.x, end.y, end.z);
            for (double i = 0; i < 5.0; i += 0.5) {
                Vec3d particlePos = start.add(direction.multiply(i));
                world.addParticle(ParticleTypes.SMOKE, particlePos.x, particlePos.y, particlePos.z, 0, 0, 0);
            }
            user.getItemCooldownManager().set(this, 30);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("i see u §4Shift for more info"));
        } else {
            tooltip.add(Text.literal("right-click to dash and damage enemies"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
