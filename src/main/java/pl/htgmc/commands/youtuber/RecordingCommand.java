package pl.htgmc.commands.youtuber;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class RecordingCommand implements CommandExecutor {

    private static Set<Player> recordingPlayers = new HashSet<>(); // Zbiór graczy, którzy nagrywają

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Tylko gracze mogą używać tej komendy.");
            return true;
        }

        Player player = (Player) sender;

        // Sprawdzamy, czy gracz ma odpowiednią permisję
        if (!player.hasPermission("htgmc.youtube")) {
            player.sendMessage("§cNie masz uprawnień do ustawienia punktu spawn!");
            return false;
        }

        if (recordingPlayers.contains(player)) {
            // Wyłącz nagrywanie
            recordingPlayers.remove(player);
            player.sendMessage("Zakończyłeś nagrywanie. Czat został włączony, a wiadomości są ponownie odbierane.");
            Bukkit.broadcastMessage(player.getDisplayName() + " zakończył nagrywanie.");
        } else {
            // Włącz nagrywanie
            recordingPlayers.add(player);
            player.sendMessage("Rozpocząłeś nagrywanie! Czat został wyciszony, a wiadomości są blokowane.");
            Bukkit.broadcastMessage(player.getDisplayName() + " nagrywa odcinek! Prosimy o nie przeszkadzanie.");
        }

        return true;
    }

    public static boolean isRecording(Player player) {
        return recordingPlayers.contains(player);
    }
}
