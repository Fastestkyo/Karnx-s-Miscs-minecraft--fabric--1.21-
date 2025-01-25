package com.example.myswordmod.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class LuckySword extends SwordItem {

    private static final Random RANDOM = new Random();

    public LuckySword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {
            triggerRandomEffect(player, (ServerWorld) player.getWorld(), target);
        }
        return super.postHit(stack, target, attacker);
    }

    private void triggerRandomEffect(PlayerEntity player, ServerWorld world, LivingEntity target) {
        int effect = RANDOM.nextInt(6);
        switch (effect) {
            case 0 -> healcase(player);
            case 1 -> dmgcase(player);
            case 2 -> dropcase(world, player);
            case 3 -> spawncase(world, target.getPos());
            case 4 -> speedcase(player);
            case 5 -> explocase(target);
        }
    }
    private void healcase(PlayerEntity player) {
        player.setHealth(Math.min(player.getMaxHealth(), player.getHealth() + 6.0f));
        player.sendMessage(Text.literal("You feel rejuvenated!"), true);
        player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
    }

    private void dmgcase(PlayerEntity player) {
        player.damage(player.getDamageSources().magic(), 4.0f);
        player.sendMessage(Text.literal("Ouch! The sword backfired!"), true);
        player.playSound(SoundEvents.ENTITY_GENERIC_HURT, 1.0f, 1.0f);
    }

    private void dropcase(ServerWorld world, PlayerEntity player) {
        ItemStack droppedItem = new ItemStack(Items.DIAMOND, RANDOM.nextInt(3) + 1);
        player.dropItem(droppedItem, true);
        player.sendMessage(Text.literal("The sword blessed you with riches!"), true);
    }

    private void spawncase(ServerWorld world, Vec3d position) {
        EntityType<?>[] entities = {EntityType.ZOMBIE, EntityType.CREEPER, EntityType.SKELETON};
        EntityType<?> randomEntity = entities[RANDOM.nextInt(entities.length)];

        var entity = randomEntity.create(world);
        if (entity != null) {
            entity.refreshPositionAndAngles(position.x, position.y, position.z, 0.0F, 0.0F);
            world.spawnEntity(entity);
        }
    }






    private void speedcase(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1));
        player.sendMessage(Text.literal("You feel lighter on your feet!"), true);
    }

    private void explocase(LivingEntity target) {
        World world = target.getWorld();
        if (!world.isClient) {
            world.createExplosion(null, target.getX(), target.getY(), target.getZ(), 3.0f, World.ExplosionSourceType.TNT);
        }
    }
}
