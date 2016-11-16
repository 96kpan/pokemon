package model;

import java.awt.Image;

import pokemons.Pokemon;

// The type 
public class PokemonTile extends Tile {
	private Pokemon pokemonOnTile;
	
	public PokemonTile(Image tileImage, Pokemon pokemonOnTile) {
		super(tileImage);
		this.pokemonOnTile = pokemonOnTile;
	}
	

	@Override
	public void playerIsOnTile(Game game) {
		//Game.launchBattle(Pokemon pokemonToBattle);
		
	}

	// Here we return h for a hidden tile. This is the type of tile that is
	// Hidden by some sort of element on the map if we have a grass type map this 
	// tile will have grass on it which hides the item.
	@Override
	public String toString() {
		return "h";
	}

}
