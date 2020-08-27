package me.NxtGen.net.Command;

import me.NxtGen.net.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Reload implements CommandExecutor {
    Main main = JavaPlugin.getPlugin(Main.class);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("nxtgenreload")) {
            if (sender.hasPermission("nxtgen.reload")) {
                if (args.length == 0) {
                    main.reloadConfig();
                    sender.sendMessage(main.prefix + "Reload complete");
                }
            }
            return true;
        }
        return true;
    }
}
