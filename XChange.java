package com.adamstruthers.xchange;

import org.bukkit.plugin.java.JavaPlugin;

public class XChange extends JavaPlugin{
	
	public void onEnable(){
		getLogger().info("onEnable invoked!");
		
		XChangeCommandsExecutor cmds = new XChangeCommandsExecutor(this);
		getCommand("trade").setExecutor(cmds);
		//getCommand("accept").setExecutor(cmds);
		//getCommand("decline").setExecutor(cmds);
		//getCommand("counter").setExecutor(cmds);
	}
	
	public void onDisable(){
		getLogger().info("onDisable invoked!");
	}
	
}
