package model;
// A tile for holding a pokemon this tile will initiate a battle if it is landed on
// with the given pokemon.
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import pokemons.Pokemon;
import pokemons.PokemonModel;

// The type 
public class PokemonTile extends Tile implements Serializable {
	//private PokemonModel pokemonOnTile;
	
	public PokemonTile(BufferedImage tileImage, Pokemon pokemonOnTile) {
		super(tileImage);
		//this.pokemonOnTile = pokemonOnTile;
	}
	

	@Override
	public void playerIsOnTile(PokemonGame game) {
		//Game.launchBattle(Pokemon pokemonToBattle);
		game.launchBattle();
		
	}
	
	@Override
	public boolean getHasPokemon() {
		return true;
	}

	// Here we return h for a hidden tile. This is the type of tile that is
	// Hidden by some sort of element on the map if we have a grass type map this 
	// tile will have grass on it which hides the item.
	@Override
	public String toString() {
		//return Character.toString(Character.toUpperCase(pokemonOnTile.getName().charAt(0)));
		return Character.toString('P');
	}

}
