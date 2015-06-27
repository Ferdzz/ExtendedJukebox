package com.stuntmania.extendedjukebox;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import com.stuntmania.extendedjukebox.block.BlockAntenna;
import com.stuntmania.extendedjukebox.block.BlockLoader;
import com.stuntmania.extendedjukebox.gui.GuiHandler;
import com.stuntmania.extendedjukebox.networking.PacketHandler;
import com.stuntmania.extendedjukebox.networking.SyncMessage;
import com.stuntmania.extendedjukebox.networking.SyncMessageHandler;
import com.stuntmania.extendedjukebox.proxy.CommonProxy;
import com.stuntmania.extendedjukebox.tileentity.TEAntenna;
import com.stuntmania.extendedjukebox.tileentity.TELoader;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = ExtendedJukebox.MODID, version = ExtendedJukebox.VERSION)
public class ExtendedJukebox {
	@SidedProxy(clientSide = "com.stuntmania.extendedjukebox.proxy.ClientProxy", serverSide = "com.stuntmania.extendedjukebox.proxy.CommonProxy")
	public static CommonProxy proxy;
	@Instance
	public static ExtendedJukebox instance;
	public static final String MODID = "extendedjukebox";
	public static final String VERSION = "0.1";
	
	public static Block loader;
	public static Block antenna;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("Started loading " + MODID + " version " + VERSION);
		
		loader = new BlockLoader().setBlockName("blockLoader").setCreativeTab(CreativeTabs.tabAllSearch);
		antenna = new BlockAntenna().setBlockName("blockAntenna").setCreativeTab(CreativeTabs.tabAllSearch);
		GameRegistry.registerBlock(loader, "blockLoader");
		GameRegistry.registerBlock(antenna, "blockAntenna");
		GameRegistry.registerTileEntity(TELoader.class, "blockDish");
		GameRegistry.registerTileEntity(TEAntenna.class, "blockAntenna");
		
		proxy.registerRenderers();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		PacketHandler.INSTANCE.registerMessage(SyncMessageHandler.class, SyncMessage.class, 0, Side.SERVER);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("Loaded " + MODID + " version " + VERSION + " correctly");
	}
	
	/*
	 * So with resource packs and mods adding new types of music discs and such into the game, the old minecraft jukebox is in need of some improvements. With a range of 16 blocks (having the audio sill strong) its not that convenient. So my idea is this, two blocks added, the signal dish and the music controller, the dish is a single block, must be in sunlight, and have at least 4 sides uncovered. however the more iron blocks you place in the area extends the range, the higher up and the bigger the dish makes for better range. So if [x=Hight] and [y=Size of dish] then [ (x/10)*(y*2)= Range) ] So a dish at 100y with a 3x3 dish would get a range of 180 blocks, sounds like a lot but this includes the height up there so it is still not that remarkable. good for local music. The controller links up with the dish and allows you to que up music discs to play, Maby up to 10 or so. Main reason why this block exists is so you don't have to travel up 200 blocks to change the song. Possibly could have to power the controller with RF for some extra challenge. Once this is all set up then any player can either use a radio item or possibly just a menu and can select any radio signal they are within range of to listen to.
	 */
}
