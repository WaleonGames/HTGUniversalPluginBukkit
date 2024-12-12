package pl.htgmc.commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Sprawdzamy, czy wysyłający komendę jest graczem
        if (!(sender instanceof Player)) {
            sender.sendMessage("Ta komenda jest tylko dla graczy!");
            return false;
        }

        Player player = (Player) sender;

        // Sprawdzamy, czy gracz ma odpowiednią permisję
        if (!player.hasPermission("htgmc.admin")) {
            player.sendMessage("§cNie masz uprawnień do ustawienia punktu spawn!");
            return false;
        }

        // Ustawiamy punkt spawn na aktualną lokalizację gracza
        player.getServer().getWorld("world").setSpawnLocation(player.getLocation());
        player.sendMessage("§aPunkt spawn został ustawiony!");

        return true;
    }
}
