package com.stuntmania.extendedjukebox.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.input.Keyboard;

import com.stuntmania.extendedjukebox.tileentity.TELoader;

public class GuiLoader extends GuiContainer {
	
	private GuiNumericalTextField commandTextField;
	private TELoader te;
	
	public GuiLoader(InventoryPlayer inventoryPlayer, TELoader tileEntity) {
		super(new ContainerLoader(inventoryPlayer, tileEntity));
		this.te = tileEntity;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		this.commandTextField = new GuiNumericalTextField(this.fontRendererObj, this.width / 2 - 150, 50, 300, 20, GuiNumericalTextField.FILTER_NUMERIC);
		this.commandTextField.setMaxStringLength(32767);
		this.commandTextField.setFocused(true);
		this.commandTextField.setText("HELLO I AM HERE");
		Keyboard.enableRepeatEvents(true);	
	}
	
	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
		super.onGuiClosed();
	}
	
	public void updateScreen() {
		this.commandTextField.updateCursorCounter();
	}
	
	protected void keyTyped(char c, int key) {
		if(key == 1) {
			if(commandTextField.isFocused())
				commandTextField.setFocused(false);
			else
				this.mc.thePlayer.closeScreen();
		} else 
			this.commandTextField.textboxKeyTyped(c, key);
	}
	
	@Override
	protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
        super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
		this.commandTextField.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
		this.commandTextField.drawTextBox();
	}
}
