package com.example.todo.game.entity;

import java.util.List;

public class Player {
    private String name;
    private String job;
    private int level;
    private int hp;
    private int mp;
    private int atk;
    private int matk;
    private int comboRate;
    private int criticalRate;
    private int avoidRate;
    private List<Skill> skills;

    // 追加フィールド
    private int exp;
    private int wins;
    private int maxHp;
    private int maxMp;

    // --- Getter / Setter ---
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getMp() { return mp; }
    public void setMp(int mp) { this.mp = mp; }
    public int getAtk() { return atk; }
    public void setAtk(int atk) { this.atk = atk; }
    public int getMatk() { return matk; }
    public void setMatk(int matk) { this.matk = matk; }
    public int getComboRate() { return comboRate; }
    public void setComboRate(int comboRate) { this.comboRate = comboRate; }
    public int getCriticalRate() { return criticalRate; }
    public void setCriticalRate(int criticalRate) { this.criticalRate = criticalRate; }
    public int getAvoidRate() { return avoidRate; }
    public void setAvoidRate(int avoidRate) { this.avoidRate = avoidRate; }
    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }

    public int getExp() { return exp; }
    public void setExp(int exp) { this.exp = exp; }

    public int getWins() { return wins; }
    public void setWins(int wins) { this.wins = wins; }

    public int getMaxHp() { return maxHp; }
    public void setMaxHp(int maxHp) { this.maxHp = maxHp; }

    public int getMaxMp() { return maxMp; }
    public void setMaxMp(int maxMp) { this.maxMp = maxMp; }
}