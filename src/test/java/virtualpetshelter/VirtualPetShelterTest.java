package virtualpetshelter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Collection;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet virtualPet1;
	VirtualPet virtualPet2;

	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		virtualPet1 = new VirtualPet("Pookie", "is Ugly", 100, 100, 100);
		virtualPet2 = new VirtualPet("Dookie", "is Pretty", 100, 100, 100);

	}

	@Test
	public void shouldReturnNamePookie() {
		String check = virtualPet1.getName();
		assertEquals(check, "Pookie");
	}

	@Test
	public void shouldReturnDescriptionOfIsUgly() {
		String check = virtualPet1.getDescription();
		assertEquals(check, "is Ugly");
	}

	@Test
	public void shouldBeAbleToAddPet() {
		underTest.add(virtualPet1);
		VirtualPet retrievedPet = underTest.findVirtualPet("Pookie");
		assertThat(retrievedPet, is(virtualPet1));
	}

	@Test
	public void shouldBeAbleToAddTwoPet() {
		underTest.add(virtualPet1);
		underTest.add(virtualPet2);
		Collection<VirtualPet> allVirtualPets = underTest.getAllVirtualPets();
		assertThat(allVirtualPets, containsInAnyOrder(virtualPet1, virtualPet2));
	}

	@Test
	public void shouldBeAbleToAdoptAHomelessPet() {
		underTest.add(virtualPet1);
		underTest.adopt(virtualPet1);
		VirtualPet retrievedPet = underTest.findVirtualPet(virtualPet1.getVirtualPetName());
		assertThat(retrievedPet, is(nullValue()));
	}

	@Test
	public void shouldHaveHungerOf100() {
		VirtualPet underTest = new VirtualPet("", "", 100, 100, 100);
		int check = underTest.getFeed();
		assertEquals(check, 100);
	}

	@Test
	public void shouldHaveWaterOf100() {
		VirtualPet underTest = new VirtualPet("", "", 100, 100, 100);
		int check = underTest.getWater();
		assertEquals(check, 100);
	}

	@Test
	public void shouldHaveBoredeomOf100() {
		VirtualPet underTest = new VirtualPet("", "", 100, 100, 100);
		int check = underTest.getBoredom();
		assertEquals(check, 100);
	}

	@Test
	public void shouldBeAbleToFeedAllPets() {
		underTest.add(virtualPet1);
		underTest.add(virtualPet2);
		underTest.feedAll();
		int check1 = virtualPet1.getFeed();
		int check2 = virtualPet2.getFeed();
		assertEquals(check1, 90);
		assertEquals(check2, 90);

	}

	@Test
	public void shouldBeAbleToWaterAllPets() {
		underTest.add(virtualPet1);
		underTest.add(virtualPet2);
		underTest.waterAll();
		int check1 = virtualPet1.getWater();
		int check2 = virtualPet2.getWater();
		assertEquals(check1, 90);
		assertEquals(check2, 90);

	}

	@Test
	public void shouldBeAbleToTickAllPets() {
		underTest.add(virtualPet1);
		underTest.add(virtualPet2);
		underTest.tickAll();
		int check1 = virtualPet1.getWater();
		int check2 = virtualPet2.getWater();
		assertEquals(check1, 110);
		assertEquals(check2, 110);
	}
	
	@Test
	public void shouldDecreaseBoredomBy10WhenPlaying() {
		underTest.add(virtualPet1);
		underTest.play(virtualPet1);
		int check = virtualPet1.getBoredom();
		assertEquals(check, 90);
	
	}
}
