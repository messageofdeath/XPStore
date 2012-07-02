package me.messageofdeath.XPStore;

import me.messageofdeath.XPStore.API.Store;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class XPStore extends JavaPlugin {
	
	public static FileConfiguration config;
	public static XPStore plugin;
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		d();
		Store.prefix = "[" + pdfFile.getName() + "] v" + pdfFile.getVersion() + ": ";
		if(Store.getVerboseLogging() == true) {
			Store.log("enabling...");
			Store.log("Checking config...");
			Store.getFile().checkConfig();
			Store.log("registering commands...");
			Store.registerCommands();
			Store.log("registered commands!");
			Store.log("registering listeners...");
			Store.registerListeners();
			Store.log("registered listeners!");
			Store.log("is now enabled!");
		}else{
			Store.getFile().checkConfig();
			Store.registerCommands();
			Store.registerListeners();
			Store.log("is now enabled!");
		}
	}
	
	@Override
	public void onDisable() {
		Store.log("is now disabled!");
	}

	public void d() {
		config = getConfig();
		plugin = this;
	}
}