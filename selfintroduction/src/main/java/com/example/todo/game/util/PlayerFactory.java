package com.example.todo.game.util;

import com.example.todo.game.dto.PlayerDto;
import com.example.todo.game.enums.Job;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

@Component
public class PlayerFactory {
    private static final Random random = new Random();

    // 数値定義を一元管理
    private static final Map<Job, JobStatDefinition> jobStatDefinitions = new EnumMap<>(Job.class);

    static {
        jobStatDefinitions.put(Job.WARRIOR, new JobStatDefinition(8000, 9999, 500, 800, 1200, 1500, 0, 0, 30, 30, 10));
        jobStatDefinitions.put(Job.ARCHER, new JobStatDefinition(6000, 7000, 700, 800, 1000, 1600, 0, 0, 20, 5, 40));
        jobStatDefinitions.put(Job.FIGHTER, new JobStatDefinition(5000, 5500, 500, 600, 800, 1000, 0, 0, 80, 50, 50));
        jobStatDefinitions.put(Job.MAGE, new JobStatDefinition(3000, 4000, 1000, 1700, 200, 200, 2000, 3000, 0, 10, 10));
        jobStatDefinitions.put(Job.TEST, new JobStatDefinition(99999, 99999, 9999, 9999, 9999, 9999, 0, 0, 50, 0, 0));
    }

    public static PlayerDto generate(String name, String jobName) {
        Job job = Job.valueOf(jobName);
        JobStatDefinition def = jobStatDefinitions.get(job);
        PlayerDto dto = new PlayerDto(name, jobName);

        int hp = getRandom(def.hpMin, def.hpMax);
        int mp = getRandom(def.mpMin, def.mpMax);
        int atk = getRandom(def.atkMin, def.atkMax);
        int matk = getRandom(def.matkMin, def.matkMax);

        dto.setMaxHp(hp);
        dto.setMaxMp(mp);
        dto.setHp(hp);
        dto.setMp(mp);
        dto.setAtk(atk);
        dto.setMatk(matk);
        dto.setComboRate(def.comboRate);
        dto.setCriticalRate(def.criticalRate);
        dto.setAvoidRate(def.avoidRate);

        return dto;
    }

    private static int getRandom(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    // 表示側で使う用
    public static Map<Job, JobStatDefinition> getAllJobDefinitions() {
        return jobStatDefinitions;
    }
}