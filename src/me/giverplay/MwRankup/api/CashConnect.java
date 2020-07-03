package me.giverplay.MwRankup.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import me.giverplay.MwRankup.Main;

public class CashConnect
{
  protected static Connection con = null;
  public static ConsoleCommandSender cs = Bukkit.getConsoleSender();
  
  public static void open()
  {
	String url = "jdbc:mysql://" + Main.configs.getString("cash.sql") 
	                             + ":" + Main.configs.getString("cash.port")
	                             + "/" + Main.configs.getString("cash.db");
	String user = Main.configs.getString("cash.user");
	String pass = Main.configs.getString("cash.pass");
	
	try
	{
	  con = DriverManager.getConnection(url, user, pass);
	  cs.sendMessage(Mensagens.mysql_conectou);
	}
	catch (SQLException e)
	{
	  cs.sendMessage(Mensagens.mysql_nao_conectou);
	}
  }
  
  public static void close()
  {
	if(con != null)
	{
      try
      {
    	con.close();
    	cs.sendMessage(Mensagens.mysql_conexao_fechada);
      }
      catch(SQLException e)
      {
    	cs.sendMessage(Mensagens.mysql_conexao_nao_fecha);
      }
	}
  }
  
  public static void createTable()
  {
	if(con != null)
	{
	  PreparedStatement stm = null;
	  try
	  {
		stm = con.prepareStatement("CREATE TABLE IF NOT EXISTS `cash` (`id` INT NOT NULL AUTO_INCREMENT,`player` VARCHAR(24) NULL,`quantia` DOUBLE NULL,PRIMARY KEY (`id`));");
		stm.executeUpdate();
		cs.sendMessage(Mensagens.mysql_tabela_c);
	  }
	  catch(SQLException e)
	  {
		cs.sendMessage(Mensagens.mysql_tabela_n);
	  }
	}
  }
}
