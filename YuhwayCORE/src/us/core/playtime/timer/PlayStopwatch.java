package us.core.playtime.timer;

import org.bukkit.Bukkit;

import us.core.Core;

public class PlayStopwatch {

	public void Timer(Core plugin) {
		int stop = 0;
		stop = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {

				
			}
		}, 0L, 300L);
	}



}
