package pl.htgmc.commands.premium;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Sprawdzamy, czy gracz ma odpowiednią permisię
            if (player.hasPermission("htgmc.premiun")) {
                if (!player.getAllowFlight()) {
                    player.setAllowFlight(true);
                    player.setFlying(true); // Włączamy latanie
                    player.sendMessage(ChatColor.GREEN + "Latanie zostało włączone!");
                } else {
                    player.setAllowFlight(false);
                    player.setFlying(false); // Wyłączamy latanie
                    player.sendMessage(ChatColor.RED + "Latanie zostało wyłączone.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Nie masz uprawnień do tej komendy.");
            }
        }
        return true;
    }
}
