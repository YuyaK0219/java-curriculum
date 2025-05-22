// パッケージ宣言：このクラスが属するグループ（フォルダのようなもの）
package curriculum1_23;

/**
 * カプセル化の例として使われるクラス。 名前・身長・速度を持ち、それぞれにgetter/setterを用意している。
 */
public class Encapsulation {

	// フィールド（データ）：外部から直接アクセスできないようにprivateで隠す（カプセル化）
	private String name;
	private double height;
	private int spead; // ← 速度（スペルは「speed」が正しい）

	// コンストラクタ：オブジェクト生成時にフィールドへ初期値を代入
	public Encapsulation(String name, double height, int spead) {
		this.name = name;
		this.height = height;
		this.spead = spead;
	}

	// 名前を取得するメソッド（getter）
	public String getName() {
		return this.name;
	}

	// 名前を変更するメソッド（setter）
	public void setName(String name) {
		this.name = name;
	}

	// 身長を取得するgetter
	public double getHeight() {
		return height;
	}

	// 身長を設定するsetter
	public void setHeight(double height) {
		this.height = height;
	}

	// 速度を取得するgetter
	public int getSpead() {
		return spead;
	}

	// 速度を設定するsetter
	public void setSpead(int spead) {
		this.spead = spead;
	}
}