package net.rinaorc;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.rinaorc.commands.AuctionCmd;
import net.rinaorc.commands.AuctionRetreiveCmd;
import net.rinaorc.commands.AuctionSellCmd;
import net.rinaorc.manager.SwitchPageManager;

import java.util.logging.Logger;

public class AuctionHouse extends JavaPlugin {

    private static AuctionHouse PLUGIN;

    private Server server = getServer();
    private PluginManager pluginManager = server.getPluginManager();
    private Logger logger = getLogger();

    @Override
    public void onEnable() {
    	registerCommands();
    	pluginManager.registerEvents(new SwitchPageManager(), this);
        logger.info("The plugin is now enabled, and can now be used in game.");
    }

    @Override
    public void onDisable() {
        logger.info("The plugin is now disabled, and can no longer be used in game.");
    }
    
    public static AuctionHouse getInstance() {
    	return PLUGIN;
    }
    
    private void registerCommands() {
    	getCommand("ah").setExecutor(new AuctionCmd());
    	getCommand("ahsell").setExecutor(new AuctionSellCmd());
    	getCommand("ahr").setExecutor(new AuctionRetreiveCmd());
    }
    
}
