package sample;

public class hairetu {
	public static void main(String[] args) {
		String[][] fruit = {
				{ "mikan", "onigiri", "pain,lemon" },
				{ "ui-,huuu,nnaannan,muu" },
				{ "buuu,eeeeee,ccccc,xxx" }
				};
		for (int i = 0; i < fruit.length; i++) {
			String[] splitfruits = fruit[i][0].split(",");
			for (int j = 0; j < splitfruits.length; j++) {
				System.out.println(splitfruits[j]);
			}
		}
	}
}