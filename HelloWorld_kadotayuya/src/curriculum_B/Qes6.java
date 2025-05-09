package curriculum_B; // パッケージ名の宣言（このクラスが所属するグループ）

import java.util.ArrayList; //	リスト
import java.util.List;
import java.util.Random; //	ランダムな数値生成
import java.util.Scanner; //	ユーザー入力取得
 
public class Qes6 {
	public static void main(String[] args) {
		System.out.println("知りたい商品を「、」で区切って入力してください");

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		List<String> productList = new ArrayList<>();
		for (String item : input.split("、")) { //　、をなくす
			productList.add(item.trim());
		}
		Random rand = new Random();

		final int TV_TOTAL = 11;
		int tvCount = rand.nextInt(TV_TOTAL + 1); // 0〜11
		int displayCount = TV_TOTAL - tvCount;

		for (String product : productList) {
			String message = "";

			// 三項演算子でテレビ／ディスプレイの台数を判断
			int stock = (product.equals("テレビ")) ? tvCount
					: (product.equals("ディスプレイ")) ? displayCount : rand.nextInt(12); // その他商品はランダム

			switch (product) {
				case "パソコン":
				case "冷蔵庫":
				case "扇風機":
				case "洗濯機":
				case "加湿器":
				case "テレビ":
				case "ディスプレイ":
					message = product + "の残りは" + stock + "台です";
					break;
			default:
				message = "対象の商品ではありません";
				break;
			}
			System.out.println(message);
		}
		scanner.close();
	}
}