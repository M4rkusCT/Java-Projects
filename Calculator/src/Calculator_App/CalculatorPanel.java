package Calculator_App;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorPanel extends JPanel {

	private JButton screen;
	private JPanel buttonsPanel;
	private boolean firstValue = true;
	private Double result;
	private String lastOperation;
	
	// Constructor
	public CalculatorPanel() {
		
		setLayout(new BorderLayout());
		
		lastOperation = "=";
		
		// ----------------------------
		
		// The Calculator screen
		
		screen = new JButton("0");
		
		screen.setEnabled(false);
		
		add(screen, BorderLayout.NORTH);
		
		// -----------------------------
		
		// The Calculator buttons
		
		buttonsPanel = new JPanel();
		
		buttonsPanel.setLayout(new GridLayout(4, 4));
		
		Numbers insertNumber = new Numbers();
		
		Operations insertOperations = new Operations();
		
		buttons("7", insertNumber);
		
		buttons("8", insertNumber);
		
		buttons("9", insertNumber);
		
		buttons("/", insertOperations);

		buttons("4", insertNumber);
		
		buttons("5", insertNumber);
		
		buttons("6", insertNumber);
		
		buttons("*", insertOperations);
		
		buttons("1", insertNumber);
		
		buttons("2", insertNumber);
		
		buttons("3", insertNumber);
		
		buttons("-", insertOperations);
		
		buttons(".", insertNumber);
		
		buttons("0", insertNumber);
		
		buttons("=", insertOperations);
		
		buttons("+", insertOperations);
		
		add(buttonsPanel);
	}
	
	// Setters
	public void buttons(String num, ActionListener listener) {
		
		// To create the buttons
		
		JButton newButton = new JButton(num);
		
		newButton.addActionListener(listener);
		
		buttonsPanel.add(newButton);
	}
	
	// Inner Class
	private class Numbers implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			// To add the numbers on the screen
			
			if(e.getActionCommand() != "." && firstValue || !firstValue) {
				if(firstValue && Integer.parseInt(e.getActionCommand()) != 0 && e.getActionCommand() != ".") {
					
					firstValue = false;
					
					screen.setText("" + e.getActionCommand());
				}
				else if(Double.parseDouble(screen.getText()) != 0) screen.setText(screen.getText() + e.getActionCommand());
			}
			
		}
		
	}
	
	private class Operations implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			calculate(Double.parseDouble(screen.getText()));
			
			lastOperation = e.getActionCommand();
			
			firstValue = true;
			
		}
		
		// Setters
		public void calculate(Double num) {
			
			// To calculate numbers using the last selected operation
			
			if(lastOperation.equals("+")) result += num;
			else if(lastOperation.equals("-")) result -= num;
			else if(lastOperation.equals("*")) result *= num;
			else if(lastOperation.equals("/")) result /= num;
			else result = num;
			
			screen.setText("" + result);
		}
	}
}
