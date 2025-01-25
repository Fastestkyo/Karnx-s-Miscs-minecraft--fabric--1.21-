package net.karnx.random_mod.item.custom;

import net.minecraft.client.gui.screen.Screen;
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

public class EnderSword extends SwordItem {
    private long lastused = 0;
    public EnderSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return super.use(world, user, hand);
        long ticks = world.getTime();
        if (ticks - lastused < 60) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
        if (world instanceof ServerWorld) {
            throwEnderPearl(user, world);
        }
        lastused = ticks;
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private void throwEnderPearl(PlayerEntity player, World world) {
        net.minecraft.entity.projectile.thrown.EnderPearlEntity enderPearl = new net.minecraft.entity.projectile.thrown.EnderPearlEntity(world, player);
        Vec3d lookDirection = player.getRotationVector();
        enderPearl.setVelocity(lookDirection.x, lookDirection.y, lookDirection.z, 1.5f, 1.0f);  // Adjust speed and inaccuracy
        world.spawnEntity(enderPearl);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§2ENDERMANNNANANN §l§5Shift For More Info"));
        } else {
            tooltip.add(Text.literal("right click to throw a pearl!"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
