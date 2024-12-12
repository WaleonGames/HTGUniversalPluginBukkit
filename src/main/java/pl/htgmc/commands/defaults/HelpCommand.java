package pl.htgmc.commands.defaults;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Ta komenda jest tylko dla graczy!");
            return false;
        }

        Player player = (Player) sender;

        // Zaczynamy wyświetlanie ogólnych komend
        player.sendMessage("§6----- Lista komend -----");

        // Lista komend dostępnych dla graczy "default"
        player.sendMessage("§7/help - §fWyświetl tę pomoc.");
        player.sendMessage("§7/msg <gracz> <wiadomość> - §fWyślij wiadomość do gracza.");
        player.sendMessage("§7/spawn - §fPrzejdź do miejsca startowego na mapie.");
        player.sendMessage("§7/helpop <wiadomość> - §fWyślij wiadomość do administracji.");
        player.sendMessage("§7/discord - §fOtwórz link do naszego Discorda.");
        player.sendMessage("§7/strona - §fPrzejdź na naszą stronę internetową.");

        // Zakończenie listy
        player.sendMessage("§6------------------------");
        return true;
    }
}
