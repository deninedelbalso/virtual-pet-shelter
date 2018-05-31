package virtualpetshelter;

import java.util.ArrayList;
import java.util.Collection;

public class VirtualPet {

	private String petName;
	private String description;
	private int feed;
	private int boredom;
	private int water;
	

	public VirtualPet(String petName, String description, int feed, int boredom , int water) {
	this.petName = petName;
	this.description = description;
	this.feed = feed;
	this.boredom = boredom;
	this.water = water;
	}


	public String getVirtualPetName() {
		return petName;
	}
	

	public String getDescription() {
		return description;
	}
	

	public int getFeed() {
		return feed;
	
	}
	public int getBoredom() {
		return boredom;
	
	}
	
	public int getWater() {
		return water;
	
	}
	
	public void tick() {
		feed += 10;
		boredom += 10;
		water += 10;

	}

	public void feed() {
		feed -= 10;

	}

	public void water() {
		water -= 10;

	}
	public void boredom() {
		boredom -= 10;
	

	}



	public String getName() {
		return petName;
	}


	public void play(){		
		boredom -= 10;
	}


	
}