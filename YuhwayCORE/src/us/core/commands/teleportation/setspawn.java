package us.core.commands.teleportation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.core.interfaces.Messages;
import us.core.teleportation.teleport.teleportManager;
import us.core.utilities.utils;

public class setspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("setspawn") && sender.hasPermission("core.setspawn")) {
			
			if(!(p.hasPermission("core.setspawn"))) {
				
				p.sendMessage(utils.translate(Messages.prefix + "&cYou &4&ldont &chave the required permission to use this command!"));
				
				return false;
				
			}
			
			teleportManager.setSpawn(p);
			return false;
		} 
		
		return false;
	}

}
