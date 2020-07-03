package me.giverplay.MwRankup.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.giverplay.MwRankup.Main;
import me.giverplay.MwRankup.api.API;
import me.giverplay.MwRankup.api.Constantes;

public class ComandoPalito implements CommandExecutor
{
	public String pegarMotivo(Player p, String palito)
	{
		String nome = "motivo_" + palito + "_" + p.getName().toLowerCase();
		String config = Main.mtvs.getString(nome);
		return config;
	}
	public  void salvarMotivo(Player p, String motivo, String palito){
		String path = "motivo_" + palito + "_" + p.getName().toLowerCase();
		Main.mtvs.set(path, motivo);
		Main.mtvs.saveConfig();
		Main.mtvs.reloadConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender staff, Command cmd, String label, String[] args)
	{
		if(!(staff instanceof Player))
		{
			staff.sendMessage(Constantes.console_sender);	
			return true;
		}
		else
		{
			Player staffer = (Player) staff;
			if (cmd.getName().equalsIgnoreCase("palito"))
			{
				if(args.length == 0)
				{
					if(staffer.hasPermission("modernalworld.palito.info"))
					{
						staffer.sendMessage("§b==== §fPalito §b====");
						staffer.sendMessage("§a/palito motivo [palito][motivo] - §cMotivo do Palito");
						staffer.sendMessage("§a/palito executar <[ban, kick, tempban]> <jogador> - §cExecutar");
						staffer.sendMessage("§b================");
					}
					else
					{
						staffer.sendMessage("§b==== §fPalito §b====");
						staffer.sendMessage(Constantes.sem_perm);
						staffer.sendMessage("§aFeito por GiverPlay!");
						staffer.sendMessage("§b================");
					}
				}
				else
				{
					if(args[0].equalsIgnoreCase("motivo"))
					{
						if(staffer.hasPermission("modernalworld.palito.motivo"))
						{
							if(args.length == 0)
							{
								staffer.sendMessage("§aMotivos atuais:");
								staffer.sendMessage("§aBan: " + pegarMotivo(staffer, "ban"));
								staffer.sendMessage("§aTempBan: " + pegarMotivo(staffer, "tempban"));
								staffer.sendMessage("§aKick: " + pegarMotivo(staffer, "kick"));
								staffer.sendMessage("§cPara alterar: /palito motivo <ban|tempban|kick> <motivo>");
								staffer.sendMessage("§cTempBan padrao dura 1 hora!");
							}
							else
							{
								if(args[1].equalsIgnoreCase("ban"))
								{
									String str;
									str = API.Construtor(args);
									salvarMotivo(staffer, str, "ban");
									return true;
								}
								else if(args[1].equalsIgnoreCase("tempban"))
								{
									String str;
									str = API.Construtor(args);
									salvarMotivo(staffer, str, "tempban");
									return true;
								}
								else if(args[1].equalsIgnoreCase("kick"))
								{
									String str;
									str = API.Construtor(args);
									salvarMotivo(staffer, str, "kick");
									return true;
								}
								else
								{
									staffer.sendMessage(Constantes.prefixo + "§cNao existe esse palito, use [ban, kick, tempban]");
								}
							}
						}
						else
						{
							staffer.sendMessage(Constantes.sem_perm);;
						}
					}
					if(args[0].equalsIgnoreCase("executar"))
					{
						if(staffer.hasPermission("modernalworld.palito.executar"))
						{
							if(args.length == 0)
							{
								staffer.sendMessage(Constantes.prefixo + "§cEspecifique o palito!");
							}
							else
							{
								if(args.length == 0)
								{
									staffer.sendMessage(Constantes.prefixo + "§cEspecifique o jogador!");
								}
								else
								{
									if(args[1].equalsIgnoreCase("ban"))
									{
										staffer.chat("/ban " + args[2] + " " + pegarMotivo(staffer, "ban"));
									}
									if(args[1].equalsIgnoreCase("tempban"))
									{
										staffer.chat("/tempban " + args[2] + " 1 hour " + pegarMotivo(staffer, "tempban"));
									}
									if(args[1].equalsIgnoreCase("kick"))
									{
										staffer.chat("/kick " + args[2] + " " + pegarMotivo(staffer, "kick"));
									}
								}
							}
						}
						else
						{
							staffer.sendMessage(Constantes.sem_perm);
						}
					}
				}
			}
			return false;
		}
	}
}