package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.*;
import view.*;

public class GraphicViewMapTwo extends JPanel implements Observer {
	private PokemonMap map;
	private PokemonGame theGame;
	private BufferedImage fire;
	private BufferedImage water;
	private BufferedImage emptyGround;
	private BufferedImage grass;
	private BufferedImage trainer;
	private BufferedImage tree;


	public GraphicViewMapTwo(PokemonGame game) {
		try {
		fire = ImageIO.read(new File("images/fire.png"));
		water = ImageIO.read(new File("images/water.png"));
		emptyGround = ImageIO.read(new File("images/emptyGround.png"));
		grass = ImageIO.read(new File("images/grass.png"));
		trainer = ImageIO.read(new File("images/trainer.png"));
		tree = ImageIO.read(new File("images/tree.png"));

		}
		catch(IOException e) {
		e.printStackTrace();

		}
		this.theGame = game;
		initJPanel();

		}
	
	private void initJPanel() {
		setLayout(null);
		setSize(750, 750);
		setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		this.addKeyListener(new MovementListener(theGame));

		
	}
	
	public void paintComponent(Graphics g) {
		for(int i = 0; i < 23 ; i++) {
			for(int j = 0; j < 23; j++) {
				Tile curTile = theGame.getMap().getTile(i, j);
				if(curTile.toString().equals("g")){
					g.drawImage(grass, j * 32, i * 32, null);
				}
				if(curTile.toString().equals("f")){
					g.drawImage(fire, j * 32, i * 32, null);
				}
				if(curTile.toString().equals("e")){
					g.drawImage(emptyGround, j * 32, i * 32, null);
				}
				if(curTile.toString().equals("t")){
					g.drawImage(tree, j * 32, i * 32, null);
				}
				if(curTile.toString().equals("w")){
					g.drawImage(water, j * 32, i * 32, null);
				}
				if(curTile.getHasTrainer()){
					g.drawImage(trainer,j * 32, i * 32, null);
				}
				if(curTile.getHasPokemon()){
					g.drawImage(grass, j * 32, i * 32, null);
				}

				
			}
				
		}

			
	}


	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
		revalidate();
	}

}
