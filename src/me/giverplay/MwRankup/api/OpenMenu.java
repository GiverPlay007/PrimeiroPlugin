package me.giverplay.MwRankup.api;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class OpenMenu extends JavaPlugin
{
	
  public static Inventory recMainMenuAbrir()
  {
	  Inventory recMainMenu = Bukkit.createInventory(null, 54, Constantes.rec_main_menu_nome);
	  
      ItemStack palitos = StackCreator.add(Material.BLAZE_ROD, Constantes.rec_palito_menu_nome);      
      ItemStack vidro = StackCreator.add(Material.STAINED_GLASS_PANE, "§b|", 15);
      
      recMainMenu.setItem(0, vidro);
      recMainMenu.setItem(1, vidro);
      recMainMenu.setItem(2, vidro);
      recMainMenu.setItem(3, vidro);
      recMainMenu.setItem(4, vidro);
      recMainMenu.setItem(5, vidro);
      recMainMenu.setItem(6, vidro);
      recMainMenu.setItem(7, vidro);
      recMainMenu.setItem(8, vidro);
      recMainMenu.setItem(9, vidro);
      recMainMenu.setItem(10, vidro);
      recMainMenu.setItem(16, vidro);
      recMainMenu.setItem(17, vidro);
      recMainMenu.setItem(18, vidro);
      recMainMenu.setItem(26, vidro);
      recMainMenu.setItem(27, vidro);
      recMainMenu.setItem(35, vidro);
      recMainMenu.setItem(36, vidro);
      recMainMenu.setItem(37, vidro);
      recMainMenu.setItem(43, vidro);
      recMainMenu.setItem(44, vidro);
      recMainMenu.setItem(45, vidro);
      recMainMenu.setItem(46, vidro);
      recMainMenu.setItem(47, vidro);
      recMainMenu.setItem(48, vidro);
      recMainMenu.setItem(49, vidro);
      recMainMenu.setItem(50, vidro);
      recMainMenu.setItem(51, vidro);
      recMainMenu.setItem(52, vidro);
      recMainMenu.setItem(53, vidro);
      
      recMainMenu.setItem(13, palitos);
      
      return recMainMenu;
    }
  public static Inventory recPalitoMenuAbrir()
  {
	Inventory recPalitoMenu = Bukkit.createInventory(null, 27, Constantes.rec_palito_menu_nome);
	  
    ItemStack palitoban = StackCreator.add(Material.BLAZE_ROD, Constantes.palito_ban_nome);
    ItemStack palitotempban = StackCreator.add(Material.BLAZE_ROD, Constantes.palito_tempban_nome);
    ItemStack palitokick = StackCreator.add(Material.BLAZE_ROD, Constantes.palito_kick_nome);
    ItemStack vidro = StackCreator.add(Material.STAINED_GLASS_PANE, "§b|", 15);
    
    recPalitoMenu.setItem(0, vidro);
    recPalitoMenu.setItem(1, vidro);
    recPalitoMenu.setItem(2, vidro);
    recPalitoMenu.setItem(3, vidro);
    recPalitoMenu.setItem(4, vidro);
    recPalitoMenu.setItem(5, vidro);
    recPalitoMenu.setItem(6, vidro);
    recPalitoMenu.setItem(7, vidro);
    recPalitoMenu.setItem(8, vidro);
    recPalitoMenu.setItem(9, vidro);
    recPalitoMenu.setItem(17, vidro);
    recPalitoMenu.setItem(18, vidro);
    recPalitoMenu.setItem(19, vidro);
    recPalitoMenu.setItem(20, vidro);
    recPalitoMenu.setItem(21, vidro);
    recPalitoMenu.setItem(22, vidro);
    recPalitoMenu.setItem(23, vidro);
    recPalitoMenu.setItem(24, vidro);
    recPalitoMenu.setItem(25, vidro);
    recPalitoMenu.setItem(26, vidro);
    
    recPalitoMenu.setItem(12, palitoban);
    recPalitoMenu.setItem(13, palitotempban);
    recPalitoMenu.setItem(14, palitokick);
    
    return recPalitoMenu;
  }
  public static Inventory warpsMenuAbrir()
  {
	Inventory warpsMenu = Bukkit.createInventory(null, 54, Constantes.warps_menu_nome);
	  
	ItemStack grade = StackCreator.add(Material.STAINED_GLASS_PANE, "§b-", 15);
	ItemStack minas = StackCreator.add(Material.DIAMOND_PICKAXE, Constantes.minas_menu_nome);
	ItemStack bigornas = StackCreator.add(Material.ANVIL, Constantes.bigornas_nome);
	ItemStack terrenos = StackCreator.add(Material.GRASS, Constantes.terrenos_nome);
	ItemStack spawn = StackCreator.add(Material.BEACON, Constantes.spawn_nome);
	ItemStack pvp = StackCreator.add(Material.DIAMOND_SWORD, Constantes.pvp_menu_nome);
	ItemStack encantar = StackCreator.add(Material.ENCHANTMENT_TABLE, Constantes.encantar_nome);
	ItemStack loja = StackCreator.add(Material.EMERALD, Constantes.loja_nome);
	ItemStack caixas = StackCreator.add(Material.CHEST, Constantes.caixas_nome);
	
	warpsMenu.setItem(0, grade);
	warpsMenu.setItem(1, grade);
	warpsMenu.setItem(2, grade);
	warpsMenu.setItem(3, grade);
	warpsMenu.setItem(4, grade);
	warpsMenu.setItem(5, grade);
	warpsMenu.setItem(6, grade);
	warpsMenu.setItem(7, grade);
	warpsMenu.setItem(8, grade);
	warpsMenu.setItem(9, grade);
	warpsMenu.setItem(17, grade);
	warpsMenu.setItem(18, grade);
	warpsMenu.setItem(26, grade);
	warpsMenu.setItem(27, grade);
	warpsMenu.setItem(35, grade);
	warpsMenu.setItem(36, grade);
	warpsMenu.setItem(44, grade);
	warpsMenu.setItem(45, grade);
	warpsMenu.setItem(46, grade);
	warpsMenu.setItem(47, grade);
	warpsMenu.setItem(48, grade);
	warpsMenu.setItem(49, grade);
	warpsMenu.setItem(50, grade);
	warpsMenu.setItem(51, grade);
	warpsMenu.setItem(52, grade);
	warpsMenu.setItem(53, grade);
	
	warpsMenu.setItem(13, spawn);
	warpsMenu.setItem(21, pvp);
	warpsMenu.setItem(23, minas);
	warpsMenu.setItem(29, bigornas);
	warpsMenu.setItem(31, terrenos);
	warpsMenu.setItem(33, encantar);
	warpsMenu.setItem(39, caixas);
	warpsMenu.setItem(41, loja);
	
	return warpsMenu;
  }
  public static Inventory minasMenuAbrir()
  {
	Inventory minasMenu = Bukkit.createInventory(null, 45, Constantes.minas_menu_nome);
	
	ItemStack vidro = StackCreator.add(Material.STAINED_GLASS_PANE, "§b|", 15);
	ItemStack sobrevivente = StackCreator.add(Material.DIRT, Constantes.grupo_sobrevivente_nome);
	ItemStack guerreiro = StackCreator.add(Material.STONE, Constantes.grupo_guerreiro_nome);
	ItemStack gladiador = StackCreator.add(Material.ENDER_STONE, Constantes.grupo_gladiador_nome);
	ItemStack combatente = StackCreator.add(Material.COAL_ORE, Constantes.grupo_combatente_nome);
	ItemStack fuzileiro = StackCreator.add(Material.LAPIS_ORE, Constantes.grupo_fuzileiro_nome);
	ItemStack mercenario = StackCreator.add(Material.IRON_ORE, Constantes.grupo_mercenario_nome);
	ItemStack engenheiro = StackCreator.add(Material.GOLD_ORE, Constantes.grupo_engenheiro_nome);
	ItemStack alquimista = StackCreator.add(Material.DIAMOND_ORE, Constantes.grupo_alquimista_nome);
	ItemStack cientista = StackCreator.add(Material.EMERALD_ORE, Constantes.grupo_cientista_nome);
	ItemStack nobre = StackCreator.add(Material.IRON_BLOCK, Constantes.grupo_nobre_nome);
	ItemStack rei = StackCreator.add(Material.GOLD_BLOCK, Constantes.grupo_rei_nome);
	ItemStack imperador = StackCreator.add(Material.DIAMOND_BLOCK, Constantes.grupo_imperador_nome);
	ItemStack modernal = StackCreator.add(Material.EMERALD_BLOCK, Constantes.grupo_modernal_nome);
	
	minasMenu.setItem(10, sobrevivente);
	minasMenu.setItem(11, guerreiro);
	minasMenu.setItem(12, gladiador);
	minasMenu.setItem(19, combatente);
	minasMenu.setItem(20, fuzileiro);
	minasMenu.setItem(21, mercenario);
	minasMenu.setItem(28, engenheiro);
	minasMenu.setItem(29, alquimista);
	minasMenu.setItem(30, cientista);
	minasMenu.setItem(15, nobre);
	minasMenu.setItem(23, rei);
	minasMenu.setItem(25, imperador);
	minasMenu.setItem(33, modernal);
	
	minasMenu.setItem(0, vidro);
	minasMenu.setItem(1, vidro);
	minasMenu.setItem(2, vidro);
	minasMenu.setItem(3, vidro);
	minasMenu.setItem(4, vidro);
	minasMenu.setItem(5, vidro);
	minasMenu.setItem(6, vidro);
	minasMenu.setItem(7, vidro);
	minasMenu.setItem(8, vidro);
	minasMenu.setItem(9, vidro);
	minasMenu.setItem(17, vidro);
	minasMenu.setItem(18, vidro);
	minasMenu.setItem(26, vidro);
	minasMenu.setItem(27, vidro);
	minasMenu.setItem(35, vidro);
	minasMenu.setItem(36, vidro);
	minasMenu.setItem(37, vidro);
	minasMenu.setItem(38, vidro);
	minasMenu.setItem(39, vidro);
	minasMenu.setItem(40, vidro);
	minasMenu.setItem(41, vidro);
	minasMenu.setItem(42, vidro);
	minasMenu.setItem(43, vidro);
	minasMenu.setItem(44, vidro);
	
	return minasMenu;
  }
  public static Inventory arenasMenuAbrir()
  {
	Inventory arenasMenu = Bukkit.createInventory(null, 9, Constantes.arenas_menu_nome);
	
	ItemStack chain = StackCreator.add(Material.IRON_BARDING, Constantes.chain_nome);
	ItemStack minapvp = StackCreator.add(Material.DIAMOND_SWORD, Constantes.minapvp_nome);
	ItemStack fps = StackCreator.add(Material.DIAMOND_SWORD, Constantes.arenafps_nome);
	ItemStack buraco = StackCreator.add(Material.CLAY_BRICK, Constantes.arenaburaco_nome);
	ItemStack forest = StackCreator.add(Material.VINE, Constantes.arenaforest_nome);
	
	arenasMenu.setItem(0, chain);
	arenasMenu.setItem(2, minapvp);
	arenasMenu.setItem(4, forest);
	arenasMenu.setItem(6, fps);
	arenasMenu.setItem(8, buraco);
	
	return arenasMenu;
  }
  public static Inventory camarotesMenuAbrir()
  {
	Inventory camarotesMenu = Bukkit.createInventory(null, 9, Constantes.camarotes_menu_nome);
	  
	ItemStack x1 = StackCreator.add(Material.GOLDEN_APPLE, Constantes.x1_nome);
	ItemStack fight = StackCreator.add(Material.IRON_SWORD, Constantes.fight_nome);
	ItemStack glad = StackCreator.add(Material.DIAMOND_SWORD, Constantes.gladiador_nome);
	ItemStack killer = StackCreator.add(Material.DIAMOND_SWORD, Constantes.killer_nome);
	ItemStack chain = StackCreator.add(Material.IRON_BARDING, Constantes.chain_nome);
	
	camarotesMenu.setItem(0, glad);
	camarotesMenu.setItem(2, x1);
	camarotesMenu.setItem(4, fight);
	camarotesMenu.setItem(6, chain);
	camarotesMenu.setItem(8, killer);
	
	return camarotesMenu;  
  }
  public static Inventory pvpMenuAbrir()
  {
	Inventory pvpMenu = Bukkit.createInventory(null, 9, Constantes.pvp_menu_nome);
	
	ItemStack arenas = StackCreator.add(Material.DIAMOND_SWORD, Constantes.arenas_menu_nome);
	ItemStack camarotes = StackCreator.add(Material.WOOD_STAIRS, Constantes.camarotes_menu_nome);
	
	pvpMenu.setItem(3, arenas);
	pvpMenu.setItem(5, camarotes);
	
	return pvpMenu;
  }
  public static Inventory kitsMainMenuAbrir()
  {
	Inventory kitsMenu = Bukkit.createInventory(null,  45, Constantes.kits_menu_nome);
	
	ItemStack vidro = StackCreator.add(Material.STAINED_GLASS_PANE, "§b|", 15);
	ItemStack ranks = StackCreator.add(Material.DIAMOND_PICKAXE, Constantes.kits_rank_menu_nome);
	ItemStack vips = StackCreator.add(Material.DIAMOND, Constantes.kits_vip_menu_nome);
	
	kitsMenu.setItem(21, ranks);
	kitsMenu.setItem(23, vips);
	
	kitsMenu.setItem(0, vidro);
	kitsMenu.setItem(1, vidro);
	kitsMenu.setItem(2, vidro);
	kitsMenu.setItem(3, vidro);
	kitsMenu.setItem(4, vidro);
	kitsMenu.setItem(5, vidro);
	kitsMenu.setItem(6, vidro);
	kitsMenu.setItem(7, vidro);
	kitsMenu.setItem(8, vidro);
	kitsMenu.setItem(9, vidro);
	kitsMenu.setItem(17, vidro);
	kitsMenu.setItem(18, vidro);
	kitsMenu.setItem(26, vidro);
	kitsMenu.setItem(27, vidro);
	kitsMenu.setItem(35, vidro);
	kitsMenu.setItem(36, vidro);
	kitsMenu.setItem(37, vidro);
	kitsMenu.setItem(38, vidro);
	kitsMenu.setItem(39, vidro);
	kitsMenu.setItem(40, vidro);
	kitsMenu.setItem(41, vidro);
	kitsMenu.setItem(42, vidro);
	kitsMenu.setItem(43, vidro);
	kitsMenu.setItem(44, vidro);
	  
	return kitsMenu;
  }
  public static Inventory kitsRanksMenuAbrir()
  {
    Inventory kitsRanksMenu = Bukkit.createInventory(null, 45, Constantes.kits_rank_menu_nome);
    
    ItemStack vidro = StackCreator.add(Material.STAINED_GLASS_PANE, "§b|", 15);
    ItemStack sobrevivente = StackCreator.add(Material.DIRT, Constantes.grupo_sobrevivente_nome);
	ItemStack guerreiro = StackCreator.add(Material.STONE, Constantes.grupo_guerreiro_nome);
	ItemStack gladiador = StackCreator.add(Material.ENDER_STONE, Constantes.grupo_gladiador_nome);
	ItemStack combatente = StackCreator.add(Material.COAL_ORE, Constantes.grupo_combatente_nome);
	ItemStack fuzileiro = StackCreator.add(Material.LAPIS_ORE, Constantes.grupo_fuzileiro_nome);
	ItemStack mercenario = StackCreator.add(Material.IRON_ORE, Constantes.grupo_mercenario_nome);
	ItemStack engenheiro = StackCreator.add(Material.GOLD_ORE, Constantes.grupo_engenheiro_nome);
	ItemStack alquimista = StackCreator.add(Material.DIAMOND_ORE, Constantes.grupo_alquimista_nome);
	ItemStack cientista = StackCreator.add(Material.EMERALD_ORE, Constantes.grupo_cientista_nome);
	
	kitsRanksMenu.setItem(0, vidro);
	kitsRanksMenu.setItem(1, vidro);
	kitsRanksMenu.setItem(2, vidro);
	kitsRanksMenu.setItem(3, vidro);
	kitsRanksMenu.setItem(4, vidro);
	kitsRanksMenu.setItem(5, vidro);
	kitsRanksMenu.setItem(6, vidro);
	kitsRanksMenu.setItem(7, vidro);
	kitsRanksMenu.setItem(8, vidro);
	kitsRanksMenu.setItem(9, vidro);
	kitsRanksMenu.setItem(17, vidro);
	kitsRanksMenu.setItem(18, vidro);
	kitsRanksMenu.setItem(26, vidro);
	kitsRanksMenu.setItem(27, vidro);
	kitsRanksMenu.setItem(35, vidro);
	kitsRanksMenu.setItem(36, vidro);
	kitsRanksMenu.setItem(37, vidro);
	kitsRanksMenu.setItem(38, vidro);
	kitsRanksMenu.setItem(39, vidro);
	kitsRanksMenu.setItem(40, vidro);
	kitsRanksMenu.setItem(41, vidro);
	kitsRanksMenu.setItem(42, vidro);
	kitsRanksMenu.setItem(43, vidro);
	kitsRanksMenu.setItem(44, vidro);
	
	kitsRanksMenu.setItem(12, sobrevivente);
	kitsRanksMenu.setItem(13, guerreiro);
	kitsRanksMenu.setItem(14, gladiador);
	kitsRanksMenu.setItem(21, combatente);
	kitsRanksMenu.setItem(22, fuzileiro);
	kitsRanksMenu.setItem(23, mercenario);
	kitsRanksMenu.setItem(30, engenheiro);
	kitsRanksMenu.setItem(31, alquimista);
	kitsRanksMenu.setItem(32, cientista);
    
    return kitsRanksMenu;
  }
  public static Inventory kitsVipsMenuAbrir()
  {
    Inventory kitsVipsMenu = Bukkit.createInventory(null, 45, Constantes.kits_vip_menu_nome);
    
    ItemStack vidro = StackCreator.add(Material.STAINED_GLASS_PANE, "§b|", 15);
	ItemStack nobre = StackCreator.add(Material.IRON_BLOCK, Constantes.grupo_nobre_nome);
	ItemStack rei = StackCreator.add(Material.GOLD_BLOCK, Constantes.grupo_rei_nome);
	ItemStack imperador = StackCreator.add(Material.DIAMOND_BLOCK, Constantes.grupo_imperador_nome);
	ItemStack modernal = StackCreator.add(Material.EMERALD_BLOCK, Constantes.grupo_modernal_nome);
	
	kitsVipsMenu.setItem(12, nobre);
	kitsVipsMenu.setItem(14, rei);
	kitsVipsMenu.setItem(30, imperador);
	kitsVipsMenu.setItem(32, modernal);
	
	kitsVipsMenu.setItem(0, vidro);
	kitsVipsMenu.setItem(1, vidro);
	kitsVipsMenu.setItem(2, vidro);
	kitsVipsMenu.setItem(3, vidro);
	kitsVipsMenu.setItem(4, vidro);
	kitsVipsMenu.setItem(5, vidro);
	kitsVipsMenu.setItem(6, vidro);
	kitsVipsMenu.setItem(7, vidro);
	kitsVipsMenu.setItem(8, vidro);
	kitsVipsMenu.setItem(9, vidro);
	kitsVipsMenu.setItem(17, vidro);
	kitsVipsMenu.setItem(18, vidro);
	kitsVipsMenu.setItem(26, vidro);
	kitsVipsMenu.setItem(27, vidro);
	kitsVipsMenu.setItem(35, vidro);
	kitsVipsMenu.setItem(36, vidro);
	kitsVipsMenu.setItem(37, vidro);
	kitsVipsMenu.setItem(38, vidro);
	kitsVipsMenu.setItem(39, vidro);
	kitsVipsMenu.setItem(40, vidro);
	kitsVipsMenu.setItem(41, vidro);
	kitsVipsMenu.setItem(42, vidro);
	kitsVipsMenu.setItem(43, vidro);
	kitsVipsMenu.setItem(44, vidro);
	
	return kitsVipsMenu;
  }
}