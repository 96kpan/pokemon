package view;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;


import model.MapOne;
import model.PokemonGame;
import model.PokemonMap;


public class PokemonTextView extends JPanel implements Observer {
	private PokemonGame theGame;
	private JTextArea textArea;
	private JTextArea messageText;
	private JTextArea directions;

	public PokemonTextView(PokemonGame theGame)  {
		this.theGame = theGame;
		initTextView();
	}

	private void initTextView() {
		setUpJPanel();
		setUpTextArea();

	}

	private void setUpJPanel() {
		setLayout(null);
		setSize(750, 500);
		setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		this.addKeyListener(new MovementListener(theGame));

	}

	private void setUpTextArea() {
		textArea = new JTextArea(theGame.toString());
		add(textArea);
		textArea.setLocation(0, 0);
		textArea.setSize(1000, 1000);
		textArea.setFont(new Font("Courier", Font.BOLD, 18));
		textArea.setEditable(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		textArea.setText(theGame.toString());
		
		repaint();
		revalidate();
		
	}

	


}
