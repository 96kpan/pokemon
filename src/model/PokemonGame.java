package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Observable;
import java.util.Random;

import javax.swing.JOptionPane;

import item.Axe;
import item.Bait;
import item.HealthPot;
import item.Pokeball;
import pokemons.Pokemon;
import pokemons.PokemonModel;
import view.BattleView;

public class PokemonGame extends Observable implements Serializable {
	PokemonMap map;
	public Trainer trainer;
	Battle newBattle;
	BattleView view;
	public int winCondition;
	public int whichMap;
	public boolean shouldLaunchBattle;
	public static final int TOTAL_MOVES = 500;
	private int movesLeft;
	private String itemadded;
	public int battleType;


	public PokemonGame(PokemonMap m)  {
		map = m;
	
		trainer = new Trainer("ASH KETCHUP");
		trainer.setLocation(MapOne.startPoint);
		map.getTile(trainer.getLocation().x, trainer.getLocation().y)
		.setHasTrainer(true);
		this.movesLeft = TOTAL_MOVES;
	}

	//singleton OODP to only have one instance throughout the game
	
	public void toggleMap(){
	
		if(this.whichMap == 1){
			whichMap = 2;
			map = new MapOne();
		}
		else{
			whichMap = 1;
			map = new MapTwo();
		}
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
		String s = "Steps left " + this.movesLeft;

		return s;
	}

	private void moveTrainerInDirection(Direction direction) {
		int currX = trainer.getLocation().x;
		int currY = trainer.getLocation().y;
		switch (direction) {
		case South:
			if(map.getTile(currX + 1, currY).toString().equals("t")) {
				movingIntoTree(currX + 1, currY);
			}
			if (currX + 1 < PokemonMap.MAP_WIDTH 
					&& map.getTile(currX + 1, currY).canMove) {
				map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(false);
				map.getTile(currX + 1, currY).setHasTrainer(true);
				trainer.setLocation(new Point(currX + 1, currY));
				movesLeft--;

			}
			break;
		case North:
			if(map.getTile(currX - 1, currY).toString().equals("t")) {
				movingIntoTree(currX -1, currY);
			}
			if (currX - 1 >= 0 && map.getTile(currX - 1, currY).canMove) {
				map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(false);
				map.getTile(currX - 1, currY).setHasTrainer(true);
				trainer.setLocation(new Point(currX - 1, currY));
				movesLeft--;
			}

			break;

		case West:
			if (currY - 1 >= 0 && map.getTile(currX, currY - 1).toString().equals("t")) {
				movingIntoTree(currX,currY -1);
			}
			if (currY - 1 >= 0 && map.getTile(currX, currY - 1).canMove) {
				map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(false);
				map.getTile(currX, currY - 1).setHasTrainer(true);
				trainer.setLocation(new Point(currX, currY - 1));
				movesLeft--;

			}
			break;

		case East: {
			if(currY + 1 < PokemonMap.MAP_HEIGHT
					&& map.getTile(currX, currY + 1).toString().equals("t")) {
				movingIntoTree(currX, currY + 1);
			}
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
	
	public void movingIntoTree(int xPos, int yPos) {
		int result = JOptionPane.showConfirmDialog(
				null, "You have run into a tree would you like to try and chop it?");
		if(result == JOptionPane.YES_OPTION) {
			chopTree(xPos,yPos);
		}
		
	}
	
	public void chopTree(int xPos, int yPos) {
		if(trainer.getBackpack().getCountOfItems("Axe") > 0) {
			map.map[xPos][yPos] = new GrassTile(null);
			JOptionPane.showMessageDialog(null, "You chopped the tree!!");
			trainer.getBackpack().removeItem("Axe");
			
		}
		else {
			JOptionPane.showMessageDialog(null, "You need to find an axe.... try looking in the grass");
		}
		
	}

	public void launchBattle(int mode) {
		battleType = mode;
		shouldLaunchBattle = true;
	}

	public void acquireItem() {
		Random rand = new Random();
		int  randNum = rand.nextInt(100) + 1;
		if(randNum > 41) {
			if(this.map.getClass() == MapOne.class) {
				trainer.getBackpack().addItem(new Axe(1));
				itemadded = "Axe";
			}
		}
		else if(randNum > 1 && randNum <= 21) {
			trainer.getBackpack().addItem(new HealthPot("Health pot", 1));
			itemadded = "HealthPot";
		}
		else if(randNum > 21 && randNum <= 41) {
			trainer.getBackpack().addItem(new Pokeball(1));
			itemadded = "Pokeball";
		}
		/*else {
			trainer.getBackpack().addItem(new Bait("Bait",1));
			itemadded = "Bait";
		}*/

	}
	
	public String getItemAdded(){
		return this.itemadded;
	}

	public boolean isGameOver(){
		
		
			
	
			
		//Win Condition 1: Finite steps condition -> WORKS
		if(this.winCondition == 0){
			if(movesLeft <= 0){
				JOptionPane.showMessageDialog(null, "You've reached the maximum number of steps");
				gameOverMessage();
				System.exit(0);
				
				
			}
		}
		
		//Win Condition 3: Finite number of pokemons condition -> works
		//hits 5 pokemons, game is over
		else if(this.winCondition == 2){
			if(this.trainer.getPokemons().size() >= 5){
				gameOverMessage();
				return true;
				
				
			}

		}

		return false;

	}
	
	public void gameOverMessage() {
		JOptionPane.showMessageDialog(null, "Thanks for playing here are your stats: \n "
				+ "Pokemon Caught: " + trainer.getPokemons().toString() + "\n  Item counts:\n "
						+ trainer.getBackpack().toString());
		
	}


}
