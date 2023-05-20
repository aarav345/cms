package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateStudent {

	private JFrame frame;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneNumberField;
	private JTextField addressField;
	
	
	
	

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
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

	public JTextField getAddressField() {
		return addressField;
	}

	public void setAddressField(JTextField addressField) {
		this.addressField = addressField;
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
					UpdateStudent window = new UpdateStudent();
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
	public UpdateStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.setBounds(100, 100, 984, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel updateStudentlabel = new JLabel("Update Student");
		updateStudentlabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		updateStudentlabel.setBounds(400, 103, 155, 26);
		frame.getContentPane().add(updateStudentlabel);
		
		JLabel studentName = new JLabel("Student name:");
		studentName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		studentName.setBounds(72, 180, 137, 26);
		frame.getContentPane().add(studentName);
		
		JLabel emaillabel = new JLabel("Email:");
		emaillabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		emaillabel.setBounds(72, 232, 115, 26);
		frame.getContentPane().add(emaillabel);
		
		JLabel phonelabel = new JLabel("Phone Number:");
		phonelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		phonelabel.setBounds(72, 285, 139, 26);
		frame.getContentPane().add(phonelabel);
		
		JLabel level = new JLabel("level 4:");
		level.setFont(new Font("Times New Roman", Font.BOLD, 18));
		level.setBounds(507, 285, 115, 26);
		frame.getContentPane().add(level);
		
		
		
		nameField = new JTextField();
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
				
				if((Character.isLetter(c)) || (c==KeyEvent.VK_SPACE)) {
					nameField.setEditable(true);
				} else {
					nameField.setEditable(false);
				}
			}
		});
		nameField.setColumns(10);
		nameField.setBounds(213, 183, 263, 25);
		frame.getContentPane().add(nameField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(213, 235, 263, 25);
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
		phoneNumberField.setBounds(213, 288, 263, 25);
		frame.getContentPane().add(phoneNumberField);
		
		JComboBox level5combobox = new JComboBox();
		level5combobox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		level5combobox.setBounds(213, 336, 160, 24);
		frame.getContentPane().add(level5combobox);
		level5combobox.addItem("Unavailable");
		level5combobox.addItem("Pass");
		level5combobox.addItem("Fail");
		level5combobox.setSelectedItem("Select Pass or Fail");
		level5combobox.setVisible(false);
		
		
		JComboBox level6combobox = new JComboBox();
		level6combobox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		level6combobox.setBounds(590, 336, 160, 24);
		frame.getContentPane().add(level6combobox);
		level6combobox.addItem("Unavailable");
		level6combobox.addItem("Pass");
		level6combobox.addItem("Fail");
		level6combobox.setSelectedItem("Select Pass or Fail");
		level6combobox.setVisible(false);
		
		JLabel level5label = new JLabel("level 5:");
		level5label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		level5label.setBounds(72, 331, 115, 26);
		frame.getContentPane().add(level5label);
		level5label.setVisible(false);
		
		JLabel level6label = new JLabel("level 6:");
		level6label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		level6label.setBounds(505, 331, 72, 26);
		frame.getContentPane().add(level6label);
		level6label.setVisible(false);
		
		level5combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(level5combobox.getSelectedItem().toString().equals("Pass")) {
					level6combobox.setVisible(true);
					level6label.setVisible(true);
				}
			}
		});
		
		
		JComboBox level4combobox = new JComboBox();
		level4combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(level4combobox.getSelectedItem().toString().equals("Pass")) {
					level5combobox.setVisible(true);
					level5label.setVisible(true);
				}
				
			}
			
		});
		level4combobox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		level4combobox.setBounds(590, 286, 160, 24);
		frame.getContentPane().add(level4combobox);
		level4combobox.addItem("Unavailable");
		level4combobox.addItem("Pass");
		level4combobox.addItem("Fail");
		level4combobox.setSelectedItem("Select Pass or Fail");
		
		
		
		JComboBox courseCombo = new JComboBox();
		courseCombo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		courseCombo.setBounds(590, 180, 223, 26);
		frame.getContentPane().add(courseCombo);
		
		try {

			MyConnection con = new MyConnection();
			
			Statement stmt = con.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select course from level_4");
			
			while(rs.next()) {
				courseCombo.addItem(rs.getString("course"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> fieldList = new ArrayList<JTextField>();
				fieldList.add(addressField);
				fieldList.add(nameField);
				fieldList.add(emailField);
				fieldList.add(phoneNumberField);
				for(JTextField field : fieldList) {
				      field.setText("");
				   }
			}
		});
		resetButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		resetButton.setBounds(623, 384, 103, 35);
		frame.getContentPane().add(resetButton);
		
		JButton AddTutorButton = new JButton("Add");
		AddTutorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con = new MyConnection();
				
				DatabaseCreation creation = new DatabaseCreation(con.getConnection());
				
				EmailValidation emailValidation = new EmailValidation(emailField.getText());
				
				
				Boolean condition = (nameField.getText().equals("")) || (emailField.getText().equals(""))
						|| (phoneNumberField.getText().equals("")) || (addressField.getText().equals(""));
				
				if(emailValidation.checkEmail()!=1 ) {
					JOptionPane.showMessageDialog(frame, "Invalid Email ID....");
					
				} else if(phoneNumberField.getText().length()!=10){
					JOptionPane.showMessageDialog(frame, "Enter 10 digits in phone number.");
				}
				else if(condition !=  false) {
					JOptionPane.showMessageDialog(frame, "Required Fields name, email, phone number and part time not filled");
				} else if(condition == false){
					
					creation.updateStudentTable(nameField.getText(), emailField.getText(),
							phoneNumberField.getText(), courseCombo.getSelectedItem().toString(), addressField.getText(), level4combobox.getSelectedItem().toString(),
							level5combobox.getSelectedItem().toString(), level6combobox.getSelectedItem().toString());
					JOptionPane.showMessageDialog(frame, "Data added in Student_details.");
				}
				
				
			}
		});
		AddTutorButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		AddTutorButton.setBounds(772, 384, 103, 35);
		frame.getContentPane().add(AddTutorButton);
		
		JLabel courseLabel = new JLabel("Course:");
		courseLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		courseLabel.setBounds(507, 180, 72, 26);
		frame.getContentPane().add(courseLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		addressLabel.setBounds(505, 232, 137, 26);
		frame.getContentPane().add(addressLabel);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(590, 235, 263, 25);
		frame.getContentPane().add(addressField);
		
		
		
		
		
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}
}
