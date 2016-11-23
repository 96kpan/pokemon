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

import pokemons.Pokemon;

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
	
	public void setEveryTileToEmpty() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = new EmptyTile(placeholder);
			}
		}
	}
	
	
	
	public void treeBorder() {
		fillRowWithTrees(0);
		fillRowWithTrees(map.length - 1);
		fillColumnWithTrees(0);
		fillColumnWithTrees(map[0].length - 1);
		makeEntrance();
		
	}
	
	private void makeEntrance() {
		map[8][0] = new EmptyTile(placeholder);
		map[9][0] = new EmptyTile(placeholder);
		map[10][0] = new EmptyTile(placeholder);
	}
	
	private void fillRowWithTrees(int rowToFill) {
		for(int i = 0; i < map.length; i++) {
			map[rowToFill][i] = new TerrainTile(placeholder,"t");
		}
	}
	
	private void fillColumnWithTrees(int columnToFill) {
		for(int i = 0; i < map.length; i++) {
			map[i][columnToFill] = new TerrainTile(placeholder,"t");
		}
	}
	
	public void makeGrassRectangle(Point start, int width, int height) {
		System.out.println("Called");
		for(int i = start.x; i < width + start.x; i++ ) {
			for(int j = start.y; j < height + start.y; j++) {
				map[i][j] = new GrassTile(placeholder);
			}
		}
	}
	
	private void placePokemon() {
		ArrayList<Pokemon> pokemonToPlace = new ArrayList<Pokemon>();
		//init pokemon
		//pokemonToPlace.add();
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
	
	public abstract void initMap();
	
	
}
