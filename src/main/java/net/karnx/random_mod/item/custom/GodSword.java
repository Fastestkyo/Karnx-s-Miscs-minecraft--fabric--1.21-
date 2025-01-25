package net.karnx.random_mod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Random;

public class GodSword extends SwordItem {
    public GodSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (tryOneShot(target)) {
            target.setHealth(0.0F);
            return true;
        }
        return super.postHit(stack, target, attacker);
    }
    private boolean tryOneShot(LivingEntity entity) {
        Random random = new Random();
        return random.nextFloat() < 0.06f;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§8rumour has it that this sword has 5% to §l§4insta-kill!"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
