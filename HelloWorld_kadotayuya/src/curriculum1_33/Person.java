package curriculum1_33;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double height, weight;

    public Person(String firstName, String lastName, int age, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String fullName() {
        return firstName + lastName;
    }

    // Carを買う（所有者として名前をセットし、購入メッセージを出力）
    public void buy(Car car) {
        car.setOwner(this.fullName());
        System.out.println(car.getOwner() + "が購入しました");
    }

    // Bicycleを買う（同上）
    public void buy(Bicycle bicycle) {
        bicycle.setOwner(this.fullName());
        System.out.println(bicycle.getOwner() + "が購入しました");
    }
}