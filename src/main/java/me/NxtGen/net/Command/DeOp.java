package me.NxtGen.net.Command;

import me.NxtGen.net.Main;
import org.Hackerguardian.HG.Report.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class DeOp implements CommandExecutor {
    Main main = JavaPlugin.getPlugin(Main.class);
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("deop")) {
            if (sender.hasPermission("nxtgen.deop")) {
                if (args.length == 0) {
                    Player p10 = Bukkit.getPlayer(args[0]);
                    p10.sendMessage(main.prefix + "hahahahaha noob");
                    p10.sendMessage(main.prefix + "git good with ninja contact RAR_E for the Book");
                    return true;
                }
                OfflinePlayer test = Bukkit.getOfflinePlayer(args[0]);
                if (test.isOnline() == true) {
                    Player p1 = Bukkit.getPlayer(args[0]);
                    UUID p2 = Bukkit.getPlayer(args[0]).getUniqueId();
                    p1.setOp(false);
                    MySQL.removefromOPDatabase(p2);
                }else {
                    OfflinePlayer p5 = Bukkit.getOfflinePlayer(args[0]);
                    UUID uuid = null;
                    if (args[0] == null) {
                        //well oof
                    } else {
                        uuid = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
                    }
                    sender.sendMessage(main.prefix + "Player name: " + p5.getName() + " Player UUID: " + uuid);
                    try {
                        MySQL.removefromOPDatabase(uuid);
                        p5.setOp(false);
                        sender.sendMessage(main.prefix + "Offline player removed.");
                    } catch (Exception e) {}
                    sender.sendMessage(main.prefix + "Deop all confirm?????");
                }
            }
        }
        return true;
    }
}
