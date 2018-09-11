package net.angusbeefgaming.api;

import net.angusbeefgaming.api.bungee.NetworkManager;
import net.angusbeefgaming.api.bungee.PlayerManager;
import net.angusbeefgaming.api.bungee.ServerManager;

public class API {
	public static NetworkManager networkManager;
	public static PlayerManager playerManager;
	public static ServerManager serverManager;
	
	static boolean started;
	public static void startApi(Main plugin) {
		if(started) return;
		
		networkManager = new NetworkManager();
		playerManager = new PlayerManager();
		serverManager = new ServerManager();
		started = true;
	}
}
