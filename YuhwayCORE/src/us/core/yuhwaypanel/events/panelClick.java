package us.core.yuhwaypanel.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import us.core.interfaces.Messages;
import us.core.utilities.utils;
import us.core.yuhwaypanel.panelManager;

public class panelClick implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		if (e.getInventory().getTitle().equalsIgnoreCase(utils.translate(panelManager.panelName))) {
			e.setCancelled(true);

			ItemStack is = e.getCurrentItem();

			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase(utils.translate("&4&lUNLOAD CORE"))) {

				Bukkit.broadcastMessage(utils.translate(Messages.prefix + "&cThe core is now shutting down!"));
				utils.disablePlugin();
				e.getWhoClicked().closeInventory();
				e.setCancelled(true);
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase(utils.translate("&c&lReload CORE"))) {

				e.getWhoClicked().sendMessage(utils.translate(Messages.prefix + "&4&lFEATURE IS CURRENTLY LOCKED"));
				e.getWhoClicked().closeInventory();
				e.setCancelled(true);
				return;
			}

			if (!e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&4&lUNLOAD CORE"))
					|| !e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(utils.translate("&c&lReload CORE"))) {
				e.getWhoClicked().closeInventory();
				e.setCancelled(true);
				return;
			}

		}
	}

}
