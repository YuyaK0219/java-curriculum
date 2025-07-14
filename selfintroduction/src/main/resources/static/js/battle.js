window.addEventListener("DOMContentLoaded", () => {
    // ゲージアニメーション
    const animateBar = (barElement, current, max) => {
        if (!barElement) return;
        const percent = Math.max(0, Math.min(100, (current / max) * 100));
        barElement.style.width = percent + "%";
    };

    // プレイヤーHP/MPを取得
    const hpText = document.getElementById("hpValue")?.textContent;
    const mpText = document.getElementById("mpValue")?.textContent;

    if (hpText && mpText) {
        const [hp, maxHp] = hpText.split("/").map(Number);
        const [mp, maxMp] = mpText.split("/").map(Number);

        const hpBar = document.getElementById("hpBar");
        const mpBar = document.getElementById("mpBar");

        animateBar(hpBar, hp, maxHp);
        animateBar(mpBar, mp, maxMp);
    }

    // 🆕 敵HPゲージの取得と描画
    const enemyHpText = document.getElementById("enemyHpValue")?.textContent;
    if (enemyHpText) {
        const [enemyHp, enemyMaxHp] = enemyHpText.split("/").map(Number);
        const enemyHpBar = document.getElementById("enemyHpBar");
        animateBar(enemyHpBar, enemyHp, enemyMaxHp);
    }

    // バトルログ自動スクロール
    const logBox = document.getElementById("logBox");
    if (logBox) {
        logBox.scrollTop = logBox.scrollHeight;
    }
});