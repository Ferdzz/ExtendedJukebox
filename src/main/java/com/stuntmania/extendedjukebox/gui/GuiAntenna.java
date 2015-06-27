package com.stuntmania.extendedjukebox.gui;

import net.minecraft.client.gui.GuiScreen;

import org.lwjgl.input.Keyboard;

import com.stuntmania.extendedjukebox.networking.PacketHandler;
import com.stuntmania.extendedjukebox.networking.SyncMessage;
import com.stuntmania.extendedjukebox.tileentity.TEAntenna;

public class GuiAntenna extends GuiScreen {
	
	private TEAntenna te;
	private GuiNumericalTextField textField;
	
	public GuiAntenna(TEAntenna te) {
		this.te = te;
	}
	
	@Override
	public void initGui() {
		System.out.println("antenna");
		textField = new GuiNumericalTextField(fontRendererObj, 0, 0, 50, 25, GuiNumericalTextField.FILTER_NUMERIC);
		textField.setMaxStringLength(32767);
		textField.setFocused(true);
		textField.setText(te.id + "");
		Keyboard.enableRepeatEvents(true);	
	}
	
	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
		PacketHandler.INSTANCE.sendToServer(new SyncMessage(te.xCoord, te.yCoord, te.zCoord, Integer.parseInt(textField.getText())));
		te.id = Integer.parseInt(textField.getText());
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
}
