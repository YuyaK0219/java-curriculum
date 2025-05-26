package curriculum1_31;

class Person {
    // インスタンスフィールド
    private String name;
    private int age;
    private double height;
    private double weight;

    // クラスフィールド（全員で共有される）
    static int count = 0;

    // コンストラクタ（初期化処理）
    Person(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

        count++; // インスタンスが作られるたびにカウントを1増やす
    }

    // BMIを返すメソッド
    public double bmi() {
        return this.weight / this.height / this.height;
    }

    // 自己紹介とBMIを出力するメソッド
    public void print() {
        System.out.println("名前は" + this.name + "です");
        System.out.println("年は" + this.age + "です");
        System.out.printf("BMIは%.1fです\n", this.bmi());
    }

    // クラスメソッド（合計人数を表示）
    public static void printCount() {
        System.out.println("合計" + count + "人です");
    }
}
