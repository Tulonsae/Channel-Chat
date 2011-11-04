package com.feildmaster.chanchat.Util;

import com.feildmaster.chanchat.Chan.ChannelManager;
import com.feildmaster.chanchat.Chat;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
//import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.util.config.Configuration;

public final class ChatUtil {
    private static final Server server = Bukkit.getServer();
    public static final Logger log = getServer().getLogger();
    private static Chat chatPlugin;
    private static PluginManager pm;

    public static Server getServer() {
        return server;
    }
    public static PluginManager getPluginManager() {
        if(pm == null)pm = server.getPluginManager();
        return pm;
    }
    public static Chat getChatPlugin() {
        if(chatPlugin == null) {
            chatPlugin = (Chat)getPluginManager().getPlugin("ChannelChat");
        }
        return chatPlugin;
    }
    public static ChannelManager getCM() {
        return getChatPlugin().getCM();
    }

    public static Configuration getDefaultConfig() {
        return getChatPlugin().getConfiguration();
    }
    public static Player getPlayer(String name) {
        return getServer().getPlayer(name);
    }

    public static void reload() {
        getChatPlugin().getCC1().reload();
        getChatPlugin().getCC2().reload(true);
    }
    public static void save() {
        getChatPlugin().getCC1().save();
        getChatPlugin().getCC2().save();
    }
    public static Logger log() {
        return getServer().getLogger();
    }

    // Convenience Methods
    public static String error(String msg) {
        return ChatColor.RED+msg;
    }
    public static String info(String msg) {
        return ChatColor.YELLOW+msg;
    }
    public static String format(ChatColor color, String msg) {
        return String.format(color+"[%1$s] %2$s", getChatPlugin().getDescription().getName(), msg);
    }
}
