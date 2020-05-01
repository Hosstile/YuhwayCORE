package us.core.commands.panels;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.core.Core;
import us.core.interfaces.Messages;
import us.core.utilities.utils;
import us.core.yuhwaypanel.panelManager;

public class panelCommand implements CommandExecutor {

	public Core plugin;

	public panelCommand(Core plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("panel") && sender.hasPermission("core.panel")) {

			if (!(p.hasPermission("core.panel"))) {

				p.sendMessage(utils.translate(
						Messages.prefix + "&cYou &4&ldont &chave the required permission to use this command!"));

				return false;

			}

			panelManager.openIventory(p);
			return false;
		}

		return false;
	}

}
