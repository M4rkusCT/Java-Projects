package Rock_Paper_Scissors_Game;

import javax.swing.*;

public class Rock_Paper_Scissors_GameFrame extends JFrame{

	// Constructor
	public Rock_Paper_Scissors_GameFrame() {
		
		// To create the frame of the app.
		
		setBounds(500, 200, 350, 300);
		
		setResizable(false);
		
		setTitle("Rock Paper Scissors Game");
		
		add(new Rock_Paper_Scissors_GamePanel());
		
		setVisible(true);
	}
}
