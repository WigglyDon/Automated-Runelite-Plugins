package com.wigglydonplugins.AutoCrafting.config_types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LEATHER_TYPE {
  LEATHER(1741),
  GREEN_DRAGON_LEATHER(1745),
  BLUE_DRAGON_LEATHER(	2505),
  RED_DRAGON_LEATHER(2507),
  BLACK_DRAGON_LEATHER(2509);

  private final int leatherType;
}
