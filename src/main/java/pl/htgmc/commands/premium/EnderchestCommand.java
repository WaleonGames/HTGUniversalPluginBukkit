package pl.htgmc.commands.premium;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderchestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Sprawdzamy, czy gracz ma odpowiednią permisię
            if (player.hasPermission("htgmc.premiun")) {
                player.openInventory(player.getEnderChest()); // Otwiera Ender Chest
                player.sendMessage(ChatColor.GREEN + "Otworzyłeś swój Ender Chest.");
            } else {
                player.sendMessage(ChatColor.RED + "Nie masz uprawnień do tej komendy.");
            }
        }
        return true;
    }
}
