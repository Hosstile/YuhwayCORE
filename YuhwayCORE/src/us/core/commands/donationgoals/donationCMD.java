package us.core.commands.donationgoals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.core.donationgoal.checker.donationGoals;
import us.core.files.types.Levels;
import us.core.interfaces.Messages;
import us.core.levels.levelManager;
import us.core.utilities.utils;


public class donationCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("donationgoal") || cmd.getName().equalsIgnoreCase("goal")) {
			
			Player p= (Player) sender;
			
		
			p.sendMessage(utils.translate(Messages.prefix + "&7Opening goal gui!"));
			p.openInventory(donationGoals.inv);
			return false;
			
		}
		
		
		return false;
	}

}
