package me.giverplay.MwRankup.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.giverplay.MwRankup.Main;
import me.giverplay.MwRankup.api.Constantes;

public class ComandoMito implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender cmdSender, Command cmd, String label, String[] args)
  {
	if(cmd.getName().equalsIgnoreCase("mito"))
	{
	  if(cmdSender instanceof Player)
	  {
		Player sender = (Player) cmdSender;
		
		if(args.length < 1)
		{
		  sender.sendMessage("§aMito: §f" + Main.mito);
		}
		else
		{
		  if(sender.hasPermission("modernalworld.mito"))
		  {
			Player mt = Bukkit.getServer().getPlayer(args[0]);
			if(!(mt == null))
			{
			  Main.mito = mt.getName();
			  Main.configs.set("tags.mito", mt);
			  Main.configs.saveConfig();
			  Main.configs.reloadConfig();			  
			  Bukkit.getServer().broadcastMessage("\n§b§lNovo mito:\n§f§n" + mt.getName() + "\n");
			  mt.getWorld().playSound(mt.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F);
			}
			else
			{
			  sender.sendMessage(Constantes.jogador_nulo);
			}
		  }
		  else
		  {
			sender.sendMessage(Constantes.sem_perm);
			return true;
		  }
		}
 	  }
	  else
	  {
		cmdSender.sendMessage(Constantes.console_sender);
	  }
	}
	return false;
  }
}
