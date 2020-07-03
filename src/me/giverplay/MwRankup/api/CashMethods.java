package me.giverplay.MwRankup.api;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashMethods extends CashConnect
{
  public static ConsoleCommandSender sc = Bukkit.getConsoleSender();
  
  public static boolean contains(String player)
  {
	PreparedStatement stm = null;
	try
	{
	  stm = con.prepareStatement("SELECT * FROM `cash` WHERE `player` = ?");
	  stm.setString(1, player.toLowerCase());
	  ResultSet rs = stm.executeQuery();
	  while(rs.next())
	  {
		return true;
	  }
	  return true;
	}
	catch(SQLException e)
	{
	  return false;
	}
  }
  
  public static void setPlayer(String player)
  {
	PreparedStatement stm = null;
	try
	{
	  stm = con.prepareStatement("INSERT INTO `cash` (`player`, `quantia`) VALUES (?,?)");
	  stm.setString(1, player.toLowerCase());
	  stm.setInt(2, 0);
	  stm.executeUpdate();
	  sc.sendMessage(Mensagens.cash_jogador_criado.replaceAll("$p", player));
	} 
	catch (SQLException e)
	{
	  sc.sendMessage(Mensagens.cash_jogador_nao_criado);
	}
  }
  
  public static void set(String player, int quantia)
  {
	if(contains(player))
	{
	  PreparedStatement stm = null;	  
	  try
	  {
		stm = con.prepareStatement("UPDATE `cash` SET `quantia` = ? WHERE `player` = ?");
		stm.setInt(1, quantia);
		stm.setString(2, player.toLowerCase());
		stm.executeUpdate();
	  }
	  catch (SQLException e)
	  {
		sc.sendMessage(Mensagens.cash_nao_setado.replaceAll("$p", player));
	  }
	}
	else
	{
      setPlayer(player);
	}
  }
  
  public static int get(String player)
  {
	if(contains(player))
	{
	  PreparedStatement stm = null;
	  try
	  {
		stm = con.prepareStatement("SELECT * FROM `cash` WHERE `player` = ?");
		stm.setString(1, player.toLowerCase());
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
		  return rs.getInt("quantia");
		}
		return 0;
	  }
	  catch(SQLException e)
	  {
	    return 0;
	  }
	}
	else
	{
	  setPlayer(player);
	  return 0;
	}
  }
  
  public static void add(String player, int quantia)
  {
	if(contains(player))
	{
	 set(player, get(player) + quantia);
	}
	else
	{
	  setPlayer(player);
	  set(player, get(player) + quantia);
	}
  }
  
  public static void remove(String player, int quantia)
  {
	if(contains(player))
	{
	 set(player, get(player) - quantia);
	}
	else
	{
	  setPlayer(player);
	  set(player, get(player) - quantia);
	}
  }
}
