package us.core.levels.level;

import java.util.UUID;

import org.bukkit.entity.Player;

import us.core.Core;
import us.core.levels.levelManager;

public class starterLevels {
	
	public starterLevels(UUID id, Player player) {
		
		levelManager.createLevelSection(id, player);
		return;
		
	}

}
