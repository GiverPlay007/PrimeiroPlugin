package me.giverplay.MwRankup.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class ListenerChuva
  implements Listener
{
  @EventHandler(priority=EventPriority.NORMAL)
  public void chuva(WeatherChangeEvent e)
  {
    if (e.toWeatherState())
    {
      e.setCancelled(true);
    }
  }
}