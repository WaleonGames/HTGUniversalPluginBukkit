package pl.htgmc.commands.premium;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RepairCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Sprawdzamy, czy gracz ma odpowiednią permisię
            if (player.hasPermission("htgmc.premiun")) {
                for (ItemStack item : player.getInventory()) {
                    if (item != null && item.getType() != Material.AIR) {
                        // Naprawia przedmioty
                        item.setDurability((short) 0);
                    }
                }
                player.sendMessage(ChatColor.GREEN + "Twoje przedmioty zostały naprawione!");
            } else {
                player.sendMessage(ChatColor.RED + "Nie masz uprawnień do tej komendy.");
            }
        }
        return true;
    }
}
