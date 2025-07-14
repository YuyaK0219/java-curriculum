package com.example.todo.game.entity;

public class Skill {
    private String name;
    private int mp;
    private double multiplier;
    private String note;
    private boolean isMultiAttack;
    private boolean isMagic;

    private int stability;   // 安定率（例：100=±0%、90=±10%、80=±20%）
    private int hitCount;    // 多段攻撃数（通常1）

    // --- 通常スキル（物理単体 or 多段） ---
    public Skill(String name, int mp, double multiplier, String note, boolean isMultiAttack) {
        this(name, mp, multiplier, note, isMultiAttack, false);
    }

    // --- 魔法・物理共通スキル（6引数） ---
    public Skill(String name, int mp, double multiplier, String note, boolean isMultiAttack, boolean isMagic) {
        this.name = name;
        this.mp = mp;
        this.multiplier = multiplier;
        this.note = note;
        this.isMultiAttack = isMultiAttack;
        this.isMagic = isMagic;

        // 初期設定：多段数・安定率
        this.stability = 70;
        this.hitCount = isMultiAttack ? estimateHitCountFromNote(note) : 1;
    }

    // --- フル指定用（上級者向け） ---
    public Skill(String name, int mp, double multiplier, String note,
                 boolean isMultiAttack, boolean isMagic, int stability, int hitCount) {
        this.name = name;
        this.mp = mp;
        this.multiplier = multiplier;
        this.note = note;
        this.isMultiAttack = isMultiAttack;
        this.isMagic = isMagic;
        this.stability = stability;
        this.hitCount = hitCount;
    }

    // --- 自動でnoteから段数を推測（例："3回攻撃" → 3） ---
    private int estimateHitCountFromNote(String note) {
        if (note == null) return 2;
        if (note.contains("3回")) return 3;
        if (note.contains("4回")) return 4;
        if (note.contains("2回")) return 2;
        return 2; // デフォルト
    }

    // --- Getter / Setter ---
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMp() { return mp; }
    public void setMp(int mp) { this.mp = mp; }

    public double getMultiplier() { return multiplier; }
    public void setMultiplier(double multiplier) { this.multiplier = multiplier; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public boolean isMultiAttack() { return isMultiAttack; }
    public void setMultiAttack(boolean multiAttack) { isMultiAttack = multiAttack; }

    public boolean isMagic() { return isMagic; }
    public void setMagic(boolean magic) { isMagic = magic; }

    public int getStability() { return stability; }
    public void setStability(int stability) { this.stability = stability; }

    public int getHitCount() { return hitCount; }
    public void setHitCount(int hitCount) { this.hitCount = hitCount; }
}