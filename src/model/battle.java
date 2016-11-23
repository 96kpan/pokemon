package model;

import java.util.Random;

import pokemons.*;
import pokemons.Pokemon;

public class battle {

	private Trainer player;
	private PokemonGame game;
	private Pokemon battlePokemon;
	private static final int ROCK_HEALTH = 50;
	private boolean pokemonRanAway;
	private boolean playerRanAway;
	private boolean battleOver;

	// finish pokemon Logic

	// constructor which will initialize variables
	public battle() {
		player = player.getInstance();
		game = game.getInstance();
		pokemonRanAway = false;
		playerRanAway = false;
		battleOver = false;
	}

	// get random pokemon
	private void randomPokemon(){
		int rand = (int)(Math.random()*100)+1;

		if(rand < 60){
			//common pokemons
			double commonPokemon = (Math.random() * 6)+1;
			if(commonPokemon < 1){
				battlePokemon = new Bulbasaur(); //common
				return;
			}if(commonPokemon < 2){
				battlePokemon = new Charmander(); //common
				return;
			}if(commonPokemon < 3){
				battlePokemon = new Eevee(); //common
				return;
			}if(commonPokemon < 4){
				battlePokemon = new Jigglypuff(); //common
				return;
			}if(commonPokemon < 5){
				battlePokemon = new Pikachu(); //common
				return;
			}else{
				battlePokemon = new Squirtle(); //common
				return;
			}
		}
		
		else if(rand < 90){
			//medium rare
			double mediumRare = (Math.random() * 3)+1;
			if(mediumRare < 1){
				battlePokemon = new Blaziken(); //common
				return;
			}if(mediumRare < 2){
				battlePokemon = new Garchomp(); //common
				return;
			}else{
				battlePokemon = new Gengar(); //common
				return;
			}
		}
		
		else {
			double rarePokemon = (Math.random()*2)+1;
			if(rarePokemon < 1){
				battlePokemon = new Lugia(); //rare
				return;
			}
			else{
				battlePokemon = new Mewtwo(); //rare
				return;
			}
		}
	}

	//getter for random pokemon
	public Pokemon getRandomPokemon(){
		return battlePokemon;
	}

	//throw rock, each rock throw is -50 hp
	public void throwRock(){

		if(battlePokemon.getTotalHealth() <= 50){
			battlePokemon.setFainted(true);
			battleOver = true;
		}
		else{
			battlePokemon.setTotalHealth(battlePokemon.getTotalHealth() - ROCK_HEALTH);
			battlePokemon.addRunProbability(10);

			if(battlePokemon.getRunProbability() > 90){
				pokemonRanAway = true;
			}
		}	
	}

	//throw pokeball, will only catch pokemon if the pokemon's health is less than 75
	public void throwPokeball(){
		if(battlePokemon.getTotalHealth() <= 50 && battlePokemon.getRunProbability() <= 50){
			player.addPokemon(battlePokemon);
			battleOver = true;
		}
		else{
			battlePokemon.addRunProbability(10);

			if(battlePokemon.getRunProbability() > 90){
				pokemonRanAway = true;
			}
		}
	}

	//throw bait
	//run probability lowers
	public void throwBait(){
		battlePokemon.addRunProbability(-10);

		if(battlePokemon.getRunProbability() > 90){
			pokemonRanAway = true;
		}
	}


	//player run away
	public void runAway(){
		playerRanAway = true;
	}
	
	//sees if the battle is over or not
	public boolean battleOver(){
		if(this.playerRanAway || this.pokemonRanAway || this.battleOver){
			return true;
		}
		
		return false;
	}
}
