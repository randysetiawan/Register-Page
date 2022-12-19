import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main implements ActionListener{
	JFrame frame = new JFrame("Register Page");
	JPanel panel = new JPanel(new GridLayout(6, 2));
	JPanel genderPanel = new JPanel(new GridLayout(1,1));
	JPanel emptyPanel = new JPanel();
	JLabel usernameLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	JLabel confirmPasswordLabel = new JLabel("Confirm Password");
	JLabel genderLabel = new JLabel("Gender");
	JLabel countryLabel = new JLabel("Country");
	JTextField usernameTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();
	JRadioButton maleRadioButton = new JRadioButton("Male");
	JRadioButton femaleRadioButton = new JRadioButton("Female");
	ButtonGroup genderButtonGroup = new ButtonGroup();
	String[] countryList = {"Indonesia", "Malaysia", "Singapore", "Laos", "Kamboja"};
	JComboBox<String> countryComboBox = new JComboBox<>(countryList);
	JButton registerButton = new JButton("Register");

	public Main() {
		panel.add(usernameLabel);
		panel.add(usernameTextField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(confirmPasswordLabel);
		panel.add(confirmPasswordField);
		panel.add(genderLabel);
		genderButtonGroup.add(maleRadioButton);
		genderButtonGroup.add(femaleRadioButton);
		genderPanel.add(maleRadioButton);
		genderPanel.add(femaleRadioButton);
		panel.add(genderPanel);
		panel.add(countryLabel);
		countryComboBox.setEditable(false);
		panel.add(countryComboBox);
		panel.add(emptyPanel);
		registerButton.addActionListener(this);
		panel.add(registerButton);
		frame.add(panel);
		initializeFrame();
	}
	
	public void initializeFrame() {
		frame.setTitle("Register Page");
		frame.setSize(350, 175);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registerButton) {
			if(usernameTextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Input Username!", "Warning", JOptionPane.WARNING_MESSAGE);
			} else if(passwordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Input Password!.", "Warning", JOptionPane.WARNING_MESSAGE);
			} else if(confirmPasswordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Input Confirmation Password!", "Warning", JOptionPane.WARNING_MESSAGE);
			} else if(!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()) {
				JOptionPane.showMessageDialog(frame, "Select Gender!", "Warning", JOptionPane.WARNING_MESSAGE);
			} else if(!passwordField.getText().equals(confirmPasswordField.getText())) {
				JOptionPane.showMessageDialog(frame, "Password and Confirmation Password Different!", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "Registration Successful", "Success", JOptionPane.DEFAULT_OPTION);
			}
		}
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
