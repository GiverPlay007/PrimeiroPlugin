package me.giverplay.MwRankup.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.giverplay.MwRankup.api.CashMethods;
import me.giverplay.MwRankup.api.Mensagens;

public class ComandoCash extends CashMethods implements CommandExecutor
{
  ArrayList<String> confirmar = new ArrayList<String>();
  HashMap<String, Integer> confirmar2 = new HashMap<String, Integer>();
  HashMap<String, String> confirmar3 = new HashMap<String, String>();
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
  {
	if(cmd.getName().equalsIgnoreCase("cash"))
	{
	  if(args.length == 0)
	  {
		if(sender instanceof Player)
		{
		  Player p = (Player) sender;
		  String s = String.valueOf(get(p.getName()));
		  p.sendMessage(Mensagens.cash_saldo.replaceAll("$s", s));
		  return true;
		}
	    else
	    {
		  sender.sendMessage(Mensagens.console_sender);
		  return true;
	    }
	  }
	  if(args.length >= 1)
	  {
		if(args[0].equalsIgnoreCase("set"))
		{
		  if(sender.hasPermission("modernalworld.cash"))
		  {
		    if(args.length < 3)
		    {
			  sender.sendMessage(Mensagens.cash_cmd_set);
			  return true;
		    }
		    
		    String target = String.valueOf(args[1]);
		    int quantia;
		    try
		    {
		      quantia = Integer.parseInt(args[0]);
		    }
		    catch(NumberFormatException e)
		    {
		      sender.sendMessage(Mensagens.cash_numero_invalido);
		      return true;
		    }
		    set(target, quantia);
		    sender.sendMessage(Mensagens.cash_setado.replaceAll("$p", target).replaceAll("$s", String.valueOf(quantia)));
		    return true;
		  }
		  else
		  {
			sender.sendMessage(Mensagens.sem_perm);
			return true;
		  }
		}
		
		if(args[0].equalsIgnoreCase("add"))
		{
		  if(sender.hasPermission("modernalworld.cash"))
		  {
	      if(args.length < 3)
	      {
		    sender.sendMessage(Mensagens.cash_cmd_add);
			return true;
		  }
			    
	      String target = String.valueOf(args[1]);
		  int quantia;
		  try
		  {
			quantia = Integer.parseInt(args[0]);
		  }
		  catch(NumberFormatException e)
		  {
			sender.sendMessage(Mensagens.cash_numero_invalido);
			return true;
		  }
		  add(target, quantia);
		  sender.sendMessage(Mensagens.cash_add.replaceAll("$s", String.valueOf(quantia)).replaceAll("$t", target));
		  return true;
		  }
		  else
	      {
			sender.sendMessage(Mensagens.sem_perm);
			return true;
		  }
		}
		  if(args[0].equalsIgnoreCase("remove"))
		  {
		    if(sender.hasPermission("modernalworld.cash"))
		    {
			if(args.length < 3)
			{
			  sender.sendMessage(Mensagens.cash_cmd_remove);
			  return true;
			}
			   
			String target = String.valueOf(args[1]);
			int quantia;
			try
			{
			  quantia = Integer.parseInt(args[0]);
		    }
		    catch(NumberFormatException e)
		    {
			  sender.sendMessage(Mensagens.cash_numero_invalido);
		      return true;
		    }
			remove(target, quantia);
			sender.sendMessage(Mensagens.cash_remove.replaceAll("$s", String.valueOf(quantia)).replaceAll("$t", target));
			return true;
		  }
		  else
		  {
			sender.sendMessage(Mensagens.sem_perm);
		    return true;
		  }
		}
	    if(args[0].equalsIgnoreCase("pay"))
	    {
		  if(sender instanceof Player)
		  {
			Player p = (Player) sender;
			if(args.length < 3)
			{
			  sender.sendMessage(Mensagens.cash_cmd_pay);
			  return true;
			}
			String target = String.valueOf(args[1]);
			if(!contains(target))
			{
			  p.sendMessage(Mensagens.jogador_nulo);
			  return true;
			}
			
			int quantia;
			try
			{
			  quantia = Integer.parseInt(args[2]);
			}
			catch(NumberFormatException e)
			{
			  sender.sendMessage(Mensagens.cash_numero_invalido);
			  return true;
			}
			int total = get(p.getName()) - quantia;
			if(total < 0)
			{
			  p.sendMessage(Mensagens.cash_saldo_insulficiente);
			  return true;
			}
			confirmar2.put(p.getName(), quantia);
			confirmar3.put(p.getName(), target);
			
			p.sendMessage(Mensagens.cash_confirmar.replaceAll("$t", target).replaceAll("$s", String.valueOf(quantia)));
			return true;		
		  }
		  else
		  {
			sender.sendMessage(Mensagens.console_sender);
			return true;
		  }
	    }
	    if(args[0].equalsIgnoreCase("confirmar"))
	    {
	      if(sender instanceof Player)
	      {
	    	if(confirmar.contains(sender.getName()))
	    	{
	    	  String p = sender.getName();
	    	  String alvo = confirmar3.get(p);
	    	  int qt = confirmar2.get(p);
	    	  
	    	  add(alvo, qt);
			  remove((p), qt);
			  
			  confirmar.remove(p);
			  confirmar2.remove(p);
			  confirmar3.remove(p);
				
			  sender.sendMessage(Mensagens.cash_enviou.replaceAll("$p", alvo).replaceAll("$s", String.valueOf(qt)));
				
			  Player rcv = Bukkit.getPlayerExact(alvo);
			  if(rcv != null && rcv.isOnline())
			  {
			    rcv.sendMessage(Mensagens.cash_recebeu.replaceAll("$p", p).replaceAll("$s", String.valueOf(qt)));
			  }
	    	}
	    	else
	    	{
	    	  sender.sendMessage(Mensagens.cash_nada_confirmar);
	    	  return true;
	    	}
	      }
	    }
	    return true;
	  }
	  String target = String.valueOf(args[0]);
	  if(!contains(target))
	  {
		sender.sendMessage(Mensagens.jogador_nulo);
		return true;
	  }
	  sender.sendMessage(Mensagens.cash_player_possui.replaceAll("$t", target).replaceAll("$s", String.valueOf(get(target))));
	}
    return false;   
  }
}
