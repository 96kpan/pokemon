// Last updated: 1042

package controller;

import javax.swing.JFrame;

import model.MapOne;
import model.PokemonGame;
import model.PokemonMap;
import model.Trainer;
import view.PokemonTextView;

public class GameController extends JFrame {
	private PokemonGame theGame;
	private MapOne firstMap;
	private PokemonMap currentMap;
	private PokemonTextView textView;

	public GameController() {
		firstMap = new MapOne();
		currentMap = firstMap;
		theGame = new PokemonGame();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		this.setLocation(0, 0);
		this.setTitle("Pokemon Safari Zone");
		textView = new PokemonTextView(theGame);
		this.add(textView);
		textView.setVisible(true);
		theGame.addObserver(textView);
	}

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.setVisible(true);

	}

}