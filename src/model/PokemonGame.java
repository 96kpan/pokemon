package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Observable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import item.Axe;
import item.Bait;
import item.HealthPot;
import item.Pokeball;
import pokemons.Pokemon;
import pokemons.PokemonModel;
import view.BattleView;
import view.GraphicViewMapTwo;

public class PokemonGame extends Observable implements Serializable {
	static PokemonMap map;
	public Trainer trainer;
	Battle newBattle;
	BattleView view;
	public int winCondition;
	public int whichMap;
	public boolean shouldLaunchBattle;
	private static final int TOTAL_MOVES = 500;
	private int movesLeft;
	private static PokemonGame game;
	
	private boolean moving = false;
	
	public PokemonGame(PokemonMap m)  {
		map = m;
	
		trainer = new Trainer("ASH KETCHUP");
		trainer.setLocation(MapOne.startPoint);
		map.getTile(trainer.getLocation().x, trainer.getLocation().y)
		.setHasTrainer(true);
		this.movesLeft = TOTAL_MOVES;
	}

	//singleton OODP to only have one instance throughout the game
	public static PokemonGame getInstance() {
		if(game == null){
			game = new PokemonGame(map);
		}

		return game;
	}
	
	public boolean isMoving() {
		return moving;
	}
	
	public void setMoving(boolean m) {
		moving = m;
	}

	//returns the Game's Map
	public PokemonMap getMap() {
		return this.map;
	}

	@Override
	public String toString() {
		return map.toString();
	}

	public void moveTrainer(Direction direction) {
		moveTrainerInDirection(direction);
		this.setChanged();
		this.notifyObservers();
	}

	//general information
	public String toStringNoOfSteps(){
		String s = "No of Steps taken " + this.movesLeft;

		return s;
	}

	private void moveTrainerInDirection(Direction direction) {
		int currX = trainer.getLocation().x;
		int currY = trainer.getLocation().y;
		switch (direction) {
		case South:
			if (currX + 1 < PokemonMap.MAP_WIDTH 
					&& map.getTile(currX + 1, currY).canMove) {
				map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(false);
				map.getTile(currX + 1, currY).setHasTrainer(true);
				trainer.setLocation(new Point(currX + 1, currY));
				movesLeft--;
				GraphicViewMapTwo.move(Direction.South);
			}
			break;
		case North:
			if (currX - 1 >= 0 && map.getTile(currX - 1, currY).canMove) {
				map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(false);
				map.getTile(currX - 1, currY).setHasTrainer(true);
				trainer.setLocation(new Point(currX - 1, currY));
				movesLeft--;
			}

			break;

		case West:
			if (currY - 1 >= 0 && map.getTile(currX, currY - 1).canMove) {
				map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(false);
				map.getTile(currX, currY - 1).setHasTrainer(true);
				trainer.setLocation(new Point(currX, currY - 1));
				movesLeft--;

			}
			break;

		case East: {
			if (currY + 1 < PokemonMap.MAP_HEIGHT
					&& map.getTile(currX, currY + 1).canMove) {
				map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(false);
				map.getTile(currX, currY + 1).setHasTrainer(true);
				trainer.setLocation(new Point(currX, currY + 1));
				movesLeft--;
			}
		}
		break;
		}
		map.getTile(trainer.getLocation().x, trainer.getLocation().y).playerIsOnTile(this);

	}

	public void launchBattle() {
		shouldLaunchBattle = true;
	}

	public void acquireItem() {
		Random rand = new Random();
		int  randNum = rand.nextInt(100) + 1;
		if(randNum == 1) {
			if(this.map.getClass() == MapOne.class) {
				trainer.getBackpack().addItem(new Axe(1));
			}
		}
		else if(randNum > 1 && randNum <= 21) {
			trainer.getBackpack().addItem(new HealthPot("Health pot", 1));
		}
		else if(randNum > 21 && randNum <= 41) {
			trainer.getBackpack().addItem(new Pokeball(1));
		}
		else {
			trainer.getBackpack().addItem(new Bait("Bait",1));
		}

	}

	public boolean isGameOver(){
		
		if(game == null){
			game = getInstance();
			game.map.map[9][1] = new EmptyTile(null);
		}
		
		//Win Condition 1: Finite steps condition
		if(this.winCondition == 0){
			if(game.trainer.stepCount() == 0){
				System.out.println("game.trainer.getBackpack().getNumOfPokeballs() " + game.trainer.getBackpack().getNumOfPokeballs());
				return true;
			}
		}
		
		//Win Condition 2: Finite balls condition
		else if(this.winCondition == 1){
			if(game.trainer.getBackpack().getNumOfPokeballs() == 0)
				return true;
		}
		
		//Win Condition 3: Finite number of pokemons condition
		//hits 5 pokemons, game is over
		else if(this.winCondition == 2){
			if(game.trainer.getPokemons().size() == 5){
				return true;
			}

		}

		return false;

	}


}
