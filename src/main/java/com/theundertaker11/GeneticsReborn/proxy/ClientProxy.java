package com.theundertaker11.geneticsreborn.proxy;

import com.theundertaker11.geneticsreborn.Reference;
import com.theundertaker11.geneticsreborn.items.GRItems;
import com.theundertaker11.geneticsreborn.render.RenderRegistry;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MODID + ":" + id, "inventory"));
	}
	@Override
	public void registerRenders()
	{
		RenderRegistry.Render();
		
		ResourceLocation GlassSyringeTextures = new ResourceLocation(Reference.MODID + ":" + "GlassSyringeFull");
		ResourceLocation MetalSyringeTextures = new ResourceLocation(Reference.MODID + ":" + "MetalSyringeFull");
		
		ModelBakery.registerItemVariants(GRItems.GlassSyringe, GlassSyringeTextures);
		ModelBakery.registerItemVariants(GRItems.MetalSyringe, MetalSyringeTextures);
	}

}
