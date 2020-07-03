package me.giverplay.MwRankup.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.giverplay.MwRankup.api.Constantes;

public class ComandoGsudo implements CommandExecutor
{
  public static String Bdr(String[] args)
	{
	  StringBuilder sb = new StringBuilder();
	  for (int i = 0; i < args.length; i++)
	  {
		if(args[i] == "")
		{
		}
		else
		{
		  sb.append(args[i]);
	      sb.append(" ");
		}
	  }
	  return sb.toString();
	}
	
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	if(cmd.getName().equalsIgnoreCase("gsudo"))
	{
	  if(sender.hasPermission("modernalworld.gsudo"))
	  {
	    if(args.length < 2)
		{
		  sender.sendMessage("§cUso: /gsudo <jogador> <comandos>");
		  return true;
		}
		else
		{
		  Player alvo = Bukkit.getServer().getPlayer(args[0]);
		  if(alvo == null)
		  {
			sender.sendMessage(Constantes.jogador_nulo);
	   	  }
		  else
		  {
			String cmdN = Bdr(args);
			alvo.chat(cmdN.toString());
			sender.sendMessage("§aForçando §c" + alvo.getName() + " §aa digitar §c" + cmdN);
		  }
		}
	  }
	  else
	  {
	    sender.sendMessage(Constantes.sem_perm);
	    return true;
	  }
	}
  return false;
  }
}
