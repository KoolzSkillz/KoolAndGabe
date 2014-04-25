package SPPlugin;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SPPlugin
  extends JavaPlugin
{
  public Permission playerPermission = new Permission("bedrock.place");
  public static SPPlugin plugin;
  public final Logger logger = Logger.getLogger("Minecraft");
  
  public void onDisable()
  {
    PluginDescriptionFile p = getDescription();
    this.logger.info(p.getName() + " V" + p.getVersion() + " Has been enabled!");
  }
  
  public void onEnable()
  {
    PluginDescriptionFile p = getDescription();
    this.logger.info(p.getName() + " V" + p.getVersion() + " Has been enabled!");
    getConfig().options().copyDefaults(true);
    saveConfig();
    new BlockListener(this);
    PluginManager pm = getServer().getPluginManager();
    pm.addPermission(this.playerPermission);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if (commandLabel.equalsIgnoreCase("news"))
    {
      player.sendMessage(ChatColor.GREEN + "[News]: " + ChatColor.GOLD + getConfig().getString("news"));
    }
    else if (commandLabel.equalsIgnoreCase("server"))
    {
      player.sendMessage(ChatColor.GREEN + "======[Plugin v1.0]======");
      player.sendMessage(ChatColor.GREEN + "[Server]: " + ChatColor.GOLD + getConfig().getString("server"));
      player.sendMessage(ChatColor.GREEN + "======[" + getConfig().getString("servername") + "]======");
    }
    else if (commandLabel.equalsIgnoreCase("staff"))
    {
      player.sendMessage(ChatColor.BLUE + "[Mods]: " + ChatColor.GOLD + getConfig().getString("mods"));
      player.sendMessage(ChatColor.GREEN + "[Smods]: " + ChatColor.GOLD + getConfig().getString("smods"));
      player.sendMessage(ChatColor.DARK_RED + "[Admin]: " + ChatColor.GOLD + getConfig().getString("admins"));
      player.sendMessage(ChatColor.DARK_PURPLE + "[CoOwner]: " + ChatColor.GOLD + getConfig().getString("coowners"));
      player.sendMessage(ChatColor.DARK_PURPLE + "[Owner]: " + ChatColor.GOLD + getConfig().getString("owner"));
    }
    else if (commandLabel.equalsIgnoreCase("donate"))
    {
      player.sendMessage(ChatColor.GREEN + "[Server]: " + ChatColor.GOLD + getConfig().getString("donateinfo"));
      player.sendMessage(ChatColor.GREEN + getConfig().getString("donateinfo"));
      player.sendMessage(ChatColor.GREEN + getConfig().getString("donate"));
    }
else if (commandLabel.equalsIgnoreCase("MOTD"))
    {
      player.sendMessage(ChatColor.GREEN + "[MOTD]: " + ChatColor.GOLD + getConfig().getString("MOTD"));
    }
    return false;
  }
}
