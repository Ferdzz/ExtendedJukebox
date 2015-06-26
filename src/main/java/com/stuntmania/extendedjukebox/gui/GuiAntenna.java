package com.stuntmania.extendedjukebox.gui;

import org.lwjgl.input.Keyboard;

import com.stuntmania.extendedjukebox.tileentity.TEAntenna;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiAntenna extends GuiContainer {
	
	private TEAntenna te;
	private GuiNumericalTextField textField;
	
	public GuiAntenna(TEAntenna te) {
		super(new ContainerAntenna(te));
		this.te = te;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		textField = new GuiNumericalTextField(fontRendererObj, 0, 0, 50, 25, GuiNumericalTextField.FILTER_NUMERIC);
		textField.setMaxStringLength(32767);
		textField.setFocused(true);
		textField.setText(te.id + "");
		Keyboard.enableRepeatEvents(true);	
	}
	
	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
		te.id = Integer.parseInt(textField.getText());
		super.onGuiClosed();
	}
	
	public void updateScreen() {
		textField.updateCursorCounter();
	}
	
	protected void keyTyped(char c, int key) {
		if(key == 1) {
//			if(textField.isFocused())
//				textField.setFocused(false);
//			else
				this.mc.thePlayer.closeScreen();
		} else 
			textField.textboxKeyTyped(c, key);
	}
	
	@Override
	protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
        super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
		textField.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
		textField.drawTextBox();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		
	}
}
