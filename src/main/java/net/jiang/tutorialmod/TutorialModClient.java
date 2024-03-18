package net.jiang.tutorialmod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jiang.tutorialmod.block.ModBlocks;
import net.jiang.tutorialmod.entity.ModEntities;
//import net.jiang.tutorialmod.util.ModModelPredicateProvider;
import net.jiang.tutorialmod.event.AttackKeyCheckHandler;
import net.jiang.tutorialmod.event.ChatMessageHandler;
import net.jiang.tutorialmod.event.KeyInputHandler;
import net.jiang.tutorialmod.networking.ModMessages;
import net.jiang.tutorialmod.particle.ModParticles;
import net.jiang.tutorialmod.particle.ParticleStorage;
import net.jiang.tutorialmod.particle.custom.CitrineParticle;
import net.jiang.tutorialmod.screen.GemPolishingScreen;
import net.jiang.tutorialmod.screen.ModScreenHandlers;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.world.ClientWorld;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.TNT_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.STONE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FU_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FIREWORK_ARROW, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DIAMOND_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LIGHTNING_PROJECTILE, FlyingItemEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTATO_TNT_PREPARE, RenderLayer.getCutout());

        KeyInputHandler.register();
        ChatMessageHandler.register();
        AttackKeyCheckHandler.registerAttackKeyListener();

        HandledScreens.register(ModScreenHandlers.GEM_POLISHING_SCREEN_HANDLER, GemPolishingScreen::new);
        ModMessages.registerS2CPackets();

        ParticleFactoryRegistry.getInstance().register(ModParticles.CITRINE_PARTICLE, CitrineParticle.Factory::new);
//        ModModelPredicateProvider.registerModModels();

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {//客户端已经成功连接到服务器
                // 调用您的方法
                ParticleStorage.spawnAllParticles(MinecraftClient.getInstance().world);
                System.out.println("哈哈哈哈哈");

        });
    }
}
