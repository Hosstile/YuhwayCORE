package us.core.levels.events;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import us.core.files.types.Levels;
import us.core.interfaces.Messages;
import us.core.levels.level.starterLevels;
import us.core.utilities.utils;

public class LevelJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		UUID id = e.getPlayer().getUniqueId();
		
		if(((Levels.levels.getString("Players." + id)) == null)) {
		
		starterLevels sl = new starterLevels(id, p);
		p.sendMessage(utils.translate(Messages.prefix + "&7A &f&lLevels &7cache has been created for you!"));
		return;
		}
		
	}

}
