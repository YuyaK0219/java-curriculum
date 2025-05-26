package curriculum1_32;

class Person {
    public static int count = 0;

    private String firstName;
    private String lastName; // ← 追加
    private int age;
    private double height, weight;

    // オーバーロードされたコンストラクタ（firstName, lastName, age, height, weight）
    Person(String firstName, String lastName, int age, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        Person.count++; // 人数カウント
    }

    // フルネームを返すメソッド
    public String fullName() {
        return this.firstName + this.lastName;
    }

    // BMIを計算して返す
    public double bmi() {
        return this.weight / this.height / this.height;
    }

    // 自己紹介を出力
    public void print() {
        System.out.println("名前は" + this.fullName() + "です");
        System.out.println("年は" + this.age + "です");
        System.out.printf("BMIは%.1fです\n", this.bmi());
    }

    // クラスメソッド：人数を表示
    public static void printCount() {
        System.out.println("合計" + Person.count + "人です");
    }
}