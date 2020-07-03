package me.giverplay.MwRankup.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;
import me.giverplay.MwRankup.Main;
import me.giverplay.MwRankup.api.Constantes;

public class ListenerMagnata implements Listener
{
  @EventHandler
  public void onChat(ChatMessageEvent e)
  {
    if (e.getTags().contains("magnata") && e.getSender().getName().equals(Main.magnata))
    {
      e.setTagValue("magnata", Constantes.magnata_prefixo);
    }
  }
}
