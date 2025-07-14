package com.example.todo.game.util;

public class JobStatDefinition {
    public final int hpMin, hpMax;
    public final int mpMin, mpMax;
    public final int atkMin, atkMax;
    public final int matkMin, matkMax;
    public final int comboRate;
    public final int criticalRate;
    public final int avoidRate;

    public JobStatDefinition(int hpMin, int hpMax, int mpMin, int mpMax,
                             int atkMin, int atkMax, int matkMin, int matkMax,
                             int comboRate, int criticalRate, int avoidRate) {
        this.hpMin = hpMin;
        this.hpMax = hpMax;
        this.mpMin = mpMin;
        this.mpMax = mpMax;
        this.atkMin = atkMin;
        this.atkMax = atkMax;
        this.matkMin = matkMin;
        this.matkMax = matkMax;
        this.comboRate = comboRate;
        this.criticalRate = criticalRate;
        this.avoidRate = avoidRate;
    }
}