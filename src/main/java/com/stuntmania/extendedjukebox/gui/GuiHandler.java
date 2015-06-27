package com.stuntmania.extendedjukebox.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.stuntmania.extendedjukebox.tileentity.TEAntenna;
import com.stuntmania.extendedjukebox.tileentity.TELoader;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	/*
	 * 0 -> Disc Loader 
	 * 1 -> Antenna 
	 * 2 -> Radio
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			return new ContainerLoader(player.inventory, (TELoader) world.getTileEntity(x, y, z));
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			return new GuiLoader(player.inventory, (TELoader) world.getTileEntity(x, y, z));
		case 1:
			return new GuiAntenna((TEAntenna) world.getTileEntity(x, y, z));
		default:
			return null;
		}
	}
	
}
