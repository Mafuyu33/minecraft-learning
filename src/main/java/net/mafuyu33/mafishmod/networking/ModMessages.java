package net.mafuyu33.mafishmod.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.mafuyu33.mafishmod.TutorialMod;
import net.mafuyu33.mafishmod.networking.packet.*;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier EXAMPLE_ID = new Identifier(TutorialMod.MOD_ID, "example");
    public static final Identifier Shield_Dash_ID = new Identifier(TutorialMod.MOD_ID, "shield_dash");
    public static final Identifier Bow_Dash_ID = new Identifier(TutorialMod.MOD_ID, "bow_dash");
    public static final Identifier PARTICLE_DATA_ID = new Identifier(TutorialMod.MOD_ID, "particle_data");

//    public static final Identifier Particle_Color_ID = new Identifier(TutorialMod.MOD_ID, "particle_color");
    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(Shield_Dash_ID, ShieldDashC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(Bow_Dash_ID, BowDashC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(PARTICLE_DATA_ID, ParticleDataC2SPacket::receive);
//        ServerPlayNetworking.registerGlobalReceiver(Particle_Color_ID, ParticleColorC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleS2CPacket::receive);
    }
}
