package net.karnx.random_mod.compenent;

import com.mojang.serialization.Codec;
import net.karnx.random_mod.RandomMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", builder ->  builder.codec(BlockPos.CODEC));


    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperater){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(RandomMod.MOD_ID, name),
                builderOperater.apply(ComponentType.builder()).build());


    }


    public static void registerDataComponentTypes(){
        RandomMod.LOGGER.info("Registering Data Component Types For " + RandomMod.MOD_ID);

    }
}
