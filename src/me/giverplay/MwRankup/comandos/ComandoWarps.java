package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.giverplay.MwRankup.api.Constantes;
import me.giverplay.MwRankup.api.OpenMenu;

public class ComandoWarps implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender cmdSender, Command cmd, String label, String[] args)
  {
    if(cmd.getName().equalsIgnoreCase("warps"))
    {
      if(cmdSender instanceof Player)
      {
        Player sender = (Player) cmdSender;
		sender.openInventory(OpenMenu.warpsMenuAbrir());
      }
      else
      {
        cmdSender.sendMessage(Constantes.console_sender);
      }
	}
	return false;
  }
}
