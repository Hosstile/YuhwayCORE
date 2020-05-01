package us.core.levels;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import us.core.files.types.Levels;
import us.core.utilities.utils;

public class levelManager {

	public static int lvl1 = 4;
	public static int lvl2 = 10;
	public static int lvl3 = 24;
	public static int lvl4 = 85;
	public static int lvl5 = 105;
	public static int lvl6 = 125;
	public static int lvl7 = 135;
	public static int lvl8 = 165;
	public static int lvl9 = 185;
	public static int lvl10 = 225;
	public static int lvl11 = 250;
	public static int lvl12 = 295;
	public static int lvl13 = 300;
	public static int lvl14 = 325;
	public static int lvl15 = 350;
	public static int lvl16 = 375;
	public static int lvl17 = 400;
	public static int lvl18 = 420;
	public static int lvl19 = 460;
	public static int lv20 = 500;

	public static void createLevelSection(UUID id, Player player) {

		Levels.levels.set("Players." + id + ".name", player.getName());
		Levels.levels.set("Players." + id + ".levels", 0);
		Levels.levels.set("Players." + id + ".levelxp", 0);
		Levels.levels.set("Players." + id + ".blocksbroken", 0);

		Levels.savelevels();

		return;

	}

	public static Player getPlayer(UUID id) {

		return Bukkit.getPlayer(id);

	}

	public static void setBlocksBroken(UUID id, int blocksbroken) {

		int current = getblocksBroken(id);

		Levels.levels.set("Players." + id + ".blocksbroken", current = current + 1);

	}

	public static String getName(UUID id) {

		return Levels.levels.getString("Players." + id + ".name");

	}

	public static int getblocksBroken(UUID id) {
		return Levels.levels.getInt("Players." + id + ".blocksbroken");
	}

	public static int getLevels(UUID id) {

		return Levels.levels.getInt("Player." + id + ".levels");

	}

	public static void setLevels(UUID id, int levels) {

		Levels.levels.set("Players." + id + ".levels", levels);
		Levels.savelevels();

	}

	public static void addLevels(UUID id, int levels) {

		int current = getLevels(id);

		Levels.levels.set("Players." + id + ".levels", current = current + 1);
		Levels.savelevels();

	}

	public static void clearLevels(UUID id) {
		Levels.levels.set("Players." + id + ".levels", null);
		Levels.savelevels();
	}

	public static void setXP(Player p, int xp) {

		Levels.levels.set("Players." + p.getUniqueId() + ".levelxp", xp);
		p.sendMessage(utils.translate("&7Your xp has just been set to &f" + xp + "&7."));
		Levels.savelevels();

	}

	public static int getXP(Player p) {

		return Levels.levels.getInt("Players." + p.getUniqueId() + ".levelxp");
	}

	public static void addXP(Player p, int xp) {

		int current = getXP(p);

		p.sendMessage(utils.translate("&7You have just recieved &f" + xp + " &7levels."));

		Levels.levels.set("Players." + p.getUniqueId() + ".levelxp", current = current + xp);
		Levels.savelevels();

		if (current == lvl1) {
			int st = getLevels(p.getUniqueId());
			levelManager.setLevels(p.getUniqueId(), st = st +1);
			Levels.savelevels();

			p.sendMessage(utils.translate("&8&l&m-----------------------"));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&a&l YOU HAVE LEVELED UP"));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&7&l         &f&l   " + st + "            "));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&8&l&m-----------------------"));
			return;

		}
		
		if (current == lvl2) {
			int st = getLevels(p.getUniqueId());
			levelManager.setLevels(p.getUniqueId(), st = st +1);
			Levels.savelevels();

			p.sendMessage(utils.translate("&8&l&m-----------------------"));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&a&l YOU HAVE LEVELED UP"));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&7&l         &f&l   " + st + "            "));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&8&l&m-----------------------"));
			return;

		}
		
		if (current == lvl3) {
			int st = getLevels(p.getUniqueId());
			levelManager.setLevels(p.getUniqueId(), st = st +1);
			Levels.savelevels();

			p.sendMessage(utils.translate("&8&l&m-----------------------"));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&a&l YOU HAVE LEVELED UP"));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&7&l         &f&l   " + st + "            "));
			p.sendMessage(utils.translate("&7"));
			p.sendMessage(utils.translate("&8&l&m-----------------------"));
			return;

		}

	}

}
