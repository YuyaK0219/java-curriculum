package curriculum1_27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("にゅうりょ-く（例：ライオン:2.1:80,ゾウ:3.2:40,パンダ:1.9:30）");
		String input = sc.nextLine();

		List<Encapsulation> animals = new ArrayList<>(); //リスト化
		String[] animalEntries = input.split(",");

		// 入力データを解析してリストに追加
		for (String entry : animalEntries) {
			String[] parts = entry.split(":");
			if (parts.length != 3) {            //長さが3以外の時の処理
				System.out.println(parts[0] + "の入力おかしいよ");
				continue;
			}
			String name = parts[0];
			double height = Double.parseDouble(parts[1]);
			int speed = Integer.parseInt(parts[2]);

			String scientificName;

			// 名前ごとにswitchで学名を設定
			switch (name) {
				case "ライオン":
					scientificName = "パンテラ レオ";
					break;
				case "ゾウ":
					scientificName = "ロキソドンタ・サイクロティス";
					break;
				case "パンダ":
					scientificName = "アイルロポダ・メラノレウカ";
					break;
				case "チンパンジー":
					scientificName = "パン・トゥログロディテス";
					break;
				case "シマウマ":
					scientificName = "エクウス・クアッガ";
					break;
				default:
					scientificName = "不明";
			}

			// リストに追加（学名も保持）
			animals.add(new Encapsulation(name, height, speed, scientificName));
		}

		// 出力
		for (Encapsulation animal : animals) {
			System.out.println("\n動物名：" + animal.getName());
			System.out.println("体長：" + animal.getHeight() + "m");
			System.out.println("速度：" + animal.getSpeed() + "km/h");
			System.out.println("学名：" + animal.getScientificName());
		}
	}
}