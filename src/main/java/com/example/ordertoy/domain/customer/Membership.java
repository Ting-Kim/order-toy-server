package com.example.ordertoy.domain.customer;

public class Membership {

    private Grade grade;

    private int point;

    private Membership(Grade grade, int point) {
        this.grade = grade;
        this.point = point;
    }

    public static Membership of(Grade grade, int point) {
        return new Membership(grade, point);
    }

    public static Membership create() {
        return new Membership(Grade.STONE, 0);
    }
}
