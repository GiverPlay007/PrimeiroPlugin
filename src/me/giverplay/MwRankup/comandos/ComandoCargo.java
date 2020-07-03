package me.giverplay.MwRankup.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.giverplay.MwRankup.api.Mensagens;

public class ComandoCargo implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
  if(cmd.getName().equalsIgnoreCase("cargo"))
  {
    if(!sender.hasPermission("modernalworld.cargo"))
    {
	  sender.sendMessage(Mensagens.sem_perm);
	  return true;
    }
    if(args.length < 2)
	{
	  sender.sendMessage(Mensagens.cargo_uso);
	  sender.sendMessage(Mensagens.cargo_exemplo);
	  return true;
	}	
	  if(args[0] == "set")
	  {
		Player p = Bukkit.getPlayer(args[1]);
		if(p == null)
		{
		  sender.sendMessage(Mensagens.jogador_nulo);
		  return true;
		}		
  	    if(args[2].equalsIgnoreCase("Ajudante"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group set Ajudante");
		}
		else if(args[2].equalsIgnoreCase("Moderador"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group set Moderador");
		}
		else if(args[2].equalsIgnoreCase("ModPlus"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group set ModPlus");
	    }
		else if(args[2].equalsIgnoreCase("Admin"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group set Admin");		    
		}
		else if(args[2].equalsIgnoreCase("Gerente"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group set Gerente");
		}
		else
	    {
		  sender.sendMessage(Mensagens.cargo_nao_encontrado);
		  sender.sendMessage(Mensagens.cargo_listagem);
	      return true;
	    }		
	  }
	  if(args[0] == "add")
	  {
		Player p = Bukkit.getPlayer(args[1]);
		if(p == null)
		{
		  sender.sendMessage(Mensagens.jogador_nulo);
		  return true;
		}		
		if(args[2].equalsIgnoreCase("Ajudante"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group add Ajudante");
		}
		  else if(args[2].equalsIgnoreCase("Moderador"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group add Moderador");
		}
		else if(args[2].equalsIgnoreCase("ModPlus"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group add ModPlus");
		}
		else if(args[2].equalsIgnoreCase("Admin"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group add Admin");
	    }
		else if(args[2].equalsIgnoreCase("Gerente"))
		{
	      Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group add Gerente");
		}
		else
		{
	      sender.sendMessage(Mensagens.cargo_nao_encontrado);
		  sender.sendMessage(Mensagens.cargo_listagem);
          return true;
		}	
	  }
	  if(args[0] == "remove")
	  {
	    Player p = Bukkit.getPlayer(args[1]);
	    if(p == null)
		{
		  sender.sendMessage(Mensagens.jogador_nulo);
		  return true;
		}
		if(args[2].equalsIgnoreCase("Ajudante"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group remove Ajudante");
		}
	    else if(args[2].equalsIgnoreCase("Moderador"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group remove Moderador");
		}
		else if(args[2].equalsIgnoreCase("ModPlus"))
	    {
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group remove ModPlus");
		}
		else if(args[2].equalsIgnoreCase("Admin"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group remove Admin");
		}
		else if(args[2].equalsIgnoreCase("Gerente"))
		{
		  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " group remove Gerente");
		}
		else
		{
	      sender.sendMessage(Mensagens.cargo_nao_encontrado);
	      sender.sendMessage(Mensagens.cargo_listagem);
		  return true;
		}
	  }	  
	}
    return false;
  }
}
