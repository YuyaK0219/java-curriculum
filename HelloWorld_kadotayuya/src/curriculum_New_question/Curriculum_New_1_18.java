package curriculum_New_question;

import java.util.Random;

public class Curriculum_New_1_18 {
	// Q1：引数に文字列型と整数型をいれてコンソールに「Hello JavaSE 11」と出力するメソッドを作成してください。
	public static void printMessage(String text, int number) {
		System.out.println(text + " " + number);
	}

	// Q2：引数に整数を渡すと渡した値同士を乗算しコンソールに出力するメソッドを作成してください
	public static void multiply(int a, int b) {
		System.out.println(a * b);
	}

	// Q3：引数として整数の配列を渡すと、受け取った値を順番にコンソールに出力するメソッドを作成してください
	public static void printArray(int[] array) {
		for (int num : array) {
			System.out.println(num);
		}
	}

	// Q4：Q2をオーバーロードして引数を小数2つに変更し、引数同士を和算しコンソールに出力してください。
	public static void multiply(double a, double b) { // 修正点
		System.out.println(a + b);
	}

	// Q5：引数に整数を渡すと、1～100までのランダムな数字を引数の回数分格納して
	// 格納した値を順番にコンソールで出力後、格納した値を返すメソッドを作成してください。
	// ※0は出力＆格納しないようにしてください。
	public static int[] generateRandomNumbers(int count) {
		Random rand = new Random();
		int[] result = new int[count];
		for (int i = 0; i < count;) {
			int value = rand.nextInt(100) + 1; // 1〜100
			if (value != 0) {
				result[i] = value;
				System.out.println(value);
				i++;
			}
		}
		return result;
	}

	// Q6：引数にQ5で作成したメソッドの返り値を受け取り、受け取った配列の要素の平均値をコンソールに出力するメソッドを作成してください。
	// ※小数点以下も表示されるようにしてください。
	public static double average(int[] array) {
		int sum = 0;
		for (int num : array) {
			sum += num;
		}
		double avg = sum / (double) array.length;
		System.out.println("平均値: " + avg);
		return avg;
	}

	// Q7：引数にQ6で作成したメソッドの返り値を受け取り、受け取った値が50以上ならばtrueそれ以外はfalseを返しコンソールに出力してください
	public static boolean isOver50(double value) {
		boolean result = value >= 50;
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		// 作成したメソッドをここで呼び出してください
		// Q1
		printMessage("Hello JavaSE", 49);
		// Q2
		multiply(20, 7);
		// Q3
		int[] sampleArray = { 22, 56, 56 };
		printArray(sampleArray);
		// Q4
		multiply(4.7, 8.8); // 修正点
		// Q5
		int[] randomValues = generateRandomNumbers(9);
		// Q6
		double avg = average(randomValues);
		// Q7
		isOver50(avg);
	}
}
