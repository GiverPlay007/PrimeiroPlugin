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

public class ListenerKits implements Listener
{
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
	Player player = (Player) event.getWhoClicked();
	ItemStack clicked = event.getCurrentItem();
	InventoryView inventory = player.getOpenInventory();
	
	if(inventory.getTitle() == Constantes.kits_menu_nome)
	{
	  event.setCancelled(true);
	  
	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.kits_rank_menu_nome)
	  {
		player.closeInventory();
	    player.openInventory(OpenMenu.kitsRanksMenuAbrir());
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.kits_vip_menu_nome)
	  {
		player.closeInventory();
		player.openInventory(OpenMenu.kitsVipsMenuAbrir());
	  }
	}
	
	if(inventory.getTitle() == Constantes.kits_rank_menu_nome)
	{
	  event.setCancelled(true);
		
	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_sobrevivente_nome)
      {
    	player.closeInventory();
    	player.chat("/kit sobrevivente");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_guerreiro_nome)
      {
    	player.closeInventory();
    	player.chat("/kit guerreiro");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_gladiador_nome)
      {
    	player.closeInventory();
    	player.chat("/kit gladiador");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_combatente_nome)
      {
    	player.closeInventory();
    	player.chat("/kit combatente");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_fuzileiro_nome)
      {
    	player.closeInventory();
    	player.chat("/kit fuzileiro");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_mercenario_nome)
      {
    	player.closeInventory();
    	player.chat("/kit mercenario");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_engenheiro_nome)
      {
    	player.closeInventory();
    	player.chat("/kit engenheiro");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_alquimista_nome)
      {
    	player.closeInventory();
    	player.chat("/kit alquimista");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_cientista_nome)
      {
    	player.closeInventory();
    	player.chat("/kit cientista");
      }
	}
	
	if(inventory.getTitle() == Constantes.kits_vip_menu_nome)
	{
	  event.setCancelled(true);
	  
	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  } 
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_nobre_nome)
      {
    	player.closeInventory();
    	player.chat("/kit nobre");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_rei_nome)
      {
    	player.closeInventory();
    	player.chat("/kit rei");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_imperador_nome)
      {
    	player.closeInventory();
    	player.chat("/kit imperador");
      }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_modernal_nome)
      {
    	player.closeInventory();
    	player.chat("/kit modernal");
      }
	}
  }
}
