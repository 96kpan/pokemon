package model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapOne extends PokemonMap {
	// A place holder image for now will use next time.
	private BufferedImage placeholder;
	
	public MapOne() {
		super();
		try {
			placeholder = ImageIO.read(new File("images/dog.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initMap();
	}

	@Override
	public void initMap() {
		setEveryTileToEmpty();
		treeBorder();
		makeGrassRectangle(new Point(1,1), 8,10);
		makeGrassRectangle(new Point(11, 1),11,10);
		makeGrassRectangle(new Point(1,13), 11,9);
		
		
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder mapRep = new StringBuilder();
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				mapRep.append("[" + map[i][j].toString() + "] ");
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
	
	private void treeBorder() {
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

}
