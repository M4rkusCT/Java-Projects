package Password_Generator_App;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Password_GeneratorPanel extends JPanel {

	private JButton password;
	private JPanel checkBoxPanel;
	private JSpinner mySpinner;
	private JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
	
	// Constructor
	public Password_GeneratorPanel() {
		
		setLayout(new BorderLayout());
		
		// -------------------------------
		
		// The screen to display the generated password. 
		
		password = new JButton("New Password");
		
		password.setEnabled(false);
		
		add(password, BorderLayout.NORTH);
		
		// -------------------------------
		
		// The checkboxes to create the passwords.
		
		checkBoxPanel = new JPanel();
		
		//checkBoxPanel.setLayout(new GridLayout(4,4));
		
		JLabel tag = new JLabel("Password length");
		
		mySpinner = new JSpinner(new SpinnerNumberModel(8, 8, 30, 1));
		
		Dimension dim = new Dimension(40, 20);
		
		mySpinner.setPreferredSize(dim);
		
		checkBox1 = new JCheckBox("Uppercase letters");
		
		checkBox2 = new JCheckBox("Lowercase letters");
		
		checkBox3 = new JCheckBox("Numbers");
		
		checkBox4 = new JCheckBox("Special characters");
		
		checkBoxPanel.add(checkBox1);
		
		checkBoxPanel.add(checkBox2);
		
		checkBoxPanel.add(checkBox3);
		
		checkBoxPanel.add(checkBox4);
		
		checkBoxPanel.add(tag);
		
		checkBoxPanel.add(mySpinner);
		
		add(checkBoxPanel, BorderLayout.CENTER);
		
		// -------------------------------
		
		// The button to generate the new password.
		
		JButton generator = new JButton("Generate");
		
		generator.addActionListener(new GeneratorPassword());
		
		add(generator, BorderLayout.SOUTH);
		
	}
	
	// Inner Class
	private class GeneratorPassword implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String characters = "";
			
			String newPassword = "";
			
			String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
			
			String upperCaseLetters = "ABCDEFGHIJKLMNOPQSRTUVWXYZ";

			String numbers = "0123456789";

			String specialCharacters = "~!@#$%^&*()_+=|";
			
			int length = (int) mySpinner.getValue();
			
			for(int i = 0;i < length;i++) {

				if(checkBox1.isSelected()) {
					
					int num = (int) (Math.random() * upperCaseLetters.length());
					
					characters += upperCaseLetters.charAt(num);
				}
				if(checkBox2.isSelected()) {
					
					int num = (int) (Math.random() * lowerCaseLetters.length());
					
					characters += lowerCaseLetters.charAt(num);
				}
				if(checkBox3.isSelected()) characters += (int) (Math.random() * numbers.length());
				if(checkBox4.isSelected()) {
					
					int num = (int) (Math.random() * specialCharacters.length());
					
					characters += specialCharacters.charAt(num);
				}
			}
			
			for(int i = 0;i < length;i++) {
				
				int num = (int) (Math.random() * characters.length());
				
				newPassword += characters.charAt(num);
			}
			
			password.setText(newPassword);
		}
		
	}
}
