package sample;

import java.util.Random;
import java.util.Scanner;

public class sample2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("じゃんけんしましょう");
		System.out.println("手を出せ。1:ぐー　2:ちょき　3:ぱー");
		int hand = scn.nextInt();

		String handname = "";
		if (hand == 1) {
			handname = "ぐー";
		} else if (hand == 2) {
			handname = "ちょ";
		} else if (hand == 3) {
			handname = "ぱ";
		} else {
			System.out.println("1-3字入れなよ");
		}
		System.out.println("you hand : " + handname);

		String enemybettleHand = "";
		int enemyhand = rand.nextInt(3);
		if (enemyhand == 1) {
			enemybettleHand = "ぐ";
		} else if (enemyhand == 2) {
			enemybettleHand = "ち";
		} else {
			enemybettleHand = "ぱ";
		}
		System.out.println("enemy hand : " + enemybettleHand);

		if (hand == enemyhand) {
			System.out.println("結果 : kabutomushi");
		} else if ((hand == 1 && enemyhand == 2) || (hand == 2 && enemyhand == 3) || (hand == 3 && enemyhand == 1)) {
			System.out.println("you win !");
		} else {
			System.out.println("you lose !");
		}

	}

}