package me.giverplay.MwRankup.handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import me.giverplay.MwRankup.api.Constantes;

public class ListenerCamarotes implements Listener
{
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
    Player player = (Player) event.getWhoClicked();
	ItemStack clicked = event.getCurrentItem();
	InventoryView inventory = player.getOpenInventory();
	
	if(inventory.getTitle() == Constantes.camarotes_menu_nome)
	{
	  event.setCancelled(true);
	  
	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  }
	  
	  if(clicked.getItemMeta().getDisplayName() == Constantes.x1_nome)
	  {
		player.closeInventory();
		player.chat(Constantes.x1_camarote);
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.killer_nome)
	  {
		player.closeInventory();
		player.chat(Constantes.killer_camarote);
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.fight_nome)
	  {
		player.closeInventory();
		player.chat(Constantes.fight_camarote);
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.chain_nome)
	  {
		player.closeInventory();
		player.chat(Constantes.chain_camarote);
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.gladiador_nome)
	  {
		player.closeInventory();
		player.chat(Constantes.gladiador_camarote);
	  }
	}
  }
}
