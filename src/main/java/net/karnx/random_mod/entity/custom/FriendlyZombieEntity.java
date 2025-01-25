package net.karnx.random_mod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class FriendlyZombieEntity extends ZombieEntity {

    private final PlayerEntity summoner;

    public FriendlyZombieEntity(EntityType<? extends ZombieEntity> entityType, World world, PlayerEntity summoner) {
        super(entityType, world);
        this.summoner = summoner;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.summoner != null) {
            LivingEntity target = this.summoner.getAttacking(); // Get the entity the player is attacking

            if (target != null && target.isAlive()) {
                this.setTarget(target);  // Make the zombie attack the same target as the player
            }
        }
    }

    @Override
    public boolean canTarget(LivingEntity target) {
        // Prevent the zombie from targeting the summoner (player)
        if (target.equals(this.summoner)) {
            return false;
        }
        return super.canTarget(target);
    }
}
