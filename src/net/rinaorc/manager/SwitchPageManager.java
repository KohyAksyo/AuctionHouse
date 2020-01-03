package net.rinaorc.manager;

import java.util.Optional;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import test.AuctionGUI;

public class SwitchPageManager implements Listener{
	
	
	@EventHandler
	public void onPlayerClickEvent(InventoryClickEvent event) {
		
		Inventory inv = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		Player player = (Player) event.getWhoClicked();
		
		
		if(!inv.getName().toLowerCase().contains("auction house") || item == null || item.getType() == Material.AIR) {
			return;
		}

		event.setCancelled(true);
		
		if(item.hasItemMeta() && item.getItemMeta().equals(Items.PREVIOUS.getItemMeta())) {
			
			int page = AuctionGUI.getPage(player);
			AuctionGUI.open(player, page > 0 ? page - 1 : page);
			
		} else if(item.hasItemMeta() && item.getItemMeta().equals(Items.NEXT.getItemMeta())) {
			
			AuctionGUI.open(player, AuctionGUI.getPage(player) + 1);
				
		} else {
			
			Optional<AuctionItem> optional = AuctionManager.getItemList().stream().filter(obj -> obj.getItem().equals(item)).findFirst();
			if(!optional.isPresent()) {
				player.sendMessage("§cCet article a déjà été acheté par quelqu'un d'autre !");
				AuctionGUI.open(player, AuctionGUI.getPage(player));
				return;
			}
			
			AuctionManager.sellItem(ploptional.get()onItem);
			AuctionGUI.open(player, AuctionGUI.getPage(player));
			
		}
		
	}
	
}
