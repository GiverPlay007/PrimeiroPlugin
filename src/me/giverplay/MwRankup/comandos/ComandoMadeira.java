package me.giverplay.MwRankup.comandos;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class ComandoMadeira implements CommandExecutor
{
  int delay = 60;
  HashMap<String, Long> espera = new HashMap<String, Long>();
  @SuppressWarnings("deprecation")
@Override
  public boolean onCommand(CommandSender cmdSender, Command comando, String label, String[] argumentos)
  {
	if(comando.getName().equalsIgnoreCase("madeirah"))
	{
	  if(!(cmdSender instanceof Player))
	  {
		cmdSender.sendMessage("Console bobinho!");
		return ! false;
	  }
	  Player jogador = (Player) cmdSender;
	    if(espera.containsKey(jogador.getName())) // Se a espera conter o jogador
	    {
	      // Coeficiente para calcular o tempo restante
		  long restante = ((espera.get(jogador.getName()) / 1000) + delay) - (System.currentTimeMillis() / 1000);
		  if(restante > 0) // Se o tempo for maior que 0 segundos
		  {
			jogador.sendMessage("§cAguarde mais " + restante + " segundos!");
		  }
		  else
		  {

			int tanto;
			int resto;
			
			for(int i = 0; i <= 35; i++) // Para cada Slot do inv do jogador, que são 36 ao todo
			{
		      ItemStack itemEmQuestao = jogador.getInventory().getItem(i);
		      Material tipo = itemEmQuestao.getType();
		      
              if(tipo.equals(Material.WOOD))
              {
            	if(itemEmQuestao.getAmount() / 10 > 1)
			    {
			      resto = itemEmQuestao.getAmount() % 10; // Calcula o que vai sobrar de material
			      tanto = itemEmQuestao.getAmount() / 10; // Calcula o tanto de espadas
			    	
			      jogador.getInventory().remove(i); // Limpa o Item
			    	
			      jogador.getInventory().addItem(new ItemStack(Material.WOOD_SWORD, tanto)); // Add as espadas
			      jogador.getInventory().addItem(new ItemStack(Material.WOOD, resto)); // Add o que sobrou
			    }
              }
              if(tipo.equals(Material.COBBLESTONE))
              {
            	if(itemEmQuestao.getAmount() / 10 > 1)
				{
				  resto = itemEmQuestao.getAmount() % 10;
				  tanto = itemEmQuestao.getAmount() / 10;
				    
				  jogador.getInventory().remove(i);
				    
				  jogador.getInventory().addItem(new ItemStack(Material.STONE_SWORD, tanto));
				  jogador.getInventory().addItem(new ItemStack(Material.COBBLESTONE, resto));
				
			    }
              }
			}
			jogador.sendMessage("§aTransformado");
			espera.put(jogador.getName(), System.currentTimeMillis()); // Coloca o jogador na lista de espera
		  }
	    }		
	  }
	return false;
  }
}
