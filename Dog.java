import java.util.Random;

public class Dog {
	private String name;
	private String owner;
	private Integer price;
	private Integer age;
	private Integer health;

	// Constructors
	public Dog(String name, Integer price, Integer age) {
		super();
		this.name = name;
		this.price = price;
		this.age = age;
		this.health = 50;
		this.owner = "";
	}

	// Setters and Getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	// Methods
	public void printDetails() {
		System.out.println();
		System.out.println("====================");
		System.out.println("     Dog Details    ");
		System.out.println("====================");
		System.out.println("Name   : " + this.name);
		System.out.println("Price  : $" + this.price);
		System.out.println("Age    : " + this.age);
		System.out.println("Health : " + this.health);

		String status = this.health.intValue() > 0 ? "Alive" : "Dead";
		System.out.println("Status: " + status);
		
		System.out.println("====================");
	}

	public void feed() {
		if (this.health > 0 && this.owner.isEmpty()) {

			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}

			int res = new Random().nextInt(10);
			if (res > 6) {
				System.out.println(this.name + " has food poisoning...");
				this.health = Math.max(0, health - 10);
			} else {
				System.out.println(this.name + " likes the food!");
				this.health = Math.min(100, health + 20);
			}
		}
	}
	
	public void play()
	{
		if (this.health > 0 && this.owner.isEmpty()) {

			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}

			int res = new Random().nextInt(10);
			if (res > 4) {
				System.out.println(this.name + " stumbled upon a rock!");
				this.health = Math.max(0, health - 5);
			} else {
				System.out.println(this.name + " has an amazing playing experience!");
				this.health = Math.min(100, health + 10);
			}
		}
	}

}
