import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<Dog> arr = new ArrayList<Dog>();

	public void buyDogs()
	{
		int count = viewDogsPrice();
		
		if (count == 0)
		{
			pause();
			return;
		}
		
		int c;
		while (true)
		{
			System.out.println("Which dog do you want to buy? [1 - " + count + "]: ");
			c = scan.nextInt();
			scan.nextLine();
			
			if (c >= 1 && c <= count)
				break;
		}
		
		cls();
		System.out.println("Customer Data:");
		System.out.println("==============");
		
		String name;
		while (true)
		{
			System.out.println("Input your name [>1 word]: ");
			name = scan.nextLine();
			
			name = name.trim();
			if (name.split("\\s+").length > 1)
				break;
		}
		
		String email;
		while (true)
		{
			System.out.println("Enter your email [Contains '@' and end with '.com']: ");
			email = scan.nextLine();
			
			if (email.contains("@") && email.endsWith(".com"))
				break;
		}
		
		
		System.out.println("Transaction success!");
		
		int trueIndex = 0;
		for (int i=1; i!=c; ++i)
		{
			if (!arr.get(trueIndex).getOwner().isEmpty() || arr.get(trueIndex).getHealth() == 0)
			{
				--i;
			}
			++trueIndex;
		}
		
		arr.get(trueIndex).setOwner(name + " - " + email);
		
		pause();
	}
	
	public void viewDogs() {
		if (arr.isEmpty()) {
			cls();
			System.out.println("====================");
			System.out.println("No Dogs Available...");
			System.out.println("====================");
			pause();
			return;
		}

		while (true) {
			cls();
			System.out.println("View Dogs");
			System.out.println("=========");
			System.out.println("1. View all dogs in PetStore");
			System.out.println("2. View all dogs history");
			System.out.println("3. Back");
			System.out.println("Choose: ");
			
			int c = scan.nextInt();
			scan.nextLine();

			switch (c) {
			case 1:
				viewDogsAlive();
				pause();
				break;
			case 2:
				viewDogsHistory();
				pause();
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	}

	public void viewDogsHistory() {
		cls();
		if (arr.isEmpty()) {
			System.out.println("====================");
			System.out.println("No Dogs Available...");
			System.out.println("====================");
			return;
		}

		arr.sort((Dog a, Dog b) -> a.getName().compareTo(b.getName()));
		
		System.out.println("All Dogs in Pet Store: ");
		System.out.println("=======================");

		int count = 1;
		for (Dog d : arr) {
			System.out.printf("%3d. Name     : %s\n", count++, d.getName());
			System.out.println("     Price    : " + d.getPrice());
			System.out.println("     Age      : " + d.getAge());
			System.out.println("     Health   : " + d.getHealth());

			String status = d.getHealth() > 0 ? "Alive" : "Dead";
			System.out.println("     Status   : " + status);
			
			if (!d.getOwner().isEmpty())
			{
				System.out.println("     Owner    : " + d.getOwner());
			}
			System.out.println("=======================");
		}
	}
	
	public int viewDogsPrice() {
		cls();
		if (arr.isEmpty()) {
			System.out.println("====================");
			System.out.println("No Dogs Available...");
			System.out.println("====================");
			return 0;
		}
		
		arr.sort((Dog a, Dog b) -> a.getPrice().compareTo(b.getPrice()));
		
		System.out.println("All Dogs in Pet Store (Sorted By Price): ");
		System.out.println("=======================================");

		int count = 1;
		for (Dog d : arr) {
			if (d.getHealth() > 0 && d.getOwner().isEmpty()) {
				System.out.printf("%3d. Name     : %s\n", count++, d.getName());
				System.out.println("     Price    : " + d.getPrice());
				System.out.println("     Age      : " + d.getAge());
				System.out.println("     Health   : " + d.getHealth());

				String status = d.getHealth() > 0 ? "Alive" : "Dead";
				System.out.println("     Status   : " + status);
				System.out.println("=======================");
			}
		}

		return count-1;
	}

	public int viewDogsAlive() {
		cls();
		if (arr.isEmpty()) {
			System.out.println("====================");
			System.out.println("No Dogs Available...");
			System.out.println("====================");
			return 0;
		}
		
		arr.sort((Dog a, Dog b) -> a.getName().compareTo(b.getName()));
		
		System.out.println("All Dogs in Pet Store: ");
		System.out.println("=======================");

		int count = 1;
		for (Dog d : arr) {
			if (d.getHealth() > 0 && d.getOwner().isEmpty()) {
				System.out.printf("%3d. Name     : %s\n", count++, d.getName());
				System.out.println("     Price    : " + d.getPrice());
				System.out.println("     Age      : " + d.getAge());
				System.out.println("     Health   : " + d.getHealth());

				String status = d.getHealth() > 0 ? "Alive" : "Dead";
				System.out.println("     Status   : " + status);
				System.out.println("=======================");
			}
		}

		return count-1;
	}

	public void dogAction() {
		while (true) {

			cls();
			if (arr.isEmpty()) {
				System.out.println("====================");
				System.out.println("No Dogs Available...");
				System.out.println("====================");
				pause();
				return;
			}

			System.out.println("What are you going to do?");
			System.out.println("=========================");
			System.out.println("1. Feed all of them");
			System.out.println("2. Playing with all of them");
			System.out.println("3. Back");
			System.out.println("Choose: ");

			int c = scan.nextInt();
			scan.nextLine();

			switch (c) {
			case 1:
				for (Dog d : arr) {
					d.feed();
				}
				System.out.println("Feeding done!");
				pause();
				break;
			case 2:
				for (Dog d : arr) {
					d.play();
				}
				System.out.println("Playing time is over!");
				pause();
				break;
			case 3:
				return;
			default:
				break;
			}
		}

	}

	public void insertDog() {
		String name;
		Integer price;
		Integer age;

		cls();
		System.out.println("Insert New Dog:");
		System.out.println("===============");

		while (true) {
			System.out.println("Dog Name [More than 3 characters]: ");
			name = scan.nextLine();

			if (name.length() > 3)
				break;
		}

		while (true) {
			System.out.println("Dog Price [Must be a multiple of 100]: ");
			price = scan.nextInt();
			scan.nextLine();

			if (price % 100 == 0)
				break;
		}

		while (true) {
			System.out.println("Dog Age [0-14]: ");
			age = scan.nextInt();
			scan.nextLine();

			if (age >= 0 && age <= 14)
				break;
		}

		arr.add(new Dog(name, price, age));
		arr.get(arr.size() - 1).printDetails();
		pause();

	}

	public Main() {

		arr.add(new Dog("Dogey", 200, 1));
		arr.add(new Dog("June", 300, 4));
		arr.add(new Dog("Butter", 250, 10));
		

		while (true) {
			cls();
			System.out.println("Welcome to Doge Pet Store!");
			System.out.println("===========================");
			System.out.println("1. Insert new dog");
			System.out.println("2. Do some actions to dogs");
			System.out.println("3. View dogs");
			System.out.println("4. Somebody wants to buy a dog");
			System.out.println("5. Exit");
			System.out.println("Choose: ");

			int c = scan.nextInt();
			scan.nextLine();

			switch (c) {
			case 1:
				insertDog();
				break;
			case 2:
				dogAction();
				break;
			case 3:
				viewDogs();
				break;
			case 4:
				buyDogs();
				break;
			case 5:
				System.out.println("Thank you for visiting! UwU");
				return;
			default:
				break;
			}
		}

	}

	public static void main(String[] args) {
		new Main();
	}

	// Helper functions
	public void pause() {
		System.out.println("Press any key to continue...");
		scan.nextLine();
	}

	public void cls() {
		for (int i = 0; i < 50; ++i) {
			System.out.println();
		}
	}
}
