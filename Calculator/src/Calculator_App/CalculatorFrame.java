package Calculator_App;

import javax.swing.*;

public class CalculatorFrame extends JFrame {

	// Constructor
	public CalculatorFrame() {
		
		setBounds(500, 300, 300, 300);
		
		setTitle("Calculator");
		
		add(new CalculatorPanel());
		
		setVisible(true);
	}
}