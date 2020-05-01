package us.core.scoreboard.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.wasteofplastic.askyblock.ASkyBlock;
import com.wasteofplastic.askyblock.ASkyBlockAPI;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
import us.core.Core;
import us.core.utilities.utils;

public class scoreboardJoin implements Listener {

	Economy econ =null;
	
	Core st = Core.plugin;
	
	Vault v;
	ASkyBlock sb;
		
	 @EventHandler
	    public void joinServer(PlayerJoinEvent event) {
	        
		 Player player = event.getPlayer();

		 player.sendMessage(Core.asbAPI.getIslandName(player.getUniqueId()));
	        
	        ScoreboardManager scoreboardManager = Bukkit.getServer().getScoreboardManager();
	        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
	        Objective objective = scoreboard.registerNewObjective("Test", "Dummy");
	        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	        Team balance = scoreboard.registerNewTeam("balance");
	        Team season = scoreboard.registerNewTeam("season");
	        Team spacer1 = scoreboard.registerNewTeam("spacer1");
	        Team spacer2 = scoreboard.registerNewTeam("spacer2");
	        
	        Team island = scoreboard.registerNewTeam("island");
	        
	        Team s = scoreboard.registerNewTeam("s");  Team a = scoreboard.registerNewTeam("a");
	        
	        s.addEntry(utils.translate("&7 "));
	        a.addEntry(utils.translate("&3 "));
	        
	        spacer1.addEntry(utils.translate("           &8&l&m------"));
	        spacer2.addEntry(utils.translate("&8&l&m---------------"));
	        
	        season.setSuffix("");
	        season.setPrefix("");
	        
	        island.addEntry(utils.translate("&b&lIsland&8: &f" ));
	        
	        balance.addEntry(utils.translate("&b&lBalance&8: &f" + Core.getPlayerBalance(player)));
	        balance.setSuffix("");
	        balance.setPrefix("");
	        
	        objective.getScore(utils.translate("&7 ")).setScore(0);
	        objective.getScore(utils.translate("&8&l&m----------------------")).setScore(1);
	        objective.getScore(utils.translate("&3 ")).setScore(4);
	        objective.getScore(utils.translate("&b&lBalance&8: &f" + Core.getPlayerBalance(player))).setScore(6);
	        objective.getScore(utils.translate("&b&lIsland&8: &f"  ) ).setScore(5);
	        objective.getScore(utils.translate("             &8&l&m------")).setScore(7);
	        
            
	        String title = utils.translate("&b&lYuhway Skyblock");
	        char[] split = title.toCharArray();

	  
	            int counter = 0;
	            String finaltitle = utils.translate("&b&lYuhway Skyblock");

	   
	                if (counter < split.length) {
	                    String letter = String.valueOf(split[counter]);
	                    counter += 1;
	                    String space = "";
	                    for (int i = 0; i < split.length - counter; i++) {
	                        space += " ";
	                    }

	                    finaltitle +=   letter;
	                    objective.setDisplayName(finaltitle);
	                    balance.setSuffix(""+ "");
	                }else{
	                    String space = "";
	                    finaltitle = "";
	                    for (int i = 0; i < split.length - counter; i++) {
	                        space += " ";
	                    }
	                    objective.setDisplayName(space);
	                    counter = 0;
	                }
	            
	        

	        player.setScoreboard(scoreboard);
	    
	}

}
