// Last updated: 1042

package controller;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import model.MapOne;
import model.MapTwo;
import model.PokemonBattle;
import model.PokemonGame;
import model.PokemonMap;
import model.TrainerBattle;
import view.BattleView;
import view.GraphicViewMapTwo;
import model.Battle;
import model.EmptyTile;
import view.PokemonTextView;

public class GameController extends JFrame implements Observer {
	private PokemonGame theGame;
	private MapOne firstMap;

	private JLayeredPane layeredPane;

	private MapTwo secondMap;


	private PokemonMap currentMap;
	private PokemonTextView textView;
	private BattleView battleView;
	private GraphicViewMapTwo graphicViewMapTwo;
	

	public GameController() {
		firstMap = new MapOne();
		currentMap = firstMap;
		theGame = null;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpGame();
		setUpFrame();
		theGame.addObserver(this);
		this.setTitle("Pokemon Safari Zone");
		setUpLayeredFrame();
		theGame.addObserver(this);
		System.out.println("aaaaaa" + theGame);
		graphicViewMapTwo = new GraphicViewMapTwo(theGame);
		layeredPane.add(graphicViewMapTwo,0);
		graphicViewMapTwo.setVisible(true);
		theGame.addObserver(graphicViewMapTwo);
	}

	

//	firstMap = new MapOne();
//	currentMap = firstMap;
//	theGame = new PokemonGame();
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	this.setSize(1000, 1000);
//	this.setLocation(0, 0);
//	this.setTitle("Pokemon Safari Zone");
//	textView = new PokemonTextView(theGame);
//	this.add(textView);
//	textView.setVisible(true);
//	theGame.addObserver(textView);
	
	
//	 firstMap = new MapOne();
//	 currentMap = firstMap;
//	 theGame = setUpGame(theGame);
//	 setUpFrame();
//	 theGame.addObserver(this);
//	
//	 this.setTitle("Pokemon Safari Zone");
//	 battleView = new BattleView(new Battle());
//	 this.add(battleView);
//	 battleView.setVisible(true);

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.setVisible(true);

	}
	
	private void setUpLayeredFrame() {
		this.layeredPane = new JLayeredPane();
		layeredPane.setLocation(0,0);
		layeredPane.setSize(1000, 1000);
		layeredPane.setVisible(true);
		this.add(layeredPane);
		
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

	private void setUpGame() {
		int result = JOptionPane.showConfirmDialog(this,
				"Start with previous saved state?\n" + "No means all new objects");
		if (result == JOptionPane.YES_OPTION) {
			try {
				System.out.println("reading game");
				FileInputStream rawBytes = new FileInputStream("Pokemon_Saved_Data");
				ObjectInputStream inFile = new ObjectInputStream(rawBytes);
				this.theGame = (PokemonGame) inFile.readObject();
				System.out.println();
				inFile.close();
			} catch (Exception e) {
				System.out.println("Reading objects failed");
			}
		} else if (result == JOptionPane.NO_OPTION) {
			
			
			JRadioButton[] rb = new JRadioButton[2];
			JPanel p = new JPanel(new GridLayout(2, 1));
			for (int x = 0; x < 2; x++) {
				rb[x] = new JRadioButton("Map " + (x+1));
				p.add(rb[x]);
			}
			JOptionPane.showMessageDialog(null, p);
			
			if(rb[0].isSelected()){
				this.theGame = new PokemonGame(new MapOne());
			}else{
				this.theGame = new PokemonGame(new MapTwo());
			}
			
			JRadioButton[] rb2 = new JRadioButton[3];
			JPanel p2 = new JPanel(new GridLayout(3, 1));
			rb2[0] = new JRadioButton("Win Condition 1: Finite steps condition");
			p2.add(rb2[0]);
			rb2[1] = new JRadioButton("Win Condition 2: Finite balls condition");
			p2.add(rb2[1]);
			rb2[2] = new JRadioButton("Win Condition 3: Finite number of pokemons condition");
			p2.add(rb2[2]);
			
			for(int i = 0; i < 3; i++){
				if(rb2[i].isSelected()){
					theGame.winCondition = i;
				}
			}
			
			JOptionPane.showMessageDialog(null, p2);
			
			
			
			
		} else {
			System.exit(0);
		}
		

	}
	
	private void showBattle() {
		Battle battle = new TrainerBattle();
		battleView = new BattleView(battle);
		layeredPane.add(battleView);
		layeredPane.setLayer(battleView,1);
		battleView.setVisible(true);
		graphicViewMapTwo.setFocusable(false);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		if(theGame.shouldLaunchBattle) {
			showBattle();
			this.theGame.getMap().map[9][1] = new EmptyTile(null);
			//System.out.println(this.theGame.toString());
			theGame.shouldLaunchBattle = false;
			graphicViewMapTwo.setFocusable(true);
			graphicViewMapTwo.setVisible(true);
			
			
		}
		
		
		
	}

}