package dev.maarten.testplugin;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestPluginTest {
  private ServerMock server;
  private TestPlugin plugin;

  @Before
  public void setUp() {
    server = MockBukkit.mock();
    plugin = (TestPlugin) MockBukkit.load(TestPlugin.class);
  }

  @After
  public void tearDown() {
    MockBukkit.unmock();
  }

  @Test
  void onEnable_SavesDefaultConfig() {
    // TODO: Finish
  }
}
