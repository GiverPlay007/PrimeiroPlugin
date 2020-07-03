package me.giverplay.MwRankup.comandos;


import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.giverplay.MwRankup.api.Constantes;
import me.giverplay.MwRankup.handlers.ListenerTpa;

public class ComandoTPAceitar implements CommandExecutor
{
  public static ArrayList<String> lista1 = ListenerTpa.lista;
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(Constantes.console_sender);
      return true;
    }
    final Player p = (Player)sender;
    if (!p.hasPermission("modernalworld.tpa"))
    {
      p.sendMessage(Constantes.sem_perm);
      return true;
    }
    if (args.length == 0)
    {
      p.sendMessage("§cUtilize: /tpaceitar <jogador>");
      return true;
    }
    final Player quemConvidou = Bukkit.getPlayer(args[0]);
    if (quemConvidou != null)
    {
      final HashMap<Player, Player> convites = ComandoTpa.convites;
      final ArrayList<String> lista = ListenerTpa.lista;
      if (!lista.contains(quemConvidou.getName()))
      {
        quemConvidou.sendMessage("§cTeleporte cancelado...");
        return true;
      }
      if (convites.containsKey(quemConvidou))
      {
        p.sendMessage("§aPedido de teleporte aceito.");
        quemConvidou.sendMessage("§eTeleportando...");
        lista1.add(p.getName());
        quemConvidou.teleport(p);
        lista.remove(p.getName());
        quemConvidou.sendMessage("§aPedido de teleporte aceito.");
        convites.remove(quemConvidou);
      }
      else if (lista1.contains(p.getName()))
      {
        p.sendMessage("§cVocê ja aceitou o convite.");
        return true;
      }
      return true;
    }
    return true;
  }
}
