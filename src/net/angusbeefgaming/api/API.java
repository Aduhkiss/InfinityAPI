package net.angusbeefgaming.api;

import net.angusbeefgaming.api.bungee.NetworkManager;
import net.angusbeefgaming.api.bungee.PlayerManager;
import net.angusbeefgaming.api.bungee.ServerManager;

public class API {
	static NetworkManager networkManager;
	static PlayerManager playerManager;
	static ServerManager serverManager;
	public static void startApi(Main plugin) {
		networkManager = new NetworkManager();
		playerManager = new PlayerManager();
		serverManager = new ServerManager();
	}
}
