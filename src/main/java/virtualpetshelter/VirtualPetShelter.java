package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> virtualPets = new HashMap<>();

	public void add(VirtualPet virtualPet) {
		virtualPets.put(virtualPet.getVirtualPetName(), virtualPet);
	}

	public VirtualPet findVirtualPet(String petName) {
		return virtualPets.get(petName);
	}

	public Collection<VirtualPet> getAllVirtualPets() {
		return virtualPets.values();
	}

	public void adopt(VirtualPet virtualPet) {
		virtualPets.remove(virtualPet.getVirtualPetName(), virtualPet);

	}

	public void intake(VirtualPet virtualPet) {
		virtualPets.put(virtualPet.getVirtualPetName(), virtualPet);

	}

	public void play(VirtualPet virtualPet) {
		virtualPet.play();
	}

	public void feedAll() {
		for (VirtualPet virtualPet : virtualPets.values()) {
			virtualPet.feed();
		}
	}

	public void waterAll() {
		for (VirtualPet virtualPet : virtualPets.values()) {
			virtualPet.water();

		}
	}

	public void tickAll() {
		for (VirtualPet virtualPet : virtualPets.values()) {
			virtualPet.tick();
		}
	}

	public void showStats() {
		for (VirtualPet virtualPet : virtualPets.values()) {
			System.out.println("Boredom: " + virtualPet.getBoredom() + "" + "Description: " + virtualPet.getDescription() + "" + "Feed: " + virtualPet.getFeed() + "" + "Water: " + virtualPet.getWater() + "" + "Name: " + virtualPet.getName() + "");
		}	
	}

}