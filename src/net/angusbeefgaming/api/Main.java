package net.angusbeefgaming.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.api.bungee.NetworkManager;
import net.angusbeefgaming.api.bungee.PlayerManager;

public class Main extends JavaPlugin {
	static Main instance;
	
	@Override
	public void onEnable() {
		Bukkit.getLogger().info("Infinity API Loaded!");
		instance = this;
		
		// Setup Bungee Messaging Channels
		
		// For Sending Messages
	    getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    // For Recieving Messages
	    getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new NetworkManager());
	    getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PlayerManager());
	    
	    // Start the API
	}
	
	public static Main getInstance() {
		return instance;
	}

}
