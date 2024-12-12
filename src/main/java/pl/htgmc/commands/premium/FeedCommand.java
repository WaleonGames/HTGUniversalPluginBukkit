package pl.htgmc.commands.premium;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Sprawdzamy, czy gracz ma odpowiednią permisię
            if (player.hasPermission("htgmc.premiun")) {
                player.setFoodLevel(20); // Pełny poziom głodu
                player.sendMessage(ChatColor.GREEN + "Zostałeś nakarmiony!");
            } else {
                player.sendMessage(ChatColor.RED + "Nie masz uprawnień do tej komendy.");
            }
        }
        return true;
    }
}
