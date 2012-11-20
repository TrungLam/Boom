package com.github.biyussbf;

import java.util.logging.Logger;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Boom extends JavaPlugin{
	
	public static Boom plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public final PluginDescriptionFile pdf = this.getDescription();
	
	public void onDisable(){
		logger.info(pdf + " is disabled");
	}
	public void onEnable(){
		logger.info(pdf + " is enabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args){
		Player player = (Player) sender;
		World world = player.getWorld();
		
		if (Label.equalsIgnoreCase("boom") && player.isOp()){
			Block targetBlock = player.getTargetBlock(null, 300);
			world.createExplosion(targetBlock.getLocation(), 4F);
		}
		return false;
	}

}
