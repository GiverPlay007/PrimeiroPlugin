package me.giverplay.MwRankup.handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import me.giverplay.MwRankup.api.Constantes;
import me.giverplay.MwRankup.api.OpenMenu;

public class ListenerPVP implements Listener
{
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
    Player player = (Player) event.getWhoClicked();
	ItemStack clicked = event.getCurrentItem();
	InventoryView inventory = player.getOpenInventory();
	
	if(inventory.getTitle() == Constantes.pvp_menu_nome)
	{
	  event.setCancelled(true);
		
	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.arenas_menu_nome)
	  {
		player.closeInventory();
	    player.openInventory(OpenMenu.arenasMenuAbrir());
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.camarotes_menu_nome)
	  {
		player.closeInventory();
	    player.openInventory(OpenMenu.camarotesMenuAbrir());
	  }
	}
  }
}
