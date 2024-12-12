package pl.htgmc;

import org.bukkit.plugin.java.JavaPlugin;
import pl.htgmc.commands.admin.SetSpawnCommand;
import pl.htgmc.commands.defaults.*;
import pl.htgmc.commands.premium.*;
import pl.htgmc.listeners.RecordingListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        // Rejestracja komend
        this.registerCommands();

        this.registerListeners();
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new RecordingListener(), this);
    }

    private void registerCommands() {
        // Zmienna z linkiem do Discorda (możesz to dostosować)
        String discordLink = "https://discord.gg/4RsfKMnw";
        String url = "https://htgmc.odoo.com";

        // Rejestracja komend graczy
        this.getCommand("help").setExecutor(new HelpCommand());
        this.getCommand("msg").setExecutor(new MsgCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("helpop").setExecutor(new HelpOpCommand(this));
        this.getCommand("discord").setExecutor(new DiscordCommand(discordLink));
        this.getCommand("strona").setExecutor(new StronaCommand(url));

        // Rejestracja komend premium
        this.getCommand("feed").setExecutor(new FeedCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("enderchest").setExecutor(new EnderchestCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("repair").setExecutor(new RepairCommand());

        // Rejestracja komend administracyjnych
        this.getCommand("setspawn").setExecutor(new SetSpawnCommand());
    }
}
