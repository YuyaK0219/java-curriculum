package logic; 

import java.time.LocalDateTime; // 現在の日時を取得するためのクラス
import java.time.format.DateTimeFormatter; // 日時を指定した書式で表示するためのクラス

public class MessagePrinter {
	// フィールド（クラス内で使う変数）
	private String greeting; // あいさつ文
	private String sushiComment; // 寿司についてのコメント
	private String sushiFact; // 寿司に関する豆知識
	private String currentDateTime; // 現在の日時を文字列として保持する

	// コンストラクタ（クラスの初期化時に実行される処理）
	public MessagePrinter() {
		this.greeting = "こんにちは！ここは日本です！"; // あいさつ文をセット
		this.sushiComment = "この寿司はうまい"; // 寿司のコメントをセット
		this.sushiFact = "寿司は和食です"; // 寿司の豆知識をセット

		LocalDateTime now = LocalDateTime.now(); // 現在の日時を取得
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // 書式を指定
		this.currentDateTime = "今の現在日時は" + now.format(formatter) + "です"; // 整形して文字列にする
	}

	// 全てのメッセージを出力するメソッド
	public void printAll() {
		System.out.println(this.greeting); // あいさつを表示
		System.out.println(this.sushiComment); // 寿司コメントを表示
		System.out.println(this.sushiFact); // 寿司豆知識を表示
		System.out.println(this.currentDateTime); // 現在日時を表示
	}
}