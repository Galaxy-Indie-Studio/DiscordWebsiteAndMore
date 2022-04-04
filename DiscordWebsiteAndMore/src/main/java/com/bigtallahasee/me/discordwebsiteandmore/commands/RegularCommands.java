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

public class RegularCommands implements TabExecutor {
    Plugin dwm = DiscordWebsiteAndMore.getPlugin(DiscordWebsiteAndMore.class);
    private final boolean websiteEnabled = dwm.getConfig().getBoolean("Is-Website-Enabled");
    private final boolean discordEnabled = dwm.getConfig().getBoolean("Is-DiscordInvite-Enabled");
    private final boolean dynmapEnabled = dwm.getConfig().getBoolean("Is-DynmapUrl-Enabled");
    private final boolean voteEnabled = dwm.getConfig().getBoolean("Is-VoteUrls-Enabled");
    private final boolean wikiEnabled = dwm.getConfig().getBoolean("Is-WikiUrl-Enabled");

    private final String discordUrl = dwm.getConfig().getString("Discord-URL");
    private final String dynmapUrl = dwm.getConfig().getString("Dynmap-URL");
    private final String websiteUrl = dwm.getConfig().getString("Website-URL");
    private final String wikiUrl = dwm.getConfig().getString("Wiki-URL");
    String[] voteSites = new String[5];


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        voteSites[0] = dwm.getConfig().getString("Voting-URL1");
        voteSites[1] = dwm.getConfig().getString("Voting-URL2");
        voteSites[2] = dwm.getConfig().getString("Voting-URL3");
        voteSites[3] = dwm.getConfig().getString("Voting-URL4");
        voteSites[4] = dwm.getConfig().getString("Voting-URL5");

        if(command.getName().equalsIgnoreCase("dwm")){
            if(args[0].equalsIgnoreCase("discord") && discordEnabled){
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Join Our Discord Today");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
                player.sendMessage(ChatColor.GREEN + discordUrl);
            }
            if(args[0].equalsIgnoreCase("dynmap") && dynmapEnabled){
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Check Out Our Dynmap");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
                player.sendMessage(ChatColor.GREEN +dynmapUrl);
                player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");

            }
            if(args[0].equalsIgnoreCase("vote") && voteEnabled){
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Vote for the Server :D");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
                player.sendMessage(ChatColor.GREEN + voteSites[0]);
                player.sendMessage(ChatColor.GREEN + voteSites[1]);
                player.sendMessage(ChatColor.GREEN + voteSites[2]);
                player.sendMessage(ChatColor.GREEN + voteSites[3]);
                player.sendMessage(ChatColor.GREEN + voteSites[4]);
            }
            if(args[0].equalsIgnoreCase("website") && websiteEnabled){
                player.sendMessage(ChatColor.LIGHT_PURPLE +"Check Out Our Website Today");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
                player.sendMessage(ChatColor.GREEN + websiteUrl);
            }
            if(args[0].equalsIgnoreCase("wiki") && wikiEnabled){
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Need Help? Check out our wiki");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------------");
                player.sendMessage(ChatColor.GREEN + wikiUrl);
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String a, String[] args) {
        List<String> list = Arrays.asList("website", "discord", "wiki", "vote", "dynmap");
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
