package me.calebbassham.servermessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerMessages extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(cc(String.format("&8[&a+&8] &3%s &8&o(&b&o%d&8&o/&3&o%d&8&o)", e.getPlayer().getDisplayName(), Bukkit.getOnlinePlayers().size(), Bukkit.getMaxPlayers())));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        e.setQuitMessage(cc(String.format("&8[&c-&8] &3%s &8&o(&b&o%d&8&o/&3&o%d&8&o)", e.getPlayer().getDisplayName(), Bukkit.getOnlinePlayers().size() - 1, Bukkit.getMaxPlayers())));
    }

    private String cc(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
