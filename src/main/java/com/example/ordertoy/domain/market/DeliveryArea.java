package com.example.ordertoy.domain.market;

public enum DeliveryArea {
  MOK1DONG("목1동"),
  MOK2DONG("목2동"),
  MOK3DONG("목3동"),
  MOK4DONG("목4동"),
  SINJUNG1DONG("신정1동"),
  SINJUNG2DONG("신정2동"),
  SINJUNG3DONG("신정3동"),
  SINJUNG4DONG("신정4동"),
  GURO1DONG("구로1동");

  private String korName;

  DeliveryArea(String korName) {
    this.korName = korName;
  }
}
