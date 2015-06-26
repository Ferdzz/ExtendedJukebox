package com.stuntmania.extendedjukebox.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import com.stuntmania.extendedjukebox.tileentity.TEAntenna;

public class ContainerAntenna extends Container{
	protected TEAntenna tileEntity;
	
	public ContainerAntenna(TEAntenna te) {
		this.tileEntity = te;
	}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileEntity.isUseableByPlayer(player);
	}
}
