package me.giverplay.MwRankup.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;
import me.giverplay.MwRankup.Main;
import me.giverplay.MwRankup.api.Constantes;

public class ListenerMito implements Listener
{
  Plugin plugin = Main.getPlugin(Main.class);
  @EventHandler
  public void quandoFalar(ChatMessageEvent e)
  {
  if (e.getTags().contains("mito") && e.getSender().getName().equals(Main.mito))
    {
	  String tag = Constantes.mito_prefixo;
	  e.setTagValue("mito", tag);
    }
  }

  public void quandoMatar(PlayerDeathEvent e)
  {
    Player matou = e.getEntity().getKiller();
	Player morreu = e.getEntity();
	
	if(matou instanceof Player && morreu.getName() == Main.mito)
	{
	  matou.getWorld().playSound(matou.getLocation(), Sound.AMBIENCE_THUNDER, 20.0F, 1.0F);
	  Main.mito = matou.getName();
	  Main.configs.set("tags.mito", matou.getName());
	  Main.configs.saveConfig();
	  Main.configs.reloadConfig();
	  Bukkit.getServer().broadcastMessage("");
	  Bukkit.getServer().broadcastMessage("§b§lNovo mito: §f§n" + matou.getName());
	  Bukkit.getServer().broadcastMessage("");
	  
	  matou.sendMessage("§aVoce matou o mito, portanto se tornou o mito atual");
	  morreu.sendMessage("§cVoce morreu para " + matou.getName() + ", não é mais o mito :(");
	  
	  Main.economy.depositPlayer(matou, 15000);
	}
  }
}
