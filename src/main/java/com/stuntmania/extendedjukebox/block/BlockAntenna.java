package com.stuntmania.extendedjukebox.block;

import com.stuntmania.extendedjukebox.ExtendedJukebox;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockAntenna extends Block {

	private int[][] first = { { 0, -1, 0 }, { -1, -1, 0 }, { -1, -1, -1 }, { 0, -1, -1 }, { 1, -1, 0 }, { 1, -1, 1 }, { 0, -1, 1 }, { -1, -1, 1 }, { 1, -1, -1 } };
	
	public BlockAntenna() {
		super(Material.iron);
		this.setBlockTextureName(ExtendedJukebox.MODID + ":antenna");
	}
	
	public int getSize(World world, int x, int y, int z) {
		if (world.canBlockSeeTheSky(x, y, z)) {
			for (int i = 0; i < first.length; i++) {
				if (!world.getBlock(first[i][0] + x, first[i][1] + y - 1, first[i][2] + z).equals(Blocks.iron_block))
					return 1;
			}
			return 2;
		} else {
			return 0;
		}
	}
	
	
}
