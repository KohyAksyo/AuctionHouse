package net.rinaorc.manager;

import java.util.UUID;

import org.bukkit.inventory.ItemStack;

public class AuctionItem {
	
	private final int addedTime;
	private final int expirationTime;
	private final double price;
	private final UUID sellerUUID;
	private final ItemStack item;
	
	public AuctionItem(int addedTime, int expirationTime, double price, UUID sellerUUID, ItemStack item) {
		this.addedTime = addedTime;
		this.expirationTime = expirationTime;
		this.price = price;
		this.sellerUUID = sellerUUID;
		this.item = item;
	}
	
	public int getAddedTime() {
		return addedTime;
	}
	
	public int getExpirationTime() {
		return expirationTime;
	}

	public double getPrice() {
		return price;
	}
	
	public UUID getSellerUUID() {
		return sellerUUID;
	}
	
	public ItemStack getItem() {
		return item;
	}
	
}
