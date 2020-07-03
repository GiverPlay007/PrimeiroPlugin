package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.giverplay.MwRankup.api.Mensagens;
import me.giverplay.MwRankup.api.OpenMenu;

public class ComandoCamarotes implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
	if(arg1.getName().equalsIgnoreCase("camarotes"))
	{
	  if(!(arg0 instanceof Player))
	  {
	    arg0.sendMessage(Mensagens.console_sender);	
	    return true;
	  }
	  Player arg0_2 = (Player) arg0;
	  arg0_2.openInventory(OpenMenu.camarotesMenuAbrir());
	}
	return false;
  }
}
