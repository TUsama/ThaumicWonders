package com.verdantartifice.thaumicwonders.common.blocks.devices;

import java.util.Random;

import com.verdantartifice.thaumicwonders.common.blocks.BlocksTW;
import com.verdantartifice.thaumicwonders.common.blocks.base.BlockDeviceTW;
import com.verdantartifice.thaumicwonders.common.tiles.devices.TileCoalescenceMatrix;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockCoalescenceMatrix extends BlockDeviceTW<TileCoalescenceMatrix> {
    public static final PropertyInteger CHARGE = PropertyInteger.create("charge", 0, 10);
    
    public BlockCoalescenceMatrix() {
        super(Material.IRON, TileCoalescenceMatrix.class, "coalescence_matrix");
        this.setSoundType(SoundType.METAL);
        this.setCreativeTab(null);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CHARGE, Integer.valueOf(0)));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { CHARGE });
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(CHARGE, Integer.valueOf(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(CHARGE).intValue();
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlocksTW.COALESCENCE_MATRIX_PRECURSOR);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return false;
    }
}
