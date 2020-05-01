package us.core.commands.level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.core.files.types.Levels;
import us.core.levels.levelManager;
import us.core.utilities.utils;


public class levelCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("level") && sender.hasPermission("core.level")) {
			
			Player p= (Player) sender;
			
			p.sendMessage(utils.translate("&8&l&m---------------------"));		
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&a&lYour current level is&8&l: &7&l< &f&l" + Levels.levels.getInt("Players." + p.getUniqueId() + ".levels") + " &7&l>"));
			p.sendMessage(utils.translate("&7XP&8: &f&l" + levelManager.getXP(p)));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&8&l&m---------------------"));		
		}
		
		
		return false;
	}

}
