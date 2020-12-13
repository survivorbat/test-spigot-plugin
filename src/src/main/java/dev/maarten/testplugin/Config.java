package dev.maarten.testplugin;

import org.bukkit.configuration.MemoryConfiguration;

public final class Config {

  public static MemoryConfiguration getDefaultConfigValues() {
    MemoryConfiguration configuration = new MemoryConfiguration();

    configuration.addDefault("join_message", "Hello %s!");

    return configuration;
  }
}
