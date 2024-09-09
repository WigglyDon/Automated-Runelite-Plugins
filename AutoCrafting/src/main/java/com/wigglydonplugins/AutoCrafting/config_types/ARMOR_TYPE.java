package com.wigglydonplugins.AutoCrafting.config_types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ARMOR_TYPE {
  VAMBRACES("vambraces", 1),
  CHAPS("chaps", 2),
  BODY("body", 3),
  ANY_SOFT_LEATHER("any soft leather", 1);

  private final String armorType;
  private final int leatherNeeded;
}
