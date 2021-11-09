package com.bigtallahasee.me.discordwebsiteandmore;

import com.bigtallahasee.me.discordwebsiteandmore.commands.*;
import com.bigtallahasee.me.discordwebsiteandmore.events.WelcomeServerEvent;
import com.bigtallahasee.me.discordwebsiteandmore.utils.Settings;
import com.bigtallahasee.me.discordwebsiteandmore.utils.UpdateChecker;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.bigtallahasee.me.discordwebsiteandmore.utils.Logger;

public final class DiscordWebsiteAndMore extends JavaPlugin {

    public static DiscordWebsiteAndMore instance;
    public static DiscordWebsiteAndMore plugin;

    @Override
    public void onEnable() {
        System.out.println("DiscordWebsiteAndMore has been Enabled!");

        //Events
        getServer().getPluginManager().registerEvents(new WelcomeServerEvent(), this);


        //Commands
        getCommand("discord").setExecutor(new DiscordInvite());
        getCommand("website").setExecutor(new WebsiteURL());
        getCommand("voting").setExecutor(new VotingURL());
        getCommand("dwmreload").setExecutor(new ReloadConfig());

        getCommand("dwmping").setExecutor(new PingCommand());
        getCommand("dwmping").setTabCompleter(new PingCommand());

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Update Checker
        new UpdateChecker(this, 96701).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Logger.log(Logger.LogLevel.SUCCESS, ("DiscordWebsiteAndMore is up to date!"));
            } else {
                Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
                Logger.log(Logger.LogLevel.WARNING, ("DiscordWebsiteAndMore is outdated!"));
                Logger.log(Logger.LogLevel.WARNING, ("Newest version: " + version));
                Logger.log(Logger.LogLevel.WARNING, ("Your version: " + Settings.VERSION));
                Logger.log(Logger.LogLevel.WARNING, ("Please Update Here: " + Settings.PLUGIN_URL + UpdateChecker.resourceId));
                Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
            }
        });
    }
    public void onDisable() {
        System.out.println("DiscordWebsiteAndMore has been Disabled! Goodbye");
    }

    public static DiscordWebsiteAndMore getPlugin() {
        return plugin;
    }

    public static Plugin getInstance() {
        return instance;
    }
}



