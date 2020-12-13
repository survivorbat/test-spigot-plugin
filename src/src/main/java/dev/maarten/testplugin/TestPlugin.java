package dev.maarten.testplugin;

import java.io.File;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

public final class TestPlugin extends JavaPlugin implements Listener {
  private final FileConfiguration configuration = this.getConfig();
  private final Logger logger = this.getLogger();

  /**
   * Allows us to mock the plugin
   */
  protected TestPlugin(
    JavaPluginLoader loader,
    PluginDescriptionFile description,
    File dataFolder,
    File file
  ) {
    super(loader, description, dataFolder, file);
  }

  public TestPlugin() {}

  @Override
  public void onEnable() {
    saveDefaultConfig();
    getServer().getPluginManager().registerEvents(this, this);
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();

    String joinTemplate = this.configuration.getString("join_message");

    if (joinTemplate != null) {
      event.setJoinMessage(String.format(joinTemplate, player.getDisplayName()));
    }
  }
}
