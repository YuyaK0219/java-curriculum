package curriculum1_30;

public class Person {
    // フィールド（インスタンス変数）
    String name;
    int age;
    double height;
    double weight;

    // クラス変数（人数カウント用）
    static int count = 0;

    // コンストラクタ（名前・年齢・身長・体重を受け取って初期化）
    Person(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        count++; // 人数をカウント
    }

    // BMIを計算して返すメソッド（戻り値：double）
    double bmi() {
        double rawBmi =  weight / (height * height);
        return Math.floor(rawBmi * 1) / 1.0;
    }

    // 自己紹介とBMIを出力するメソッド（戻り値なし）
    void print() {
        System.out.println("名前は" + this.name + "です");
        System.out.println("年は" + this.age + "才です");
        System.out.printf("BMIは%.1fです\n", this.bmi()); // ← こっちは四捨五入のまま
    }
}