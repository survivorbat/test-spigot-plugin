package dev.maarten.testplugin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.MemoryConfiguration;
import org.junit.jupiter.api.Test;

public class ConfigTest {

  @Test
  void GetDefaultConfigValues_ReturnsExpectedValues() {
    // Act
    MemoryConfiguration result = Config.getDefaultConfigValues();

    // Assert
    Configuration defaults = result.getDefaults();

    assertEquals("Hello %s!", defaults.get("join_message"));
  }
}
