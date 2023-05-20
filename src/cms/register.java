package cms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.w3c.dom.events.EventTarget;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class register {

	private JFrame frame;
	private JTextField textField;
	private JTextField dobtext;
	private JTextField textField_3;
	private String passwordString;
	private String confirmpasswordString;
	private ButtonGroup buttonGroup;
	private final JPasswordField passwordField = new JPasswordField();
	private JPasswordField confirmpasswordField;
	
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 592, 559);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Signup panel");
		lblNewLabel.setBounds(155, 38, 256, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		name.setBounds(143, 114, 83, 27);
		panel.add(name);
		
		JLabel emaiLabel = new JLabel("Email:");
		emaiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		emaiLabel.setBounds(143, 152, 83, 27);
		panel.add(emaiLabel);
		
		JLabel lblUsername_1_1_1 = new JLabel("DOB:");
		lblUsername_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsername_1_1_1.setBounds(144, 189, 83, 27);
		panel.add(lblUsername_1_1_1);
		
		JLabel lblUsername_1_1_1_1 = new JLabel("Phone Number:");
		lblUsername_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsername_1_1_1_1.setBounds(73, 226, 128, 27);
		panel.add(lblUsername_1_1_1_1);
		
		JLabel lblUsername_1_1_2 = new JLabel("Password:");
		lblUsername_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsername_1_1_2.setBounds(114, 263, 83, 27);
		panel.add(lblUsername_1_1_2);
		
		JLabel lblUsername_1_1_2_1 = new JLabel("Confirm Password:");
		lblUsername_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsername_1_1_2_1.setBounds(52, 298, 145, 27);
		panel.add(lblUsername_1_1_2_1);
		
		JRadioButton maleButton = new JRadioButton("Male");
		maleButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		maleButton.setBounds(61, 341, 103, 21);
		panel.add(maleButton);
		
		JRadioButton femaleButton = new JRadioButton("Female");
		femaleButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		femaleButton.setBounds(204, 341, 103, 21);
		panel.add(femaleButton);
		
		JRadioButton otherButton = new JRadioButton("Others");
		otherButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		otherButton.setBounds(352, 341, 103, 21);
		panel.add(otherButton);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(maleButton);
		buttonGroup.add(femaleButton);
		buttonGroup.add(otherButton);
		
		JComboBox courseBox = new JComboBox();
		courseBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		courseBox.setEditable(true);
		courseBox.setBounds(155, 421, 215, 25);
		panel.add(courseBox);
		
		JComboBox usersCombo_1 = new JComboBox();
		usersCombo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usersCombo_1.getSelectedItem().toString()=="Student") {
					courseBox.setVisible(true);
				}
			}
		});
		usersCombo_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		usersCombo_1.setEditable(true);
		usersCombo_1.setBounds(155, 386, 215, 25);
		panel.add(usersCombo_1);
		
		usersCombo_1.addItem("Admin");
		usersCombo_1.addItem("Tutor");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if((Character.isLetter(c)) || (c==KeyEvent.VK_SPACE) || (c==KeyEvent.VK_BACK_SPACE)) {
					textField.setEditable(true);
				} else {
					textField.setEditable(false);
				}
				
			}
		});
		textField.setColumns(10);
		textField.setBounds(236, 114, 310, 25);
		panel.add(textField);
		
		JTextField emailtext = new JTextField();
		emailtext.setColumns(10);
		emailtext.setBounds(236, 155, 310, 25);
		panel.add(emailtext);
		
		dobtext = new JTextField();
		dobtext.setColumns(10); 
		dobtext.setBounds(236, 192, 310, 25);
		panel.add(dobtext);
		
		textField_3 = new JTextField();
		
		
		
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//action when key is pressed
				
				char c = e.getKeyChar();
				
				int length = textField_3.getText().length();
				
				if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)) {
					if(length <= 10) {
						textField_3.setEditable(true);
					}
				} else {
					textField_3.setEditable(false);
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(236, 229, 310, 25);
		panel.add(textField_3);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// establishes connection with database
				
				MyConnection connection = new MyConnection();
				
				// object for performing database actions
				DatabaseCreation createCreation = new DatabaseCreation(connection.getConnection());
				
				// provide us which gender is selected
				SelectfromButtonGroup select = new SelectfromButtonGroup(buttonGroup);
				
				// validates email
				EmailValidation emailValidation = new EmailValidation(emailtext.getText());
				
				
				//inputs
				passwordString = new String(passwordField.getPassword());
				
				confirmpasswordString = new String(confirmpasswordField.getPassword());
				
				String tablenameString = usersCombo_1.getSelectedItem().toString();
				
				try {
					
					
					
					// check if all the fields are empty or not
					Boolean conditionBoolean = (emailtext.getText().equals("")) || (textField_3.getText().equals("")) || 
							(passwordString.equals("")) || (confirmpasswordString.equals("")) 
							|| (textField.getText().equals("")) || (dobtext.getText().equals(""))
							|| (select.getSelectedButtonText().equals("")) || (usersCombo_1.getSelectedItem().toString()=="Select User Mode");
					
				
								
	
					if(emailValidation.checkEmail()!=1 ) {
						JOptionPane.showMessageDialog(frame, "Invalid Email ID....");
						
					} else if(textField_3.getText().length()!=10){
						JOptionPane.showMessageDialog(frame, "Enter 10 digits in phone number.");
					} 
					else if(!passwordString.equals(confirmpasswordString)) {
						
						JOptionPane.showMessageDialog(frame, "Different Passwords");
						
					} else if(conditionBoolean==false) {
						if(createCreation.tableExist(tablenameString)!=1) {
							createCreation.databaseCreation(tablenameString);
						} 
						
						
						
						createCreation.insertDataRegister(textField.getText(),emailtext.getText(),dobtext.getText(), textField_3.getText(), passwordString, 
								select.getSelectedButtonText(), tablenameString, courseBox.getSelectedItem().toString());
						JOptionPane.showMessageDialog(frame, "Created account Go to login page");
					} else {
						JOptionPane.showMessageDialog(frame, "Empty Fields");
					}
					
				} catch (NullPointerException e1) {
					createCreation.insertDataRegister(textField.getText(),emailtext.getText(),dobtext.getText(), textField_3.getText(), passwordString, 
							select.getSelectedButtonText(), tablenameString, "");
					JOptionPane.showMessageDialog(frame, "Created account Go to login page");
				}	catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(55, 466, 125, 46);
		panel.add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login log = new Login();
				log.getFrame().setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogin.setBackground(SystemColor.menu);
		btnLogin.setBounds(374, 466, 125, 46);
		panel.add(btnLogin);
		passwordField.setBounds(236, 263, 310, 27);
		panel.add(passwordField);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(236, 298, 310, 27);
		panel.add(confirmpasswordField);
		
		
		// adds course in jumbobox
		try {

			MyConnection con = new MyConnection();
			
			Statement stmt = con.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select course from level_4");
			
			while(rs.next()) {
				courseBox.addItem(rs.getString("course"));
				usersCombo_1.addItem("Student");
			}
		} catch (SQLSyntaxErrorException e) {
			JOptionPane.showMessageDialog(frame, "Not ready for students.");
			courseBox.setVisible(false);
			usersCombo_1.removeItem("Student");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		courseBox.setVisible(false);
	}
}
