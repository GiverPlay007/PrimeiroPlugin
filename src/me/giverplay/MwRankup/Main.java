package me.giverplay.MwRankup;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.giverplay.MwRankup.api.CashConnect;
import me.giverplay.MwRankup.api.Config;
import me.giverplay.MwRankup.api.Constantes;
import net.milkbowl.vault.economy.Economy;
import me.giverplay.MwRankup.comandos.*;
import me.giverplay.MwRankup.handlers.*;

public class Main extends JavaPlugin
{
  public static Config mtvs;
  public static Config configs;
  public static Config msg;
  
  public static Economy economy;
  
  public static String mito;
  public static String magnata;
  
  public static Main main;

  @Override
  public void onEnable()
  {
	if(getServer().getPluginManager().getPlugin("Legendchat") == null ||
	   getServer().getPluginManager().getPlugin("Vault") == null)
	{
	  this.setEnabled(false);
	  return;
	}
	  
    Bukkit.getServer().getConsoleSender().sendMessage(Constantes.prefixo + "Iniciado");
    
    getCommand("palito").setExecutor(new ComandoPalito());
    getCommand("rec").setExecutor(new ComandoRec());
    getCommand("falar").setExecutor(new ComandoFalar());
    getCommand("ping").setExecutor(new ComandoPing());
    getCommand("autosellall").setExecutor(new ComandoAutosellall());
    getCommand("reparar").setExecutor(new ComandoReparar());
    getCommand("traduzir").setExecutor(new ComandoTraduzir());
    getCommand("giverplay").setExecutor(new ComandoGiverplay());
    getCommand("warps").setExecutor(new ComandoWarps());
    getCommand("minas").setExecutor(new ComandoMinas());
    getCommand("kits").setExecutor(new ComandoKits());
    getCommand("arenas").setExecutor(new ComandoArenas());
    getCommand("camarotes").setExecutor(new ComandoCamarotes());
    getCommand("desabilitarplugin").setExecutor(new ComandoDesabilitarPlugin());
    getCommand("habilitarplugin").setExecutor(new ComandoHabilitarPlugin());
    getCommand("gsudo").setExecutor(new ComandoGsudo());
    getCommand("console").setExecutor(new ComandoConsole());
    getCommand("op").setExecutor(new ComandoOpFix());
    getCommand("cargo").setExecutor(new ComandoCargo());
    getCommand("mito").setExecutor(new ComandoMito());
    getCommand("cash").setExecutor(new ComandoCash());
    getCommand("tpa").setExecutor(new ComandoTpa());
    getCommand("tpnegar").setExecutor(new ComandoTPNegar());
    getCommand("tpaceitar").setExecutor(new ComandoTPAceitar());
    getCommand("tpadesativar").setExecutor(new ComandoTpaDesativar());
    
    getServer().getPluginManager().registerEvents(new ListenerPalito(), this);
    getServer().getPluginManager().registerEvents(new ListenerRec(), this);
    getServer().getPluginManager().registerEvents(new ListenerChuva(), this);
    getServer().getPluginManager().registerEvents(new ListenerPlacasColoridas(), this);
    getServer().getPluginManager().registerEvents(new ListenerWarps(), this);
    getServer().getPluginManager().registerEvents(new ListenerKits(), this);
    getServer().getPluginManager().registerEvents(new ListenerArenas(), this);
    getServer().getPluginManager().registerEvents(new ListenerMinas(), this);
    getServer().getPluginManager().registerEvents(new ListenerCamarotes(), this);
    getServer().getPluginManager().registerEvents(new ListenerPVP(), this);  
    getServer().getPluginManager().registerEvents(new ListenerMito(), this);
    getServer().getPluginManager().registerEvents(new ListenerMagnata(), this);
    getServer().getPluginManager().registerEvents(new ListenerTpa(), this);
    getServer().getPluginManager().registerEvents(new ListenerCash(), this);
    
    setupEconomy();
    atualizarMagnata();
    CashConnect.open();
    CashConnect.createTable();
    
    mtvs = new Config("motivos");
    configs = new Config("configs");
    mtvs.saveDefaultConfig();
    configs.saveDefaultConfig();
    msg = new Config("mensagens");
    msg.saveDefaultConfig();
    
    mito = configs.getString("tags.mito");
    magnata = configs.getString("tags.magnata");
    
    main = this;
  }
  
  public void onDisable()
  {
    CashConnect.close();
  }
  
  private boolean setupEconomy()
  {
    RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
    if (economyProvider != null) 
    {
      economy = (Economy)economyProvider.getProvider();
    }
    return (economy != null);
  }
  
  private void atualizarMagnata()
  {
	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
	{
	  @SuppressWarnings("deprecation")
	public void run()
	  {
		for(OfflinePlayer player : Bukkit.getServer().getOfflinePlayers())
		{
		  if(economy.getBalance(player) > economy.getBalance(Bukkit.getOfflinePlayer(magnata)))
		  {
			magnata = player.getName();
			configs.set("tags.magnata", player.getName());
			configs.saveConfig();
			getServer().broadcastMessage("§2O novo magnata agora é: §a" + player.getName());
		  }
		}
	  }
	}, 0L, 1200L);
  }
}
