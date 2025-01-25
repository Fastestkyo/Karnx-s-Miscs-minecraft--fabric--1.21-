package net.karnx.random_mod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShadowSword extends SwordItem {
    private static final int COOLDOWN_TICKS = 30;
    private static final float DAMAGE = 6.0F;

    public ShadowSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            Vec3d direction = user.getRotationVector().normalize();
            Vec3d start = user.getPos();
            Vec3d end = start.add(direction.multiply(5.0));
            Box dashBox = new Box(start, end).expand(1.0); // Widen the path slightly
            world.getOtherEntities(user, dashBox).forEach(entity -> {
                if (entity instanceof LivingEntity livingEntity) {

                    livingEntity.damage(livingEntity.getDamageSources().generic(), DAMAGE);
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
}
