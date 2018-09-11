package net.angusbeefgaming.api.bungee;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.angusbeefgaming.api.Main;

public class PlayerManager implements PluginMessageListener {
	static String playerAddress;
	static String localStorage;
	
	/**
	 * Send a Player to the specified server.
	 * @param player
	 * @param server
	 */
	public void sendToServer(Player player, String server) {
		  ByteArrayDataOutput out = ByteStreams.newDataOutput();
		  out.writeUTF("Connect");
		  out.writeUTF(server);
		  player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	/**
	 * Send any player on the network a message
	 * @param player
	 * @param message
	 */
	public void sendMessage(String player, String message) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Message");
		out.writeUTF(player);
		out.writeUTF(message);
		Player sender = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
		sender.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	/**
	 * Disconnect a player from the proxy server
	 * @param player
	 * @param message
	 */
	public void disconnectPlayer(String player, String message) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("KickPlayer");
		out.writeUTF(player);
		out.writeUTF(message);
		Player sender = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
		sender.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	/**
	 * Get the IP Address of a Player Object
	 * @param player
	 * @return
	 */
	public String getPlayerAddress(Player player) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("IP");
		player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
		if(playerAddress != null) {
			localStorage = playerAddress;
			playerAddress = null;
			return localStorage;
		}
		else {
			return getPlayerAddress(player);
		}
	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord")) return;
		
	      ByteArrayDataInput in = ByteStreams.newDataInput(message);
	      String subchannel = in.readUTF();
	      if (subchannel.equals("IP")) {
	    	  playerAddress = in.readUTF();
	      }
	}
}
