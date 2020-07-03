package me.giverplay.MwRankup.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import me.giverplay.MwRankup.api.Constantes;

public class ComandoHabilitarPlugin implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if(cmd.getName().equalsIgnoreCase("habilitarplugin"))
    {
      if(sender.hasPermission("modernalworld.plugins"))
      {
    	if(args.length >= 1)
    	{
    	  Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(args[0]);
    	  if(pl == null)
    	  {
    	    sender.sendMessage(Constantes.plugin_nulo);
    	  }
    	  else if(pl.isEnabled() == true)
    	  {
    		sender.sendMessage("§cPlugin ja habilitado");
    	  }
    	  else
    	  {
    		Bukkit.getServer().getPluginManager().enablePlugin(pl);
    	    sender.sendMessage("§aPlugin §f" + pl.getName() + " §ahabilitado");
    	  }
    	}
    	else
    	{
    	  sender.sendMessage("§cUso: /habilitarplugin <pl>");
    	}
      }
      else
      {
    	sender.sendMessage(Constantes.sem_perm);
      }
    }
	return false;
  }
}
