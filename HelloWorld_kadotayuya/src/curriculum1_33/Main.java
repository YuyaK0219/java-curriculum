package curriculum1_33;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("鈴木", "太郎", 20, 1.7, 60);
        Person person2 = new Person("山田", "花子", 22, 1.5, 40);

        Car car = new Car();
        Bicycle bicycle = new Bicycle();

        // 所有者をbuyメソッドで設定（購入処理）
        person1.buy(car);
        person2.buy(bicycle);

    }
}