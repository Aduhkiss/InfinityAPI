package net.angusbeefgaming.api.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemUtil {
    private static ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    /**
     * Get an ItemStack for use in an inventory
     * @param item
     * @param name
     * @return
     */
    public static ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
    
    /**
     * Get an ItemStack for use in an inventory with color
     * @param item
     * @param name
     * @return
     */
    public static ItemStack nameItem(Material item, String name, ChatColor color) {
    	return nameItem(new ItemStack(item), color + name);
    }
    
    /**
     * Get a Player head for the playername
     * @param playername
     * @return
     */
    public static ItemStack getPlayerHead(String playername) {
    	ItemStack skull = new ItemStack(397, 1, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setDisplayName(playername);
        skull.setItemMeta(meta);
        return skull;
    }
}
