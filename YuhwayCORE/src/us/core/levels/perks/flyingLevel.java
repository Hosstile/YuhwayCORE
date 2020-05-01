package us.core.levels.perks;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import us.core.Core;
import us.core.interfaces.Messages;
import us.core.utilities.utils;

public class flyingLevel {
	
	public static void fly(UUID id, int time, Core plugin) {
		
		Player p = Bukkit.getPlayer(id);
		p.setAllowFlight(true);
		p.setFlying(true);
		
		if(time == 100) {
		p.sendMessage(utils.translate(Messages.prefix + "&cYour flight will expire in &715 &cminutes!"));
		
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

            @Override
            public void run(){
               
            	p.setAllowFlight(false);
            	p.setFlying(false);
            	p.sendMessage(utils.translate(Messages.prefix + "&cYour flight has &4&lEXPIRED&c!"));
            	
            }
        }, time * 180);
        
        
    	if(time == 200) {
    		p.sendMessage(utils.translate(Messages.prefix + "&cYour flight will expire in &730 &cminutes!"));
    		
    	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

    	        @Override
    	        public void run(){
    	           
    	        	p.setAllowFlight(false);
    	        	p.setFlying(false);
    	        	p.sendMessage(utils.translate(Messages.prefix + "&cYour flight has &4&lEXPIRED&c!"));
    	        	
    	        }
    	    }, time * 180);
    }
		
	}
	


}
		
		
	

}
