// Last updated: 11/15 2104
// [WORKING ON BY NIVEN FRANCIS]

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import item.Bait;
import item.HealthPot;
import item.Item;
import item.Pokeball;
import model.Trainer;

public class trainerTest {
	@Test
	public void tester() {
		Trainer t = new Trainer("Niven", null);
		Item i1 = new Bait("Bait");
		Item i2 = new Pokeball("Safari Ball");
		Item i3 = new HealthPot("Health pot");
		
		t.getBackpack().addItem(i1);
		t.getBackpack().addItem(i2);
		t.getBackpack().addItem(i3);
		t.getBackpack().printItems();
		t.getBackpack().addItem(i1);
		t.getBackpack().removeItem(i1);
		t.getBackpack().useItem(i2);
		t.getBackpack().printItems();
		t.getBackpack().numItems();
		t.getBackpack().removeItem(i2);
		t.getBackpack().removeItem(i3);
		t.getBackpack().printItems();
		
		assertTrue(t.addSteps(1));
		assertFalse(t.addSteps(499));
		assertEquals(500, t.stepCount());
		assertEquals("Niven", t.getName());
		
		t.throwBait();
		t.throwBall();
		t.throwRock();
		t.run();
	}
}
