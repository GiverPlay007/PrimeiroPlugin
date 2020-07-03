package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ComandoGiverplay implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if(cmd.getName().equalsIgnoreCase("giverplay"))
    {
	  sender.sendMessage("§aBem vindo ao Rankup, primeiro servidor de nossa rede! Estamos felizes com sua presença :)");
      sender.sendMessage("§aA melhora do servidor depende de você, reportando bugs e hacks :D");
      sender.sendMessage("§aBom jogo, e boa diversão ;)");
	}
	return false;
  }
}
