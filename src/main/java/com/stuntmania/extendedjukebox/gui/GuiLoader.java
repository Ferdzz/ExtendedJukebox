package com.stuntmania.extendedjukebox.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiFlatPresets;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import com.stuntmania.extendedjukebox.tileentity.TEDish;

public class GuiLoader extends GuiContainer {
	
	public GuiLoader(InventoryPlayer inventoryPlayer, TEDish tileEntity) {
		super(new ContainerLoader(inventoryPlayer, tileEntity));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
	//	fontRendererObj.drawStringWithShadow("OMG LELEL", 10, 10, 10);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	@Override
	public void initGui() {
		super.initGui();
	//	buttonList.add(new GuiButton(0, 100, 10, "hello"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0:
			//do stuff
			break;
		}
	}
}
