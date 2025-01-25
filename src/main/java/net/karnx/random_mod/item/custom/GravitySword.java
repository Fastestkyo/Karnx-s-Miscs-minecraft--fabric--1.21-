package net.karnx.random_mod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class GravitySword extends SwordItem {
    private static final double EFFECT_RADIUS = 5.0;
    private static final int COOLDOWN_TICKS = 200;

    public GravitySword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            Vec3d center = user.getPos();
            List<Entity> entities = serverWorld.getOtherEntities(user,
                    new Box(center.subtract(EFFECT_RADIUS, EFFECT_RADIUS, EFFECT_RADIUS),
                            center.add(EFFECT_RADIUS, EFFECT_RADIUS, EFFECT_RADIUS)),
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
            user.getItemCooldownManager().set(this, COOLDOWN_TICKS);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
