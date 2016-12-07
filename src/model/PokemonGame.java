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
	
	private transient BufferedImage trainer_sheet;
	private transient Image[] trainer_front;
	private transient Image[] trainer_back;
	private transient Image[] trainer_left;
	private transient Image[] trainer_right;
	private boolean moving = false;
	
	private Frames f;


	public PokemonGame(PokemonMap m)  {
		try {
			trainer_sheet = ImageIO.read(new File("images/trainerSprite.png"));
		} catch (IOException e) {
			e.printStackTrace();

		}
		
		trainer_front = new Image[4];
		trainer_back = new Image[4];
		trainer_left = new Image[4];
		trainer_right = new Image[4];
		Image scaledImage;
		for(int x = 0; x < 4; x++) {
			scaledImage = trainer_sheet.getSubimage(0*32, x*32, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH);
			trainer_front[x] = scaledImage;
			scaledImage = trainer_sheet.getSubimage(1*32, x*32, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH);
			trainer_back[x] = scaledImage;
			scaledImage = trainer_sheet.getSubimage(2*32, x*32, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH);
			trainer_right[x] = scaledImage;
			scaledImage = trainer_sheet.getSubimage(3*32, x*32, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH);
			trainer_left[x] = scaledImage;
		} 
		map = m;
	
		trainer = new Trainer("ASH KETCHUP");
		trainer.setLocation(MapOne.startPoint);
		map.getTile(trainer.getLocation().x, trainer.getLocation().y)
		.setHasTrainer(true);
		this.movesLeft = TOTAL_MOVES;
		addFrame(Direction.South);
	}

	//singleton OODP to only have one instance throughout the game
	public static PokemonGame getInstance() {
		if(game == null){
			game = new PokemonGame(map);
		}

		return game;
	}
	
	public void addFrame(Direction d) {
		if(d == Direction.North) {
			f = new Frames(trainer_back, trainer.getLocation().x, trainer.getLocation().y);
		}
		if(d == Direction.South) {
			f = new Frames(trainer_front, trainer.getLocation().x, trainer.getLocation().y);
		}
		if(d == Direction.East) {
			f = new Frames(trainer_right, trainer.getLocation().x, trainer.getLocation().y);
		}
		if(d == Direction.West) {
			f = new Frames(trainer_left, trainer.getLocation().x, trainer.getLocation().y);
		}
	}
	
	public Frames getFrame() {
		return f;
	}
	
	public boolean isMoving() {
		return moving;
	}
	
	public void setMoving(boolean m) {
		moving = m;
	}
	
	public class Frames {
		public Image[] img;
		int index = 0;
		int x = 0;
		int y = 0;
		public Frames(Image[] image, int j, int i) {
			img = image;
			index = 0;
			x = j;
			y = i;
		}
		
		public void drawFrame(Graphics g) {
			g.drawImage(img[index], x, y, null);
		}
		
		public int getIndex() {
			return index;
		}
		
		public void setIndex(int i) {
			index = i;
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
