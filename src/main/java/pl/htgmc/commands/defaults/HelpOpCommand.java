package pl.htgmc.commands.defaults;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.htgmc.Main;

public class HelpOpCommand implements CommandExecutor {
    private final Main plugin;

    public HelpOpCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Musisz podać treść wiadomości.");
                return false;
            }

            String message = String.join(" ", args);
            String helpOpMessage = ChatColor.RED + "[HELP] " + player.getName() + ": " + message;

            // Wysyłamy wiadomość do wszystkich administratorów
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (onlinePlayer.hasPermission("htgmc.helpop")) {
                    onlinePlayer.sendMessage(helpOpMessage);
                }
            }

            player.sendMessage(ChatColor.GREEN + "Twoja prośba o pomoc została wysłana.");
            return true;
        }

        sender.sendMessage("Tylko gracze mogą używać tej komendy.");
        return false;
    }
}

