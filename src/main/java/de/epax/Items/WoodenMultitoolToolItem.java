package de.epax.Items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;

public class WoodenMultitoolToolItem extends Item {

    public WoodenMultitoolToolItem(Item.Settings settings) {
        super(settings);
    }


    public boolean isEffectiveOn(BlockState state) {
        return state.isIn(BlockTags.PICKAXE_MINEABLE) || state.isIn(BlockTags.AXE_MINEABLE) || state.isIn(BlockTags.SHOVEL_MINEABLE);
    }


    public float getAttackDamage() {
        return 4.0F;
    }


    public float getAttackSpeed() {
        return -2.4F;
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (player == null) {
            return ActionResult.PASS;
        }
        if (this.isEffectiveOn(world.getBlockState(pos))) {
            return super.useOnBlock(context);
        }

        return ActionResult.PASS;
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem() == items.WOODEN_MULTI_TOOL;
    }

    public ActionResult use(ItemUsageContext context) {
        return ActionResult.SUCCESS;
    }
}
