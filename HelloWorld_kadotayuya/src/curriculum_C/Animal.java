package curriculum_C;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Animal {
	public static void main(String[] args) {

		// Q1 Dogクラスを呼び出して変数に代入し、動物の名前をコンソールに出力してください。
		Dog dog = new Dog();
		System.out.println("動物の名前: " + dog.getName());

		// Q2 Dogクラスを呼び出して変数に代入し、動物の数をコンソールに出力してください。
		Dog dogWithCount = new Dog(3);
		System.out.println("動物の数: " + dogWithCount.getCount());

		// 現在の日時を「yyyy-MM-dd H:m:s」形式で変数に代入して、コンソールに出力してください
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s");
		String formattedDateTime = now.format(formatter);
		System.out.println("現在の日時: " + formattedDateTime);
	}
}