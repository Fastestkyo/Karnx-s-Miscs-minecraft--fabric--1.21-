package net.karnx.random_mod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SoulSword extends SwordItem {
    public SoulSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof  PlayerEntity player) {
            float dmg = stack.getDamage();
            float heal = dmg * 0.40f;
            player.heal(heal);
            int exp = (int) (dmg * 0.5);
            player.addExperience(exp);
        }

        return super.postHit(stack, target, attacker);
    }
}
