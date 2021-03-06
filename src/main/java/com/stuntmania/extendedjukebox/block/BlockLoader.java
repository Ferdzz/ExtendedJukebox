package com.stuntmania.extendedjukebox.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.stuntmania.extendedjukebox.ExtendedJukebox;
import com.stuntmania.extendedjukebox.tileentity.TELoader;

public class BlockLoader extends BlockContainer {
	
	private IIcon[] icons;
	
	public BlockLoader() {
		super(Material.iron);
		icons = new IIcon[4];
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TELoader();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		// if (player.getCurrentEquippedItem() != null)
		// ((TELoader) world.getTileEntity(x, y, z)).id = Item.getIdFromItem(player.getCurrentEquippedItem().getItem());
		if(!world.isRemote)
			player.openGui(ExtendedJukebox.MODID, 0, world, x, y, z);
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
		int facing = MathHelper.floor_double((double) ((entityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null) {
			switch (facing) {
			case 0:
				world.setBlockMetadataWithNotify(x, y, z, 2, 1 | 2);
				break;
			
			case 1:
				world.setBlockMetadataWithNotify(x, y, z, 5, 1 | 2);
				break;
			
			case 2:
				world.setBlockMetadataWithNotify(x, y, z, 3, 1 | 2);
				break;
			
			case 3:
				world.setBlockMetadataWithNotify(x, y, z, 4, 1 | 2);
				break;
			}
			world.markBlockForUpdate(x, y, z);
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		icons[0] = reg.registerIcon(ExtendedJukebox.MODID + ":loader_bottom");
		icons[1] = reg.registerIcon(ExtendedJukebox.MODID + ":loader_top");
		icons[2] = reg.registerIcon(ExtendedJukebox.MODID + ":loader_front");
		icons[3] = reg.registerIcon(ExtendedJukebox.MODID + ":loader_side");
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		if (ForgeDirection.getOrientation(side).equals(ForgeDirection.DOWN))
			return icons[0];
		else if (ForgeDirection.getOrientation(side).equals(ForgeDirection.UP))
			return icons[1];
		else {
			if (side == meta)
				return icons[2];
			return icons[3];
		}
	}
}
