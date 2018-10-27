package net.angusbeefgaming.api.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvUtil {
/*
 * @author Atticus Zambrana
 * 
 * Utility Class for managing player inventories
 */
	
	/**
	 * Clear the given players inventory
	 * @param player
	 */
	public static void clearInv(Player player) {
		Inventory inv = player.getInventory();
		for(ItemStack item : inv.getContents()) {
			inv.remove(item);
		}
	}
	
	/**
	 * Clear the given inventory object
	 * @param inv
	 */
	public static void clearInv(Inventory inv) {
		for(ItemStack item : inv.getContents()) {
			inv.remove(item);
		}
	}
}
