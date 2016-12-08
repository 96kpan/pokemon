package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import model.Battle;
import model.PokemonGame;
//import model.PokemonBattle;
import model.Trainer;
import model.TrainerBattle;

public class BattleView extends JPanel {
	private JTextArea battlePokemonText;
	private JTextArea battlePokemonHP;
	private JTextArea chosenPokemonHP;
	private JTextArea myPokemonText;
	private JTextArea messageText;
	private JButton rockButton;
	private JButton baitButton;
	private JButton runButton;
	private JButton pokeballButton;
	// private JButton strengthenButton;
	private Battle theBattle;
	private boolean begin = true;
	private boolean toggle = true;

	private Image background;
	private Image pokemon;
	private BufferedImage ball;
	private BufferedImage rock;
	private Font font;
	private PokemonGame theGame;

	private List<Throwables> th;
	private List<Enemy> p;

	public BattleView(Battle battle) {

		try {
			font = Font.createFont(Font.TRUETYPE_FONT,
					new FileInputStream("fonts" + File.separator + "Pokemon GB.ttf"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		font = font.deriveFont(18F);

		loadImages();

		th = new LinkedList<Throwables>();
		p = new LinkedList<Enemy>();

		this.theBattle = battle;
		initButtons();
		initTextView();
		initBattleText();
		theGame = PokemonGame.getInstance();

		Timer timer = new Timer(40, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Iterator<Throwables> it = th.iterator();
				while (it.hasNext()) {
					Throwables t = it.next();
					if (t.x > 550) {
						it.remove();
					} else {
						t.x += 10;
						t.y -= 3;
						repaint();
					}
				}
			}
		});
		
		Timer timer2 = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Iterator<Enemy> it2 = p.iterator();

				while (it2.hasNext()) {
					Enemy n = it2.next();
					if (n.x > 510) {
						it2.remove();
					} else {
						n.x += 5;
						n.y -= 2;
						repaint();
					}
				}

			}
		});
		
		timer.start();
		timer2.start();

	}

	private class Throwables {
		Image img;
		int x = 200;
		int y = 225;

		public Throwables(Image image) {
			img = image;
		}

		public void drawThrowable(Graphics g) {
			Image scaledImage = img.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
			g.drawImage(scaledImage, x, y, null);
		}
	}

	private class Enemy {
		Image img;
		int x = 500;
		int y = 100;

		public Enemy(Image image) {
			img = image;
		}

		public void drawEnemy(Graphics g) {
			g.drawImage(img, x, y, null);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image scaledImage = background.getScaledInstance(750, 500, Image.SCALE_SMOOTH);
		g.drawImage(scaledImage, 0, 0, null);
		scaledImage = Trainer.getInstance().getBackOfTrainer().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
		g.drawImage(scaledImage, 150, 220, null);
		if (begin) {
			scaledImage = (theBattle).getRandomPokemon().getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
			g.drawImage(scaledImage, 500, 100, null);
			begin = false;
		}
		for (Throwables t : th) {
			t.drawThrowable(g);
		}
		for (Enemy n : p) {
			n.drawEnemy(g);
		}
		scaledImage = (theBattle).getRandomPokemon().getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
		g.drawImage(scaledImage, 500, 100, null);
	}

	private void loadImages() {
		try {
			background = ImageIO.read(new File("images" + File.separator + "battle.png"));
			pokemon = ImageIO.read(new File("images" + File.separator + "pokemon.png"));
			ball = ImageIO.read(new File("images/pokeball.png")).getSubimage(0, 32, 32, 32);
			rock = ImageIO.read(new File("images/rock.png")).getSubimage(0, 32, 32, 32);
		} catch (IOException e) {
			System.out.println("Could not find image");
		}
	}

	private void initBattleText() {
		battlePokemonText = new JTextArea(this.theBattle.getName());
		battlePokemonText.setSize(200, 30);
		battlePokemonText.setLocation(60, 65);
		battlePokemonText.setFont(font);
		this.add(battlePokemonText);

		battlePokemonHP = new JTextArea(this.theBattle.getHP());
		battlePokemonHP.setSize(150, 14);
		battlePokemonHP.setLocation(160, 101);
		this.add(battlePokemonHP);

		myPokemonText = new JTextArea(this.theBattle.chosenName());
		myPokemonText.setSize(200, 30);
		myPokemonText.setLocation(440, 250);
		myPokemonText.setFont(font);
		this.add(myPokemonText);

		chosenPokemonHP = new JTextArea(this.theBattle.chosenHP());
		chosenPokemonHP.setSize(150, 14);
		chosenPokemonHP.setLocation(540, 302);
		this.add(chosenPokemonHP);
	}

	private void initButtons() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 2));
		buttonPanel.setSize(380, 115);
		buttonPanel.setLocation(340, 365);

		rockButton = new JButton("ROCK");
		rockButton.setFont(font);
		ButtonListener fightListener = new ButtonListener();
		rockButton.addActionListener(fightListener);

		baitButton = new JButton("BAIT");
		baitButton.setFont(font);
		ButtonListener baitListener = new ButtonListener();
		baitButton.addActionListener(baitListener);

		runButton = new JButton("RUN");
		runButton.setFont(font);
		ButtonListener runListener = new ButtonListener();
		runButton.addActionListener(runListener);

		pokeballButton = new JButton("POKEBALL");
		pokeballButton.setFont(font);
		ButtonListener pokeballListener = new ButtonListener();
		pokeballButton.addActionListener(pokeballListener);

		// for pokemon battle only
		// strengthenButton = new JButton("STRENGTHEN");
		// strengthenButton.setFont(font);
		// ButtonListener strengthenListener = new ButtonListener();
		// strengthenButton.addActionListener(strengthenListener);

		buttonPanel.add(rockButton);
		buttonPanel.add(baitButton);
		buttonPanel.add(runButton);
		buttonPanel.add(pokeballButton);

		// buttonPanel.add(strengthenButton); //for pokemon battle only

		// buttonPanel.add(strengthenButton); //for pokemon battle only

		this.add(buttonPanel);

		messageText = new JTextArea("What will\n" + this.theBattle.getMyTrainer().getName() + " do?");
		messageText.setLocation(40, 400);
		messageText.setSize(400, 50);
		messageText.setFont(font);
		this.add(messageText);
	}

	private void initTextView() {
		setSize(750, 500);
		setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		battlePokemonText = new JTextArea(this.theBattle.battlePokemonToString());
		myPokemonText = new JTextArea(this.theBattle.myTrainerToString());
		this.setFocusable(true);
	}

	public void update() {
		battlePokemonHP.setText(this.theBattle.getHP());
		chosenPokemonHP.setText(this.theBattle.chosenHP());
		if (this.theBattle.battleOver()) {
			JOptionPane.showMessageDialog(null, "Battle over");
			this.setVisible(false);
		}
		repaint();
		revalidate();
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			JButton buttonClicked = (JButton) arg0.getSource();
			System.out.println(buttonClicked.getText());
			if (buttonClicked.getText().equals("ROCK")) {
				th.add(new Throwables(rock.getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
				p.add(new Enemy(
						(theBattle).getRandomPokemon().getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
				theBattle.attack();
				if (!theBattle.battleOver()) {
					JOptionPane.showMessageDialog(null, "You have weakened the pokemon");
				}
			} else if (buttonClicked.getText().equals("BAIT")) {
				theBattle.throwBait();
				// theGame.trainer.getBackOfTrainer()
				if (!theBattle.battleOver()) {
					JOptionPane.showMessageDialog(null, "The pokemon is lured in");
				}
			} else if (buttonClicked.getText().equals("RUN")) {
				System.out.println("In run view");
				theBattle.runAway();
				if (!theBattle.battleOver()) {
					JOptionPane.showMessageDialog(null, "Couldn't get away this time");
				} else {
					JOptionPane.showMessageDialog(null, "You got away");
				}
			} else if (buttonClicked.getText().equals("POKEBALL")) {
				th.add(new Throwables(ball.getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
				((TrainerBattle) theBattle).throwPokeball();

				if (!theBattle.battleOver()) {
					JOptionPane.showMessageDialog(null, "Thrwowing pokeball...... not this time!");
				}

				// } else if(buttonClicked.getText().equals("STRENGTHEN")){

			} // else if(buttonClicked.getText().equals("STRENGTHEN")){

			// ((PokemonBattle) theBattle).strengthen();
			// if(!theBattle.battleOver()){
			// JOptionPane.showMessageDialog(null, "Strengthen was not effective
			// enough");
			// }

			// }

			update();
		}
	}
}