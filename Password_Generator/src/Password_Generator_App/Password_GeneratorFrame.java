package Password_Generator_App;

import javax.swing.*;

public class Password_GeneratorFrame extends JFrame {

	// Constructor
	public Password_GeneratorFrame() {
		
		// To create the frame of the app.
		
		setBounds(500, 200, 300, 300);
		
		setTitle("Password Generator");
		
		add(new Password_GeneratorPanel());
		
		setVisible(true);
	}
}
