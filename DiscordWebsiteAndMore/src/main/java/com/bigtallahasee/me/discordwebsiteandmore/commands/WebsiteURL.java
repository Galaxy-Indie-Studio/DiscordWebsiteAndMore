package com.bigtallahasee.me.discordwebsiteandmore.commands;

import com.bigtallahasee.me.discordwebsiteandmore.DiscordWebsiteAndMore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class WebsiteURL implements CommandExecutor {
    Plugin plugin = DiscordWebsiteAndMore.getPlugin(DiscordWebsiteAndMore.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("website"))
        {
            player.sendMessage(ChatColor.LIGHT_PURPLE +"Check Out Our Website Today");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
            player.sendMessage(plugin.getConfig().getString("Website-URL"));
        }


        return false;
    }
}

