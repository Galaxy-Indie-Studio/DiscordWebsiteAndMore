package com.bigtallahasee.me.discordwebsiteandmore.commands;

import com.bigtallahasee.me.discordwebsiteandmore.DiscordWebsiteAndMore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class VotingURL implements CommandExecutor {
    Plugin plugin = DiscordWebsiteAndMore.getPlugin(DiscordWebsiteAndMore.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("voting"))
        {
            player.sendMessage(ChatColor.LIGHT_PURPLE +"Vote for the Server :D");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
            player.sendMessage(plugin.getConfig().getString("Voting-URL1"));
            player.sendMessage(plugin.getConfig().getString("Voting-URL2"));
            player.sendMessage(plugin.getConfig().getString("Voting-URL3"));
            player.sendMessage(plugin.getConfig().getString("Voting-URL4"));
            player.sendMessage(plugin.getConfig().getString("Voting-URL5"));
        }


        return false;
    }
}

