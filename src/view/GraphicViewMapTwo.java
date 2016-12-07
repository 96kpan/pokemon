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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import model.*;
import pokemons.Garchomp;
import javax.swing.Timer;

public class GraphicViewMapTwo extends JPanel implements Observer {
	private PokemonMap map;
	private PokemonGame theGame;
	private JTextArea messageText;
	private JTextArea myPokemons;
	private JTextArea itemCounts;
	private transient BufferedImage fire;
	private transient BufferedImage water;
	private transient BufferedImage emptyGround;
	private transient BufferedImage grass;
	private transient BufferedImage tree;
	private Timer timer;
	private BufferedImage terrain_sheet;
	private final int size = 32;
	private BufferedImage tile;
	private boolean begin = true;

	private int xcoor = 1 * 32;
	private int ycoor = 9 * 32;
	private int index = 0;

	private BufferedImage[] trainer_front;
	private BufferedImage[] trainer_back;
	private BufferedImage[] trainer_left;
	private BufferedImage[] trainer_right;

	private static final int DELAY_IN_MS = 0;

	private Iterator<Frames> it;

	private List<Frames> frames;

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

		trainer_front = new BufferedImage[4];
		trainer_back = new BufferedImage[4];
		trainer_left = new BufferedImage[4];
		trainer_right = new BufferedImage[4];
		BufferedImage img;

		for (int x = 0; x < 4; x++) {
			img = Trainer.getInstance().getSheet().getSubimage(x * 32, 0 * 32, 32, 32);
			trainer_back[x] = img;
			img = Trainer.getInstance().getSheet().getSubimage(x * 32, 1 * 32, 32, 32);
			trainer_front[x] = img;
			img = Trainer.getInstance().getSheet().getSubimage(x * 32, 2 * 32, 32, 32);
			trainer_right[x] = img;
			img = Trainer.getInstance().getSheet().getSubimage(x * 32, 3 * 32, 32, 32);
			trainer_left[x] = img;
		}

		frames = new LinkedList<Frames>();

		timer = new Timer(DELAY_IN_MS, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				it = frames.iterator();
				while (it.hasNext()) {
					System.out.println(it.hasNext());
					Frames frame = it.next();
					if (frame.getX() > 32 || frame.getY() > 32 || frame.getX() < -32 || frame.getY() < -32) {
						it.remove();
					} else {
						if (Trainer.getInstance().getDir() == Direction.North) {
							if (index > 3) {
								index = 0;
							}
							frame.decY();
							frame.setImg(trainer_front[index]);
							index++;
						}
						if (Trainer.getInstance().getDir() == Direction.South) {
							if (index > 3) {
								index = 0;
							}
							frame.incY();
							frame.setImg(trainer_back[index]);
							index++;
						}
						if (Trainer.getInstance().getDir() == Direction.East) {
							if (index > 3) {
								index = 0;
							}
							frame.incX();
							frame.setImg(trainer_right[index]);
							index++;
						}
						if (Trainer.getInstance().getDir() == Direction.West) {
							if (index > 3) {
								index = 0;
							}
							frame.decX();
							frame.setImg(trainer_left[index]);
							index++;
						}
						repaint();

					}
				}
			}
		});
		timer.start();

		this.theGame = game;
		initJPanel();

		InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke("UP"), "up");
		getActionMap().put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index > 3)
					index = 0;
				Frames f = new Frames(trainer_front[index], xcoor, ycoor-32);
				frames.add(f);
			}
		});

		inputMap.put(KeyStroke.getKeyStroke("DOWN"), "down");
		getActionMap().put("down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index > 3)
					index = 0;
				Frames f = new Frames(trainer_back[index], xcoor, ycoor+32);
				frames.add(f);
			}
		});

		inputMap.put(KeyStroke.getKeyStroke("LEFT"), "LEFT");
		getActionMap().put("LEFT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index > 3)
					index = 0;
				Frames f = new Frames(trainer_left[index], xcoor-32, ycoor);
				frames.add(f);
			}
		});

		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT");
		getActionMap().put("RIGHT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index > 3)
					index = 0;
				Frames f = new Frames(trainer_right[index], xcoor+32, ycoor);
				frames.add(f);
			}
		});
	}

	private class Frames {
		private Image frame;
		private int x;
		private int y;
		private int j;
		private int i;

		public Frames(Image image, int j, int i) {
			frame = image;
			x = 0;
			y = 0;
			this.j = j;
			this.i = i;
		}

		public void drawFrame(Graphics g) {
			g.drawImage(frame, j, i, 32, 32, null);
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public void incX() {
			x++;
		}

		public void incY() {
			y++;
		}

		public void decX() {
			x--;
		}

		public void decY() {
			y--;
		}

		public void setImg(Image i) {
			frame = i;
		}
	}

	private void initJPanel() {
		setLayout(null);
		setSize(1000, 1000);
		setLocation(0, 0);
		// this.setBackground(Color.WHITE);
		this.setFocusable(true);
		this.addKeyListener(new MovementListener(theGame));

		messageText = new JTextArea("No of Steps taken 500");
		messageText.setLocation(750, 100);
		messageText.setSize(150, 25);
		this.add(messageText);

		this.myPokemons = new JTextArea(theGame.trainer.getName() + "'s Pokemon");
		myPokemons.setLocation(750, 200);
		myPokemons.setSize(190, 25);
		this.add(myPokemons);


		this.itemCounts = new JTextArea("Backpack: \n" + theGame.trainer.getBackpack().toString());
		itemCounts.setLocation(750, 300);
		itemCounts.setSize(200, 200);
		this.add(itemCounts);

		JButton healthpotButton = new JButton("Add Health");
		healthpotButton.setLocation(750, 550);
		healthpotButton.setSize(190, 25);
		ButtonListener hpListener = new ButtonListener();
		healthpotButton.addActionListener(hpListener);
		healthpotButton.setVisible(true);
		this.add(healthpotButton);

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
					if (begin) {
						g.drawImage(Trainer.getInstance().getImage(), j * 32, i * 32, null);
						begin = false;
					} else {
						xcoor = j * 32;
						ycoor = i * 32;
						for (Frames f : frames) {
							f.drawFrame(g);
						}
					}
				}
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		this.messageText.setText(theGame.toStringNoOfSteps());
		System.out.println();
		System.out.println("HEREREEEEE" + theGame.trainer.getBackpack().toString());
		System.out.println();
		this.itemCounts.setText("Backpack: \n" + theGame.trainer.getBackpack().toString());
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

				JRadioButton[] rb = new JRadioButton[theGame.trainer.getPokemons().size()];
				JPanel p = new JPanel(new GridLayout(3, 5));
				for (int x = 0; x < theGame.trainer.getPokemons().size(); x++) {
					rb[x] = new JRadioButton("" + theGame.trainer.getPokemons().get(x).getName());
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
}
