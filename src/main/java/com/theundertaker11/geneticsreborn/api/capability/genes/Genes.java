package com.theundertaker11.geneticsreborn.api.capability.genes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.theundertaker11.geneticsreborn.util.ModUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Genes implements IGenes {

	public static final int TotalNumberOfGenes = EnumGenes.values().length;
	private List<EnumGenes> EnumGenesList = new ArrayList<>();

	@Override
	public void addGene(EnumGenes gene) {
		if (!EnumGenesList.contains(gene) && gene != null)
			EnumGenesList.add(gene);
	}

	@Override
	public void removeGene(EnumGenes gene) {
		if (EnumGenesList.contains(gene))
			EnumGenesList.remove(gene);
	}

	@Override
	public boolean hasGene(EnumGenes gene) {
		return EnumGenesList.contains(gene);
	}

	@Override
	public List<EnumGenes> getGeneList() {
		return this.EnumGenesList;
	}

	@Override
	public void setGeneList(List<EnumGenes> list) {
		this.EnumGenesList = list;
	}

	@Override
	public void removeAllGenes() {
		this.EnumGenesList = new ArrayList<>();
	}

	@Override
	public void addAllGenes() {
		this.EnumGenesList = new ArrayList<>(Arrays.asList(EnumGenes.values()));
	}

	@Override
	public int getGeneNumber() {
		return this.EnumGenesList.size();
	}

	public static EnumGenes getGeneFromString(String nbtstring) {
		if ("Null".equals(nbtstring))
			return null;
		ArrayList<EnumGenes> allGenes = new ArrayList<>(Arrays.asList(EnumGenes.values()));
		for (int i = 0; i < allGenes.size(); i++) {
			String genename = allGenes.get(i).toString();
			if (nbtstring.equals("GeneticsReborn" + genename)) {
				return allGenes.get(i);
			}
		}
		return null;
	}

	public static ItemStack setNBTStringsFromGenes(ItemStack stack, EntityLivingBase entityLiving) {
		if (ModUtils.getIGenes(entityLiving) == null)
			return stack;
		NBTTagCompound tag = ModUtils.getTagCompound(stack);
		IGenes genes = ModUtils.getIGenes(entityLiving);
		List<EnumGenes> genelist = genes.getGeneList();
		for (int i = 0; i < genes.getGeneNumber(); i++) {
			String genename = genelist.get(i).toString();
			tag.setString(Integer.toString(i), "GeneticsReborn" + genename);
		}
		return stack;
	}
}
