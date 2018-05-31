package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetApp {
	
	Map<String, VirtualPet> virtualPets = new HashMap<>();

	public void add(VirtualPet virtualPet) {
	virtualPets.put(virtualPet.getVirtualPetName(), virtualPet);
	}

	public VirtualPet findVirtualPet(String petName) {
		return virtualPets.get(petName);
	}

	public Collection<VirtualPet> getAllVirtualPets() {
		return  virtualPets.values();
	}

	public void adopt(VirtualPet virtualPet) {
		virtualPets.remove(virtualPet.getVirtualPetName(), virtualPet);

	}

	public void intake(VirtualPet virtualPet) {
		virtualPets.put(virtualPet.getVirtualPetName(), virtualPet);

	}


	public void waterAllPets() {
		
	}

	public void play(VirtualPet virtualPet1) {
		
	}


}
