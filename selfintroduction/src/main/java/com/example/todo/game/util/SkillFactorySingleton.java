package com.example.todo.game.util;

public class SkillFactorySingleton {

    private static final SkillFactory INSTANCE = new SkillFactory();

    private SkillFactorySingleton() {
        // privateコンストラクタで外部からのインスタンス化を禁止
    }

    public static SkillFactory getInstance() {
        return INSTANCE;
    }
}