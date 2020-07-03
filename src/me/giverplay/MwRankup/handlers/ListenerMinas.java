package me.giverplay.MwRankup.handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import me.giverplay.MwRankup.api.Constantes;

public class ListenerMinas implements Listener
{
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
    Player player = (Player) event.getWhoClicked();
	ItemStack clicked = event.getCurrentItem();
	InventoryView inventory = player.getOpenInventory();
		
	if(inventory.getTitle() == Constantes.minas_menu_nome)
	{	
	  event.setCancelled(true);
		
   	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  }
      if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_sobrevivente_nome)
	  {
	    player.closeInventory();
		player.chat("/warp sobrevivente");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_guerreiro_nome)
	  {
		player.closeInventory();
		player.chat("/warp guerreiro");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_gladiador_nome)
	  {
		player.closeInventory();
		player.chat("/warp gladiador");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_combatente_nome)
	  {
		player.closeInventory();
		player.chat("/warp combatente");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_fuzileiro_nome)
	  {
		player.closeInventory();
		player.chat("/warp fuzileiro");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_mercenario_nome)
	  {
		player.closeInventory();
		player.chat("/warp mercenario");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_engenheiro_nome)
	  {
		player.closeInventory();
		player.chat("/warp engenheiro");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_alquimista_nome)
	  {
		player.closeInventory();
		player.chat("/warp alquimista");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_cientista_nome)
	  {
		player.closeInventory();
		player.chat("/warp cientista");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_nobre_nome)
	  {
		player.closeInventory();
		player.chat("/warp nobre");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_rei_nome)
	  {
		player.closeInventory();
		player.chat("/warp rei");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_imperador_nome)
	  {
		player.closeInventory();
		player.chat("/warp imperador");
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.grupo_modernal_nome)
	  {
		player.closeInventory();
		player.chat("/warp modernal");
	  }
	}
  }
}
