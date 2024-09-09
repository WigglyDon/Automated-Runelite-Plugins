package com.wigglydonplugins.AutoHerblore;

import com.example.EthanApiPlugin.Collections.Bank;
import com.example.EthanApiPlugin.Collections.Inventory;
import com.example.EthanApiPlugin.Collections.NPCs;
import com.example.EthanApiPlugin.Collections.Widgets;
import com.example.InteractionApi.BankInteraction;
import com.example.InteractionApi.NPCInteraction;
import com.example.Packets.MousePackets;
import com.example.Packets.WidgetPackets;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
    name = "<html><font color=\"#FF0000\">[WD]</font>Auto Herblore</html>",
    description = "Automated herblore plugin"
)
public class AutoHerblorePlugin extends Plugin {

  @Inject
  private Client client;
  @Inject
  private OverlayManager overlayManager;
  @Inject
  private AutoHerbloreOverlay overlay;
  @Inject
  private AutoHerbloreConfig config;
  boolean running = false;
  int tickDelay = 0;
  int lastCreated = 0;
  private Widget potionItem = null;

  @Provides
  private AutoHerbloreConfig getConfig(ConfigManager configManager) {
    return configManager.getConfig(AutoHerbloreConfig.class);
  }

  @Override
  protected void startUp() throws Exception {
    overlayManager.add(overlay);
    running = client.getGameState() == GameState.LOGGED_IN;
  }

  @Override
  protected void shutDown() throws Exception {
    overlayManager.remove(overlay);
    running = false;
  }

  @Subscribe
  private void onGameTick(GameTick event) {
    if (!running || tickDelay > 0) {
      tickDelay--;
      return;
    }
    if (lastCreated > 0) {
      lastCreated--;
    }

    //potion making animation
    if (client.getLocalPlayer().getAnimation() == 363 && !Inventory.full()) {
      lastCreated = 3;
    }

    Inventory.search().nameContains(config.BASE_POTION()).first()
        .ifPresent((potion) -> {
          potionItem = potion;
        });

    if (!Inventory.search().nameContains(config.BASE_POTION()).empty()) {
      if (lastCreated == 0) {
        Widgets.search().withAction("Make")
            .first()
            .ifPresentOrElse((w) -> {

              int remainingUnfPots = Inventory.getItemAmount(config.BASE_POTION());
              WidgetPackets.queueResumePause(w.getId(), remainingUnfPots);
              lastCreated = 3;

            }, () -> {
              Inventory.search().nameContains(config.BASE_POTION()).first().ifPresent(potion -> {
                Inventory.search().nameContains(config.SECONDARY()).first().ifPresent(secondary -> {
                  MousePackets.queueClickPacket();
                  MousePackets.queueClickPacket();
                  WidgetPackets.queueWidgetOnWidget(potion, secondary);
                });
              });
            });
      }


    } else if (!Bank.isOpen()) {
      NPCs.search().nameContains("Banker").nearestToPlayer().ifPresent((banker) -> {
        NPCInteraction.interact(banker, "Bank");
      });
    }
    bank();
  }

  private void bank() {
    if (Bank.isOpen()) {
      Widgets.search()
          .filter(widget -> widget.getParentId() != 786474).withAction("Deposit inventory").first()
          .ifPresent(button -> {
            MousePackets.queueClickPacket();
            WidgetPackets.queueWidgetAction(button, "Deposit inventory");
          });
      withdraw(config.BASE_POTION(), 14);
      withdraw(config.SECONDARY(), 14);
      sendKey(KeyEvent.VK_ESCAPE);
      lastCreated = 0;

    }
  }

  private void withdraw(String name, int amount) {
    Bank.search().withName(name).first().ifPresent(item ->
        BankInteraction.withdrawX(item, amount)
    );
  }

  private void sendKey(int key) {
    keyEvent(KeyEvent.KEY_PRESSED, key);
    keyEvent(KeyEvent.KEY_RELEASED, key);
  }

  private void keyEvent(int id, int key) {
    KeyEvent e = new KeyEvent(
        client.getCanvas(),
        id,
        System.currentTimeMillis(),
        0,
        key,
        KeyEvent.CHAR_UNDEFINED
    );
    client.getCanvas().dispatchEvent(e);
  }


}
