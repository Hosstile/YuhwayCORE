package us.core.utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import us.core.Core;
import us.core.files.types.Levels;

public class utils {

	public static String translate(String args) {
		return ChatColor.translateAlternateColorCodes('&', args);
	}

	public static void cms(String msg) {

		Bukkit.getConsoleSender().sendMessage(utils.translate(msg));

	}
	
	public static void disablePlugin() {
		Bukkit.getPluginManager().disablePlugin(Core.plugin);
	}

}
