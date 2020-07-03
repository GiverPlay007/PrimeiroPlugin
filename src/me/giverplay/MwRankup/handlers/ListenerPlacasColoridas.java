package me.giverplay.MwRankup.handlers;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.giverplay.MwRankup.api.Constantes;

public class ListenerPlacasColoridas implements Listener
{
  @EventHandler(priority=EventPriority.HIGHEST)
  public void quandoPlayerFazerUmaPlacaChavosa(SignChangeEvent event)
  {
    if (event.getPlayer().hasPermission("modernalworld.placacolorida"))
    {
      String simbolo = "&";
      char[] formato = simbolo.toCharArray();
	  for (int i = 0; i <= 3; i++)
	  {
	   String line = event.getLine(i);
	   line = ChatColor.translateAlternateColorCodes(formato[0], line);
	   event.setLine(i, line);
	  }
	  event.getPlayer().sendMessage(Constantes.prefixo + "§aPlaca pintada!");
    }
  }
}
