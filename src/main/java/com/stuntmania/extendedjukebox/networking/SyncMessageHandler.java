package com.stuntmania.extendedjukebox.networking;

import com.stuntmania.extendedjukebox.tileentity.TEAntenna;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SyncMessageHandler implements IMessageHandler<SyncMessage, IMessage> {
	public SyncMessageHandler() {}
	@Override
	public IMessage onMessage(SyncMessage message, MessageContext ctx) {
		((TEAntenna)ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z)).id = message.id;
		return null;
	}
	
}
