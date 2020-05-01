package us.core;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.wasteofplastic.askyblock.ASkyBlockAPI;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import us.core.autoannouncements.autoannounce;
import us.core.autosave.AutoSave;
import us.core.commands.donationgoals.donationCMD;
import us.core.commands.level.levelCommand;
import us.core.commands.panels.panelCommand;
import us.core.commands.teleportation.setspawn;
import us.core.commands.teleportation.spawnCommand;
import us.core.donationgoal.checker.donationGoals;
import us.core.donationgoal.event.donoClick;
import us.core.files.FileHandler;
import us.core.levels.events.BlockCounter;
import us.core.levels.events.LevelJoin;
import us.core.scoreboard.events.scoreboardJoin;
import us.core.startup.startupHandler;
import us.core.tablist.tabHandler;
import us.core.yuhwaypanel.panelManager;
import us.core.yuhwaypanel.events.panelClick;

public class Core extends JavaPlugin {

	private static final Logger log = Logger.getLogger("Minecraft");

	private static Economy econ = null;
	private static Permission perms = null;
	private static Chat chat = null;
	public static Core plugin;

	public static ASkyBlockAPI asbAPI = null;

	public void onEnable() {
		plugin = this;

		Plugin asb = getServer().getPluginManager().getPlugin("aSkyBlock");

		if (asb != null) {
			asbAPI = ((ASkyBlockAPI) asb).getInstance(); // I think

		}

		if (!setupEconomy()) {
			Bukkit.getConsoleSender().sendMessage(
					String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

		init();

	}

	public void onDisable() {
		plugin = null;

	}

	private void init() {

		cmdhandler();
		eventhandler();
		donationGoals.init();
		confighandler();
		tabhandler();
		startup();
		autoannouncer();
		autosave();
		initFiles();
		registerEvents();
		panelManager.init();
		setupPermissions();
		setupChat();
	}

	void cmdhandler() {

		getCommand("setspawn").setExecutor(new setspawn());
		getCommand("spawn").setExecutor(new spawnCommand(this));
		getCommand("panel").setExecutor(new panelCommand(this));
		getCommand("level").setExecutor(new levelCommand());
		getCommand("goal").setExecutor(new donationCMD());
		getCommand("donationgoal").setExecutor(new donationCMD());

	}

	void eventhandler() {

	}

	void confighandler() {

		getConfig().options().copyDefaults(true);
		saveConfig();

	}

	void tabhandler() {
		tabHandler tabhand = new tabHandler(this);
	}

	void startup() {
		startupHandler notifystartup = new startupHandler(this);
	}

	void autoannouncer() {
		autoannounce an = new autoannounce(this);
	}

	void autosave() {
		AutoSave as = new AutoSave(this);
	}

	void initFiles() {
		FileHandler.initFiles(this, getDataFolder());
	}

	void registerEvents() {

		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new LevelJoin(), this);
		pm.registerEvents(new BlockCounter(), this);
		pm.registerEvents(new panelClick(), this);
		pm.registerEvents(new scoreboardJoin(), this);
		pm.registerEvents(new donoClick(), this);

	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	public static double getPlayerBalance(Player p) {

		return econ.getBalance(p.getPlayer());

	}

}
