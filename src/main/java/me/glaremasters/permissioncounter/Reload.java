package me.glaremasters.permissioncounter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    private Permissioncounter counter;

    public Reload(Permissioncounter counter) {
        this.counter = counter;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("pc.reload")) {
            counter.reloadConfig();
            sender.sendMessage("Config reloaded!");
        }
        return true;
    }

}
