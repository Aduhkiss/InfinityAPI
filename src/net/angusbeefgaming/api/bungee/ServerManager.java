package net.angusbeefgaming.api.bungee;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class ServerManager implements PluginMessageListener {
	
	static Map<String, Integer> count = new HashMap<String, Integer>();
	static Map<String, Integer> localStorage = new HashMap<String, Integer>();
	/*
	 * Server Manager Class
	 * Written by Atticus Zambrana
	 */
	
	/**
	 * Get the number of players on a server
	 * @param server
	 * @return
	 */
	public int getPlayerCount(String server) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("PlayerCount");
		out.writeUTF(server);
		Player sender = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
		if(count != null) {
			localStorage = count;
			count = null;
			return localStorage.get(server);
		}
		else {
			return getPlayerCount(server);
		}
	}
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord")) return;
		
	      ByteArrayDataInput in = ByteStreams.newDataInput(message);
	      String subchannel = in.readUTF();
	      if (subchannel.equals("PlayerCount")) {
	    	  count.put(in.readUTF(), in.readInt());
	      }
	}

}
