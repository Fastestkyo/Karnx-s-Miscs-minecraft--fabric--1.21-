package net.karnx.random_mod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class GravitySword extends SwordItem {
    public GravitySword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            Vec3d center = user.getPos();
            List<Entity> entities = serverWorld.getOtherEntities(user,
                    new Box(center.subtract(5f, 5f, 5f),
                            center.add(5f, 5f, 5f)),
                    entity -> entity instanceof LivingEntity);

            for (Entity entity : entities) {
                if (entity instanceof LivingEntity livingEntity) {
                    livingEntity.addVelocity(0, 1.5, 0);
                    livingEntity.velocityModified = true;
                    serverWorld.spawnParticles(ParticleTypes.CLOUD,
                            livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                            10, 0.5, 0.5, 0.5, 0.1);
                }
            }
            user.getItemCooldownManager().set(this, 200);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§5right-click to make monsters fly!"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
