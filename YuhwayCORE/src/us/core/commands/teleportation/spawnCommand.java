package us.core.commands.teleportation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.core.Core;
import us.core.interfaces.Messages;
import us.core.teleportation.teleport.teleportManager;
import us.core.utilities.utils;

public class spawnCommand implements CommandExecutor {

	public Core plugin;

	public spawnCommand(Core plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("spawn") && sender.hasPermission("core.spawn")) {

			if (!(p.hasPermission("core.setspawn"))) {

				p.sendMessage(utils.translate(
						Messages.prefix + "&cYou &4&ldont &chave the required permission to use this command!"));

				return false;

			}

			teleportManager.teleportToSpawn(p, plugin);
			return false;
		}

		return false;
	}

}
