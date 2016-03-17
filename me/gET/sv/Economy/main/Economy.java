package me.gET.sv.Economy.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Economy extends JavaPlugin{

	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	
	public static Plugin getPlugin(){
		return Bukkit.getServer().getPluginManager().getPlugin("EconomySystem");
	}
	
	public static int getMoney(Player p){
		if(getPlugin().getConfig().get(p.getUniqueId().toString()) != null){
			return getPlugin().getConfig().getInt(p.getUniqueId().toString());
		}
		return 0;
	}
	
	public static void setMoney(Player p, int i){
		getPlugin().getConfig().set(p.getUniqueId().toString(), i);
	}
	
}
