// Last updated: 1042
// A class that represents a model for the game map.
// This is represented by a double array of tile objects
// When the player lands on the tile objects the playerIsOnTile() method .
package model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import pokemons.Blaziken;
import pokemons.Bulbasaur;
import pokemons.Charmander;
import pokemons.Eevee;
import pokemons.Garchomp;
import pokemons.Gengar;
import pokemons.Jigglypuff;
import pokemons.Lugia;
import pokemons.Mewtwo;
import pokemons.Pikachu;
import pokemons.Pokemon;
import pokemons.Squirtle;


//Abstract class for the Map
public abstract class PokemonMap {
	public static final int MAP_HEIGHT = 23;
	public static final int MAP_WIDTH = 23;
	protected Tile[][] map;
	protected BufferedImage placeholder;
	
	public PokemonMap() {
		map = new Tile[MAP_HEIGHT][MAP_WIDTH];
		try {
			placeholder = ImageIO.read(new File("images/dog.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Tile getTile(int row, int column) {
		return map[row][column];
	}
	
	
	//returns the char of the item on each tile
	@Override
	public String toString() {
		StringBuilder mapRep = new StringBuilder();
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j].getHasTrainer()) {
					mapRep.append("[T] ");
				}
				else {
					mapRep.append("[" + map[i][j].toString() + "] ");
				}
			}
			mapRep.append("\n");
		}
		return mapRep.toString();
	}
	
	
	//sets the tile to empty (can walk through)
	public void setEveryTileToEmpty() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = new EmptyTile(placeholder);
			}
		}
	}
	
	
	//sets a border of trees on the map
	public void treeBorder() {
		fillRowWithTrees(0);
		fillRowWithTrees(map.length - 1);
		fillColumnWithTrees(0);
		fillColumnWithTrees(map[0].length - 1);
		makeEntrance();
		
	}
	
	//sets a border fo fire on the map
	public void fireBorder(){
		fillRowWithFire(0);
		fillRowWithFire(map.length - 1);
		fillColumnWithFire(0);
		fillColumnWithFire(map[0].length - 1);
		makeEntrance();
	}
	
	
	//makes the entrance on the map
	private void makeEntrance() {
		map[8][0] = new EmptyTile(placeholder);
		map[9][0] = new EmptyTile(placeholder);
		map[10][0] = new EmptyTile(placeholder);
	}
	
	//fills a row with tree tiles
	private void fillRowWithTrees(int rowToFill) {
		for(int i = 0; i < map.length; i++) {
			map[rowToFill][i] = new TerrainTile(placeholder,"t");
		}
	}
	
	//fills a colum with trees
	private void fillColumnWithTrees(int columnToFill) {
		for(int i = 0; i < map.length; i++) {
			map[i][columnToFill] = new TerrainTile(placeholder,"t");
		}
	}
	
	
	//fills a row with fire
	private void fillRowWithFire(int rowToFill) {
		for(int i = 0; i < map.length; i++) {
			map[rowToFill][i] = new TerrainTile(placeholder,"f");
		}
	}
	
	//fills a colum wit fire
	private void fillColumnWithFire(int columnToFill) {
		for(int i = 0; i < map.length; i++) {
			map[i][columnToFill] = new TerrainTile(placeholder,"f");
		}
	}
	
	
	//makes a grass rectangle
	public void makeGrassRectangle(Point start, int width, int height) {
		System.out.println("Called");
		for(int i = start.x; i < width + start.x; i++ ) {
			for(int j = start.y; j < height + start.y; j++) {
				map[i][j] = new GrassTile(placeholder);
			}
		}
	}
	
	//makes a fire rectangle
	public void makeFireRectangle(Point start, int width, int height) {
		System.out.println("Called");
		for(int i = start.x; i < width + start.x; i++ ) {
			for(int j = start.y; j < height + start.y; j++) {
				map[i][j] = new TerrainTile(placeholder,"f");
			}
		}
	}
	
	//places pokemon on the map
	public void placePokemon() {
		ArrayList<Pokemon> pokemonToPlace = new ArrayList<Pokemon>();
		Blaziken blaziken = new Blaziken(50, 50, "blaziken", "fire", false, 1, placeholder);
		Bulbasaur bulbasaur = new Bulbasaur(50, 50, "bulbasaur", "green", false, 2, placeholder);
		Charmander charmander = new Charmander(50,50,"charmander","fire",false,1,placeholder);
		Eevee eevee = new Eevee(50, 50, "eevee", "wind", false, 1, placeholder);
		Garchomp garchomp = new Garchomp(50,50,"garchomp", "fighting", false, 1, placeholder);
		Gengar gengar = new Gengar(50,50, "gengar", "ghost", false, 1, placeholder);
		Jigglypuff jigglypuff = new Jigglypuff(50,50,"jigglypuff","normal", false,1,placeholder);
		Lugia lugia = new Lugia(50,50,"lugia","specal",false,1,placeholder);
		Mewtwo mewtwo = new Mewtwo(50, 50, "mewtwo", "special", false, 1, placeholder);
		Pikachu pikachu = new Pikachu(50,50,"pikachu","lightening",false,3,placeholder);
		Squirtle squirtle = new Squirtle(50,50,"squirtle","water",false,2,placeholder);
		
		
		pokemonToPlace.add(blaziken);
		pokemonToPlace.add(bulbasaur);
		pokemonToPlace.add(charmander);
		pokemonToPlace.add(eevee);
		pokemonToPlace.add(garchomp);
		pokemonToPlace.add(gengar);
		pokemonToPlace.add(jigglypuff);
		pokemonToPlace.add(lugia);
		pokemonToPlace.add(mewtwo);
		pokemonToPlace.add(pikachu);
		pokemonToPlace.add(squirtle);


		
		while(pokemonToPlace.size() > 0) {
			Random rand = new Random(); 
			int value = rand.nextInt(pokemonToPlace.size()); 
			int rowToPlace = rand.nextInt(PokemonMap.MAP_HEIGHT);
			int colToPlace = rand.nextInt(PokemonMap.MAP_WIDTH);
			if(map[rowToPlace][colToPlace].toString().equals("g")) {
				map[rowToPlace][colToPlace] = new PokemonTile(placeholder,
						pokemonToPlace.get(value));
				pokemonToPlace.remove(pokemonToPlace.get(value));
				
			}
					
		}
		
		
		
	}
	
	//intializes the map
	public abstract void initMap();
	
	
}
