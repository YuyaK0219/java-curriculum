package curriculum1_23;

public class Encapsulation {

	private String name;
	private double height;
	private int spead;

	public Encapsulation(String name, double height, int spead) {
		this.name = name;
		this.height = height;
		this.spead = spead;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getSpead() {
		return spead;
	}

	public void setSpead(int spead) {
		this.spead = spead;
	}

}
