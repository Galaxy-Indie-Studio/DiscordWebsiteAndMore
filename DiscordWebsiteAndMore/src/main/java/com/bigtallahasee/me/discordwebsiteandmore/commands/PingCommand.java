package com.bigtallahasee.me.discordwebsiteandmore.commands;

import com.bigtallahasee.me.discordwebsiteandmore.DiscordWebsiteAndMore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PingCommand implements TabExecutor {
    DiscordWebsiteAndMore plugin = DiscordWebsiteAndMore.getPlugin(DiscordWebsiteAndMore.class);

    private String adminBroadcastMsg = plugin.getConfig().get("Admin-Broadcast-Received-Msg").toString();
    private String modBroadcastMsg = plugin.getConfig().get("Mod-Broadcast-Received-Msg").toString();
    private String helperBroadcastMsg = plugin.getConfig().get("Helper-Broadcast-Received-Msg").toString();

    private String adminPlayerMsg = plugin.getConfig().get("Admin-To-Player-Auto-Msg").toString();
    private String modPlayerMsg = plugin.getConfig().get("Mod-To-Player-Auto-Msg").toString();
    private String helperPlayerMsg = plugin.getConfig().get("Helper-To-Player-Auto-Msg").toString();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("dwm.default") || player.hasPermission("dwm.*") || player.isOp() || player.hasPermission("dwm.ping")) {
            if (command.getName().equals("dwmping")) {
                if (args[0].equalsIgnoreCase("admin")) {
                    //This will be broadcast to anyone with permission (dwm.admin)
                    Bukkit.broadcast(" ", "dwm.admin");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#-----------------------------#", "dwm.admin");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "# DiscordWebsiteAndMore              #", "dwm.admin");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#-----------------------------#", "dwm.admin");
                    Bukkit.broadcast(ChatColor.GREEN + player.getName()+ " " + ChatColor.LIGHT_PURPLE + adminBroadcastMsg, "dwm.admin");
                    Bukkit.broadcast(" ", "dwm.admin");

                    //This is the automatic message that is sent to the player after pinging admin
                    player.sendMessage(" ");
                    player.sendMessage(ChatColor.GREEN + "#-----------------------------#");
                    player.sendMessage(ChatColor.GREEN + "# DiscordWebsiteAndMore              #");
                    player.sendMessage(ChatColor.GREEN + "#-----------------------------#");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + adminPlayerMsg);
                    player.sendMessage(" ");
                }
                if (args[0].equalsIgnoreCase("mod")) {
                    //This is where it will broadcast a message when a player pings a mod
                    Bukkit.broadcast(" ", "dwm.mod");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#-----------------------------#", "dwm.mod");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "# DiscordWebsiteAndMore              #", "dwm.mod");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#-----------------------------#", "dwm.mod");
                    Bukkit.broadcast(ChatColor.GREEN + player.getName() + " " + ChatColor.LIGHT_PURPLE + modBroadcastMsg, "dwm.mod");
                    Bukkit.broadcast(" ", "dwm.mod");

                    //this is the auto msg sent to player after pinging mods
                    player.sendMessage(" ");
                    player.sendMessage(ChatColor.GREEN + "#-----------------------------#");
                    player.sendMessage(ChatColor.GREEN + "# DiscordWebsiteAndMore              #");
                    player.sendMessage(ChatColor.GREEN + "#-----------------------------#");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + modPlayerMsg);
                    player.sendMessage(" ");
                }
                if (args[0].equalsIgnoreCase("helper")) {
                    //this is what is broadcasted to helpers when a player pings helpers
                    Bukkit.broadcast(" ", "dwm.helper");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#-----------------------------#", "dwm.helper");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "# DiscordWebsiteAndMore              #", "dwm.helper");
                    Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "#-----------------------------#", "dwm.helper");
                    Bukkit.broadcast( ChatColor.GREEN + player.getName() + " " + ChatColor.LIGHT_PURPLE + helperBroadcastMsg, "dwm.helper");
                    Bukkit.broadcast(" ", "dwm.admin");

                    //this is the auto msg after a player pings a helper\
                    player.sendMessage(" ");
                    player.sendMessage(ChatColor.GREEN + "#-----------------------------#");
                    player.sendMessage(ChatColor.GREEN + "# DiscordWebsiteAndMore              #");
                    player.sendMessage(ChatColor.GREEN + "#-----------------------------#");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + helperPlayerMsg);
                    player.sendMessage(" ");
                }
            }
        }else{
            player.sendMessage(ChatColor.RED + "You don't have the required perm to");
            player.sendMessage(ChatColor.RED + "execute that command!");
            player.sendMessage(ChatColor.GREEN + "Required Permission (dwm.ping)");
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = Arrays.asList("admin", "mod", "helper");
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

