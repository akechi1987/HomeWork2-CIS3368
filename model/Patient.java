package model;

public class Patient {

	private int uuid;
	private String name;
	private int age;
	private String gender;
	private String blood_type;
	private double weight;
	private String height;
	
	public Patient(int uuid, String name, int age, String gender, String blood_type, double weight, String height) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.blood_type = blood_type;
		this.weight = weight;
		this.height = height;
	}

	public int getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getBlood_type() {
		return blood_type;
	}

	public double getWeight() {
		return weight;
	}

	public String getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "UUID: " + uuid + ", Name:" + name + ", Age: " + age + ", Gender: " + gender + ", Blood type: "
				+ blood_type + ", Weight: " + weight + ", Height: " + height;
	}
	
	
}
