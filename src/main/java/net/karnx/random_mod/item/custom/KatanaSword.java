package net.karnx.random_mod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class KatanaSword extends SwordItem {
    public KatanaSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    private int combo = 0;
    private long lasthit = 0;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        long time = world.getTime();
        if (time - lasthit > 60) {
            combo = 0;
        }
        if (combo < 3) {
            combo++;
        }
        lasthit = time;
        applyCombo(user);
        return super.use(world, user, hand);
    }
    private void applyCombo(PlayerEntity user) {
        switch (combo) {
            case 1:
                break;
            case 2:
                user.getMainHandStack().setDamage(user.getMainHandStack().getDamage() -5);
                break;
            case 3:
                user.getMainHandStack().setDamage(user.getMainHandStack().getDamage() -6);
                break;
            default:
                combo = 0;
                break;
        }
    }
}
