package com.example.todo.game.entity;

public class Enemy {
    private String name;
    private int level;
    private int hp;
    private int maxHp; // ⭐ 追加：最大HP
    private int atk;
    private int exp;
    private int criticalRate;
    private int comboRate;
    private int avoidRate;
    private boolean isBoss;
    private boolean paralyzed; // ✅ パラライズ状態（バトル中永続）

    // --- コンストラクタ ---
    public Enemy() {}

    public Enemy(String name, int level, int hp, int atk, int exp, int criticalRate, int comboRate, int avoidRate) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp; // ⭐ 初期化時に maxHp を設定
        this.atk = atk;
        this.exp = exp;
        this.criticalRate = criticalRate;
        this.comboRate = comboRate;
        this.avoidRate = avoidRate;
    }

    public Enemy(String name, int level, int hp, int atk, int exp, int criticalRate, int comboRate) {
        this(name, level, hp, atk, exp, criticalRate, comboRate, 0);
    }

    // --- Getter ---
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp; // ⭐ Getter 追加
    }

    public int getAtk() {
        return paralyzed ? atk / 2 : atk; // ✅ パラライズ時はATK半減
    }

    public int getExp() {
        return exp;
    }

    public int getCriticalRate() {
        return criticalRate;
    }

    public int getComboRate() {
        return comboRate;
    }

    public int getAvoidRate() {
        return avoidRate;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public boolean isParalyzed() {
        return paralyzed;
    }

    // --- Setter ---
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp; // ⭐ Setter 追加
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setCriticalRate(int criticalRate) {
        this.criticalRate = criticalRate;
    }

    public void setComboRate(int comboRate) {
        this.comboRate = comboRate;
    }

    public void setAvoidRate(int avoidRate) {
        this.avoidRate = avoidRate;
    }

    public void setBoss(boolean boss) {
        isBoss = boss;
    }

    public void setParalyzed(boolean paralyzed) {
        this.paralyzed = paralyzed;
    }
}