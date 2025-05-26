package curriculum1_30;

public class Main {
	public static void main(String[] args) {
		// Personオブジェクトを生成（名前・年齢・身長・体重を指定）
		Person person1 = new Person("鈴木太郎", 20, 1.7, 60.0);

		// 名前・年齢・身長を個別に出力
		System.out.println(person1.name);
		System.out.println(person1.age);
		System.out.println(person1.height);

		// 自己紹介＋BMI出力（こちらは元の四捨五入）
		person1.print();

		// 合計人数を出力
		System.out.println("合計" + Person.count + "人です");
	}
}