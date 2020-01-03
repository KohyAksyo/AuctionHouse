package net.rinaorc.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.rinaorc.manager.AuctionItem;
import net.rinaorc.manager.AuctionManager;

public final class AuctionHouseGUI {
	
	private static final List<Inventory> inventory = new ArrayList<>();
	
	private AuctionHouseGUI() {
		
	}
	
	/*public static final void refresh() {
		int i = 0;
		int p = 0;
		for(Map.Entry<UUID, AuctionItem> entry : AuctionManager.getItems().entrySet()) {
			if(inventory.size() < p) {
				inventory.add(Bukkit.createInventory(null, 45, "Auction House | Page " + p));
			}
			inventory.get(p).setItem(i, entry.getValue().getItem());
			i++;
			if(i >= 20) {
				i = 0;
				p++;
			}
		}
	}
	
	public static final void open(Player player, int page) {
		refresh();
		Bukkit.broadcastMessage("inv size: " + inventory.size());
		Bukkit.broadcastMessage("page: " + page);
		Bukkit.broadcastMessage("page condition: " + (page > inventory.size() ? inventory.size() : page));
		player.openInventory(inventory.get(page > inventory.size() ? inventory.size() : page));
	}*/
	
}
