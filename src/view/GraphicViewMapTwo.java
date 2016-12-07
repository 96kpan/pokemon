package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
import javax.swing.JPanel;
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
	private static final int max = 32;
	
	private int xcoor = 1*32;
	private int ycoor = 9*32;
	private int dir = 0;

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
		
		
		frames = new LinkedList<Frames>();

		timer = new Timer(4, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Iterator<Frames> it = frames.iterator();
				while (it.hasNext()) {
					Frames frame = it.next();
					if(frame.getX() > 32 || frame.getY() > 32 || frame.getX() < -32 || frame.getY() < -32) {
						it.remove();
					}
					else {
						if(Trainer.getInstance().getDir() == Direction.North)
							frame.decY();
						if(Trainer.getInstance().getDir() == Direction.South)
							frame.incY();
						if(Trainer.getInstance().getDir() == Direction.East)
							frame.incX();
						if(Trainer.getInstance().getDir() == Direction.West)
							frame.decX();
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
            	for (int x = 0; x < 4; x++) {
					BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, dir * 32, 32,
							32);
					Frames f = new Frames(temp, xcoor, ycoor);
					frames.add(f);
				}
            }
        });
        
        inputMap.put(KeyStroke.getKeyStroke("UP"), "up");
        getActionMap().put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for (int x = 0; x < 4; x++) {
					BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, 1 * 32, 32,
							32);
					Frames f = new Frames(temp, xcoor, ycoor);
					frames.add(f);
				}
            }
        });
        
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "down");
        getActionMap().put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for (int x = 0; x < 4; x++) {
					BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, 0 * 32, 32,
							32);
					Frames f = new Frames(temp, xcoor, ycoor);
					frames.add(f);
				}
            }
        });
        
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "LEFT");
        getActionMap().put("LEFT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for (int x = 0; x < 4; x++) {
					BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, 3 * 32, 32,
							32);
					Frames f = new Frames(temp, xcoor, ycoor);
					frames.add(f);
				}
            }
        });
        
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT");
        getActionMap().put("RIGHT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for (int x = 0; x < 4; x++) {
					BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, 2 * 32, 32,
							32);
					Frames f = new Frames(temp, xcoor, ycoor);
					frames.add(f);
				}
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
			g.drawImage(frame, x + j, y + i, 32, 32, null);
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

		this.myPokemons = new JTextArea(theGame.trainer.getName() + "'s Pokemons");
		myPokemons.setLocation(750, 200);
		myPokemons.setSize(190, 25);
		this.add(myPokemons);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// System.out.println(theGame.trainer.getPokemons().size());

		for (int i = 0; i < theGame.trainer.getPokemons().size(); i++) {
			g.drawImage(theGame.trainer.getPokemons().get(i).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH),
					770, 250 + (50 * i), null);

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
					}
					else {
						xcoor = j*32;
						ycoor = i*32;
						
						if (Trainer.getInstance().getDir() == Direction.North) {
							dir = 1;
							
//							for (int x = 0; x < 4; x++) {
//								BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, 1 * 32, 32,
//										32);
//								Frames f = new Frames(temp, j * 32, i * 32);
//								frames.add(f);
//							}
						} else if (Trainer.getInstance().getDir() == Direction.South) {
							dir = 0;
							
//							for (int x = 0; x < 4; x++) {
//								BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, 0 * 32, 32,
//										32);
//								Frames f = new Frames(temp, j * 32, i * 32);
//								frames.add(f);
//							}
						} else if (Trainer.getInstance().getDir() == Direction.East) {
							dir = 2;
							
//							for (int x = 0; x < 4; x++) {
//								BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, 2 * 32, 32,
//										32);
//								Frames f = new Frames(temp, j * 32, i * 32);
//								frames.add(f);
//							}
						} else if (Trainer.getInstance().getDir() == Direction.West) {
							dir = 3;
							
//							for (int x = 0; x < 4; x++) {
//								BufferedImage temp = Trainer.getInstance().getSheet().getSubimage(x * 32, 3 * 32, 32,
//										32);
//								Frames f = new Frames(temp, j * 32, i * 32);
//								frames.add(f);
//							}
						}
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
		this.repaint();
		revalidate();
	}
}
