package com.example.todo.game.util;

import com.example.todo.game.entity.Skill;
import com.example.todo.game.enums.Job;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SkillFactory {
    private final Map<Job, List<Skill>> jobSkills = new HashMap<>();

    public SkillFactory() {
        // --- 剣士 ---
        jobSkills.put(Job.WARRIOR, Arrays.asList(
                new Skill("通常攻撃", 0, 1.0, "1.0倍物理攻撃", false),
                new Skill("ウィークアタック", 10, -1.0, "1/2の確率でx0.5かx4", true), // 特殊処理フラグ用に-1.0
                new Skill("パワースラッシュ", 10, 2.0, "2.0倍物理攻撃", false),
                new Skill("かぶと割り", 30, 3, "3.0倍物理攻撃", false),
                new Skill("フルブレイク", 70, 5.0, "5.0倍物理攻撃", false)
        ));

        // --- 弓使い ---
        jobSkills.put(Job.ARCHER, Arrays.asList(
                new Skill("通常攻撃", 0, 1.0, "1.0倍物理攻撃", false),
                new Skill("ピアッシングショット", 15, 1.8, "1.8倍物理攻撃", false),
                new Skill("ツインアロー", 20, 1.3, "2回攻撃 x1.3倍", true, false, 100, 2),
                new Skill("イーグルアイ", 25, 2.2, "2.2倍物理攻撃", false),
                new Skill("パラライズアロー", 50, 2.5, "2.5倍+敵ATK半減", false)
        ));

        // --- 武闘家 ---
        jobSkills.put(Job.FIGHTER, Arrays.asList(
                new Skill("通常攻撃", 0, 1.0, "1.0倍物理攻撃", false),
                new Skill("拳乱舞", 30, 1.2, "3回攻撃 x1.2倍", true, false, 100, 3),
                new Skill("爆裂拳", 10, 2.5, "2.5倍物理攻撃", false),
                new Skill("カウンター", 50, 3.0, "被ダメ時に3.0倍反撃", false),
                new Skill("鉄山靡", 80, 1.8, "1.8倍+連続攻撃率+10%", false)
        ));

        // --- 魔法使い ---
        jobSkills.put(Job.MAGE, Arrays.asList(
                new Skill("通常攻撃", 0, 1.0, "1.0倍物理攻撃", false),
                new Skill("ファイアボール", 50, 4.0, "4.0倍魔法攻撃", false, true),
                new Skill("アイスランス", 70, 5.5, "5.5倍魔法攻撃", false, true),
                new Skill("サンダーストーム", 100, 8.5, "8.5倍魔法攻撃", false, true),
                new Skill("メテオストライク", 200, 15.0, "15.0倍魔法攻撃", false, true)
        ));

        // --- TestPlayer ---
        jobSkills.put(Job.TEST, Arrays.asList(
                new Skill("通常攻撃", 0, 1.0, "1.0倍物理攻撃", false),
                new Skill("弱攻撃", 10, 10.0, "10.0倍物理攻撃", false),
                new Skill("中攻撃", 20, 20.0, "20.0倍物理攻撃", false),
                new Skill("強攻撃", 30, 30.0, "30.0倍物理攻撃", false),
                new Skill("Winner", 50, 999.0, "999.0倍物理攻撃（最強）", false)
        ));
    }

    public List<Skill> getSkills(Job job) {
        return jobSkills.getOrDefault(job, new ArrayList<>());
    }

    public List<Skill> getSkills(String jobName) {
        try {
            Job job = Job.valueOf(jobName);
            return getSkills(job);
        } catch (IllegalArgumentException e) {
            return new ArrayList<>();
        }
    }
}