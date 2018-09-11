package net.angusbeefgaming.api.bungee;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.angusbeefgaming.api.Main;

public class NetworkManager implements PluginMessageListener {
	// Private String Array for holding network data
	private static String[] networkedServers;
	private static String[] localStorage;
	
	/**
	 * Returns a String Array of all servers on the network
	 * @return
	 */
	public String[] getNetworkedServers() {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("GetServers");
		Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
		player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
		if(networkedServers != null) {
			localStorage = networkedServers;
			networkedServers = null;
			return localStorage;
		}
		else {
			return getNetworkedServers();
		}
	}
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord")) return;
		
	      ByteArrayDataInput in = ByteStreams.newDataInput(message);
	      String subchannel = in.readUTF();
	      if (subchannel.equals("GetServers")) {
	    	  networkedServers = in.readUTF().split(", ");
	      }
	}
}
