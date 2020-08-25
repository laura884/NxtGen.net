package me.NxtGen.net.Command;

import me.NxtGen.net.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.Hackerguardian.HG.Report.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Set;


public class Boot implements CommandExecutor{
   Main main = JavaPlugin.getPlugin(Main.class);


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("boot")) {
            if (sender instanceof Player) {

                //player
                Player p1 = (Player) sender;
                if (p1.hasPermission("nxtgen.boot")) {
                    p1.sendMessage(ChatColor.GOLD + "Køre nu. Putter alt tilbage som det skal være før Pikhovederne prøvede at overtage serveren ");
                    p1.setWhitelisted(true); //set player on whitelist
                    //p1.setWhitelisted(false); //remove player from whitelist
                    p1.sendMessage(p1 + "Has been addet to whitelist");
                    //Bukkit.setWhitelist(true); //enable whitelist
                    Bukkit.setWhitelist(false); //disable whitelist
                    //Bukkit.reloadWhitelist(); //reload whitelist
                    p1.sendMessage(ChatColor.GOLD + "WHITELIST off ");
                    p1.sendMessage("Gonna op all");
                    //(not use
                    //p1.performCommand("/op" + main.getConfig().getStringList("Names") ); )

                    for (byte b = 0; b < main.getConfig().getStringList("Names").size(); b++)
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + main.getConfig().getStringList("Names").get(b));
                    p1.sendMessage("Gonna Whitelist remove");
                    Set<OfflinePlayer> p2 = Bukkit.getWhitelistedPlayers();
                    p2.clear();

                    p1.sendMessage("Gonna add all ranks to people");
                    for (byte c = 0; c < main.getConfig().getStringList("Owner").size(); c++)
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + main.getConfig().getStringList("Owner").get(c) + " parent set owner");
                    for (byte d = 0; d < main.getConfig().getStringList("Dev").size(); d++)
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + main.getConfig().getStringList("Dev").get(d) + " parent set delveloper");
                    for (byte e = 0; e < main.getConfig().getStringList("Admin").size(); e++)
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + main.getConfig().getStringList("Admin").get(e) + " parent set admin");

                    p1.sendMessage("Gonna restart ");
                    return true;
                }
            }

        }
        return false;
    }

}
