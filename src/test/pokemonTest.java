//Katie Pan
//Test cases for Pokemon Class

package test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

import model.ItemTile;
import model.MapOne;
import model.MapTwo;
import model.Pokemon;
import model.PokemonMap;
import model.Tile;
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
	
	private void assertTrue(boolean b) {
		// TODO Auto-generated method stub
		
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
	
	public void mapTest() {
		PokemonMap mapOne = new MapOne();
		PokemonMap mapTwo = new MapTwo();
		mapOne.initMap();
		mapTwo.initMap();
	}
	
	public void TileTest() {
		BufferedImage image = ImageIO.read(new File("someImage.jpeg"));
		Tile itemTile = new ItemTile(image);
		
		
		
	}
	
	

}
