package net.rinaorc.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.rinaorc.economy.Economy;

public class AuctionManager {
	
	private static final ArrayList<AuctionItem> itemsList = new ArrayList<>();
	
	public static final void addItem(AuctionItem item) {
		itemsList.add(item);
	}
	
	public static final void removeItem(AuctionItem item) {
		itemsList.remove(item);
	}
	
	public static final void clearItems() {
		itemsList.clear();
	}
	
	public static final void sellItem(Player player, AuctionItem item) {
		if(item == null) {
			return;
		}
		
		ItemStack itemStack = item.getItem();
		ItemMeta meta = itemStack.getItemMeta();
		List<String> lore = meta.getLore();
		for(int i = 0; i < 8; i++) {
			lore.remove(lore.size() - 1);
		}
		meta.setLore(lore);
		itemStack.setItemMeta(meta);
		
		if(Economy.has(player.getUniqueId(), item.getPrice())) {
			Economy.removeMoney(player.getUniqueId(), item.getPrice());
			removeItem(item);
			player.getInventory().addItem(item.getItem());
			player.sendMessage("§aVous avez acheté §e" + item.getIte.getType().toString()e() + "§a pour §e" + item.getPrice() + "$");
		} else {
			player.sendMessage("§cVous n'avez pas assez d'argent pour acheter cet objet !");
		}
	}
	
	public static final List<AuctionItem> getSellerItems(UUID uuid) {
		return itemsList.stream().filter(item -> uuid.equals(item.getSellerUUID())).collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	public static final List<AuctionItem> getItemList() {
		return (List<AuctionItem>) itemsList.clone();
	}
	
}
