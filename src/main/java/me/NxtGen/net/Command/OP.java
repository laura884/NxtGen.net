package me.NxtGen.net.Command;

import org.Hackerguardian.HG.Report.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class OP implements CommandExecutor {
    String simple = null;
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("op")) {
            if (sender.hasPermission("nxtgen.op")) {
                if (args.length == 0) {
                    Player p10 = Bukkit.getPlayer(args[0]);
                    p10.sendMessage("hahahahaha noob");
                    p10.sendMessage("git good with ninja contact RAR_E for the Book");
                    return true;
                }
                OfflinePlayer test = Bukkit.getOfflinePlayer(args[0]);
                if (test.isOnline() == true) {
                    Player p1 = Bukkit.getPlayer(args[0]);
                    UUID p2 = Bukkit.getPlayer(args[0]).getUniqueId();
                    p1.setOp(true);
                    MySQL.insterIntoOPDatabase(p2, p1.getName());
                    p1.sendMessage("Det virker");
                }else {
                    OfflinePlayer p5 = Bukkit.getOfflinePlayer(args[0]);
                    UUID uuid = null;
                    if (args[0] == null) {
                        //well oof
                    } else {
                        uuid = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
                    }
                    sender.sendMessage("" + "Player name: " + p5.getName() + " Player UUID: " + uuid);
                    try {
                        MySQL.insterIntoOPDatabase(uuid, p5.getName());
                        p5.setOp(true);
                        sender.sendMessage("Offline player added.");
                    } catch (Exception e) {}

                }
                return true;

            }
        }
        return true;
    }
}
