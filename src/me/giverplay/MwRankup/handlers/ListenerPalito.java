package me.giverplay.MwRankup.handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.giverplay.MwRankup.api.Constantes;

public class ListenerPalito implements Listener
{
  @EventHandler
  public void aoBaterNoPlayerComUmDosPalitosEstePluginIraExecutarAsSeguintesFuncoes(PlayerInteractEntityEvent e)
  { 
    if (((e.getPlayer() instanceof Player)) && ((e.getRightClicked() instanceof Player)))
    {
      Player p = e.getPlayer();
      ItemStack item = p.getItemInHand();
      Player target = (Player)e.getRightClicked();
      if(p.hasPermission("modernalworld.palito.executar") && (item.getType() == Material.BLAZE_ROD))
      {
        if(item.getItemMeta().getDisplayName() == Constantes.palito_ban_nome)
        {
          p.chat("/palito executar ban " + target);
        }
        if(item.getItemMeta().getDisplayName() == Constantes.palito_tempban_nome)
        {
          p.chat("/palito executar tempban " + target);
        }
        if(item.getItemMeta().getDisplayName() == Constantes.palito_kick_nome)
        {
          p.chat("/palito executar kick " + target);
        }
      }
    }
  }
}