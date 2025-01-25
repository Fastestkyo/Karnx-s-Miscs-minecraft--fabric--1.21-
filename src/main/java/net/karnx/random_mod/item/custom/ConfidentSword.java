package net.karnx.random_mod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;

public class ConfidentSword extends SwordItem {
    public ConfidentSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof LivingEntity user && target instanceof  LivingEntity entity) {
            kb(user, entity);
            dash(user, entity);
        }
        return super.postHit(stack, target, attacker);
    }
    private void kb(LivingEntity user, LivingEntity target) {
        float kb = 0.5f;
        target.takeKnockback(kb, user.getX() - target.getX(), user.getZ() - target.getZ());
    }
    private void dash(LivingEntity user, LivingEntity target) {
        Vec3d dir = target.getPos().subtract(user.getPos()).normalize();
        double dspeed = 1.5;
        Vec3d dvel = dir.multiply(dspeed);
        user.setVelocity(user.getVelocity().add(dvel));
        user.velocityModified = true;
    }
}
