package me.giverplay.MwRankup.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.giverplay.MwRankup.api.Constantes;

public class ComandoPing
  implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ping"))
    {
      int ping = ((CraftPlayer)p).getHandle().ping;
      if (args.length == 0)
      {
        p.sendMessage(Constantes.prefixo +"§bSeu Ping: §f" + ping + " §fms.");
      }
      else if (p.getServer().getPlayer(args[0]) != null)
      {
        String p2 = args[0];
        Player target = Bukkit.getServer().getPlayer(args[0]);
        int ping2 = ((CraftPlayer)target).getHandle().ping;
        p.sendMessage(Constantes.prefixo + "§bO ping de §f" + p2 + " §b: §f" + ping2 + " §fms.");
      }
      else
      {
        p.sendMessage(Constantes.prefixo + Constantes.jogador_nulo);
      }
    }
    return false;
  }
}
