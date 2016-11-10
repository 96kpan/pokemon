//Katie Pan
//Test cases for Pokemon Class

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Pokemon;
import pokemons.Bulbasaur;
import pokemons.Charmander;

public class pokemonTest {

	@Test
	//charmander test
	public void charmanderTest() {
		Pokemon pokemon1 = new Charmander(5, 45, "charmander", "fire", false, 20, null);
		assertTrue(5 == pokemon1.getLevel());
		assertTrue(45 == pokemon1.getTotalHealth());
		assertTrue("charmander" == pokemon1.getName());
		assertTrue("fire" == pokemon1.getType());
		assertTrue(false == pokemon1.getCaptured());
		assertTrue(20 == pokemon1.getRunProbability());
		assertTrue(null == pokemon1.getImage());
		pokemon1.setLevel(500);
		pokemon1.setTotalHealth(600);
		pokemon1.setCaptured(true);
		assertTrue(500 == pokemon1.getLevel());
		assertTrue(600 == pokemon1.getTotalHealth());
		assertTrue(true == pokemon1.getCaptured());
		assertTrue(600 == pokemon1.getTotalHealthLeft());
		
	}
	
	@Test
	//squirtle test
	public void squirtleTest() {
		Pokemon pokemon1 = new Charmander(15, 40, "squirtle", "water", true, 18, null);
		assertTrue(15 == pokemon1.getLevel());
		assertTrue(40 == pokemon1.getTotalHealth());
		assertTrue("squirtle" == pokemon1.getName());
		assertTrue("water" == pokemon1.getType());
		assertTrue(true == pokemon1.getCaptured());
		assertTrue(18 == pokemon1.getRunProbability());
		assertTrue(null == pokemon1.getImage());
		pokemon1.setLevel(500);
		pokemon1.setTotalHealth(600);
		pokemon1.setCaptured(true);
		assertTrue(500 == pokemon1.getLevel());
		assertTrue(600 == pokemon1.getTotalHealth());
		assertTrue(true == pokemon1.getCaptured());
		assertTrue(600 == pokemon1.getTotalHealthLeft());
	}
	
	@Test
	//squirtle test
	public void bulbasaurTest() {
		Pokemon pokemon1 = new Bulbasaur(65, 30, "bulbasaur", "grass", false, 58, null);
		assertTrue(65 == pokemon1.getLevel());
		assertTrue(30 == pokemon1.getTotalHealth());
		assertTrue("bulbasaur" == pokemon1.getName());
		assertTrue("grass" == pokemon1.getType());
		assertTrue(false == pokemon1.getCaptured());
		assertTrue(58 == pokemon1.getRunProbability());
		assertTrue(null == pokemon1.getImage());
		pokemon1.setLevel(500);
		pokemon1.setTotalHealth(600);
		pokemon1.setCaptured(true);
		assertTrue(500 == pokemon1.getLevel());
		assertTrue(600 == pokemon1.getTotalHealth());
		assertTrue(true == pokemon1.getCaptured());
		assertTrue(600 == pokemon1.getTotalHealthLeft());
	}
	
	

}
