package com.example.todo.game.util;

import com.example.todo.game.enums.Job;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerStatusProvider {

    public static Map<String, Map<String, String>> getAllJobStats() {
        Map<String, Map<String, String>> stats = new LinkedHashMap<>();

        Map<Job, JobStatDefinition> definitions = PlayerFactory.getAllJobDefinitions();

        for (Map.Entry<Job, JobStatDefinition> entry : definitions.entrySet()) {
            Job job = entry.getKey();
            JobStatDefinition def = entry.getValue();

            Map<String, String> status = new LinkedHashMap<>();
            status.put("HP", formatRange(def.hpMin, def.hpMax));
            status.put("MP", formatRange(def.mpMin, def.mpMax));
            status.put("ATK", formatRange(def.atkMin, def.atkMax));
            status.put("MATK", formatRange(def.matkMin, def.matkMax));
            status.put("連続攻撃", def.comboRate + "%");
            status.put("クリティカル", def.criticalRate + "%");
            status.put("回避率", def.avoidRate + "%");

            stats.put(job.name(), status);
        }

        return stats;
    }

    private static String formatRange(int min, int max) {
        return (min == max) ? String.valueOf(min) : (min + "～" + max);
    }
}