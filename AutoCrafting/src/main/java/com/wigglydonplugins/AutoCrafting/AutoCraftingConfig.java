package com.wigglydonplugins.AutoCrafting;

import com.wigglydonplugins.AutoCrafting.config_types.ARMOR_TYPE;
import com.wigglydonplugins.AutoCrafting.config_types.LEATHER_TYPE;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("AutoCrafting")
public interface AutoCraftingConfig extends Config {

  @ConfigItem(
      keyName = "Leather type",
      name = "Leather type",
      description = "Type of leather?",
      position = 0
  )
  default LEATHER_TYPE LEATHER_TYPE() {
    return LEATHER_TYPE.LEATHER;
  }

  @ConfigItem(
      keyName = "Armor type",
      name = "Armor type",
      description = "Type of armor?",
      position = 1
  )
  default ARMOR_TYPE ARMOR_TYPE() {
    return ARMOR_TYPE.VAMBRACES;
  }


}
