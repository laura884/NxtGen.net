package me.NxtGen.net;

import me.NxtGen.net.Command.*;
import me.NxtGen.net.Listener.liss;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

    public static Plugin plugin;
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable () {
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
        getCommand("NPJ").setExecutor(new NewPlayercommand());
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        }
    @Override
    public void onDisable () {
        //Start up
        //reload
        //plugin reload
        PluginDescriptionFile pdffile = getDescription();
        Logger logger = java.util.logging.Logger.getLogger("Minecraft");
        logger.info(pdffile.getName() + pdffile.getVersion() + "Was disable");
    }


}

