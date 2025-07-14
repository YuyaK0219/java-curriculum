package com.example.todo.game.util;

import com.example.todo.game.entity.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyFactory {

    private static final List<Enemy> enemies = new ArrayList<>();
    private static final Random random = new Random();

    static {
        // 通常の敵（24体）
        enemies.add(createNormalEnemy("スライムLv10", 10, 800, 80, 150));
        enemies.add(createNormalEnemy("ゴブリンLv20", 20, 1100, 110, 200));
        enemies.add(createNormalEnemy("スケルトンLv30", 30, 1400, 140, 250));
        enemies.add(createNormalEnemy("ゴブリンLv40", 40, 1700, 170, 300));
        enemies.add(createNormalEnemy("スライムLv50", 50, 2000, 200, 350));
        enemies.add(createNormalEnemy("スケルトンLv60", 60, 2300, 230, 400));
        enemies.add(createNormalEnemy("スライムLv70", 70, 2600, 260, 450));
        enemies.add(createNormalEnemy("ゴブリンLv80", 80, 2900, 290, 500));
        enemies.add(createNormalEnemy("スケルトンLv90", 90, 3200, 320, 550));
        enemies.add(createNormalEnemy("ゴブリンLv100", 100, 3500, 350, 600));
        enemies.add(createNormalEnemy("スライムLv110", 110, 3800, 380, 650));
        enemies.add(createNormalEnemy("スケルトンLv120", 120, 4100, 410, 700));
        enemies.add(createNormalEnemy("スライムLv130", 130, 4400, 440, 750));
        enemies.add(createNormalEnemy("ゴブリンLv140", 140, 4700, 470, 800));
        enemies.add(createNormalEnemy("スケルトンLv150", 150, 5000, 500, 850));
        enemies.add(createNormalEnemy("ゴブリンLv160", 160, 5300, 530, 900));
        enemies.add(createNormalEnemy("スライムLv170", 170, 5600, 560, 950));
        enemies.add(createNormalEnemy("スケルトンLv180", 180, 5900, 590, 1000));
        enemies.add(createNormalEnemy("スライムLv190", 190, 6200, 620, 1050));
        enemies.add(createNormalEnemy("ゴブリンLv200", 200, 6500, 650, 1100));
        enemies.add(createNormalEnemy("スケルトンLv210", 210, 6800, 680, 1150));
        enemies.add(createNormalEnemy("ゴブリンLv220", 220, 7100, 710, 1200));
        enemies.add(createNormalEnemy("スライムLv230", 230, 7400, 740, 1250));
        enemies.add(createNormalEnemy("スケルトンLv240", 240, 7700, 770, 1300));

        // 強敵（5体）
        enemies.add(createBoss("死神リーパー", 200, 15000, 1200, 30000, 20));
        enemies.add(createBoss("深淵の騎士", 250, 15500, 1450, 45000, 30));
        enemies.add(createBoss("地獄の炎王", 300, 18000, 1700, 60000, 20));
        enemies.add(createBoss("虚無の亡霊", 350, 20500, 1950, 75000, 10));
        enemies.add(createBoss("破壊神ヴァルゴス", 399, 49999, 3999, 99999, 10));

        // レア雑魚
        Enemy gold = new Enemy();
        gold.setName("ゴールデンスライム");
        gold.setLevel(1);
        gold.setHp(500);
        gold.setMaxHp(500);
        gold.setAtk(50);
        gold.setExp(90000);
        gold.setCriticalRate(20);
        gold.setComboRate(0);
        gold.setAvoidRate(0);
        gold.setBoss(false);
        enemies.add(gold);
    }

    private static Enemy createNormalEnemy(String name, int level, int hp, int atk, int exp) {
        Enemy e = new Enemy();
        e.setName(name);
        e.setLevel(level);
        e.setHp(hp);
        e.setMaxHp(hp);
        e.setAtk(atk);
        e.setExp(exp);
        e.setCriticalRate(20);
        e.setComboRate(0);
        e.setAvoidRate(0);
        e.setBoss(false);
        return e;
    }

    private static Enemy createBoss(String name, int level, int hp, int atk, int exp, int comboRate) {
        Enemy boss = new Enemy();
        boss.setName(name);
        boss.setLevel(level);
        boss.setHp(hp);
        boss.setMaxHp(hp);
        boss.setAtk(atk);
        boss.setExp(exp);
        boss.setCriticalRate(20);
        boss.setComboRate(comboRate);
        boss.setAvoidRate(0);
        boss.setBoss(true);
        return boss;
    }

    public static Enemy randomEnemy(int battleCount) {
        Enemy original;
        int roll = random.nextInt(100);

        if (battleCount > 50) {
            // 50戦超えたら常にボス
            original = enemies.get(24 + random.nextInt(5));
        } else if (battleCount != 0 && (battleCount % 10 == 0 || roll < 1)) {
            original = enemies.get(24 + random.nextInt(5)); // 通常ボス
        } else if (roll == 1) {
            original = enemies.get(29); // ゴールデンスライム
        } else {
            original = enemies.get(random.nextInt(24)); // 通常敵
        }

        Enemy copy = copyEnemy(original);

        // 強化ロジック
        double rate = 1.0;
        double expRate = 1.0;

        if (battleCount > 50) {
            double baseBoost = 1.0 + (50 * 0.50); // 50戦までの通常強化（×11.0）
            rate = baseBoost * Math.pow(1.3, battleCount - 50); // HP/ATKはそのまま継続で強くなる

            // ★EXPのみ0.3倍に抑える（50戦目以降）
            expRate = 0.03 * (baseBoost * Math.pow(1.05, battleCount - 50));
        } else if (battleCount > 10) {
            rate = 1.0 + (battleCount * 0.20);
            expRate = rate; // EXPも同様に伸ばす（自然）
        }

        // ステータス強化
        copy.setHp((int) (copy.getHp() * rate));
        copy.setMaxHp(copy.getHp());
        copy.setAtk((int) (copy.getAtk() * rate));

        // EXPだけ控えめ（上記で分岐済み）
        copy.setExp((int) (copy.getExp() * expRate));

        return copy;
    }

    private static Enemy copyEnemy(Enemy original) {
        Enemy copy = new Enemy();
        copy.setName(original.getName());
        copy.setLevel(original.getLevel());
        copy.setHp(original.getHp());
        copy.setMaxHp(original.getHp());
        copy.setAtk(original.getAtk());
        copy.setExp(original.getExp());
        copy.setCriticalRate(original.getCriticalRate());
        copy.setComboRate(original.getComboRate());
        copy.setAvoidRate(original.getAvoidRate());
        copy.setBoss(original.isBoss());
        return copy;
    }
}