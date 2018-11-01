package me.glaremasters.permissioncounter;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class Placeholders extends PlaceholderExpansion {

    private Permissioncounter counter;

    public Placeholders(Permissioncounter counter) {
        this.counter = counter;
    }


    @Override
    public String getIdentifier() {
        return "permissioncounter";
    }

    @Override
    public String getAuthor() {
        return "blockslayer22";
    }

    @Override
    public String getPlugin() {
        return null;
    }

    @Override
    public String getVersion() {
        return counter.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {

        if (identifier.startsWith("count_")) {
            identifier = identifier.split("count_")[1];
            if (counter.getConfig().getConfigurationSection("counters").getKeys(false).contains(identifier)) {
                int total = 0;
                for (String perm : counter.getConfig().getStringList("counters." + identifier)) {
                    if (player.hasPermission(perm)) {
                        total = total + 1;
                    }
                }
                return String.valueOf(total);
            }
            else {
                return "Invalid Counter";
            }
        }

        if (identifier.startsWith("max_")) {
            identifier = identifier.split("max_")[1];
            if (counter.getConfig().getConfigurationSection("counters").getKeys(false).contains(identifier)) {
                return String.valueOf(counter.getConfig().getStringList("counters." + identifier).size());
            }
        }

        return "N/A";
    }

}
