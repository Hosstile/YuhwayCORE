package us.core.levels.level;

import java.util.UUID;

import org.bukkit.entity.Player;

import us.core.Core;
import us.core.files.types.Levels;
import us.core.levels.levelManager;

public class blockCounter {

	public blockCounter(Player p, UUID id) {
		
		int current = levelManager.getblocksBroken(id);
		
		levelManager.setBlocksBroken(id, current = current +1);
		Levels.savelevels();
		return;

	}

}
