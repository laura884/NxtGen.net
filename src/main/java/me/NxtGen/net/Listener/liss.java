package me.NxtGen.net.Listener;

import org.Hackerguardian.HG.Report.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;



public class liss implements Listener {
    public void onPlayerJoin(PlayerJoinEvent event) {
        Bukkit.broadcastMessage("Hello, " + event.getPlayer().getName() + "!");
    }
    @EventHandler
    public void onFirstJoin (PlayerJoinEvent PJE){
        if(!PJE.getPlayer().hasPlayedBefore()){
            MySQL.insterIntoPlistDatabase(PJE.getPlayer().getUniqueId(), PJE.getPlayer().getName());

        }
    }
}
