package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.mysql.cj.jdbc.PreparedStatement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private String nameString;
	private String passwordString;
	private String modeString;
	private String emailString;


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
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Login panel");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(114, 22, 267, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsername_1.setBounds(61, 89, 83, 27);
		frame.getContentPane().add(lblUsername_1);
		
		JLabel lblUsername_1_1 = new JLabel("Password: ");
		lblUsername_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsername_1_1.setBounds(61, 148, 83, 27);
		frame.getContentPane().add(lblUsername_1_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                textField.getText();
				
				char c = e.getKeyChar();
				
				if((Character.isLetter(c)) || (c==KeyEvent.VK_SPACE) || (c==KeyEvent.VK_BACK_SPACE)) {
					textField.setEditable(true);
				} else {
					textField.setEditable(false);
				}
			}
		});
		textField.setBounds(167, 89, 203, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 148, 215, 25);
		frame.getContentPane().add(passwordField);
		
		JComboBox usersCombo_1 = new JComboBox();
		usersCombo_1.setEditable(true);
		usersCombo_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		usersCombo_1.setBounds(137, 251, 215, 25);
		frame.getContentPane().add(usersCombo_1);
		
		usersCombo_1.addItem("Admin");
		usersCombo_1.addItem("Student");
		usersCombo_1.addItem("Tutor");
	
		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register reg = new register();
				frame.setVisible(false);
				reg.getFrame().setVisible(true);
				
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(85, 335, 109, 34);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nameString = textField.getText();
				passwordString = new String(passwordField.getPassword());
				modeString = usersCombo_1.getSelectedItem().toString();
				
				try {
					
					MyConnection con = new MyConnection();
					
					String sql;
					
					if(nameString.equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty username field");
					} else if (passwordString.equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty password field");
					} else if(modeString.equals("")) {
						JOptionPane.showMessageDialog(frame, "Select user mode");
					}
					
					else {
						
						if(modeString.equals("Student")) {
							sql= "Select name, password from Student where name=? and password=?";
						} else {
							sql= "Select name, password from registration where name=? and password=?";
						}
						
						PreparedStatement stmt = (PreparedStatement) con.getConnection().prepareStatement(sql);
						stmt.setString(1, nameString);
						stmt.setString(2, passwordString);
						
						ResultSet rs = stmt.executeQuery();
	                    if (rs.next()) {
	                    	Dashboard dashboard = new Dashboard(nameString, passwordString, modeString);
	                    	frame.setVisible(false);
	                    	dashboard.getFrame().setVisible(true);
	                    	
	                    	
	                    
	         
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
	                    }
						
					}
					
                    con.getConnection().close();
                    
				} catch (SQLSyntaxErrorException e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame, "Create an account...");
				}
				
				catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
			
				}
				
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLogin.setBackground(SystemColor.menu);
		btnLogin.setBounds(288, 335, 109, 34);
		frame.getContentPane().add(btnLogin);
		nameString = textField.getText();
		
	}
	
}