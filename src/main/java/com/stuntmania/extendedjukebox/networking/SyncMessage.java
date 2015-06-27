package com.stuntmania.extendedjukebox.networking;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class SyncMessage implements IMessage {
	public int id;
	public int x, y, z;
	
	public SyncMessage(){}
	
	public SyncMessage(int x, int y, int z, int id) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readInt();
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
	}
}
