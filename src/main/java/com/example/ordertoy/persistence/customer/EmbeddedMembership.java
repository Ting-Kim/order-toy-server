package com.example.ordertoy.persistence.customer;

import com.example.ordertoy.domain.customer.Grade;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class EmbeddedMembership {

  @Column(name = "membership_grade")
  private Grade grade;

  @Column(name = "membership_point")
  private Integer point;

  private EmbeddedMembership(Grade grade, Integer point) {
    this.grade = grade;
    this.point = point;
  }

  public static EmbeddedMembership of(Grade grade, Integer point) {
    return new EmbeddedMembership(grade, point);
  }

  public static EmbeddedMembership create() {
    return new EmbeddedMembership(Grade.STONE, 0);
  }
}
