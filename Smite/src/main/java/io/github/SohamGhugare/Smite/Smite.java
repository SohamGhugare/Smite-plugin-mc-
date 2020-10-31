package io.github.SohamGhugare.Smite;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Smite extends JavaPlugin implements CommandExecutor{
	public void onEnable() {
			this.getCommand("smite").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(! (sender.hasPermission("Smite.smite"))) {
			sender.sendMessage(ChatColor.RED + "You don't have the required permissions!");
			return true;
		}
		
		Player player = Bukkit.getPlayer(args[0]);
		Player player2 = (Player) sender;
		
		if(args.length == 0) {
			// Smite the player himself
			
			if(!(sender instanceof Player)) {
				// Checking if sender is console
				sender.sendMessage("You cannot smite yourself on Console!");
				return true;
			}
			else {
				// Smiting the player
				sender.sendMessage(ChatColor.GOLD + "Summoning Thunder.....");
				player2.getWorld().strikeLightning(player2.getLocation());
				return true;
			}
			
		}
		

		if(player == null) {
			// wrong name / offline player
			sender.sendMessage(ChatColor.RED + "Player isn't online / doesn't exist!");
			return true;
		}
						
		else{
			// Smite the mentioned player
			sender.sendMessage(ChatColor.GOLD + "Summoning Thunder.....");
			player.getWorld().strikeLightning(player.getLocation());
		}
		
		return false;
	}
}
	
