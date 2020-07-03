package me.giverplay.MwRankup.comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.giverplay.MwRankup.api.Constantes;

public class ComandoTpaDesativar implements CommandExecutor
{
  public static ArrayList<String> tpa = new ArrayList<String>();
  
  @Override
  public boolean onCommand(CommandSender cmdSender, Command cmd, String arg2, String[] args)
  {
	if(cmd.getName().equalsIgnoreCase("tpadesativar"))
	{
	  if(!(cmdSender instanceof Player))
	  {
		cmdSender.sendMessage(Constantes.console_sender);
		return true;  
	  }
	  Player sender = (Player) cmdSender;
	  
	  if(!(sender.hasPermission("modernalworld.tpa")))
	  {
		sender.sendMessage(Constantes.sem_perm);
		return true;
	  }
	  if(tpa.contains(sender.getName()))
	  {
		tpa.remove(sender.getName());
		sender.sendMessage("§aTpa ativo novamente!");
	  }
	  else
	  {
		tpa.add(sender.getName());
		sender.sendMessage("§cTpa desativado!");
	  }
	}
	return false;
  }
}
