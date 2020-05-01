package us.core.donationgoal.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import us.core.donationgoal.checker.donationGoals;
import us.core.interfaces.Messages;
import us.core.utilities.utils;
import us.core.yuhwaypanel.panelManager;

public class donoClick implements Listener {

	@EventHandler
	public void donoClick(InventoryClickEvent e) {

		if (e.getInventory().getTitle().equalsIgnoreCase(utils.translate(donationGoals.donategoalName))) {
			e.setCancelled(true);

			return;

		}
	}

}
