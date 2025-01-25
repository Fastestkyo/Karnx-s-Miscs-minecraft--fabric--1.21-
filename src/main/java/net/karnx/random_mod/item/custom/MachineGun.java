package net.karnx.random_mod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class MachineGun extends Item {

    public MachineGun(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (hand == Hand.MAIN_HAND && !user.isSneaking()) {
            return shootArrow(stack, user, world);
        }
        return TypedActionResult.pass(stack);
    }

    private TypedActionResult<ItemStack> shootArrow(ItemStack stack, PlayerEntity user, World world) {
        ItemStack arrowStack = findArrowInInventory(user);
        if (!arrowStack.isEmpty()) {
            if (!world.isClient) {
                ArrowEntity arrow = new ArrowEntity(EntityType.ARROW, world);
                arrow.setOwner(user);
                Vec3d velocity = user.getRotationVector().multiply(3.0F);
                arrow.setVelocity(velocity);
                arrow.updatePosition(user.getX(), user.getY() + user.getEyeHeight(user.getPose()), user.getZ());
                world.spawnEntity(arrow);
                arrowStack.decrement(1);
                return TypedActionResult.success(stack);
            }
        }
        return TypedActionResult.fail(stack);
    }
    private ItemStack findArrowInInventory(PlayerEntity user) {
        for (ItemStack stack : user.getInventory().main) {
            if (stack.getItem() == Items.ARROW) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }


}
