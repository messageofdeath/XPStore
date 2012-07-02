package me.messageofdeath.XPStore.API;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import me.messageofdeath.XPStore.XPStore;

public class Files {
	
	public XPStore plugin;
	public static File file = new File(Store.getPlugin().getDataFolder(), "database.yml");
	public Files(XPStore instance) {
		plugin = instance;
	}
	
	@SuppressWarnings("static-access")
	public File getFile() {
		return this.file;
	}
	
	public void checkConfig() {
		
	}
	
	@SuppressWarnings("null")
	public void addSign(int Type, String name, int x, int y, int z) throws FileNotFoundException, IOException, InvalidConfigurationException {
		FileConfiguration db = null;
		db.load(file);
		// Store sign
		if(Type == 1) {
			String x1 = String.valueOf(x); String y1 = String.valueOf(y); String z1 = String.valueOf(z);
			String saveplace = x1 + "," + y1 + "," + z1;
			db.set("Locations." + saveplace + ".name", name);
			db.set("Locations." + saveplace + ".type", 1);
		}
		// Bank sign
		if(Type == 2) {
			String x1 = String.valueOf(x); String y1 = String.valueOf(y); String z1 = String.valueOf(z);
			String saveplace = x1 + "," + y1 + "," + z1;
			db.set("Locations." + saveplace + ".name", name);
			db.set("Locations." + saveplace + ".type", 2);
		}
	}
}
