package me.giverplay.MwRankup.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.giverplay.MwRankup.api.API;
import me.giverplay.MwRankup.api.Constantes;

public class ComandoFalar implements CommandExecutor
{ 
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("falar"))
    {
      if (p.hasPermission("modernalworld.falar"))
      {
        if (args.length == 0)
        {
          p.sendMessage("§cUse: §7/falar mensagem");
          return true;
        }
        if (args.length > 0)
        {
          String mensagem = API.Construtor(args);
          Bukkit.broadcastMessage("§f[§b" + p.getName() + "§f]§e >> §b" + mensagem.replace("&", "§"));
        }
      }
      else
      {
        p.sendMessage(Constantes.sem_perm);
      }
    }
    return false;
  }
}