package com.example.todo.game.util;

import com.example.todo.game.dto.PlayerDto;
import com.example.todo.game.entity.Enemy;
import com.example.todo.game.entity.Skill;
import com.example.todo.game.enums.Job;

import java.util.List;
import java.util.Random;

public class SkillExecutor {

    private static final Random random = new Random();

    public static void execute(PlayerDto player, Enemy enemy, String action, LogHelper logHelper) {
        List<Skill> skills = SkillFactorySingleton.getInstance().getSkills(player.getJob());
        Skill selectedSkill = skills.stream()
                .filter(skill -> skill.getName().equals(action))
                .findFirst()
                .orElse(null);

        if (selectedSkill == null) {
            logHelper.appendPlayerLog("スキルが見つかりません。");
            return;
        }

        if (player.getMp() < selectedSkill.getMp()) {
            logHelper.appendPlayerLog("MPが足りません！");
            return;
        }

        player.setMp(player.getMp() - selectedSkill.getMp());

        int basePower = selectedSkill.isMagic() ? player.getMatk() : player.getAtk();

        int totalDamage = 0;
        int hitCount = 0;
        boolean anyHit = false;
        boolean anyCritical = false;

        int lifeStealSum = 0;
        int mpStealSum = 0;

        for (int i = 0; i < selectedSkill.getHitCount(); i++) {
            if (random.nextInt(100) < enemy.getAvoidRate()) {
                continue;
            }

            double multiplier = selectedSkill.getMultiplier();

            if ("ウィークアタック".equals(selectedSkill.getName())) {
                multiplier = random.nextBoolean() ? 0.5 : 4.0;
            }

            int damage = (int) (basePower * multiplier);

            if (player.isKabutowariActive()) {
                damage = (int) (damage * 1.3);
            }

            int stability = player.getJob().equals(Job.TEST) ? 100 : random.nextInt(31) + 70;
            int min = (int) (damage * (stability / 100.0));
            int max = damage;
            damage = random.nextInt(max - min + 1) + min;

            boolean critical = (random.nextInt(100) < player.getCriticalRate());
            if (critical) {
                damage *= 2;
                anyCritical = true;
            }

            totalDamage += damage;
            hitCount++;
            anyHit = true;

            if (player.hasLifeSteal()) {
                lifeStealSum += Math.max(1, (int) (damage * 0.02));
            }
            if (player.hasMpSteal()) {
                mpStealSum += Math.max(1, (int) (damage * 0.01));
            }
        }

        if (anyHit) {
            enemy.setHp(Math.max(0, enemy.getHp() - totalDamage));
        }

        String log = logHelper.buildPlayerAttackLog(
                player.getName(),
                selectedSkill.getName(),
                totalDamage,
                anyCritical,
                !anyHit,
                selectedSkill.getHitCount() > 1,
                hitCount
        );
        logHelper.appendPlayerLog(log);

        if (lifeStealSum > 0) {
            int newHp = Math.min(player.getHp() + lifeStealSum, player.getMaxHp());
            player.setHp(newHp);
            logHelper.appendPlayerLog("→ HP吸収効果により " + lifeStealSum + " 回復！");
        }
        if (mpStealSum > 0) {
            mpStealSum = Math.min(mpStealSum, 100);  // 吸収上限を100に制限
            int newMp = Math.min(player.getMp() + mpStealSum, player.getMaxMp());
            player.setMp(newMp);
            logHelper.appendPlayerLog("→ MP吸収効果により " + mpStealSum + " 回復！");
        }

        // 状態異常・特殊効果処理
        if ("かぶとわり".equals(selectedSkill.getName()) && !player.isKabutoBroken()) {
            player.setKabutoBroken(true);
            player.setKabutowariActive(true);
            logHelper.appendPlayerLog("→ 『かぶとわり』の効果でダメージが1.3倍になります（バトル中永続）");
        } else if ("パラライズアロー".equals(selectedSkill.getName())) {
            enemy.setParalyzed(true);
            logHelper.appendPlayerLog("→ 『パラライズアロー』の効果で敵の攻撃力が半減します（バトル中永続）");
        } else if ("鉄山靡".equals(selectedSkill.getName())) {
            if (!player.isTetsuzanpiUsed()) {
                player.setTetsuzanpiUsed(true);
                player.addComboBuff(10);
                logHelper.appendPlayerLog("→ 『鉄山靡』の効果で連続攻撃率が10%上昇します（バトル中のみ）");
            }
        }
    }

    public static void enemyAttack(PlayerDto player, Enemy enemy, LogHelper logHelper) {
        int totalDamage = 0;
        boolean isCritical = false;
        boolean isAvoided = false;
        boolean isCombo = enemy.getComboRate() > 0;
        int hitCount = 0;

        for (int i = 0; i < 3; i++) {
            if (i > 0 && random.nextInt(100) >= enemy.getComboRate()) break;

            if (random.nextInt(100) < player.getAvoidRate()) {
                isAvoided = true;
                break;
            }

            int damage = enemy.getAtk();

            if (enemy.isParalyzed()) {
                damage = damage / 2;
            }

            int stability = 70;
            int min = (int) (damage * (stability / 100.0));
            int max = damage;
            damage = random.nextInt(max - min + 1) + min;

            boolean thisCritical = (random.nextInt(100) < enemy.getCriticalRate());
            if (thisCritical) {
                damage *= 2;
                isCritical = true;
            }

            totalDamage += damage;
            hitCount++;
        }

        player.setHp(Math.max(0, player.getHp() - totalDamage));

        String log = logHelper.buildEnemyAttackLog(
                enemy.getName(),
                totalDamage,
                isCritical,
                isAvoided,
                isCombo,
                hitCount
        );
        logHelper.appendEnemyLog(log);
    }

    public static boolean shouldCombo(PlayerDto player) {
        return random.nextInt(100) < player.getComboRate();
    }

    public static void executeComboAttack(PlayerDto player, Enemy enemy, LogHelper logHelper) {
        if (enemy.getHp() <= 0) return;

        int baseDamage = player.getAtk();

        if (player.isKabutowariActive()) {
            baseDamage = (int) (baseDamage * 1.3);
        }

        int stability = player.getJob().equals(Job.TEST) ? 100 : random.nextInt(31) + 70;
        int min = (int) (baseDamage * (stability / 100.0));
        int max = baseDamage;
        int damage = random.nextInt(max - min + 1) + min;

        boolean avoided = (random.nextInt(100) < enemy.getAvoidRate());
        if (avoided) {
            logHelper.appendPlayerLog("→ 通常攻撃（追撃）は回避された！");
            return;
        }

        boolean critical = (random.nextInt(100) < player.getCriticalRate());
        if (critical) damage *= 2;

        enemy.setHp(Math.max(0, enemy.getHp() - damage));

        String log = logHelper.buildPlayerAttackLog(
                player.getName(),
                "通常攻撃（追撃）",
                damage,
                critical,
                false,
                false,
                1
        );
        logHelper.appendPlayerLog(log);

        int heal = 0;
        int mpGain = 0;

        if (player.hasLifeSteal()) {
            heal = Math.max(1, (int) (damage * 0.02));
            player.setHp(Math.min(player.getHp() + heal, player.getMaxHp()));
        }

        if (player.hasMpSteal()) {
            mpGain = Math.max(1, (int) (damage * 0.005));
            mpGain = Math.min(mpGain, 20); // 吸収量の最大値100に制限
            player.setMp(Math.min(player.getMp() + mpGain, player.getMaxMp()));
        }

        if (heal > 0) {
            logHelper.appendPlayerLog("→ HP吸収効果により " + heal + " 回復！");
        }
        if (mpGain > 0) {
            logHelper.appendPlayerLog("→ MP吸収効果により " + mpGain + " 回復！");
        }
    }
}