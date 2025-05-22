// パッケージ宣言：このクラスが所属するパッケージ
package curriculum1_25.logic;

// キャラクターの基本情報（名前・HP）を持つクラス。
// Playerなどのキャラ系クラスの共通親クラスとして使われる想定。
public class Character {
    // キャラクターの名前とHP（体力）
    private String name;
    private int hp;

    // コンストラクタ：名前を受け取り、HPをランダム（1〜999）で初期化
    public Character(String name) {
        this.name = name;
        this.hp = (int) (Math.random() * 999) + 1; // Math.random()は0.0〜1.0未満なので、+1で最低1に
    }

    // 名前を取得するgetter
    public String getName() {
        return name;
    }

    // 名前を設定するsetter
    public void setName(String name) {
        this.name = name;
    }

    // HPを取得するgetter
    public int getHp() {
        return hp;
    }

    // HPを設定するsetter
    public void setHp(int hp) {
        this.hp = hp;
    }
}