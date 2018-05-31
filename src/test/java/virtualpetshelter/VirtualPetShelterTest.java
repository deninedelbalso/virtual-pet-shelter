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

	VirtualPetApp underTest;
	VirtualPet virtualPet1;
	VirtualPet virtualPet2;

	@Before
	public void setUp() {
		underTest = new VirtualPetApp();
		virtualPet1 = new VirtualPet("Pookie", "is Ugly", 100, 100, 100);
		virtualPet2 = new VirtualPet("Dookie", "is Pretty", 100, 100, 100);

	}
	

	@Test
	public void shouldReturnNamePookie() {
		VirtualPet underTest = new VirtualPet("Pookie", "is Ugly", 100, 100, 100);
		String check = underTest.getName();
		assertEquals(check, "Pookie");
	}
	

	@Test
	public void shouldReturnDescriptionOfIsUgly() {
		VirtualPet underTest = new VirtualPet("Pookie","is Ugly", 100, 100, 100);
		String check = underTest.getDescription();
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

}
