// Last updated: Wed Nov 9, 8:16 pm
// Katie Pan
// Abstract class Pokemon

package model;

import java.awt.Image;

public abstract class Pokemon implements PokemonModel{

	private int level; //pokemon level
	private int totalHealth; //pokemon total health
	private int healthLeft; //pokemon total health left
	private String name; //pokemon's name
	private String type; //pokemon's type
	private boolean captured; //captured returns true; uncaptured returns false;
	private int runProbability;//pokemon's run probability
	private Image pokemonPicture = null; //pokemon's picture

	//constructor that initializes our instance variables 
	public Pokemon(int level, int totalHealth, String pokemonName, String pokemonType, boolean capturedOrNot, int runProbs, Image pokemonPic){
		this.level = level;
		this.totalHealth = totalHealth;
		this.healthLeft = totalHealth;
		this.name = pokemonName;
		this.type = pokemonType;
		this.captured = capturedOrNot;
		this.runProbability = runProbs;
		this.pokemonPicture = pokemonPic;
	}

	//getter for our pokemon level
	public int getLevel(){
		return this.level;
	}

	//setter for our pokemon level
	public void setLevel(int newLevel){
		this.level = newLevel;
	}

	//getter for our pokemon's total health
	public int getTotalHealth(){
		return this.totalHealth;
	}

	//setter for our pokemon's total health
	public void setTotalHealth(int newTotalHealth){
		this.totalHealth = newTotalHealth;
	}

	//getter for our pokemon's total health left
	public int getTotalHealthLeft(){
		this.healthLeft = totalHealth;
		return this.healthLeft;
	}

	//getter for our pokemon's name
	public String getName(){
		return this.name;
	}

	//getter for our pokemon's type
	public String getType(){
		return this.type;
	}

	//getter for our pokemon's captured/not status
	//returns true if captured
	//returns false if not captured
	public boolean getCaptured(){
		return this.captured;
	}

	//setter for our pokemon's captured/not status
	//sets true if captured
	//sets false if not captured
	public void setCaptured(boolean bool){
		this.captured = bool;
	}

	//getter for our pokemon's run probability
	public int getRunProbability(){
		return this.runProbability;
	}

	//setter for our pokemon's image
	public void setImage(Image i){
		this.pokemonPicture = i;
	}

	//getter for our pokemon's image
	public Image getImage(){
		return this.pokemonPicture;
	}
}
