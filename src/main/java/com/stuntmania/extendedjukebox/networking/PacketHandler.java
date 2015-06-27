package com.stuntmania.extendedjukebox.networking;

import com.stuntmania.extendedjukebox.ExtendedJukebox;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ExtendedJukebox.MODID);
}
