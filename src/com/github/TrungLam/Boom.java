package com.github.TrungLam;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Boom extends JavaPlugin implements Listener{
	
	public static Boom plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public final PluginDescriptionFile pdf = this.getDescription();
	public static boolean boom = false;
	
	public void onDisable(){
		logger.info(pdf + " is disabled");
	}
	public void onEnable(){
		logger.info(pdf + " is enabled");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args){
		Player player = (Player) sender;
		if (Label.equalsIgnoreCase("boom") && player.isOp()){
			boom = (boom) ? false:true;
			player.sendMessage("boom: " + boom);
		}
		return false;
	}
	
	@EventHandler
	public void playerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if (boom && player.isOp()){
			if (event.getAction() == Action.RIGHT_CLICK_AIR){
				player.getWorld().createExplosion(player.getTargetBlock(null, 300).getLocation(), 5F);
			}
		}
	}

}
