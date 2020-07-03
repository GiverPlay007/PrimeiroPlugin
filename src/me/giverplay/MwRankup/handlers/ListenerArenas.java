package me.giverplay.MwRankup.handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import me.giverplay.MwRankup.api.Constantes;

public class ListenerArenas implements Listener
{
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
	Player player = (Player) event.getWhoClicked();
	ItemStack clicked = event.getCurrentItem();
	InventoryView inventory = player.getOpenInventory();
	
	if(inventory.getTitle() == Constantes.arenas_menu_nome)
	{
	  event.setCancelled(true);
	  
	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  }
	  
      if(clicked.getItemMeta().getDisplayName() == Constantes.chain_nome)
      {
    	player.closeInventory();
    	player.chat(Constantes.chain_entrar);
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.minapvp_nome)
      {
    	player.closeInventory();
    	player.chat("/warp minapvp");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.arenaforest_nome)
      {
    	player.closeInventory();
    	player.chat("/warp forest");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.arenafps_nome)
      {
    	player.closeInventory();
    	player.chat("/warp fps");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.arenaburaco_nome)
      {
    	player.closeInventory();
    	player.chat("/warp buraco");
      }
	}
  }
}
