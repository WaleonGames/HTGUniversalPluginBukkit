package pl.htgmc.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.htgmc.commands.youtuber.RecordingCommand;

public class RecordingListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        // Jeśli gracz nagrywa, zablokuj wszystkie wiadomości
        if (RecordingCommand.isRecording(player)) {
            event.setCancelled(true);
            player.sendMessage("Czat jest wyciszony, ponieważ nagrywasz.");
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase();

        // Zablokuj komendy prywatnych wiadomości i helpop, jeśli gracz nagrywa
        if (command.startsWith("/msg") || command.startsWith("/helpop")) {
            if (RecordingCommand.isRecording(player)) {
                event.setCancelled(true);
                player.sendMessage("Nie możesz wysyłać wiadomości podczas nagrywania.");
            }
        }

        // Zablokuj inne osoby przed wysyłaniem wiadomości do nagrywającego
        for (Player recordingPlayer : Bukkit.getOnlinePlayers()) {
            if (RecordingCommand.isRecording(recordingPlayer) && command.contains(recordingPlayer.getName())) {
                event.setCancelled(true);
                player.sendMessage("Ten gracz nagrywa, nie możesz wysyłać do niego wiadomości.");
                break;
            }
        }
    }
}
