package com.theundertaker11.geneticsreborn.blocks;

import com.theundertaker11.geneticsreborn.blocks.bloodpurifier.BloodPurifier;
import com.theundertaker11.geneticsreborn.blocks.cellanalyser.CellAnalyser;
import com.theundertaker11.geneticsreborn.blocks.cloningmachine.CloningMachine;
import com.theundertaker11.geneticsreborn.blocks.coalgenerator.CoalGenerator;
import com.theundertaker11.geneticsreborn.blocks.dnadecrypter.DNADecrypter;
import com.theundertaker11.geneticsreborn.blocks.dnaextractor.DNAExtractor;
import com.theundertaker11.geneticsreborn.blocks.plasmidinfuser.PlasmidInfuser;
import com.theundertaker11.geneticsreborn.blocks.plasmidinjector.PlasmidInjector;
import com.theundertaker11.geneticsreborn.render.IItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GRBlocks {
	public static Block CellAnalyser;
	public static Block DNAExtractor;
	public static Block DNADecrypter;
	public static Block PlasmidInfuser;
	public static Block BloodPurifier;
	public static Block PlasmidInjector;
	public static Block CloningMachine;
	public static Block AntiFieldBlock;
	//public static Block CoalGenerator;
	public static void init() 
	{
		CellAnalyser = register(new CellAnalyser("CellAnalyser"));
		DNAExtractor = register(new DNAExtractor("DNAExtractor"));
		DNADecrypter = register(new DNADecrypter("DNADecrypter"));
		PlasmidInfuser = register(new PlasmidInfuser("PlasmidInfuser"));
		BloodPurifier = register(new BloodPurifier("BloodPurifier"));
		PlasmidInjector = register(new PlasmidInjector("PlasmidInjector"));
		CloningMachine = register(new CloningMachine("CloningMachine"));
		AntiFieldBlock = register(new BlockBase("AntiFieldBlock"));
		//CoalGenerator = register(new CoalGenerator("CoalGenerator"));
	}
	private static <T extends Block> T register (T block, ItemBlock itemBlock)
	{
		 GameRegistry.register(block);
		 if(itemBlock != null)
		 {
		 GameRegistry.register(itemBlock);
		 }
		 
		 if(block instanceof IItemModelProvider)
		 {
		 ((IItemModelProvider)block).registerItemModel(itemBlock);
		 }
		 
		 return block;
	}
		 
	private static <T extends Block> T register(T block)
	{
		 ItemBlock itemBlock = new ItemBlock(block);
		 itemBlock.setRegistryName(block.getRegistryName());
		 return register(block, itemBlock);
	}
}
