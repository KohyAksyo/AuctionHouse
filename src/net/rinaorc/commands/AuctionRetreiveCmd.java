package net.rinaorc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.rinaorc.manager.AuctionManager;

public class AuctionRetreiveCmd implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		
		if(s instanceof Player) {
			if(args.length == 0) {
				Player player = (Player) s;
				AuctionManager.getSellerItems(player.getUniqueId()).forEach(auctionItem -> {
					AuctionManager.removeItem(auctionItem);
					player.getInventory().addItem(auctionItem.getItem());
					player.sendMessage("§aVous avez retiré §e" + auctionItem.getItem().getItemMeta().getDisplayName() + "§a et §e" +
							auctionItem.getPrice() + "§b$§a été remis sur votre compte");
				});
				
				
			}else {
				s.sendMessage("§c/ahr");
			}
			
		}else {
			s.sendMessage("Tu dois etre un joueur pour executer cette commande");
		}
		
		return false;
	}

}
