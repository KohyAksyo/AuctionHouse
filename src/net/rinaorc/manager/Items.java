package net.rinaorc.manager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items {
	
	public static final ItemStack PREVIOUS = new ItemStack(Material.ARROW);
	public static final ItemStack NEXT = new ItemStack(Material.ARROW);
	static {
		ItemMeta meta;
		
		meta = PREVIOUS.getItemMeta();
		meta.setDisplayName("§cPrevious");
		PREVIOUS.setItemMeta(meta);
		
		meta = NEXT.getItemMeta();
		meta.setDisplayName("§aNext");
		NEXT.setItemMeta(meta);
	}
	
}
