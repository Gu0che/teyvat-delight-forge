package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.harvest.HarvestDrops;
import com.guoche.teyvatdelight.api.harvest.HarvestContext.Method;

import com.guoche.teyvatdelight.BlazingJinxinFlowerBlock;
import com.guoche.teyvatdelight.JinxinFlowerBehavior;
import com.guoche.teyvatdelight.TeyvatDelight;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ThirstingJinxinFlowerBlock extends BushBlock {
    private static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    public ThirstingJinxinFlowerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
@Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return JinxinFlowerBehavior.canGrowOn(state);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stack = player.getItemInHand(hand);
        int burnTime = JinxinFlowerBehavior.getFuelBurnTime(stack);
        if (burnTime <= 0) {
            return super.use(state, level, pos, player, hand, hitResult);
        }

        if (!level.isClientSide) {
            int growthSteps = JinxinFlowerBehavior.getFuelGrowthSteps(burnTime);
            JinxinFlowerBehavior.consumeFuel(player, hand, stack);
            JinxinFlowerBehavior.playFuelSound(level, pos);
            TeyvatCropDropTracker.skipNextDrop(level, pos);

            if (growthSteps >= BlazingJinxinFlowerBlock.MAX_AGE) {
                level.setBlock(pos, TeyvatDelight.BURNT_OUT_JINXIN_FLOWER.get().defaultBlockState(), 2);
                JinxinFlowerBehavior.playBurntOutSound(level, pos);
            } else {
                level.setBlock(pos, TeyvatDelight.BLAZING_JINXIN_FLOWER.get()
                        .defaultBlockState()
                        .setValue(BlazingJinxinFlowerBlock.AGE, growthSteps), 2);
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(TeyvatDelight.JINXIN_FLOWER_BUD.get());
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            TeyvatCropDropTracker.skipNextDrop(level, pos);
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void playerDestroy(
            Level level,
            Player player,
            BlockPos pos,
            BlockState state,
            @Nullable BlockEntity blockEntity,
            ItemStack tool
    ) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        TeyvatCropDropTracker.consumeSkipDrop(level, pos);
        if (!level.isClientSide && !player.isCreative()) {
            HarvestDrops.create(level, pos, state, player, tool, Method.BREAK)
                    .base(TeyvatDelight.JINXIN_FLOWER_BUD.get(), 1).drop();
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide
                && state.getBlock() != newState.getBlock()
                && !TeyvatCropDropTracker.consumeSkipDrop(level, pos)) {
            HarvestDrops.create(level, pos, state, null, ItemStack.EMPTY, Method.BREAK)
                    .base(TeyvatDelight.JINXIN_FLOWER_BUD.get(), 1).drop();
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }
}


