package Rock_Paper_Scissors_Game;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class Rock_Paper_Scissors_GamePanel extends JPanel {

	private JButton points_player, points_comp, restart;
	private JPanel buttonsPanel;
	private JLabel message;
	
	// Constructor
	public Rock_Paper_Scissors_GamePanel() {
		
		setLayout(new BorderLayout());
		
		// ---------------------------------------------
		
		JPanel score = new JPanel();
		
		// ---------------------------------------------
		
		JLabel player = new JLabel("Player: ");
		
		score.add(player);
		
		points_player = new JButton("0");
		
		points_player.setEnabled(false);
		
		score.add(points_player);
		
		// ---------------------------------------------
		
		JLabel comp = new JLabel("Comp: ");
		
		score.add(comp);
		
		points_comp = new JButton("0");
		
		points_comp.setEnabled(false);
		
		score.add(points_comp);
		
		// ---------------------------------------------
		
		// This part creates a button that resets the points.
		
		restart = new JButton("Restart");
		
		// Inner Class Anonymous
		restart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				points_player.setText("0");
				
				points_comp.setText("0");
			}
		});
		
		score.add(restart);
		
		add(score, BorderLayout.NORTH);
		
		// ---------------------------------------------
		
		// This part shows a message from who won. 
		
		message = new JLabel("", JLabel.CENTER);
		
		add(message);
		
		// ---------------------------------------------
		
		buttonsPanel = new JPanel();
		
		buttons("Rock", "rockIcon.png");
		
		buttons("Paper", "paperIcon.png");
		
		buttons("Scissors", "scissorsIcon.png");
		
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	// Setter
	public void buttons(String name, String icon) {
		
		// This setter generates the buttons with a name and an icon that the player will play.
		
		URL button_path = Rock_Paper_Scissors_GamePanel.class.getResource(icon);
		
		JButton button = new JButton(name, new ImageIcon(button_path));
		
		button.addActionListener(new Game());
		
		buttonsPanel.add(button);
	}
	
	// Inner Class
	private class Game implements ActionListener {

		private String tools[] = {"Rock", "Papel", "Scissors"};
		private String comp_tool = "";
		
		// Interface ActionListener
		public void actionPerformed(ActionEvent e) {
			
			// This actionPerformed is where the game takes place.
			
			String player = e.getActionCommand();
			
			int pos = (int) (Math.random()*3);
			
			comp_tool = tools[pos];
			
			// These conditionals are to know who won and thus call the result function.
			if(player == "Paper" && comp_tool == "Rock" || player == "Scissors" && comp_tool == "Paper" || player == "Rock" && comp_tool == "Scissors") result(1);
			else if(player == "Rock" && comp_tool == "Paper" || player == "Paper" && comp_tool == "Scissors" || player == "Scissors" && comp_tool == "Rock") result(2);
			else result(3);
		}
		
		
		// Setter
		public void result(int num) {
			
			// This setter is responsible for increasing player and comp points and showing a message.
			
			if(num == 1) {
				
				points_player.setText("" + (Integer.parseInt(points_player.getText()) + 1));
				
				message.setText("You Win");
			}
			else if(num == 2) {
				
				points_comp.setText("" + (Integer.parseInt(points_comp.getText()) + 1));
				
				message.setText("Comp Win");
			}
			else {
				
				message.setText("Tie");
			}
		}
	}
}
