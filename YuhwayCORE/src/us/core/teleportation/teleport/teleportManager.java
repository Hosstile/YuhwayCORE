package us.core.teleportation.teleport;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import us.core.Core;
import us.core.files.types.Locations;
import us.core.interfaces.Messages;
import us.core.utilities.utils;

public class teleportManager {

	public static void teleportPlayerTo(Player p, Location loc) {
		p.teleport(loc);
	}

	public static void teleportToSpawn(Player p, Core plugin) {

		if (Locations.locations.getString("Locations.Spawn") == null) {

			p.sendMessage(utils.translate(Messages.prefix + "&cPlease get an administrator to &4&lset &ca spawn!"));

			return;

		}

		int x = Locations.locations.getInt("Locations.Spawn.x");
		int y = Locations.locations.getInt("Locations.Spawn.y");
		int z = Locations.locations.getInt("Locations.Spawn.z");
		float yaw = Locations.locations.getInt("Locations.Spawn.yaw");
		;
		float pitch = Locations.locations.getInt("Locations.Spawn.pitch");
		World w = Bukkit.getWorld(Locations.locations.getString("Locations.Spawn.world"));

		final Location l = new Location(w, x, y, z, yaw, pitch);

		p.sendMessage(utils.translate("&8&l&m---------------------------"));
		p.sendMessage(utils.translate("&7"));
		p.sendMessage(utils.translate("&b&l         Teleportation        "));
		p.sendMessage(utils.translate("\n    &7Your teleport will commence \n             in &f&l5 &7seconds."));
		p.sendMessage(utils.translate("&7"));
		p.sendMessage(utils.translate("&8&l&m---------------------------"));
    
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {

				p.teleport(l);

			}
		}, 100L);

	}
	
	
	
	public static void setSpawn(Player p) {
		
		double x = p.getLocation().getX();
		double y = p.getLocation().getY();
		double z = p.getLocation().getZ();
		float yaw = p.getLocation().getYaw();
		float pitch = p.getLocation().getPitch();
		World w = p.getWorld();
		
		Locations.locations.set("Locations.Spawn.x", x);
		Locations.locations.set("Locations.Spawn.y", y);
		Locations.locations.set("Locations.Spawn.z", z);
		Locations.locations.set("Locations.Spawn.yaw", yaw);
		Locations.locations.set("Locations.Spawn.pitch", pitch);
		Locations.locations.set("Locations.Spawn.world", w.getName().toString());
		Locations.savelocations();
		
		p.sendMessage(utils.translate(Messages.prefix + "&cYou have set the main spawn!"));
		return;
	}

}
