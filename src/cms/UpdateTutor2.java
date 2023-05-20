package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateTutor2 {

	private JFrame frame;
	private JTextField moduleField1;
	private JTextField moduleField2;
	private JTextField moduleField3;
	private JTextField moduleField4;
	private JTextField tutorNameField;
	private JTextField emailField;
	private JTextField phoneNumberField;
	
	
	
	

	public JTextField getModuleField1() {
		return moduleField1;
	}

	public void setModuleField1(JTextField moduleField1) {
		this.moduleField1 = moduleField1;
	}

	public JTextField getModuleField2() {
		return moduleField2;
	}

	public void setModuleField2(JTextField moduleField2) {
		this.moduleField2 = moduleField2;
	}

	public JTextField getModuleField3() {
		return moduleField3;
	}

	public void setModuleField3(JTextField moduleField3) {
		this.moduleField3 = moduleField3;
	}

	public JTextField getModuleField4() {
		return moduleField4;
	}

	public void setModuleField4(JTextField moduleField4) {
		this.moduleField4 = moduleField4;
	}

	public JTextField getTutorNameField() {
		return tutorNameField;
	}

	public void setTutorNameField(JTextField tutorNameField) {
		this.tutorNameField = tutorNameField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JTextField getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(JTextField phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}

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
					UpdateTutor2 window = new UpdateTutor2();
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
	public UpdateTutor2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.setBounds(100, 100, 984, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel updateTutorLabel = new JLabel("Update Tutor");
		updateTutorLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		updateTutorLabel.setBounds(400, 103, 139, 26);
		frame.getContentPane().add(updateTutorLabel);
		
		JLabel tutorName = new JLabel("Tutor name:");
		tutorName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tutorName.setBounds(492, 182, 115, 26);
		frame.getContentPane().add(tutorName);
		
		JLabel module1 = new JLabel("Module1:");
		module1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		module1.setBounds(77, 182, 115, 26);
		frame.getContentPane().add(module1);
		
		
		
		JLabel module3 = new JLabel("Module3:");
		module3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		module3.setBounds(77, 288, 115, 26);
		frame.getContentPane().add(module3);
		
		
		JLabel module2 = new JLabel("Module2:");
		module2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		module2.setBounds(77, 235, 115, 26);
		frame.getContentPane().add(module2);
		
		JLabel module4 = new JLabel("Module4:");
		module4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		module4.setBounds(77, 343, 115, 26);
		frame.getContentPane().add(module4);
		
		JLabel emaillabel = new JLabel("Email:");
		emaillabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		emaillabel.setBounds(495, 235, 115, 26);
		frame.getContentPane().add(emaillabel);
		
		JLabel phonelabel = new JLabel("Phone Number:");
		phonelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		phonelabel.setBounds(492, 288, 139, 26);
		frame.getContentPane().add(phonelabel);
		
		JLabel partTimeLabel = new JLabel("Part Time:");
		partTimeLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		partTimeLabel.setBounds(495, 343, 115, 26);
		frame.getContentPane().add(partTimeLabel);
		
		moduleField1 = new JTextField();
		moduleField1.setBounds(171, 181, 231, 26);
		frame.getContentPane().add(moduleField1);
		moduleField1.setColumns(10);
		
		moduleField2 = new JTextField();
		moduleField2.setColumns(10);
		moduleField2.setBounds(171, 235, 231, 26);
		frame.getContentPane().add(moduleField2);
		
		moduleField3 = new JTextField();
		moduleField3.setColumns(10);
		moduleField3.setBounds(171, 288, 231, 26);
		frame.getContentPane().add(moduleField3);
		
		moduleField4 = new JTextField();
		moduleField4.setColumns(10);
		moduleField4.setBounds(171, 343, 231, 26);
		frame.getContentPane().add(moduleField4);
		
		
		tutorNameField = new JTextField();
		tutorNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
				
				if((Character.isLetter(c)) || (c==KeyEvent.VK_SPACE) || (c==KeyEvent.VK_BACK_SPACE)) {
					tutorNameField.setEditable(true);
				} else {
					tutorNameField.setEditable(false);
				}
			}
		});
		tutorNameField.setColumns(10);
		tutorNameField.setBounds(617, 183, 263, 25);
		frame.getContentPane().add(tutorNameField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(617, 235, 263, 25);
		frame.getContentPane().add(emailField);
		
		phoneNumberField = new JTextField();
		phoneNumberField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
				
				int length = phoneNumberField.getText().length();
				
				if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)) {
					if(length <= 10) {
						phoneNumberField.setEditable(true);
					}
				} else {
					phoneNumberField.setEditable(false);
				}
			}
		});
		phoneNumberField.setColumns(10);
		phoneNumberField.setBounds(633, 288, 263, 25);
		frame.getContentPane().add(phoneNumberField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox.setBounds(622, 348, 103, 21);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Yes");
		comboBox.addItem("No");
		comboBox.setSelectedItem("Select Yes or No");
		
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> fieldList = new ArrayList<JTextField>();
				
				fieldList.add(moduleField1);
				fieldList.add(moduleField2);
				fieldList.add(moduleField3);
				fieldList.add(moduleField4);
				fieldList.add(tutorNameField);
				fieldList.add(emailField);
				fieldList.add(phoneNumberField);
				for(JTextField field : fieldList) {
				      field.setText("");
				   }
			}
		});
		resetButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		resetButton.setBounds(507, 517, 103, 35);
		frame.getContentPane().add(resetButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con = new MyConnection();
				
				DatabaseCreation creation = new DatabaseCreation(con.getConnection());
				
				EmailValidation emailValidation = new EmailValidation(emailField.getText());
				
				// (moduleField1.getText().equals("")) || (moduleField2.getText().equals("")) || (moduleField3.getText().equals(""))
				//|| (moduleField4.getText().equals("")) || 
				
				Boolean condition = (tutorNameField.getText().equals("")) || (emailField.getText().equals(""))
						|| (phoneNumberField.getText().equals(""));
				
				if(emailValidation.checkEmail()!=1 ) {
					JOptionPane.showMessageDialog(frame, "Invalid Email ID....");
					
				} else if(phoneNumberField.getText().length()!=10){
					JOptionPane.showMessageDialog(frame, "Enter 10 digits in phone number.");
				}
				else if(condition !=  false) {
					JOptionPane.showMessageDialog(frame, "Required Fields name, email, phone number and part time not filled");
				} else if(condition == false){
					
					creation.updateTutorTable(tutorNameField.getText(), moduleField1.getText()
							, moduleField2.getText(), moduleField3.getText(), moduleField4.getText(), emailField.getText(),
							phoneNumberField.getText(), comboBox.getSelectedItem().toString());
					JOptionPane.showMessageDialog(frame, "Data added in tutor_details.");
				}
				
				
			}
		});
		updateButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		updateButton.setBounds(669, 517, 103, 35);
		frame.getContentPane().add(updateButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		backButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		backButton.setBounds(78, 517, 103, 35);
		frame.getContentPane().add(backButton);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}

}
