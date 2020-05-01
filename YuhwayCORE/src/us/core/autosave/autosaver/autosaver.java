package us.core.autosave.autosaver;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import us.core.Core;
import us.core.interfaces.Messages;
import us.core.utilities.utils;

public class autosaver {

	public static void saver(Core plugin) {

		int a = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {

				for (Player all : Bukkit.getOnlinePlayers()) {
					all.sendMessage(utils.translate(Messages.prefix + "&cWe have secured and saved your world!"));
	
				}

					for (World worlds : Bukkit.getWorlds()) {

						worlds.save();
					return;
				}

			}
		}, 0L, 3500L);
	}

}
