package curriculum_B;

import java.util.Scanner;
 
public class Qes7 {
	public static void main(String[] args) {
		// ユーザー入力用のScannerを作成
		Scanner scanner = new Scanner(System.in);

		// 生徒の人数を入力（2人未満なら終了）
		System.out.println("生徒の人数を入力してください");
		int count = scanner.nextInt();
		if (count < 2) {
			System.out.println("2人以上の人数を入れてください");
			scanner.close();
			return;
		}
		// 教科の一覧（教科数は subjects.length で取得できる）
		String[] subjects = { "英語", "数学", "理科", "社会" };

		// 各生徒の各教科の点数を保持する2次元配列
		int[][] scores = new int[count][subjects.length];

		// 各生徒の平均点を保持する配列
		double[] studentAvg = new double[count];

		// 各生徒の点数を教科ごとに入力
		for (int i = 0; i < count; i++) {
			int total = 0; // 各生徒の合計点

			for (int j = 0; j < subjects.length; j++) {
				// 各教科の点数を1つずつ入力
				System.out.print((i + 1) + "人目『" + subjects[j] + "』の点数を入力してください : ");
				int score = scanner.nextInt();
				// 点数を配列に保存しつつ、合計に加算（1行で処理）
				total += (scores[i][j] = score);
			}
			// 生徒の平均点を計算（小数）
			studentAvg[i] = total / (double) subjects.length;
			System.out.println();
		}
		// 各生徒の平均点を表示
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + "人目の平均点数は" + studentAvg[i] + "点です");
		}
		// 空行（見た目調整）
		System.out.println();

		// 各教科ごとの平均点を表示
		for (int j = 0; j < subjects.length; j++) {
			int subjectTotal = 0; // 教科ごとの合計点

			for (int i = 0; i < count; i++) {
				subjectTotal += scores[i][j]; // 生徒の点数を加算
			}
			// 教科ごとの平均点を計算して出力
			double subjectAvg = subjectTotal / (double) count;
			System.out.println("『" + subjects[j] + "』の平均点は " + subjectAvg + " 点です");
		}
		// Scannerを閉じてリソースを解放
		scanner.close();
	}
}