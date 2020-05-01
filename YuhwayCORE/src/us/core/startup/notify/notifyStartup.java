package us.core.startup.notify;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import us.core.interfaces.Messages;
import us.core.utilities.utils;

public class notifyStartup {

	public boolean notifyenabled = true;
	
	public static void notifyServer() {
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			if(all.hasPermission("core.notify")) {
				
				all.sendMessage(utils.translate("&8&l&m---------------------------------"));
				all.sendMessage(utils.translate(Messages.prefix + "&cThis server is using &f&lYuhway&c CORE."));
				all.sendMessage(utils.translate("&8&l&m---------------------------------"));
				
			} else if(!(all.hasPermission("core.notify"))) {
				return;
			}
			
		}
		
	}

}
