package me.giverplay.MwRankup.comandos;

import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.giverplay.MwRankup.api.Mensagens;

public class ComandoAutosellall implements CommandExecutor
{
	ArrayList<String> turn = new ArrayList<String>();
	
	public boolean onCommand(CommandSender enviador, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("autosellall"))
		{
			if(!(enviador instanceof Player))
			{
				enviador.sendMessage(Mensagens.console_sender);
				return true;
			} 
			Player sender = (Player) enviador;
			if(!(sender.hasPermission("modernalworld.autosellall")))
			{
				sender.sendMessage(Mensagens.sem_perm);
			}
			if(this.turn.contains(sender.getName()))
			{
				sender.sendMessage(Mensagens.ja_ligado);
			}
			else
			{
				this.turn.add(sender.getName());
				sender.sendMessage(Mensagens.ligou);
				for(int i = 0; i < 512; i++)
				{
					sender.performCommand("sell all");
				}
				sender.sendMessage(Mensagens.desligou);
				this.turn.remove(sender.getName());
				return true;
			}  
		}
		return false;
	}
}