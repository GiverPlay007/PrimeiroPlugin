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
import me.giverplay.MwRankup.api.StackCreator;

public class ListenerRec implements Listener
{
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
	Player player = (Player) event.getWhoClicked();
	ItemStack clicked = event.getCurrentItem();
	InventoryView inventory = player.getOpenInventory();
	
	if (inventory.getTitle().equals(Constantes.rec_main_menu_nome)) 
	{
	  event.setCancelled(true);
		
	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  }
	  if(clicked.getItemMeta().getDisplayName() == Constantes.rec_palito_menu_nome)
	  {
		if(player.hasPermission("modernalworld.rec.palito")){
		  player.closeInventory();
	      player.openInventory(OpenMenu.recPalitoMenuAbrir());
		}
		else{
		  player.closeInventory();
		  player.sendMessage(Constantes.sem_perm);
		}
      }
	}
	if (inventory.getTitle().equals(Constantes.rec_palito_menu_nome))
	{
	  event.setCancelled(true);
	  
	  if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
	  {
		return;
	  }
	  
	  if(clicked.getType() == Material.BLAZE_ROD)
	  {
	    if(clicked.getItemMeta().getDisplayName() == Constantes.palito_ban_nome)
	    {
	      ItemStack palito = StackCreator.add(Material.BLAZE_ROD, Constantes.palito_ban_nome);
	      player.closeInventory();
	      player.getInventory().addItem(palito);
	      player.sendMessage("§aRecebido Palito do Ban");
	    }
	    if(clicked.getItemMeta().getDisplayName() == Constantes.palito_tempban_nome)
	    {
	      ItemStack palito = StackCreator.add(Material.BLAZE_ROD, Constantes.palito_tempban_nome);
	      player.closeInventory();
		  player.getInventory().addItem(palito);
		  player.sendMessage("§aRecebido Palito do TempBan");
	    }
	    if(clicked.getItemMeta().getDisplayName() == Constantes.palito_kick_nome)
	    {
	      ItemStack palito = StackCreator.add(Material.BLAZE_ROD, Constantes.palito_kick_nome);
	      player.closeInventory();
		  player.getInventory().addItem(palito);
		  player.sendMessage("§aRecebido Palito do Kick");
	    }
	  }
	}
  }
}