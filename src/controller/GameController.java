// Last updated: 1042

package controller;

import model.MapOne;
import model.PokemonMap;

public class GameController {
	private static   PokemonMap firstMap;
	
	public static void main(String[] args) {
		firstMap = new MapOne();
		System.out.println(firstMap);
		
	}
	

}