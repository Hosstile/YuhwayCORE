package us.core.yuhwaypanel;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.core.interfaces.Messages;
import us.core.utilities.ItemBuilder;
import us.core.utilities.utils;

public class panelManager {

	public static String panelName = utils.translate("&b&lCORE &f&lPANEL");

	public static Inventory inv = Bukkit.getServer().createInventory(null, 36, utils.translate(panelName));

	public static void openIventory(Player p) {

		p.sendMessage(utils.translate(Messages.prefix + "&cOpening the &4&lCORE  &cpanel."));
		p.openInventory(inv);
		return;

	}

	public static void init() {

		ItemStack reload = new ItemBuilder(Material.ARROW).setName(utils.translate("&c&lReload CORE")).toItemStack();
		ItemStack unload = new ItemBuilder(Material.BARRIER).setName(utils.translate("&4&lUNLOAD CORE")).toItemStack();
		ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.LIGHT_BLUE).setName(utils.translate("&7")).toItemStack();
		
		ItemStack dets = new ItemBuilder(Material.SKULL_ITEM).setName(utils.translate("&b&lYuhway&f&lCore")).addLoreLine(utils.translate("&7"))
				.addLoreLine(utils.translate("&7This plugin was developed by &f&lHosstile&7")).addLoreLine("&7and for the use of a core for &f&lYuhway Skyblock&7.").toItemStack();
		
		inv.setItem(0, glass.clone());
		inv.setItem(8, glass.clone());
		inv.setItem(7, dets);
		inv.setItem(9, glass.clone());
		inv.setItem(18, glass.clone());
		inv.setItem(17, glass.clone());
		inv.setItem(26, glass.clone());
		inv.setItem(27, glass.clone());
		inv.setItem(35, glass.clone());
		inv.setItem(18, glass.clone());
		
		inv.setItem(13, reload);
        inv.setItem(22, unload);
	}

}
