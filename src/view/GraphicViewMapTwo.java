package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import model.*;
import pokemons.Garchomp;
import view.*;

public class GraphicViewMapTwo extends JPanel implements Observer {
	private PokemonMap map;
	private PokemonGame theGame;
	private JLabel messageText;
	private JLabel myPokemons;
	private JLabel itemCounts;
	private transient BufferedImage fire;
	private transient BufferedImage water;
	private transient BufferedImage emptyGround;
	private transient BufferedImage grass;
	private transient BufferedImage tree;
	JButton statsButton;

	private BufferedImage terrain_sheet;
	private final int size = 32;
	private BufferedImage tile;

	public GraphicViewMapTwo(PokemonGame game) {
		try {
			fire = ImageIO.read(new File("images/fire.png"));
			water = ImageIO.read(new File("images/water.png"));
			emptyGround = ImageIO.read(new File("images/emptyGround.png"));
			grass = ImageIO.read(new File("images/grass.png"));
			tree = ImageIO.read(new File("images/tree.png"));

			terrain_sheet = ImageIO.read(new File("images/terrain.png"));

		} catch (IOException e) {
			e.printStackTrace();

		}
		this.theGame = game;
		initJPanel();

	}

	private void initJPanel() {
		setLayout(null);
		setSize(1000, 1000);
		setLocation(0, 0);
		// this.setBackground(Color.WHITE);
		this.setFocusable(true);
		this.addKeyListener(new MovementListener(theGame));

		messageText = new JLabel("No of Steps taken 500");
		messageText.setLocation(750, 100);
		messageText.setSize(150, 25);
		this.add(messageText);

		this.myPokemons = new JLabel(theGame.trainer.getName() + "'s Pokemon");
		myPokemons.setLocation(750, 200);
		myPokemons.setSize(190, 25);
		this.add(myPokemons);

		this.itemCounts = new JLabel("<html><body>Backpack: <br>" + theGame.trainer.getBackpack().toString());
		itemCounts.setLocation(750, 300);
		itemCounts.setSize(200, 200);
		this.add(itemCounts);

		JButton healthpotButton = new JButton("Add Health");
		healthpotButton.setLocation(750, 550);
		healthpotButton.setSize(190, 25);
		healthpotButton.setFocusable(false);
		ButtonListener hpListener = new ButtonListener();
		healthpotButton.addActionListener(hpListener);
		healthpotButton.setVisible(true);
		this.add(healthpotButton);
		
		statsButton = new JButton("Items & Pokemon");
		statsButton.setLocation(750, 650);
		statsButton.setSize(190, 25);
		StatsListener statsListener = new StatsListener();
		statsButton.addActionListener(statsListener);
		statsButton.setVisible(true);
		this.add(statsButton);


	}

	public void paintComponent(Graphics g) {

		System.out.println(theGame.trainer.getPokemons().size());

		for (int i = 0; i < theGame.trainer.getPokemons().size(); i++) {
			g.drawImage(theGame.trainer.getPokemons().get(i).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH),
					770+ (50 * i), 250, null);

		}

		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 23; j++) {
				Tile curTile = theGame.getMap().getTile(i, j);

				// grass
				if (curTile.toString().equals("g")) {
					tile = terrain_sheet.getSubimage(0 * size, 0 * size, size, size);
					g.drawImage(tile, j * 32, i * 32, null);
				}

				// fire
				if (curTile.toString().equals("f")) {
					g.drawImage(fire, j * 32, i * 32, null);
				}

				// ground
				if (curTile.toString().equals("e")) {
					tile = terrain_sheet.getSubimage(0 * size, 4 * size, size, size);
					g.drawImage(tile, j * 32, i * 32, null);
				}

				// tree
				if (curTile.toString().equals("t")) {
					tile = terrain_sheet.getSubimage(0 * size, 2 * size, size, size);
					g.drawImage(tile, j * 32, i * 32, null);
				}

				// water
				if (curTile.toString().equals("w")) {
					g.drawImage(water, j * 32, i * 32, null);
				}

				// grass
				if (curTile.getHasPokemon()) {
					g.drawImage(grass, j * 32, i * 32, null);
				}

				// trainer
				if (curTile.getHasTrainer()) {
					g.drawImage(Trainer.getInstance().getImage(), j * 32, i * 32, null);
				}

			}

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		this.messageText.setText(theGame.toStringNoOfSteps());
		this.itemCounts.setText("<html><body>Backpack: <br>" + theGame.trainer.getBackpack().toString());
		if(this.theGame.isGameOver()){
			JOptionPane.showMessageDialog(null, "Game over");
			return;
		}
		this.repaint();
		revalidate();
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String text = arg0.getActionCommand();
			if (text.equals("Add Health")) {
				
				ButtonGroup bg1 = new ButtonGroup();

				JRadioButton[] rb = new JRadioButton[theGame.trainer.getPokemons().size()];
				JPanel p = new JPanel(new GridLayout(3, 5));
				for (int x = 0; x < theGame.trainer.getPokemons().size(); x++) {
					rb[x] = new JRadioButton("" + theGame.trainer.getPokemons().get(x).getName());
					bg1.add(rb[x]);
					p.add(rb[x]);
				}
				JOptionPane.showMessageDialog(null, p);

				for (int i = 0; i < theGame.trainer.getPokemons().size(); i++) {
					if (rb[i].isSelected()) {
						// find pokemon
						if(theGame.trainer.getBackpack().getCountOfItems("HealthPot") > 0){
							theGame.trainer.getBackpack().removeItem("HealthPot");
							theGame.trainer.getPokemons().get(i)
									.setTotalHealth(theGame.trainer.getPokemons().get(i).getTotalHealth() + 50);
							
							return;
						}else{
							JOptionPane.showMessageDialog(null, "No more");
							return;
						}
						

					}
				}

			}
		}
	}
	
	private class StatsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,theGame.trainer.getBackpack().toString());
			statsButton.setFocusable(false);
			return;
		}
	}
}
