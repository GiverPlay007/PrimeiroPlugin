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

public class ListenerWarps implements Listener
{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		InventoryView inventory = player.getOpenInventory();
		
		if(inventory.getTitle() == Constantes.warps_menu_nome)
		{
			event.setCancelled(true);
			
			if(clicked.getType() == Material.AIR || clicked.getType() == null || !(clicked.hasItemMeta()))
			{
				return;
			}
			if(clicked.getItemMeta().getDisplayName().equals(Constantes.bigornas_nome))
			{
				player.closeInventory();
				player.chat("/warp bigorna");
			}
			if(clicked.getItemMeta().getDisplayName().equals(Constantes.spawn_nome))
			{
				player.closeInventory();
				player.chat("/spawn");
			}
			if(clicked.getItemMeta().getDisplayName().equals(Constantes.terrenos_nome))
			{
				player.closeInventory();
				player.chat("/warp terrenos");
			}
			if(clicked.getItemMeta().getDisplayName().equals(Constantes.minas_menu_nome))
			{
				player.closeInventory();
				player.openInventory(OpenMenu.minasMenuAbrir());
			}
			if(clicked.getItemMeta().getDisplayName().equals(Constantes.pvp_menu_nome))
			{
				player.closeInventory();
				player.openInventory(OpenMenu.pvpMenuAbrir());
			}
			if(clicked.getItemMeta().getDisplayName().equals(Constantes.encantar_nome))
			{
				player.closeInventory();
				player.chat("/warp encantar");
			}
			if(clicked.getItemMeta().getDisplayName().equals(Constantes.loja_nome))
			{
				player.closeInventory();
				player.chat(Constantes.loja);
			}
			if(clicked.getItemMeta().getDisplayName().equals(Constantes.caixas_nome))
			{
				player.closeInventory();
				player.chat("/warp caixas");
			}
		}
	}
}
