package pl.htgmc.commands.defaults;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StronaCommand implements CommandExecutor {

    private final String url;

    // Konstruktor przyjmujący link do strony
    public StronaCommand(String url) {
        this.url = url;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Sprawdzamy, czy komendę wywołał gracz
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Wysyłamy graczowi link do strony
            player.sendMessage(ChatColor.GREEN + "Odwiedź naszą stronę internetową: " + url);
        } else {
            // Jeśli komenda została wywołana przez konsolę, wysyłamy komunikat
            sender.sendMessage("Ta komenda jest tylko dostępna dla graczy.");
        }

        return true;
    }
}
