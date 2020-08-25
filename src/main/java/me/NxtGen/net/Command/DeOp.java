package me.NxtGen.net.Command;

import org.Hackerguardian.HG.Report.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DeOp implements CommandExecutor {
    String simple = null;
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("deop")) {
            if (sender.hasPermission("nxtgen.deop")) {
                OfflinePlayer test = Bukkit.getOfflinePlayer(args[0]);
                if (args.length == 0) {
                    return true;
                }
                if (test.isOnline() == true) {
                    Player p1 = Bukkit.getPlayer(args[0]);
                    UUID p2 = Bukkit.getPlayer(args[0]).getUniqueId();
                    p1.setOp(false);
                    MySQL.removefromOPDatabase(p2);
                    p1.sendMessage("Det virker!!");
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
                        MySQL.removefromOPDatabase(uuid);
                        p5.setOp(false);
                        sender.sendMessage("Offline player removed.");
                    } catch (Exception e) {}
                    sender.sendMessage("DeOp HARLD91");
                }
            }
        }
        return true;
    }
}
