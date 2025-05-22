// パッケージ宣言：このクラスが所属するパッケージ
package curriculum1_25.logic;

// Playerクラス：Characterクラスを継承したプレイヤーキャラクターを表すクラス
public class Player extends Character {
    // プレイヤーの各種ステータス（魔力、攻撃力、素早さ、防御力）
    private int mp;
    private int atk;
    private int agi;
    private int def;

    // コンストラクタ：名前を引数に受け取り、ステータスをランダムに初期化
    public Player(String name) {
        super(name); // Characterクラスのコンストラクタを呼び出し、nameとhpを初期化

        // 各ステータスを1〜1000のランダム値で設定（+1して最低値1）
        this.mp  = (int) (Math.random() * 999) + 1;
        this.atk = (int) (Math.random() * 999) + 1;
        this.agi = (int) (Math.random() * 999) + 1;
        this.def = (int) (Math.random() * 999) + 1;
    }

    // MP（魔力）のgetterとsetter
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }

    // 攻撃力のgetterとsetter
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }

    // 素早さのgetterとsetter
    public int getAgi() {
        return agi;
    }
    public void setAgi(int agi) {
        this.agi = agi;
    }

    // 防御力のgetterとsetter
    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
}