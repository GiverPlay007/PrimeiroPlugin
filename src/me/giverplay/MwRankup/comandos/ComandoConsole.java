package me.giverplay.MwRankup.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.giverplay.MwRankup.api.API;
import me.giverplay.MwRankup.api.Mensagens;

public class ComandoConsole implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if(cmd.getName().equalsIgnoreCase("console"))
    {
	  if(!sender.hasPermission("modernalworld.console"))
	  {
		sender.sendMessage(Mensagens.sem_perm);
		return true;
	  }	  
      if(args.length < 1)
      {
		sender.sendMessage(Mensagens.console_uso);
	    return true;
      }
	  String nCmd = API.Construtor(args);
	  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), nCmd);
	  sender.sendMessage(Mensagens.console_executando.replaceAll("$c", nCmd));	     
    }
  return false;
  }
}
