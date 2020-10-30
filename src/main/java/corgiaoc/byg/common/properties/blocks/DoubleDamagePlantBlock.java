package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import net.minecraft.block.AbstractBlock.Properties;

public class DoubleDamagePlantBlock extends DoublePlantBlock {

    protected DoubleDamagePlantBlock(Properties builder) {
        super(builder);

    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.PIGLIN && entityIn.getType() != EntityType.MAGMA_CUBE && entityIn.getType() != EntityType.ZOMBIFIED_PIGLIN && entityIn.getType() != EntityType.GHAST) {
            entityIn.setMotionMultiplier(state, new Vector3d(0.8F, 0.75D, 0.8F));
            double d0 = Math.abs(entityIn.getPosX() - entityIn.lastTickPosX);
            double d1 = Math.abs(entityIn.getPosZ() - entityIn.lastTickPosZ);
            if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
            }
        }

    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }


}
