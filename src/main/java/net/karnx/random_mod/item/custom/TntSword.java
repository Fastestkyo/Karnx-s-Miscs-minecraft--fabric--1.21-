package net.karnx.random_mod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class TntSword extends SwordItem {
    public TntSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().createExplosion(null, target.getX(), target.getY(), target.getZ(), 3f, World.ExplosionSourceType.TNT);
        return super.postHit(stack, target, attacker);
    }
}
