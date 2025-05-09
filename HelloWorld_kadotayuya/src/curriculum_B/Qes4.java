package curriculum_B;

public class Qes4 {

	public static void main(String[] args) {
		// 外側のfor文：1〜9の段を順番に処理（縦方向）
		for (int i = 1; i <= 9; i++) {
			// 内側のfor文：各段で1〜9をかける（横方向）
			for (int j = 1; j <= 9; j++) {
				// 掛け算の結果を 2桁ゼロ埋めで整形して表示（例：01 * 03 = 03）
				System.out.printf("%02d * %02d = %02d", i, j, i * j);
				// 右端以外は「 || 」を出力して区切りを付ける
				if (j < 9) {
					System.out.print(" || ");
				} else {
					// 最後の列なら改行（空行を入れて見やすくする）
					System.out.println(); // 改行1回目：次の段へ
					System.out.println(); // 改行2回目：行間を空ける
				}
			}
		}
	}
}