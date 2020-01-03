package net.rinaorc.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.rinaorc.manager.AuctionItem;
import net.rinaorc.manager.AuctionManager;

public class AuctionSellCmd implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("randomfill")) {
				int max = Integer.parseInt(args[1]);
				for(int i = 0; i < max; i++) {
					ItemStack item = new ItemStack(Material.values()[new Random().nextInt(Material.values().length)]);
					ItemMeta meta = item.getItemMeta();
					List<String> lore = new ArrayList<>();
					if(meta.hasLore()) {
						lore.addAll(meta.getLore());
					}
					lore.add(" ");
					lore.add("Vendu par: RandomFill");
					lore.add("Date: " + System.currentTimeMillis());
					meta.setLore(lore);
					item.setItemMeta(meta);
					AuctionManager.addItem(new AuctionItem(50, 200, 14, Bukkit.getOfflinePlayer("Notch").getUniqueId(), item));
				}
				return true;
			}
		}
		
		
		if(s instanceof Player) {
			Player player = (Player) s;
			if(player.getItemInHand() != null && player.getItemInHand().getType() != Material.AIR) {
				
				if(args.length == 1) {
					try {
						int price = Integer.parseInt(args[0]);
						ItemStack item = player.getItemInHand();
						player.getInventory().setItemInHand(new ItemStack(Material.AIR));
						ItemMeta meta = item.getItemMeta();
						List<String> lore = new ArrayList<>();
						if(meta.hasLore()) {
							lore = meta.getLore();
						}
						lore.add(" ");
						lore.add("§6§m------------------");
						lore.add("");
						lore.add("§aVendeur: §7" + player.getName());
						lore.add("§aDate: §7" + System.currentTimeMillis());
						lore.add("§aPrix: §7" + price + "$");
						lore.add("");
						lore.add("§6§m------------------");
						meta.setLore(lore);
						item.setItemMeta(meta);
						AuctionManager.addItem(new AuctionItem(50, 200, 14, player.getUniqueId(), item));
						player.sendMessage("§aVous avez mis en vente §e" + (item.getItemMeta().hasDisplayName() ? item.getItemMeta().getDisplayName() : item.getType().toString()) + "§a pour §e" + price + "$");
					} catch(NumberFormatException ex) {
						//string pas un int
					}
				
				}else {
					player.sendMessage("§cTu dois inserer un prix après la commande");
				}
				
			}else {
				player.sendMessage("§cTu dois avoir un item en main !");
			}
		}else {
			s.sendMessage("prout");
		}
		
		return false;
	}
		
		

}
