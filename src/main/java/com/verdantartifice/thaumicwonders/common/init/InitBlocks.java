package com.verdantartifice.thaumicwonders.common.init;

import java.util.HashSet;
import java.util.Set;

import com.verdantartifice.thaumicwonders.ThaumicWonders;
import com.verdantartifice.thaumicwonders.common.blocks.devices.BlockDimensionalRipper;
import com.verdantartifice.thaumicwonders.common.blocks.devices.BlockEverburningUrn;
import com.verdantartifice.thaumicwonders.common.blocks.essentia.BlockCreativeEssentiaJar;
import com.verdantartifice.thaumicwonders.common.blocks.essentia.ItemBlockCreativeEssentiaJar;
import com.verdantartifice.thaumicwonders.common.tiles.devices.TileDimensionalRipper;
import com.verdantartifice.thaumicwonders.common.tiles.devices.TileEverburningUrn;
import com.verdantartifice.thaumicwonders.common.tiles.essentia.TileCreativeEssentiaJar;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class InitBlocks {
    public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<ItemBlock>();
    
    public static void initBlocks(IForgeRegistry<Block> forgeRegistry) {
        registerBlock(forgeRegistry, new BlockEverburningUrn());
        registerBlock(forgeRegistry, new BlockDimensionalRipper());
        registerBlock(forgeRegistry, new BlockCreativeEssentiaJar(), ItemBlockCreativeEssentiaJar.class);
    }
    
    private static void registerBlock(IForgeRegistry<Block> forgeRegistry, Block block) {
        forgeRegistry.register(block);
        InitBlocks.ITEM_BLOCKS.add(new ItemBlock(block));
    }
    
    private static <T extends ItemBlock> void registerBlock(IForgeRegistry<Block> forgeRegistry, Block block, Class<T> clazz) {
        forgeRegistry.register(block);
        try {
            ItemBlock itemBlock = (ItemBlock)clazz.getConstructors()[0].newInstance(new Object[] { block });
            InitBlocks.ITEM_BLOCKS.add(itemBlock);
        } catch (Exception e) {
            ThaumicWonders.LOGGER.catching(e);
        }
    }
    
    public static void initItemBlocks(IForgeRegistry<Item> forgeRegistry) {
        for (ItemBlock itemBlock : InitBlocks.ITEM_BLOCKS) {
            Block block = itemBlock.getBlock();
            itemBlock.setRegistryName(block.getRegistryName());
            forgeRegistry.register(itemBlock);
        }
    }
    
    public static void initTileEntities() {
        GameRegistry.registerTileEntity(TileEverburningUrn.class, new ResourceLocation(ThaumicWonders.MODID, "TileEverburningUrn"));
        GameRegistry.registerTileEntity(TileDimensionalRipper.class, new ResourceLocation(ThaumicWonders.MODID, "TileDimensionalRipper"));
        GameRegistry.registerTileEntity(TileCreativeEssentiaJar.class, new ResourceLocation(ThaumicWonders.MODID, "TileCreativeEssentiaJar"));
    }
}
