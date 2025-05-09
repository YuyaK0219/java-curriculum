package curriculum_B;

public class Qes5 {

	public static void main(String[] args) {
		for (int j = 1; j <= 20; j++) { //横方向（右側の数）：001〜020
			for (int i = 1; i <= 9; i++) { //縦方向（左側の数）：001〜009
				System.out.printf("%03d * %03d = %03d", i, j, i * j);//数字を三文字にする処理
				if (i != 9) {
					System.out.print(" || ");
				}
			}
			System.out.println("\n"); //改行
		}
	}
}
