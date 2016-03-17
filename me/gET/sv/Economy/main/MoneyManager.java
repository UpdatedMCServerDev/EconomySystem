package me.gET.sv.Economy.main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MoneyManager {
	
	private static FileConfiguration config = Economy.getPlugin().getConfig();
	
	public static void giveMoney(Player p, int m){
		config.set(p.getUniqueId().toString(), config.getInt(p.getUniqueId().toString()) + m);
		Economy.getPlugin().saveConfig();
	}
	
	public static void removeMoney(Player p, int m){
		config.set(p.getUniqueId().toString(), config.getInt(p.getUniqueId().toString()) - m);
		Economy.getPlugin().saveConfig();
	}
	
	public static int getPlayerMoney(Player p){
		return config.getInt(p.getUniqueId().toString());
	}
}
