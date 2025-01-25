package net.karnx.random_mod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MagnetSword extends SwordItem {
    public MagnetSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            pull(world, user);
            push(world, user);
            user.getItemCooldownManager().set(this, 100);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
    private void pull(World world, PlayerEntity user) {
        Box area = new Box(user.getBlockPos()).expand(5.0);
        world.getEntitiesByClass(Entity.class, area, entity -> entity instanceof ItemEntity).forEach(entity -> {
            Vec3d direction = new Vec3d(user.getX() - entity.getX(), user.getY() - entity.getY(), user.getZ() - entity.getZ());
            entity.setVelocity(direction.normalize().multiply(0.7));
        });
    }
    private void push(World world, PlayerEntity user) {
        Box area = new Box(user.getBlockPos()).expand(5.0);
        world.getEntitiesByClass(Entity.class, area, entity -> entity instanceof MobEntity).forEach(entity -> {
            Vec3d direction = new Vec3d(entity.getX() - user.getX(), entity.getY() - user.getY(), entity.getZ() - user.getZ());
            entity.setVelocity(direction.normalize().multiply(1.5));
        });
    }
}
