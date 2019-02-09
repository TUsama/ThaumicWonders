package com.verdantartifice.thaumicwonders.common.init;

import com.verdantartifice.thaumicwonders.ThaumicWonders;
import com.verdantartifice.thaumicwonders.common.blocks.BlocksTW;
import com.verdantartifice.thaumicwonders.common.crafting.recipes.RecipeDisjunctionClothUse;
import com.verdantartifice.thaumicwonders.common.items.ItemsTW;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.items.ItemsTC;

public class InitRecipes {
    public static void initRecipes(IForgeRegistry<IRecipe> forgeRegistry) {
        initNormalRecipes(forgeRegistry);
        initCrucibleRecipes();
        initInfusionRecipes();
    }
    
    private static void initNormalRecipes(IForgeRegistry<IRecipe> forgeRegistry) {
        forgeRegistry.register(new RecipeDisjunctionClothUse());
    }

    private static void initCrucibleRecipes() {
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ThaumicWonders.MODID, "hedge_soul_sand"), new CrucibleRecipe(
                "TWOND_NETHER_HEDGE",
                new ItemStack(Blocks.SOUL_SAND),
                new ItemStack(Blocks.SAND),
                new AspectList().add(Aspect.SOUL, 3).add(Aspect.EARTH, 3).add(Aspect.TRAP, 1)
        ));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ThaumicWonders.MODID, "hedge_ghast_tear"), new CrucibleRecipe(
                "TWOND_NETHER_HEDGE",
                new ItemStack(Items.GHAST_TEAR, 2),
                new ItemStack(Items.GHAST_TEAR),
                new AspectList().add(Aspect.SOUL, 10).add(Aspect.ALCHEMY, 10).add(Aspect.UNDEAD, 5)
        ));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ThaumicWonders.MODID, "hedge_wither_skull"), new CrucibleRecipe(
                "TWOND_NETHER_HEDGE",
                new ItemStack(Items.SKULL, 1, 1),
                new ItemStack(Items.SKULL, 1, 0),
                new AspectList().add(Aspect.UNDEAD, 10).add(Aspect.DEATH, 10).add(Aspect.SOUL, 10).add(Aspect.DARKNESS, 5)
        ));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ThaumicWonders.MODID, "hedge_end_stone"), new CrucibleRecipe(
                "TWOND_END_HEDGE",
                new ItemStack(Blocks.END_STONE),
                new ItemStack(Blocks.STONE),
                new AspectList().add(Aspect.EARTH, 5).add(Aspect.DARKNESS, 5)
        ));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ThaumicWonders.MODID, "hedge_chorus_fruit"), new CrucibleRecipe(
                "TWOND_END_HEDGE",
                new ItemStack(Items.CHORUS_FRUIT),
                new ItemStack(Items.APPLE),
                new AspectList().add(Aspect.ELDRITCH, 5).add(Aspect.SENSES, 5).add(Aspect.PLANT, 5)
        ));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ThaumicWonders.MODID, "hedge_ender_pearl"), new CrucibleRecipe(
                "TWOND_END_HEDGE",
                new ItemStack(Items.ENDER_PEARL, 2),
                new ItemStack(Items.ENDER_PEARL),
                new AspectList().add(Aspect.MOTION, 15).add(Aspect.ELDRITCH, 10)
        ));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ThaumicWonders.MODID, "disjunction_cloth"), new CrucibleRecipe(
                "TWOND_DISJUNCTION_CLOTH",
                new ItemStack(ItemsTW.DISJUNCTION_CLOTH),
                new ItemStack(ItemsTC.fabric),
                new AspectList().add(Aspect.MAGIC, 40).add(Aspect.VOID, 40).add(Aspect.AURA, 20)
        ));
    }
    
    private static void initInfusionRecipes() {
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(ThaumicWonders.MODID, "everburning_urn"), new InfusionRecipe(
                "TWOND_EVERBURNING_URN",
                new ItemStack(BlocksTW.EVERBURNING_URN),
                4,
                new AspectList().add(Aspect.FIRE, 40).add(Aspect.EARTH, 20).add(Aspect.ENERGY, 10).add(Aspect.CRAFT, 10),
                new ItemStack(BlocksTC.everfullUrn),
                new Object[] {
                        new ItemStack(Items.NETHERBRICK),
                        new ItemStack(Items.NETHERBRICK),
                        new ItemStack(Items.NETHERBRICK),
                        new ItemStack(Items.LAVA_BUCKET),
                        ThaumcraftApiHelper.makeCrystal(Aspect.FIRE),
                        new ItemStack(Blocks.OBSIDIAN)
                }
        ));
    }
}
