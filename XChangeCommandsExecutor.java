package com.adamstruthers.xchange;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class XChangeCommandsExecutor implements CommandExecutor {

	public static XChange plugin;
	
	public XChangeCommandsExecutor(XChange plugin){
		XChangeCommandsExecutor.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("trade")){
			return handleTrading(sender, args);
		}
		/*
		 * 
		 *
		if(cmd.getName().equalsIgnoreCase("accept")){
			//return handleAccepting(sender, args);
		}
		if(cmd.getName().equalsIgnoreCase("decline")){
			//return handleDeclining(sender, args);
		}
		if(cmd.getName().equalsIgnoreCase("counter")){
			//return handleBartering(sender, args);
		}
		*/
		
		return false;
	}
	
	@SuppressWarnings("null")
	public boolean handleTrading(CommandSender sender, String[] args){
		String answerTrade = null;
		Player player = (Player) sender;
		Player targetPlayer = Bukkit.getPlayerExact(args[0]);
		Inventory playerInv = player.getInventory();
		Inventory targetInv = targetPlayer.getInventory();
		ItemStack tradeItem = new ItemStack(player.getItemInHand());
		targetPlayer.sendMessage(""+ChatColor.YELLOW + player +"would like to trade "+ ChatColor.DARK_AQUA +tradeItem+ ChatColor.YELLOW +" with you."+ ChatColor.GREEN + "\n/accept to accept the trade."+ ChatColor.RED +"\n/decline to decline the trade."+ ChatColor.LIGHT_PURPLE +"\n/counter [price] to counter with a new price.");
		targetPlayer.acceptConversationInput(answerTrade);
			if(answerTrade.equalsIgnoreCase("/accept")){ //Player accepts trade
				targetInv.addItem(tradeItem);
				playerInv.remove(tradeItem);
				player.sendMessage(ChatColor.GREEN + "Trade Success!");
				targetPlayer.sendMessage(ChatColor.GREEN + "Trade Complete!");
			}else if(answerTrade.equalsIgnoreCase("/decline")){ //Player declines trade.
				player.sendMessage(ChatColor.RED + "Trade Declined!");
				targetPlayer.sendMessage(ChatColor.RED + "Trade Declined");
			}
		return true;
	}
	
	
	
}
