package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Battle;

public class BattleView extends JPanel {
	private JTextArea battlePokemonText;
	private JTextArea myPokemonText;
	private JTextArea messageText;
	private JButton rockButton;
	private JButton baitButton;
	private JButton runButton;
	private JButton pokeballButton;
	private Battle theBattle;

	private Image background;
	private Image pokemon;

	public BattleView(Battle battle) {
		loadImages();
		this.theBattle = battle;
		initButtons();
		initTextView();
		initBattleText();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image scaledImage = background.getScaledInstance(750,500,Image.SCALE_SMOOTH);
		g.drawImage(scaledImage, 0, 0, null);
	}
	
	private void loadImages() {
		try {
			background = ImageIO.read(new File("images" + File.separator
					+ "battle.png"));
		} catch (IOException e) {
			System.out.println("Could not find 'battle.png'");
		}
		try {
			pokemon = ImageIO.read(new File("images" + File.separator
					+ "pokemon.png"));

		} catch (IOException e) {
			System.out.println("Could not find 'pokemon.png'");
		}
	}

	private void initBattleText() {
		battlePokemonText = new JTextArea(this.theBattle.battlePokemonToString());
		battlePokemonText.setSize(100, 100);
		battlePokemonText.setLocation(100, 50);
		this.add(battlePokemonText);
		
		myPokemonText = new JTextArea(this.theBattle.choosenPokemonToString());
		myPokemonText.setSize(100, 100);
		myPokemonText.setLocation(600, 300);
		this.add(myPokemonText);
		
	}

	private void initButtons() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 2));
		buttonPanel.setSize(400, 100);
		buttonPanel.setLocation(350, 400);

		rockButton = new JButton("ROCK");
		ButtonListener fightListener = new ButtonListener();
		rockButton.addActionListener(fightListener);

		baitButton = new JButton("BAIT");
		ButtonListener baitListener = new ButtonListener();
		baitButton.addActionListener(baitListener);

		runButton = new JButton("RUN");
		ButtonListener runListener = new ButtonListener();
		runButton.addActionListener(runListener);

		pokeballButton = new JButton("POKEBALL");
		ButtonListener pokeballListener = new ButtonListener();
		pokeballButton.addActionListener(pokeballListener);

		buttonPanel.add(rockButton);
		buttonPanel.add(baitButton);
		buttonPanel.add(runButton);
		buttonPanel.add(pokeballButton);

		this.add(buttonPanel);

		messageText = new JTextArea("What will " + this.theBattle.getMyPokemon().getName() + " do?");
		messageText.setLocation(100, 425);
		messageText.setSize(200, 50);
		this.add(messageText);
	}

	private void initTextView() {
		setSize(750, 500);
		setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		battlePokemonText = new JTextArea(this.theBattle.battlePokemonToString());
		myPokemonText = new JTextArea(this.theBattle.choosenPokemonToString());
		this.setFocusable(true);
	}

	public void update() {
		battlePokemonText.setText(this.theBattle.battlePokemonToString());
		myPokemonText.setText(this.theBattle.choosenPokemonToString());
		if(this.theBattle.battleOver()){
			this.setVisible(false);
		}
		repaint();
		revalidate();
	}

	private class ButtonListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton buttonClicked = (JButton) arg0.getSource();
			if (buttonClicked.getText().equals("ROCK")) {
				theBattle.throwRock();
			} else if (buttonClicked.getText().equals("BAIT")) {
				theBattle.throwBait();
			} else if (buttonClicked.getText().equals("RUN")) {
				theBattle.runAway();
			} else if (buttonClicked.getText().equals("POKEBALL")) {
				theBattle.throwPokeball();
			}
			update();
		}
	}
}