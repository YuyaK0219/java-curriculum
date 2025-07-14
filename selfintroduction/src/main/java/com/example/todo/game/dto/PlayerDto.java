package com.example.todo.game.dto;

import com.example.todo.game.entity.Skill;
import java.util.List;

public class PlayerDto {
    private static final int MAX_HP_LIMIT = 99999;
    private static final int MAX_MP_LIMIT = 9999;

    private String name;
    private String job;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int atk;
    private int matk;
    private int level;
    private int exp;
    private int expToNextLevel;
    private int wins;
    private int baseComboRate;
    private int comboBuff;
    private int criticalRate;
    private int avoidRate;
    private boolean usedRecovery;
    private boolean itemAvailable;

    private boolean kabutoBroken;
    private boolean kabutowariActive;
    private boolean tetsuzanpiUsed;

    private int lastGainedExp;

    private boolean hasLifeSteal;
    private boolean hasMpSteal;
    private boolean boostedGrowth;
    private boolean hasAvoidBuff;
    private boolean hasCriticalBuff;

    private int tempHpSteal = 0;
    private int tempMpSteal = 0;

    private int hpMin;
    private int hpMax;
    private int mpMin;
    private int mpMax;
    private int atkMin;
    private int atkMax;
    private int matkMin;
    private int matkMax;

    private List<Skill> skills;

    public PlayerDto(String name, String job) {
        this.name = name;
        this.job = job;
        this.level = 1;
        this.exp = 0;
        this.expToNextLevel = 100;
        this.wins = 0;
        this.usedRecovery = false;
        this.lastGainedExp = 0;
        this.comboBuff = 0;
    }

    public String getName() { return name; }
    public String getJob() { return job; }
    public int getHp() { return hp; }
    public int getMp() { return mp; }
    public int getAtk() { return atk; }
    public int getMatk() { return matk; }
    public int getLevel() { return level; }
    public int getExp() { return exp; }
    public int getExpToNextLevel() { return expToNextLevel; }
    public int getWins() { return wins; }
    public int getCriticalRate() { return criticalRate; }
    public int getAvoidRate() { return avoidRate; }
    public boolean isUsedRecovery() { return usedRecovery; }
    public int getMaxHp() { return maxHp; }
    public int getMaxMp() { return maxMp; }
    public boolean isItemAvailable() { return itemAvailable; }

    public void setHp(int hp) {
        this.hp = Math.max(0, Math.min(hp, this.maxHp));
    }

    public void setMp(int mp) {
        this.mp = Math.max(0, Math.min(mp, this.maxMp));
    }

    public void setAtk(int atk) { this.atk = atk; }
    public void setMatk(int matk) { this.matk = matk; }
    public void setCriticalRate(int criticalRate) { this.criticalRate = criticalRate; }
    public void setAvoidRate(int avoidRate) { this.avoidRate = avoidRate; }

    public void setMaxHp(int maxHp) {
        this.maxHp = Math.min(maxHp, MAX_HP_LIMIT);
        if (this.hp <= 0 || this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = Math.min(maxMp, MAX_MP_LIMIT);
        if (this.mp < 0 || this.mp > this.maxMp) {
            this.mp = this.maxMp;
        }
    }

    public void setItemAvailable(boolean itemAvailable) { this.itemAvailable = itemAvailable; }

    public int getComboRate() { return baseComboRate + comboBuff; }
    public void setComboRate(int comboRate) { this.baseComboRate = comboRate; }
    public void addComboBuff(int amount) { this.comboBuff += amount; }
    public void resetComboBuff() { this.comboBuff = 0; }

    public boolean isKabutoBroken() { return kabutoBroken; }
    public void setKabutoBroken(boolean kabutoBroken) { this.kabutoBroken = kabutoBroken; }
    public boolean isKabutowariActive() { return kabutowariActive; }
    public void setKabutowariActive(boolean kabutowariActive) { this.kabutowariActive = kabutowariActive; }
    public boolean isTetsuzanpiUsed() { return tetsuzanpiUsed; }
    public void setTetsuzanpiUsed(boolean tetsuzanpiUsed) { this.tetsuzanpiUsed = tetsuzanpiUsed; }

    public void gainExp(int amount) {
        if (boostedGrowth) {
            amount *= 2;
        }
        this.lastGainedExp = amount;
        exp += amount;
        while (exp >= expToNextLevel) {
            exp -= expToNextLevel;
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        int oldMaxHp = maxHp;
        int oldMaxMp = maxMp;

        setMaxHp(maxHp + (int)(maxHp * 0.005));
        setMaxMp(maxMp + (int)(maxMp * 0.001));
        atk  += (int)(atk * 0.01);
        matk += (int)(matk * 0.01);

        this.hp += (this.maxHp - oldMaxHp);
        this.mp += (this.maxMp - oldMaxMp);

        this.hp = Math.min(this.hp, maxHp);
        this.mp = Math.min(this.mp, maxMp);

        expToNextLevel += 20;
    }

    public void incrementWins() { this.wins++; }

    public void useRecoveryItem() {
        this.hp = this.maxHp;
        this.mp = this.maxMp;
        this.usedRecovery = true;
    }

    public int getHpMin() { return hpMin; }
    public void setHpMin(int hpMin) { this.hpMin = hpMin; }
    public int getHpMax() { return hpMax; }
    public void setHpMax(int hpMax) { this.hpMax = hpMax; }
    public int getMpMin() { return mpMin; }
    public void setMpMin(int mpMin) { this.mpMin = mpMin; }
    public int getMpMax() { return mpMax; }
    public void setMpMax(int mpMax) { this.mpMax = mpMax; }
    public int getAtkMin() { return atkMin; }
    public void setAtkMin(int atkMin) { this.atkMin = atkMin; }
    public int getAtkMax() { return atkMax; }
    public void setAtkMax(int atkMax) { this.atkMax = atkMax; }
    public int getMatkMin() { return matkMin; }
    public void setMatkMin(int matkMin) { this.matkMin = matkMin; }
    public int getMatkMax() { return matkMax; }
    public void setMatkMax(int matkMax) { this.matkMax = matkMax; }

    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }

    public int getCurrentExp() { return exp; }
    public int getNextLevelExp() { return expToNextLevel; }
    public int getLastGainedExp() { return lastGainedExp; }
    public void setLastGainedExp(int lastGainedExp) { this.lastGainedExp = lastGainedExp; }

    public boolean hasLifeSteal() { return hasLifeSteal; }
    public void setHasLifeSteal(boolean hasLifeSteal) { this.hasLifeSteal = hasLifeSteal; }

    public boolean hasMpSteal() { return hasMpSteal; }
    public void setHasMpSteal(boolean hasMpSteal) { this.hasMpSteal = hasMpSteal; }

    public boolean isBoostedGrowth() { return boostedGrowth; }
    public void setBoostedGrowth(boolean boostedGrowth) { this.boostedGrowth = boostedGrowth; }

    public boolean hasAvoidBuff() { return hasAvoidBuff; }
    public void setHasAvoidBuff(boolean hasAvoidBuff) { this.hasAvoidBuff = hasAvoidBuff; }

    public boolean hasCriticalBuff() { return hasCriticalBuff; }
    public void setHasCriticalBuff(boolean hasCriticalBuff) { this.hasCriticalBuff = hasCriticalBuff; }

    public int getTempHpSteal() { return tempHpSteal; }
    public void setTempHpSteal(int tempHpSteal) { this.tempHpSteal = tempHpSteal; }

    public int getTempMpSteal() { return tempMpSteal; }
    public void setTempMpSteal(int tempMpSteal) { this.tempMpSteal = tempMpSteal; }

    public String getExtraPassivesDisplay() {
        StringBuilder sb = new StringBuilder();
        if (hasLifeSteal || hasMpSteal || boostedGrowth || hasCriticalBuff || hasAvoidBuff) {
            sb.append("Extra passive:<br>");
            if (hasLifeSteal) sb.append("&emsp;Life Steal 2%<br>");
            if (hasMpSteal) sb.append("&emsp;Magic Steal 1%<br>");
            if (boostedGrowth) sb.append("&emsp;EXP Boost ×2<br>");
            if (hasCriticalBuff) sb.append("&emsp;Crit Rate +10%<br>");
            if (hasAvoidBuff) sb.append("&emsp;Avoid Rate +10%<br>");
        }
        return sb.toString();
    }

    public boolean isLowHp() {
        return this.hp < this.maxHp * 0.3;
    }
}