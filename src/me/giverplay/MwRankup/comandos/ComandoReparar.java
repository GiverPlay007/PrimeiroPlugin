package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import me.giverplay.MwRankup.api.Constantes;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ComandoReparar implements CommandExecutor
{
  public boolean onCommand(CommandSender cmdSender, Command cmd, String label, String[] args)
  {
    if(cmd.getName().equalsIgnoreCase("reparar"))
    {
      if(!(cmdSender instanceof Player))
      {
        cmdSender.sendMessage(Constantes.console_sender);
      }
      else
      {
    	Player sender = (Player) cmdSender;
        if(sender.hasPermission("modernalworld.reparar"))
        {
          ItemStack item = sender.getItemInHand();
          if(item.getType() == Material.AIR)
          {
            sender.sendMessage(Constantes.prefixo + "§cVoce quer arrumar vento?");
          }
          else
          {
            if(item.getDurability() == 0)
            {
              sender.sendMessage(Constantes.prefixo + "§cIsto nao precisar ser reparado");
            }
            else
            {
              item.setDurability((short)0);
              sender.sendMessage(Constantes.prefixo + "§aReparado!");
            }
          }
        }
        else
        {
          sender.sendMessage(Constantes.prefixo + Constantes.sem_perm);
        }
      }
    }
    return false;
  }
}
