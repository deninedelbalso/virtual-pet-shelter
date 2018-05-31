package virtualpetshelter;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		VirtualPetShelter petShelter = new VirtualPetShelter();

		VirtualPet pookie = new VirtualPet("Pookie", "is ugly", 100, 100, 100);
		VirtualPet dookie = new VirtualPet("Dookie", "is pretty", 100, 100, 100);

		petShelter.add(dookie);
		petShelter.add(pookie);

		String choice;
		do {

			System.out.println();
			System.out.println("Welcome to the Virtual Pet Shelter!");
			System.out.println("This is the status of your pets:");
			petShelter.showStats();
			System.out.println();
			System.out.println("Press 1 to feed the pets");
			System.out.println("Press 2 to water the pets");
			System.out.println("Press 3 to play with the pets");
			System.out.println("Press 4 to adopt a pet");
			System.out.println("Press 5 to admit a pet");

			choice = input.nextLine();

			if (choice.equals("1")) {
				petShelter.feedAll();
				System.out.println("We are full! " + "Pookie's hunger level is now at " + pookie.getFeed()
						+ ". Dookie's hunger level is now at " + dookie.getFeed() + ".");
			} else if (choice.equals("2")) {
				petShelter.waterAll();
				System.out.println("We are full of water! " + "Pookie's thirst level is now at " + pookie.getWater()
						+ ". Dookie's thirst level is now at " + dookie.getWater() + ".");
			} else if (choice.equals("3")) {
				System.out.println("What is the name of the pet you want to play with?");
				String name = input.nextLine();
				petShelter.play(petShelter.findVirtualPet(name));
				System.out.println("Playing is fun! " + "Pookie's boredom level is now at " + pookie.getBoredom()
						+ ". Dookie's boredom level is now at " + dookie.getBoredom() + ".");
			} else if (choice.equals("4")) {
				System.out.println("What is the name of the pet you want to adopt?");
				String name = input.nextLine();
				petShelter.adopt(petShelter.findVirtualPet(name));
				System.out.println("Congrats on your new pet!");
			} else if (choice.equals("5")) {
				System.out.println("Please admit a pet.");
				System.out.println("What is the name of the pet you want to adopt?");
				String name = input.nextLine();
				System.out.println("What kind of pet is it?");
				String description = input.nextLine();
				petShelter.add(new VirtualPet(name, description, 100, 100, 100));
				System.out.println("Your pet is now admitted");
			} else {
				System.out.println("Shelter is closed. Come back later");
			}
			petShelter.tickAll();
		} while (!choice.equals("6"));

		input.close();
	}
}
