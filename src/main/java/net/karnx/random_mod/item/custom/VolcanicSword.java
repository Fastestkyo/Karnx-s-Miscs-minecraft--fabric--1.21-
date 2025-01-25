package net.karnx.random_mod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class VolcanicSword extends SwordItem {
    private long lastused = 0; // Time in ticks when the sword was last used

    public VolcanicSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return super.use(world, user, hand);
        long ticks = world.getTime();
        if (ticks - lastused < 20) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
        if (world instanceof ServerWorld) {
            fball(world, user);
        }
        lastused = ticks;
        return TypedActionResult.success(user.getStackInHand(hand));
    }
    private void fball(World world, PlayerEntity user) {
        Vec3d lookDirection = user.getRotationVector();
        Vec3d fireballVelocity = new Vec3d(lookDirection.x, lookDirection.y, lookDirection.z);

        FireballEntity fireball = new FireballEntity(world, user, fireballVelocity, 1); // 1 is the explosion power
        fireball.setPos(user.getX() + fireballVelocity.x * 2, user.getY() + user.getHeight() * 0.5, user.getZ() + fireballVelocity.z * 2);

        world.spawnEntity(fireball);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("IVE PLAYED THESE GAMES BEFORE!! §9Shift for info"));
        } else {
            tooltip.add(Text.literal("right-click to shoot fireball"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
