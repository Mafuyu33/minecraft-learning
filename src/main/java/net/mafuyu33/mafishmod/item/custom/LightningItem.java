package net.mafuyu33.mafishmod.item.custom;

import net.mafuyu33.mafishmod.entity.FuProjectileEntity;
import net.mafuyu33.mafishmod.entity.LightningProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class LightningItem extends SwordItem {


    public LightningItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            LightningProjectileEntity lightningProjectileEntity = new LightningProjectileEntity(user, world);
            lightningProjectileEntity.setItem(itemStack);
            lightningProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
            world.spawnEntity(lightningProjectileEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
//        if (!user.getAbilities().creativeMode) {
//            itemStack.decrement(1);
//        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
