package me.NxtGen.net.Command;


import me.NxtGen.net.Main;
import org.Hackerguardian.HG.Report.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;




public class NxtGenCommand implements CommandExecutor {
    Main main = JavaPlugin.getPlugin(Main.class);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("nxtgen")) {
            if (sender instanceof Player) {
                //player
                Player p1 = (Player) sender;
                //Withlistedplayers
                if (p1.hasPermission("nxtgen.use")) {
                    p1.sendMessage(main.prefix + ChatColor.GOLD + "RUNNING SAFE PROGRAM YOU CANT STOP IT! ");

                    Bukkit.setWhitelist(true); //enable whitelist
                    p1.sendMessage(main.prefix + ChatColor.GOLD + "WHITELIST ON ");
                    p1.sendMessage(main.prefix + "DEOP ALL");
                    MySQL.getallfromOPDatabase();
                    MySQL.getallfromPlistDatabase();
                    for (byte b = 0; b < MySQL.oplist2.size(); b++)
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "deop " + MySQL.oplist2.get(b));
                    p1.sendMessage(main.prefix + "WHITLISTING STAFF");
                    for (byte c = 0; c < main.getConfig().getStringList("Whitelist").size(); c++)
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist add " + main.getConfig().getStringList("Whitelist").get(c));
                    p1.sendMessage(main.prefix + "REMOVE RANKS");
                    for (byte h = 0; h < MySQL.PList2.size(); h++)
                         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + MySQL.PList2.get(h) + " parent set default");
                    p1.sendMessage(main.prefix + "ALL SET TO DEFAULT");
                    //p1.sendMessage("RESTARTING");
                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
                    return true;
                }
            }

        }
        else {
            //console
            sender.sendMessage(main.prefix + "hey console");
            return true;
        }
        return false;
    }
}