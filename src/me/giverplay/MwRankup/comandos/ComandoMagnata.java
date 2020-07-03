package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.giverplay.MwRankup.Main;

public class ComandoMagnata implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("magnata"))
	{
	  sender.sendMessage("§2§lMagnata atual: §a§l" + Main.magnata);
	  return true;
	}
    return false;
  }
}
