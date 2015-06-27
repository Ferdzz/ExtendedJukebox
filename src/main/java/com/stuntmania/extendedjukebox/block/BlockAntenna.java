package com.stuntmania.extendedjukebox.block;

import com.stuntmania.extendedjukebox.ExtendedJukebox;
import com.stuntmania.extendedjukebox.tileentity.TEAntenna;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAntenna extends BlockContainer {

	private int[][] first = { { 0, -1, 0 }, { -1, -1, 0 }, { -1, -1, -1 }, { 0, -1, -1 }, { 1, -1, 0 }, { 1, -1, 1 }, { 0, -1, 1 }, { -1, -1, 1 }, { 1, -1, -1 } };
	
	public BlockAntenna() {
		super(Material.wood);
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
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!world.isRemote)
			player.openGui(ExtendedJukebox.instance, 1, world, x, y, z);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TEAntenna();
	}
}
