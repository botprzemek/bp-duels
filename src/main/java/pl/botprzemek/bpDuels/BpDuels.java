package pl.botprzemek.bpDuels;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;
import pl.botprzemek.bpDuels.Commands.CommandsManager;
import pl.botprzemek.bpDuels.Events.EventsManager;
import pl.botprzemek.bpDuels.Game.GameManager;
import pl.botprzemek.bpDuels.Utils.ConsoleStartup;

public final class BpDuels extends JavaPlugin {

    private static BpDuels instance;

    private BukkitAudiences adventure;

    private GameManager gameManager;

    private static MiniMessage mm = MiniMessage.miniMessage();

    public BukkitAudiences adventure() {

        if(this.adventure == null) {

            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");

        }

        return this.adventure;

    }

    @Override
    public void onEnable() {

        instance = this;

        adventure = BukkitAudiences.create(this);

        new ConsoleStartup(adventure, this);

        gameManager = new GameManager(this);

        new EventsManager(this, gameManager);

        new CommandsManager(this, gameManager);

    }

    public void onDisable() {

        if(this.adventure != null) {

            this.adventure.close();
            this.adventure = null;

        }

        gameManager.cleanUp();

    }

    public static BpDuels getInstance() {

        return instance;

    }

    public static MiniMessage getMiniMessage() {

        return mm;

    }

}