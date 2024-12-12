package pl.htgmc.commands.defaults;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Ta komenda jest tylko dla graczy!");
            return false;
        }

        Player player = (Player) sender;

        // Sprawdzamy, czy spawn jest ustawiony
        Location spawnLocation = player.getServer().getWorld("world").getSpawnLocation();
        if (spawnLocation == null) {
            player.sendMessage("§cNie ustawiono punktu spawn. Ustaw go za pomocą komendy '/setspawn'!");
            return false;
        }

        // Teleportacja gracza na spawn
        player.teleport(spawnLocation);
        player.sendMessage("§aZostałeś teleportowany na spawn!");

        return true;
    }
}
