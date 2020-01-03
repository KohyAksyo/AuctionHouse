package net.rinaorc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import test.AuctionGUI;

public class AuctionCmd implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			
			if(args.length == 1) {
				AuctionGUI.open(player, Integer.parseInt(args[0]));
				return true;
			}
			
			
			if(args.length == 0) {
				
				AuctionGUI.open(player, 0);
				
			} else {
				player.sendMessage("§c/ah");
			}
			
		} else {
			sender.sendMessage("Il faut etre un joueur pour executer la commande");
		}
		
		return false;
	}

}
