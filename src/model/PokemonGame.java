package model;

import java.awt.Point;
import java.util.Observable;

public class PokemonGame extends Observable {
	PokemonMap map;
	Trainer trainer;
	private static final int TOTAL_MOVES = 500;
	private int movesLeft;

	public PokemonGame() {
		MapOne mapOne = new MapOne();
		MapTwo mapTwo = new MapTwo();
		// set this for whichever map we want to use
		map = mapTwo;
		
		
		trainer = new Trainer("ASH KETCHUP", null);
		trainer.setLocation(MapOne.startPoint);
		map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(true);
		movesLeft = TOTAL_MOVES;
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

	private void moveTrainerInDirection(Direction direction) {
		if (movesLeft < 0) {
			// end game.
		}
		System.out.println("Original loc " + trainer.getLocation());
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
			System.out.println(currY -1 );
			if (currY - 1 >= 0 && map.getTile(currX, currY - 1).canMove) {
				map.getTile(trainer.getLocation().x, trainer.getLocation().y)
				.setHasTrainer(false);
				System.out.println("here");
				map.getTile(currX, currY - 1).setHasTrainer(true);
				trainer.setLocation(new Point(currX, currY - 1));
				System.out.println("curr row: " + trainer.getLocation().x + 
						"Curr col " + trainer.getLocation().y);
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

	}

}
