package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.giverplay.MwRankup.api.OpenMenu;
import me.giverplay.MwRankup.api.Mensagens;

public class ComandoArenas implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender cmdSender, Command cmd, String label, String[] args)
  {
	if(cmd.getName().equalsIgnoreCase("arenas"))
	{
	  if(!(cmdSender instanceof Player))
	  {
		cmdSender.sendMessage(Mensagens.console_sender);
		return true;
	  }
	  Player sender = (Player) cmdSender;
	  sender.openInventory(OpenMenu.arenasMenuAbrir());	
	}
	return false;
  }
}
