package me.giverplay.MwRankup.handlers;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ListenerTpa implements Listener
{
  public static ArrayList<String> lista = new ArrayList<String>();
  
  @EventHandler
  public void mecher(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    lista.add(p.getName());
  }
}
