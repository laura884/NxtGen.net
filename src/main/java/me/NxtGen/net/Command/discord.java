package me.NxtGen.net.Command;

import me.NxtGen.net.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class discord implements CommandExecutor {
    Main main = JavaPlugin.getPlugin(Main.class);
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("discord")) {
            if (args.length == 0) {
                if (sender instanceof Player) {
                    sender.sendMessage(main.prefix + "Join Nxtgen Discord");
                    sender.sendMessage(main.prefix + "https://discord.gg/ZRw4NXN");
                    return true;
                }
                else {
                    Bukkit.broadcastMessage(main.prefix + "Join Nxtgen Discord");
                    Bukkit.broadcastMessage(main.prefix + "https://discord.gg/ZRw4NXN");
                }
                return true;
            }
        }
        return true;
    }
}