package pl.htgmc.commands.defaults;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {

    private final String discordLink;

    // Konstruktor przyjmujący link do Discorda
    public DiscordCommand(String discordLink) {
        this.discordLink = discordLink;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Sprawdzamy, czy komendę wywołał gracz
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Wysyłamy graczowi link do Discorda
            player.sendMessage(ChatColor.GREEN + "Dołącz do naszego serwera na Discordzie: " + discordLink);
        } else {
            // Jeśli komenda została wywołana przez konsolę, wysyłamy komunikat
            sender.sendMessage("Ta komenda jest tylko dostępna dla graczy.");
        }

        return true;
    }
}
