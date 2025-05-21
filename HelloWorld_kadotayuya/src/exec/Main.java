package exec;

import logic.MessagePrinter; // logicパッケージのMessagePrinterクラスを使うためのimport

public class Main { // 実行用のクラス（エントリーポイント）
	public static void main(String[] args) { // Javaアプリケーションの開始地点（mainメソッド）

		// MessagePrinterクラスのインスタンスを作成（コンストラクタが自動で呼ばれる）
		MessagePrinter printer = new MessagePrinter();

		// 作成したインスタンスのprintAllメソッドを呼び出して、メッセージをすべて出力
		printer.printAll();
	}
}