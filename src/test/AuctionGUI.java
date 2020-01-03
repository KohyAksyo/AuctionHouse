package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.rinaorc.manager.AuctionItem;
import net.rinaorc.manager.AuctionManager;
import net.rinaorc.manager.Items;

public class AuctionGUI {
	
	public static final List<AuctionItem> items = new ArrayList<>();
	public static final Map<Player, Integer> pages = new HashMap<>();
	
	public static final void open(Player player) {
		open(player, 0);
	}
	
	public static final void open(Player player, int page) {
		
		pages.put(player, page);
		
		List<AuctionItem> localItems = AuctionManager.getItemList();
		
		Inventory inventory = Bukkit.createInventory(null, 54, "Auction House | " + page);
		
		inventory.setItem(45, Items.PREVIOUS);
		inventory.setItem(53, Items.NEXT);
		
		try {
			
			for(int i = page * 45, slot = 9; (i < localItems.size()) && (slot < 45); i++) {
				
				inventory.setItem(slot++, localItems.get(i).getItem());
				
			}
		
		} catch(IndexOutOfBoundsException ex) {
			
		}
		
		player.openInventory(inventory);
		
	}
	
	public static final int getPage(Player player) {
		return pages.containsKey(player) ? pages.get(player) : 0;
	}
	
}
