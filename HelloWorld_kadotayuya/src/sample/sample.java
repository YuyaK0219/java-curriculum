package sample;

import java.util.Random;
import java.util.Scanner;

public class sample {

	public static void main(String[] args) {

		System.out.println("ようこそ占いの館へ");
		System.out.println("あなたの名前を入力してください");
		String name = new Scanner(System.in).nextLine();

		System.out.println("あなたの年齢を入れてください");
		Scanner scanner = new Scanner(System.in);
		String ageString = scanner.nextLine();

		int age = Integer.parseInt(ageString);
		int fortune = new Random().nextInt(4) + 1;

		System.out.println("占いの結果がでました！");

		String msg = "";
		switch (fortune) {
			case 1:
				msg = "大吉";
				break;
			case 2:
				msg = "中吉";
				break;
			case 3:
				msg = "吉";
				break;
			case 4:
				msg = "凶";
				break;
		}
		System.out.println(age + "際の" + name + "さん、あなたの運気番号は" + msg + "です");

	}
}