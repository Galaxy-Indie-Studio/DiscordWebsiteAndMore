package com.bigtallahasee.me.discordwebsiteandmore.commands;

import com.bigtallahasee.me.discordwebsiteandmore.DiscordWebsiteAndMore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdminCommands implements TabExecutor {
    Plugin dwm = DiscordWebsiteAndMore.getPlugin(DiscordWebsiteAndMore.class);

    String supportDiscord = "https://discord.gg/tDvbunqsWX";
    String supportGithub = "https://github.com/Galaxy-Indie-Studio/DiscordWebsiteAndMore/issues";
    String spigotSite = "https://www.spigotmc.org/resources/discord-website-and-more.96701/";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if(command.getName().equalsIgnoreCase("dwmadmin") && player.hasPermission("dwm.admin")){
            if(args[0].equalsIgnoreCase("reload")){
                dwm.reloadConfig();
                player.sendMessage(ChatColor.GREEN +"Config has successfully been reloaded!");
            }
            if(args[0].equalsIgnoreCase("support")){
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Need some help with the Plugin?");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
                player.sendMessage(ChatColor.GREEN + "Join our discord: " + supportDiscord);
                player.sendMessage(ChatColor.GREEN + "Fillout a Issue Report at: " + supportGithub);
                player.sendMessage(ChatColor.LIGHT_PURPLE +"");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"");
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Thank you all for using our plugin, If you like it " +
                        "leave a 5 star review at " + spigotSite);
            }
        }else{
            player.sendMessage(ChatColor.RED +"You don't have the proper permission to");
            player.sendMessage(ChatColor.RED +"perform this command! (dwm.admin)");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String a, String[] args) {
        List<String> list = Arrays.asList("reload", "support");
        String input = args[0].toLowerCase();

        List<String> completions = null;
        for (String s : list) {
            if (s.startsWith(input)) {
                if (completions == null) {
                    completions = new ArrayList<>();
                }
                completions.add(s);
            }
        }
        if (completions != null) {
            Collections.sort(completions);
            return completions;
        }
        return completions;
    }
}
