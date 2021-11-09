package com.bigtallahasee.me.discordwebsiteandmore.commands;

import com.bigtallahasee.me.discordwebsiteandmore.DiscordWebsiteAndMore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DiscordInvite implements CommandExecutor {
    Plugin plugin = DiscordWebsiteAndMore.getPlugin(DiscordWebsiteAndMore.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("discord"))
        {
            player.sendMessage(ChatColor.LIGHT_PURPLE +"Join Our Discord Today");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
            player.sendMessage(plugin.getConfig().getString("Discord-URL"));
        }


        return false;
    }
}
