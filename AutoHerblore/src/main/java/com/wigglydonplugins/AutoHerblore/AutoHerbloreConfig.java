package com.wigglydonplugins.AutoHerblore;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("AutoHerblore")
public interface AutoHerbloreConfig extends Config {

  @ConfigItem(
      keyName = "base potion",
      name = "base potion",
      description = "base potion?",
      position = 0
  )
  default String BASE_POTION() {
    return "Snapdragon potion (unf)";
  }

  @ConfigItem(
      keyName = "secondary",
      name = "secondary",
      description = "secondary?",
      position = 1
  )
  default String SECONDARY() {
    return "Red spiders' eggs";
  }


}
