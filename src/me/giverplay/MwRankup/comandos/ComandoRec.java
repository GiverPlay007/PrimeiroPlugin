package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.giverplay.MwRankup.api.OpenMenu;
import me.giverplay.MwRankup.api.Constantes;

public class ComandoRec implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender enviadorTop, Command cmd, String label, String[] args)
	{
		if(!(enviadorTop instanceof Player))
		{
			enviadorTop.sendMessage(Constantes.console_sender);
			return true;
		}
		
		Player sender = (Player) enviadorTop;
		
		if(!sender.hasPermission("modernalworld.rec"))
		{
			sender.sendMessage(Constantes.sem_perm);
			return true;
		}
		
		sender.openInventory(OpenMenu.recMainMenuAbrir());
		return true;
	}
}