package AnimalGetterSetter;

public class Main {

	public static void main(String[] args) {
		Encapsulation lion = new Encapsulation("らいおーん", 2.1, 80); //値を代入

		System.out.println("動物名：" + lion.getName()); //
		System.out.println("体長：" + lion.getHeight() + "m"); //
		System.out.println("速度：" + lion.getSpead() + "km/h"); //

	}
}
