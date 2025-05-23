package curriculum1_27;

public class Encapsulation {
	private String name;
	private double height;
	private int speed;
	private String scientificName;

	public Encapsulation(String name, double height, int speed, String scientificName) {
		this.name = name;
		this.height = height;
		this.speed = speed;
		this.scientificName = scientificName;
	}

	public String getName() {
		return name;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

}