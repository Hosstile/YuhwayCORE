package us.core.donationgoal.checker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.core.utilities.ItemBuilder;
import us.core.utilities.utils;

public class donationGoals {
	
	public static String donategoalName = "&b&lDonationGOAL";
	
	public static Inventory inv = Bukkit.createInventory(null, 9, utils.translate(donategoalName));
	
	public static void init() {
		
		ItemStack current = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lDonation Goal")).addLoreLine(utils.translate("&7")).addLoreLine("&f&l$0 &7&l/ &f&l$300").toItemStack();
		
		inv.setItem(4, current);
		
	}

}
