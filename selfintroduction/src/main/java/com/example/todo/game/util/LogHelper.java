package com.example.todo.game.util;

import org.springframework.stereotype.Component;

@Component
public class LogHelper {

    private final StringBuilder logBuilder = new StringBuilder();

    // ログ全体をクリア
    public void clear() {
        logBuilder.setLength(0);
    }

    // 共通ログ追加（<br>付き）
    public void append(String log) {
        logBuilder.append(log).append("<br>");
    }

    // プレイヤー側ログ（青色）
    public void appendPlayerLog(String log) {
        append("<span style='color: blue;'>" + log + "</span>");
    }

    // 敵側ログ（赤色）
    public void appendEnemyLog(String log) {
        append("<span style='color: red;'>" + log + "</span>");
    }

    // ログ取得（HTML描画用）
    public String getLog() {
        return logBuilder.toString();
    }

    // プレイヤー攻撃ログ生成
    public String buildPlayerAttackLog(String playerName, String skillName, int damage,
                                       boolean isCritical, boolean isAvoided, boolean isCombo, int hitCount) {
        if (isAvoided) {
            return "【" + playerName + "】の「" + skillName + "」！<br>→ 攻撃は回避された！";
        }

        StringBuilder log = new StringBuilder();
        log.append("【").append(playerName).append("】の「").append(skillName).append("」！<br>");

        if (isCritical) {
            log.append("→ クリティカルヒット！<br>");
        }

        log.append("→ <span style='color: blue;'>").append(damage).append("ダメージを与えた！</span>");

        if (isCombo && hitCount > 1) {
            log.append("<br>→ さらに連続攻撃が発動！ ").append(hitCount).append("ヒット！");
        }

        return log.toString();
    }

    // 敵の攻撃ログ生成
    public String buildEnemyAttackLog(String enemyName, int damage,
                                      boolean isCritical, boolean isAvoided, boolean isCombo, int hitCount) {
        if (isAvoided) {
            return "【" + enemyName + "】の攻撃！<br>→ 攻撃を回避した！";
        }

        StringBuilder log = new StringBuilder();
        log.append("【").append(enemyName).append("】の攻撃！<br>");

        if (isCritical) {
            log.append("→ クリティカルヒット！<br>");
        }

        log.append("→ <span style='color: red;'>").append(damage).append("ダメージを受けた！</span>");

        if (isCombo && hitCount > 1) {
            log.append("<br>→ さらに連続攻撃が発動！ ").append(hitCount).append("ヒット！");
        }

        return log.toString();
    }

    // スキルによるバフログ
    public String buildSkillBuffLog(String playerName, String effect) {
        return "【" + playerName + "】の「" + effect + "」の効果が発動した！";
    }

    // 勝利ログ
    public String buildBattleEndLog(String enemyName) {
        return "【" + enemyName + "】を倒した！次の敵が現れた……！";
    }

    // 敗北ログ
    public String buildBattleLoseLog(String enemyName) {
        return "【" + enemyName + "】に敗北した……";
    }

    // リタイアログ
    public String buildRetreatLog(String playerName) {
        return "【" + playerName + "】は戦いをやめた。冒険終了。";
    }
}