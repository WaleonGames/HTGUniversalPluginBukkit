package pl.htgmc.commands.defaults;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Arrays;

public class MsgCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Ta komenda jest tylko dla graczy!");
            return false;
        }

        Player player = (Player) sender;

        // Sprawdzamy, czy gracz podał odpowiednią liczbę argumentów
        if (args.length < 2) {
            player.sendMessage("§cPoprawne użycie: /msg <gracz> <wiadomość>");
            return false;
        }

        // Pierwszy argument to nazwa gracza, a reszta to wiadomość
        String targetName = args[0];
        String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        // Szukamy gracza o podanej nazwie
        Player target = Bukkit.getPlayer(targetName);
        if (target == null) {
            player.sendMessage("§cGracz o nazwie " + targetName + " nie jest online.");
            return false;
        }

        // Wysyłamy wiadomość do obu graczy
        player.sendMessage("§a[WIADOMOŚĆ] -> " + target.getName() + ": §f" + message);
        target.sendMessage("§a[WIADOMOŚĆ] -> " + player.getName() + ": §f" + message);

        return true;
    }
}
