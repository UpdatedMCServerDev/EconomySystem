package me.gET.sv.Economy.main;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class Listeners implements Listener{

	@EventHandler
	public void onPlayerKillMob(EntityDamageByEntityEvent e){
		if(!(e.getEntity() instanceof Zombie ||
		e.getEntity() instanceof Skeleton ||
		e.getEntity() instanceof Creeper)) return;
		if(!(e.getDamager() instanceof Player)) return;
		Player p = (Player) e.getDamager();
		if(((LivingEntity) e.getEntity()).getHealth() != 0) return;
		System.out.println("Foi");
		MoneyManager.giveMoney(p, 5);
	}
	
	@EventHandler
	public void onEntityDie(EntityDeathEvent e){
		if(!(e.getEntity() instanceof Zombie ||
		e.getEntity() instanceof Skeleton ||
		e.getEntity() instanceof Creeper)) return;
		System.out.println("Foi");
		MoneyManager.giveMoney(e.getEntity().getKiller(), 5);
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e){
		if (e.getPlayer().hasPlayedBefore()) return;
		Economy.getPlugin().getConfig().set(e.getPlayer().getUniqueId().toString(), 0);
	}
	
}
