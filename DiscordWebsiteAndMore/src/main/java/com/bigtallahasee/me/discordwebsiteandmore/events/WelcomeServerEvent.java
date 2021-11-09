package com.bigtallahasee.me.discordwebsiteandmore.events;

import com.bigtallahasee.me.discordwebsiteandmore.DiscordWebsiteAndMore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class WelcomeServerEvent implements Listener {
    Plugin plugin = DiscordWebsiteAndMore.getPlugin(DiscordWebsiteAndMore.class);

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.DARK_GREEN +"Hello "+ChatColor.LIGHT_PURPLE +player.getDisplayName()+ChatColor.DARK_GREEN+ " " + plugin.getConfig().getString("Join-Message"));
    }
}
