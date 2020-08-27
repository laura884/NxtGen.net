package me.NxtGen.net;

import me.NxtGen.net.Command.*;
import me.NxtGen.net.Listener.liss;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.security.PublicKey;
import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

    public static Plugin plugin;
    public FileConfiguration config = getConfig();
    public String prefix = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("Prefix"));

    @Override
    public void onEnable() {
        //Start up
        //reload
        //plugin reload
        plugin = this;
        PluginDescriptionFile pdffile = getDescription();
        Logger logger = java.util.logging.Logger.getLogger("Minecraft");
        logger.info(pdffile.getName() + pdffile.getVersion() + "Was enabled");
        getCommand("nxtgen").setExecutor(new NxtGenCommand());
        getCommand("boot").setExecutor(new Boot());
        getServer().getPluginManager().registerEvents(new liss(), this);
        getCommand("op").setExecutor(new OP());
        getCommand("deop").setExecutor(new DeOp());
        getCommand("npj").setExecutor(new NewPlayercommand());
        getCommand("nxtgenreload").setExecutor(new Reload());
        getCommand("discord").setExecutor(new discord());
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        timer();

    }

    @Override
    public void onDisable() {
        //Start up
        //reload
        //plugin reload
        PluginDescriptionFile pdffile = getDescription();
        Logger logger = java.util.logging.Logger.getLogger("Minecraft");
        logger.info(pdffile.getName() + pdffile.getVersion() + "Was disable");
    }

    public static void timer() {
        new BukkitRunnable() {
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "discord");
            }
        }.runTaskTimer(getInstance(), 48000L, 48000L);
    }

    private static Plugin getInstance() {
        return (Main)getPlugin(Main.class);
    }
}