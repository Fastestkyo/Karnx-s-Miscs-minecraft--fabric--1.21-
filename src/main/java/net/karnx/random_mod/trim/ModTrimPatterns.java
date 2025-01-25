package net.karnx.random_mod.trim;

import net.karnx.random_mod.RandomMod;
import net.karnx.random_mod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> KARNX = RegistryKey.of(RegistryKeys.TRIM_PATTERN, Identifier.of(RandomMod.MOD_ID, "karnx"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context){
        register(context, ModItems.KARNX_SMITHING_TEMPLATE, KARNX);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(item),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);
        context.register(key, trimPattern);
    }

}
