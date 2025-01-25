package net.karnx.random_mod.item.custom;

import net.karnx.random_mod.entity.custom.FriendlyZombieEntity;
import net.karnx.random_mod.entity.custom.FriendlySkeletonEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NecroSword extends SwordItem {
    public NecroSword(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld serverWorld) {
            if (Math.random() < 0.5) {
                FriendlyZombieEntity zombie = new FriendlyZombieEntity(EntityType.ZOMBIE, serverWorld, user);
                zombie.refreshPositionAndAngles(user.getX(), user.getY(), user.getZ(), 0.0F, 0.0F);
                zombie.setPersistent();
                serverWorld.spawnEntity(zombie);
            } else {
                FriendlySkeletonEntity skeleton = new FriendlySkeletonEntity(EntityType.SKELETON, serverWorld, user);
                skeleton.refreshPositionAndAngles(user.getX(), user.getY(), user.getZ(), 0.0F, 0.0F);
                skeleton.setPersistent();
                serverWorld.spawnEntity(skeleton);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }
}
