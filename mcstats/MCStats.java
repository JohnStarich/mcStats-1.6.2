package mods.mcstats;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "John-Jules", name = "mcstats", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MCStats {
	//player login/logout tracker
	private static PlayerLoginTracker playerTracker;
	
	@Instance("mcstats")
	public static MCStats instance;
	@SidedProxy(clientSide = "mods.minetech.ClientProxy", serverSide = "mods.minetech.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event){}
    
    @EventHandler
    public void load(FMLInitializationEvent initEvent){
    	GameRegistry.registerPlayerTracker(playerTracker);
    	TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){}
}
