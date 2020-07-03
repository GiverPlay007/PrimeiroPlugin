package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.giverplay.MwRankup.api.API;
import me.giverplay.MwRankup.api.Constantes;

public class ComandoTraduzir implements CommandExecutor
{
  public static String TxtBdr(String[] args)
    {
	  StringBuilder sb = new StringBuilder();
	  for (int i = 0; i < args.length; i++)
	  {
	    sb.append(args[i]);
		sb.append(" ");
	  }
	  return sb.toString();
	}
  @Override
  public boolean onCommand(CommandSender quemEnviou, Command cmd, String label, String[] args)
  {	
	if(cmd.getName().equalsIgnoreCase("traduzir"))
	{
	  Player sender = (Player) quemEnviou;
	  if(sender.hasPermission("modernalworld.traduzir"))
	  {
	    if(args.length < 2)
	    {
	      sender.sendMessage("§b==== §fTradutor §b====");
	      sender.sendMessage("");
	      sender.sendMessage("§cUso:§a /traduzir <lang> <txt>");
	      sender.sendMessage("§cExemplo:§a /traduzir pt Hello World!");
	      sender.sendMessage("");
	      sender.sendMessage("§b==================");
	      return true;
	    }
	    if(args.length >= 2)
	    {
	      String idiomaIn = args[0];
	      args[0] = "";
	      String texto = TxtBdr(args);
	      
		  try 
		  {
			sender.sendMessage("§aTexto traduzido: §b" + API.pegarTraducao(idiomaIn, texto));
			return true;
		  }
		  catch (Exception e)
		  {
			sender.sendMessage("§cFalha ao traduzir, desculpe-nos pelo transtorno :(");
	    	sender.sendMessage("§cNao foi possivel estabelecer conexao ao servidor.");
	    	return true;
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
