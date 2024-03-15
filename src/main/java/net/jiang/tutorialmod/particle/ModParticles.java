package net.jiang.tutorialmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.jiang.tutorialmod.TutorialMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType CITRINE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(TutorialMod.MOD_ID, "citrine_particle"),
                CITRINE_PARTICLE);
    }
}
