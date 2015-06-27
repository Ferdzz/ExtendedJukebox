package com.stuntmania.extendedjukebox.networking;

import net.minecraft.client.Minecraft;

import com.stuntmania.extendedjukebox.tileentity.TEAntenna;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SyncMessageHandler implements IMessageHandler<SyncMessage, IMessage> {
	@Override
	public IMessage onMessage(SyncMessage message, MessageContext ctx) {
		if (ctx.side.isServer()) {
			((TEAntenna) ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z)).setId(message.id);
			PacketHandler.INSTANCE.sendToAll(message);
			return null;
		} else {
			((TEAntenna) Minecraft.getMinecraft().theWorld.getTileEntity(message.x, message.y, message.z)).setId(message.id);
			return null;
		}
	}
}
