package us.core.autoannouncements.announcer;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.util.concurrent.AbstractScheduledService.Scheduler;

import us.core.Core;

public class announcer {

	public static void announce(Core plugin) {

		int a = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				
				for(Player all : Bukkit.getOnlinePlayers()) {
				}

			}
		}, 0L, 300L);
	}

}
