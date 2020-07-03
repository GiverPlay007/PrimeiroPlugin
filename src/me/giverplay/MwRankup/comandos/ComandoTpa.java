package me.giverplay.MwRankup.comandos;

import java.util.HashMap;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.giverplay.MwRankup.Main;
import me.giverplay.MwRankup.api.Constantes;

public class ComandoTpa implements CommandExecutor
{

  public static HashMap<Player, Player> convites = new HashMap<Player, Player>();
  
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
      p.sendMessage("§cUtilize: /tpa <jogador>");
      return true;
    }
    Player alvo = Bukkit.getPlayer(args[0]);
    if (alvo == null)
    {
      p.sendMessage(Constantes.jogador_nulo);
      return true;
    }
    if (alvo.equals(p))
    {
      p.sendMessage("§cEste jogador pode ser voce.");
      return true;
    }
    if (alvo != null)
    {
      if(ComandoTpaDesativar.tpa.contains(p.getName()))
      {
    	p.sendMessage("§aTpa ativado novamente!");
    	ComandoTpaDesativar.tpa.remove(p.getName());
      }
      if(ComandoTpaDesativar.tpa.contains(alvo.getName()))
      {
    	p.sendMessage("§c§lOops! §7§lJogador com TPA desativado!");
    	return true;   
      }
      if (convites.containsKey(p))
      {
        p.sendMessage("§cVocê ja convidou alguem, espere um momento");
        return true;
      }
      convites.put(p, p);
      TextComponent texto = new TextComponent("§eO jogador §f " + p.getName() + " §epediu para teleportar-se até você.");
      TextComponent texto4 = new TextComponent("\n§eClique ");
      texto.addExtra(texto4);
      TextComponent texto2 = new TextComponent("§a§l§nAQUI");
      texto.addExtra(texto2);
      TextComponent texto5 = new TextComponent(" §epara aceitar");
      texto.addExtra(texto5);
      TextComponent texto6 = new TextComponent(" §eou clique ");
      texto.addExtra(texto6);
      TextComponent texto3 = new TextComponent("§c§l§nAQUI");
      texto.addExtra(texto3);
      TextComponent texto8 = new TextComponent(" §epara negar.");
      texto.addExtra(texto8);
      TextComponent texto7 = new TextComponent("\n§eO pedido de teleporte expira em §e§n120 segundos§r§e.");
      texto.addExtra(texto7);
      texto2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaceitar " + p.getName()));
      texto3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpnegar " + p.getName()));
      BaseComponent[] textos = new ComponentBuilder("§aCllique para aceitar.").create();
      HoverEvent passarMouse = new HoverEvent(HoverEvent.Action.SHOW_TEXT, textos);
      texto2.setHoverEvent(passarMouse);
      BaseComponent[] textos1 = new ComponentBuilder("§cCllique para negar.").create();
      HoverEvent passarMouse1 = new HoverEvent(HoverEvent.Action.SHOW_TEXT, textos1);
      texto3.setHoverEvent(passarMouse1);
      alvo.spigot().sendMessage(texto);
      p.sendMessage("§aVocê enviou um pedido de teleporte para §f" + alvo.getName());
      new BukkitRunnable()
      {
        public void run()
        {
          if (ComandoTpa.convites.containsKey(p))
          {
            ComandoTpa.convites.remove(p);
            p.sendMessage("§cPedido de teleporte expirado.");
          }
        }
      }.runTaskLaterAsynchronously(Main.main, 2400L);
      //aqui
    }
    return true;
  }
}