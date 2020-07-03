package me.giverplay.MwRankup.comandos;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.giverplay.MwRankup.api.Constantes;

public class ComandoTPNegar implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(Constantes.console_sender);
      return true;
    }
    Player p = (Player)sender;
    if (!p.hasPermission("modernalworld.tpa"))
    {
      p.sendMessage(Constantes.sem_perm);
      return true;
    }
    if (args.length == 0)
    {
      p.sendMessage("§cUtilize: /tpnegar <jogador>");
      return true;
    }
    Player alvo = Bukkit.getPlayer(args[0]);
    if (alvo != null)
    {
      HashMap<Player, Player> convites = ComandoTpa.convites;
      if (convites.containsKey(alvo))
      {
        convites.remove(alvo);
        p.sendMessage("§cPedido de teleporte recusado.");
        alvo.sendMessage("§cPedido de teleporte recusado.");
        return true;
      }
    }
    return true;
  }
}