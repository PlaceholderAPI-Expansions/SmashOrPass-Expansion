package me.glaremasters.smashorpass;

import com.LagBug.SmashOrPass.Main;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SmashOrPassExpansion extends PlaceholderExpansion {

    private Main plugin;

    @Override
    public boolean canRegister() {
        Plugin pl = Bukkit.getPluginManager().getPlugin("SmashOrPass");
        if (pl == null) {
            return false;
        }
        return super.register();
    }

    @Override
    public String getAuthor() {
        return "blockslayer22";
    }

    @Override
    public String getIdentifier() {
        return "sop";
    }

    @Override
    public String getPlugin() {
        return "SmashOrPass";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player p, String arg) {


        if (p == null) {
            return "";
        }

        switch (arg) {
            case "smashes":
                return String.valueOf(plugin.getDataFile().getInt("PlayerData." + p.getUniqueId().toString() + ".Smashes"));
            case "passes":
                return String.valueOf(plugin.getDataFile().getInt("PlayerData." + p.getUniqueId().toString() + ".Passes"));
        }
        return null;
    }

}