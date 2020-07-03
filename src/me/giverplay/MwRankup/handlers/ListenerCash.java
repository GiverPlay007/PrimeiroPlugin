package me.giverplay.MwRankup.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.giverplay.MwRankup.api.CashMethods;

public class ListenerCash implements Listener
{
  @EventHandler
  void quandoEntrar(PlayerJoinEvent e)
  {
    if(!CashMethods.contains(e.getPlayer().getName()))
    {
      CashMethods.setPlayer(e.getPlayer().getName());
    }
  }
}
