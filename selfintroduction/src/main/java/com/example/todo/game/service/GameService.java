package com.example.todo.game.service;

import com.example.todo.game.dto.PlayerDto;
import com.example.todo.game.entity.Enemy;
import com.example.todo.game.util.EnemyFactory;
import com.example.todo.game.util.LogHelper;
import com.example.todo.game.util.PlayerFactory;
import com.example.todo.game.util.SkillExecutor;
import com.example.todo.game.util.SkillFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private LogHelper logHelper;

    @Autowired
    private SkillFactory skillFactory;

    // プレイヤー生成
    public PlayerDto createPlayer(String name, String job) {
        PlayerDto player = PlayerFactory.generate(name, job);
        player.setSkills(skillFactory.getSkills(job)); // スキル設定
        player.setItemAvailable(true); // 回復アイテム使用可（1回限り）
        logHelper.clear(); // ログ初期化
        logHelper.appendPlayerLog("【" + name + "】の冒険が始まる！");
        return player;
    }

    // 敵生成
    public Enemy generateEnemy(int wins) {
        Enemy enemy = EnemyFactory.randomEnemy(wins);
        logHelper.appendEnemyLog("敵【" + enemy.getName() + "】（Lv." + enemy.getLevel() + "）が現れた！");
        return enemy;
    }

    // ターン処理
    public void executeTurn(PlayerDto player, Enemy enemy, String action) {
        // プレイヤーの行動
        logHelper.appendPlayerLog("【" + player.getName() + "】のターン！");
        SkillExecutor.execute(player, enemy, action, logHelper);

        // 連続攻撃処理（敵が生存中）
        while (enemy.getHp() > 0 && SkillExecutor.shouldCombo(player)) {
            SkillExecutor.executeComboAttack(player, enemy, logHelper);
        }

        // 敵の行動
        if (enemy.getHp() > 0) {
            logHelper.appendEnemyLog("【" + enemy.getName() + "】のターン！");
            SkillExecutor.enemyAttack(player, enemy, logHelper);
        }

        // 勝利時処理
        if (enemy.getHp() <= 0 && player.getHp() > 0) {
            logHelper.appendPlayerLog("【" + enemy.getName() + "】を倒した！");

            int gainedExp = enemy.getExp();
            int beforeLevel = player.getLevel();

            player.setLastGainedExp(gainedExp);
            player.gainExp(gainedExp);
            player.incrementWins();

            int afterLevel = player.getLevel();
            if (afterLevel > beforeLevel) {
                logHelper.appendPlayerLog("【" + player.getName() + "】は レベル" + beforeLevel + " → " + afterLevel + " に上がった！");
            }

            // 吸収能力獲得判定（ボス限定）
            if (enemy.isBoss()) {
            	if (!player.hasLifeSteal() && Math.random() < 0.05) {
            	    player.setHasLifeSteal(true);
            	    logHelper.appendPlayerLog("<span class='pink-deep'>RareDrop</span><br><span class='green'>『HP Steal能力』獲得！（永続）</span>");
            	}
            	if (!player.hasMpSteal() && Math.random() < 0.05) {
            	    player.setHasMpSteal(true);
            	    logHelper.appendPlayerLog("<span class='pink-deep'>RareDrop</span><br><span class='green'>『MP Steal能力』獲得！（永続）</span>");
            	}
            	if (!player.isBoostedGrowth() && Math.random() < 0.05) {
            	    player.setBoostedGrowth(true);
            	    logHelper.appendPlayerLog(
            	        "<span class='pink-deep'>RareDrop</span><br>" +
            	        "<span class='green'>『EXP促進』EXP獲得量x2（永続）</span>"
            	    );
            	}
            	if (!player.hasAvoidBuff() && Math.random() < 0.05) {
            	    player.setHasAvoidBuff(true);
            	    player.setAvoidRate(player.getAvoidRate() + 10);
            	    logHelper.appendPlayerLog("<span class='pink-deep'>RareDrop</span><br><span class='green'>『回避の極意』AvoidRate+10%（永続）</span>");
            	}
            	if (!player.hasCriticalBuff() && Math.random() < 0.05) {
            	    player.setHasCriticalBuff(true);
            	    player.setCriticalRate(player.getCriticalRate() + 10);
            	    logHelper.appendPlayerLog("<span class='pink-deep'>RareDrop</span><br><span class='green'>『会心の心得』CritRate+10%（永続）</span>");
            	}
            }

            resetBattleBuffs(player); // 一時バフ解除
        }
    }

    // バトル終了時に一時バフ解除
    private void resetBattleBuffs(PlayerDto player) {
        player.setTetsuzanpiUsed(false);       // 鉄山靡リセット
        player.setKabutowariActive(false);     // かぶとわりリセット
        player.setKabutoBroken(false);         // 表示用解除
        player.resetComboBuff();               // コンボ率リセット
    }

    public String getBattleLog() {
        return logHelper.getLog();
    }

    public void clearLog() {
        logHelper.clear();
    }

    // 🔧 Controller からログ追加用
    public void appendPlayerLog(String message) {
        logHelper.appendPlayerLog(message);
    }
}