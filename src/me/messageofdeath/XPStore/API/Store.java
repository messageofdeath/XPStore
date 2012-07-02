package me.messageofdeath.XPStore.API;

import me.messageofdeath.XPStore.XPStore;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class Store {
	
	public static XPStore plugin;
	public static FileConfiguration config;
	public Store(XPStore instance) {
		plugin = instance;
		config = instance.getConfig();
	}
	
	public static String prefix;
	
	public static void log(String log) {Bukkit.getLogger().info(Store.loggerPrefix() + log);}
	
	public static String loggerPrefix() {return prefix;}
	
	@SuppressWarnings("static-access")
	public static FileConfiguration getConfig() {return plugin.config;}
	
	public static XPStore getPlugin() {return plugin;}
	
	public static boolean getVerboseLogging() {return Store.getConfig().getBoolean("Plugin.VerboseLogging");}
	
	public static boolean getEnabled() {return Store.getConfig().getBoolean("Plugin.Enabled");}
	
	public static Files getFile() {return new Files(plugin);}
	
	public static void registerCommands() {}
	
	public static void registerListeners() {}
}
