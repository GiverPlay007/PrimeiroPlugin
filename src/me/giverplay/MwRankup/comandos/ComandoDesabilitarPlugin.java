package me.giverplay.MwRankup.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import me.giverplay.MwRankup.api.Mensagens;

public class ComandoDesabilitarPlugin implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if(cmd.getName().equalsIgnoreCase("desabilitarplugin"))
	{
	  if(sender.hasPermission("modernalworld.plugins"))
	  {
	    if(args.length >= 1)
	    {
	      Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(args[0]);
	      if(pl == null)
	      {
	        sender.sendMessage(Mensagens.plugin_nulo);
	      }
	      else if(pl.isEnabled() == false)
	      {
	        sender.sendMessage("§cPlugin ja se encontra desabilitado");
	      }
	      else
	      {
	        Bukkit.getServer().getPluginManager().disablePlugin(pl);
	        sender.sendMessage("§aPlugin §f" + pl.getName() + " §adesabilitado.");
	      }
	    }
	    else
	    {
	      sender.sendMessage("§cUso: /desabilitarplugin <pl>");
	      return true;
	    }
	  }
	  else
	  {
	    sender.sendMessage(Mensagens.sem_perm);
	    return true;
	  }
	}
    return false;
  }
}