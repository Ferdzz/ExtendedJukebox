package com.stuntmania.extendedjukebox.gui;

import com.stuntmania.extendedjukebox.tileentity.TELoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0) {
			return new ContainerLoader(player.inventory, (TELoader)world.getTileEntity(x, y, z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0) {
			return new GuiLoader(player.inventory, (TELoader)world.getTileEntity(x, y, z));
		}
		return null;
	}
	
}
