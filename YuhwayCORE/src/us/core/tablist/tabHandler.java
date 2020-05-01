package us.core.tablist;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import us.core.Core;
import us.core.utilities.utils;

public class tabHandler {

	private boolean titlechanged = false;

	private static String builder = utils.translate("&8&l<&6&lBuilder&8&l> &6");

	public tabHandler(Core plugin) {

		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
		new BukkitRunnable() {

			@Override
			public void run() {
				try {
					Field a = packet.getClass().getDeclaredField("a");
					a.setAccessible(true);
					Field b = packet.getClass().getDeclaredField("b");
					b.setAccessible(true);

					Object header1 = new ChatComponentText(utils.translate("&b&lYuhway Network"));

					Object footer = new ChatComponentText(utils
							.translate("\n&f" + Bukkit.getOnlinePlayers().size() + " &7/ &f" + Bukkit.getMaxPlayers() + "\n&7\n&7www.yuhway.net"));

					a.set(packet, header1);
					titlechanged = true;

					b.set(packet, footer);

					if (Bukkit.getOnlinePlayers().size() == 0)
						return;
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
					}

				} catch (NoSuchFieldException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}.runTaskTimer((Core) plugin, 0, 20);
	}

}
