package us.core.levels.events;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import us.core.Core;
import us.core.levels.levelManager;
import us.core.levels.level.blockCounter;
import us.core.levels.perks.flyingLevel;
import us.core.utilities.utils;

public class BlockCounter implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {

		Player p = e.getPlayer();
		UUID id = e.getPlayer().getUniqueId();

		blockCounter bc = new blockCounter(p, id);

		if (levelManager.getblocksBroken(id) == 50) {
			
			levelManager.addXP(p, 4);

			levelManager.getPlayer(id).sendMessage(utils.translate(
					"&8&l&m----------------------------\n&b&lYuhway &e&lLevels &8&l» &7You just hit a milestone, \n&fYou have broken 50 blocks!\n&8&l&m----------------------------"));
			
			return;
		} else

		if (levelManager.getblocksBroken(id) == 250) {
			levelManager.addXP(p, 6);
			levelManager.getPlayer(id).sendMessage(utils.translate(
					"&8&l&m----------------------------\n&b&lYuhway &e&lLevels &8&l» &7You just hit a milestone, \n&fYou have broken 250 blocks!\n&8&l&m----------------------------"));
			return;
		}

		if (levelManager.getblocksBroken(id) == 500) {
			levelManager.addXP(p, 14);

			levelManager.getPlayer(id).sendMessage(utils.translate(
					"&8&l&m----------------------------\n&b&lYuhway &e&lLevels &8&l» &7You just hit a milestone, \n&fYou have broken 500 blocks!\n&eas a reward you will recieve &f/fly &efor the next 15 minutes!&8&l&m----------------------------"));
			flyingLevel.fly(id, 100, Core.plugin);
			return;
		}

		if (levelManager.getblocksBroken(id) == 1000) {

			levelManager.addXP(p, 30);
					levelManager.getPlayer(id).sendMessage(utils.translate(
							"&8&l&m----------------------------\n&b&lYuhway &e&lLevels &8&l» &7You just hit a milestone, \n&fYou have broken 1000 blocks!\n&eas a reward you will recieve &f/fly &efor the next 30 minutes!&8&l&m----------------------------"));
					flyingLevel.fly(id, 200, Core.plugin);
					
					return;
		}

	}

}
