package com.bigtallahasee.me.discordwebsiteandmore.commands;

import com.bigtallahasee.me.discordwebsiteandmore.DiscordWebsiteAndMore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ReloadConfig implements CommandExecutor {
    Plugin plugin = DiscordWebsiteAndMore.getPlugin(DiscordWebsiteAndMore.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.isOp() || player.hasPermission("dwm.admin")) {
            if (command.getName().equalsIgnoreCase("dwmreload")) {
                plugin.reloadConfig();
                player.sendMessage(ChatColor.GREEN +"Config has successfully been reloaded!");
            }
        }else{
            player.sendMessage(ChatColor.RED +"You don't have the proper permission to");
            player.sendMessage(ChatColor.RED +"perform this command! (dwm.admin)");
        }


        return false;
    }
}

