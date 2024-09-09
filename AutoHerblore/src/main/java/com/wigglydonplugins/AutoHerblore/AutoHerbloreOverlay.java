package com.wigglydonplugins.AutoHerblore;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
import net.runelite.api.Client;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

public class AutoHerbloreOverlay extends OverlayPanel {

  private final Client client;
  private final AutoHerblorePlugin plugin;


  @Inject
  private AutoHerbloreOverlay(Client client, SpriteManager spriteManager,
      AutoHerblorePlugin plugin) {
    super(plugin);
    this.client = client;
    this.plugin = plugin;
    setPosition(OverlayPosition.BOTTOM_RIGHT);
    setLayer(OverlayLayer.ABOVE_WIDGETS);
  }

  @Override
  public Dimension render(Graphics2D graphics2D) {
    panelComponent.getChildren().clear();

    LineComponent tickDelay = buildLine("Tick Delay: ", Integer.toString(plugin.tickDelay));
    panelComponent.getChildren().add(tickDelay);

    LineComponent lastCreated = buildLine("Last Created: ", Integer.toString(plugin.lastCreated));
    panelComponent.getChildren().add(lastCreated);

    return super.render(graphics2D);
  }

  private LineComponent buildLine(String left, String right) {
    return LineComponent.builder()
        .left(left)
        .right(right)
        .leftColor(Color.WHITE)
        .rightColor(Color.YELLOW)
        .build();
  }

  private String formatTime(Long timeInMillis) {
    long hours = TimeUnit.MILLISECONDS.toHours(timeInMillis);
    long minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) % 60;
    long seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) % 60;

    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
}
