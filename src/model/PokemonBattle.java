package model;

import java.io.Serializable;

import pokemons.Pokemon;

//pokemon battle is the gym leader battle
public class PokemonBattle extends Battle implements Serializable {

	private Pokemon battlePokemon = null;
	private Pokemon gymTrainerPokemon = null;
	private Trainer gymTrainer = null;

	private boolean ranAway;

	//pokemon battle with gym leaders
	public PokemonBattle() {
		super();
		
		battlePokemon = this.getMyTrainer().getPokemons().get(0); // automatically
																	// set to
																	// the first
																	// pokemon
																	// caught
		battlePokemon.setTotalHealth(300); // automatically set the pokemon's HP
											// to 300 HP

		gymTrainerPokemon = getBattlePokemon(); //gets random Pokemon
		gymTrainerPokemon.setTotalHealth(600); //overrides original health to 600

		ranAway = false;
	}

	@Override
	//this method must be overriden since battle over is different between the two types
	//of the battles in the pokemon game
	public boolean battleOver() {
		if (ranAway || !this.battlePokemon.getFainted() || !this.gymTrainerPokemon.getFainted())
			return true;
		return false;
	}
	
	

	//attack the other pokemon included in abstract class
	
	//run away option included in abstract class
	
	//throw bait option included in abstract class
	
	//strengthen is the last option for the pokemon. in this option
	//the trainer can strengthen its battle pokemon by increasing its HP
	//by 25 HP
	public void strengthen(){
		this.battlePokemon.setTotalHealth(this.battlePokemon.getTotalHealthLeft()+25);
	}
	

}
