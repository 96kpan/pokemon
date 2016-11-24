// Last updated: 1042

package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.MapOne;
import model.PokemonGame;
import model.PokemonMap;
import view.BattleView;
import model.Battle;
import view.PokemonTextView;

public class GameController extends JFrame {
	private PokemonGame theGame;
	private MapOne firstMap;

	private PokemonMap currentMap;
	private PokemonTextView textView;
	private BattleView battleView;

	public GameController() {
		firstMap = new MapOne();
		currentMap = firstMap;
		theGame = setUpGame(theGame);
		setUpFrame();

		this.setTitle("Pokemon Safari Zone");
		textView = new PokemonTextView(theGame);
		this.add(textView);
		textView.setVisible(true);
		theGame.addObserver(textView);
	}

	// if you want to see the battle scene text view, just copy
	// this code into the constructor

	// firstMap = new MapOne();
	// currentMap = firstMap;
	// theGame = setUpGame(theGame);
	// setUpFrame();
	//
	// this.setTitle("Pokemon Safari Zone");
	// battleView = new BattleView(new Battle());
	// this.add(battleView);
	// battleView.setVisible(true);
	// //theGame.addObserver(textView);

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.setVisible(true);

	}

	private void setUpFrame() {
		this.setLocation(0, 0);
		this.setSize(1000, 1000);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int result = JOptionPane.showConfirmDialog(GameController.this, "Would you like to save your state?");
				if (result == JOptionPane.YES_OPTION) {
					saveGameState(theGame);
					System.exit(0);
				} else if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				}

			}
		});
	}

	private void saveGameState(PokemonGame theGame) {
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("Pokemon_Saved_Data");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
			outFile.writeObject(theGame);
			outFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Writing objects failed");
		}
	}

	private PokemonGame setUpGame(PokemonGame theGame) {
		int result = JOptionPane.showConfirmDialog(this,
				"Start with previous saved state?\n" + "No means all new objects");
		if (result == JOptionPane.YES_OPTION) {
			try {
				FileInputStream rawBytes = new FileInputStream("Pokemon_Saved_Data");
				ObjectInputStream inFile = new ObjectInputStream(rawBytes);
				theGame = (PokemonGame) inFile.readObject();
				inFile.close();
			} catch (Exception e) {
				System.out.println("Reading objects failed");
			}
		} else if (result == JOptionPane.NO_OPTION) {
			theGame = new PokemonGame();
		} else {
			System.exit(0);
		}
		return theGame;

	}

}