package com.stuntmania.extendedjukebox.networking;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class SyncMessage implements IMessage {
	
	public int toSend;
	public int x, y, z;
	
	public SyncMessage(int x, int y, int z, int toSend) {
		this.toSend = toSend;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		// Writes the int into the buf
		buf.writeInt(toSend);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
		toSend = buf.readInt();
	}
}
