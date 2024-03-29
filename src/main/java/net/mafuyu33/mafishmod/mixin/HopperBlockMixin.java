package net.mafuyu33.mafishmod.mixin;

import net.mafuyu33.mafishmod.mixinhelper.BlockEnchantmentHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.HopperBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(HopperBlock.class)
public abstract class HopperBlockMixin {
	@Inject(at = @At("HEAD"), method = "onPlaced")
	private void init(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack, CallbackInfo ci) {
		if (!world.isClient) {
			System.out.println(itemStack.getEnchantments());
			if (!Objects.equals(itemStack.getEnchantments(), new NbtList())) {
//				System.out.println("添加");
				NbtList enchantments = itemStack.getEnchantments(); // 获取物品栈上的附魔信息列表
				BlockEnchantmentHelper.storeEnchantment(pos,enchantments);// 将附魔信息列表存储
			}
		}
	}
}