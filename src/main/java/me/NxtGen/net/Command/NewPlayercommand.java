package me.NxtGen.net.Command;

import org.Hackerguardian.HG.Report.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class NewPlayercommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("npj")) {
            if (sender.hasPermission("nxtgen.npj")) {
                if (args.length == 0) {
                    return true;
                }
                if (args.length == 1) {
                    Player p1 = Bukkit.getPlayer(args[0]);
                    UUID p2 = Bukkit.getPlayer(args[0]).getUniqueId();
                    MySQL.insterIntoPlistDatabase(p2, p1.getName());
                }
                return true;
            }
        }
        return true;
    }
}