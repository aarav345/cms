package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateStudent1 {

	private JFrame frame;
	private JTextField idField;
	private JTextField nameField;
	
	

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
					UpdateStudent1 window = new UpdateStudent1();
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
	public UpdateStudent1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel updateLabel = new JLabel("Update Student");
		updateLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		updateLabel.setBounds(153, 32, 150, 37);
		frame.getContentPane().add(updateLabel);
		
		JLabel courseTitle = new JLabel("Name:");
		courseTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		courseTitle.setBounds(77, 166, 115, 26);
		frame.getContentPane().add(courseTitle);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		idLabel.setBounds(111, 118, 84, 26);
		frame.getContentPane().add(idLabel);
		

		idField = new JTextField();
		idField.setBounds(162, 118, 212, 25);
		frame.getContentPane().add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(162, 167, 212, 25);
		frame.getContentPane().add(nameField);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				nameField.setText("");
				
			}
		});
		resetButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		resetButton.setBounds(77, 299, 103, 35);
		frame.getContentPane().add(resetButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MyConnection connection = new MyConnection();
					
					String sql = "";
					ResultSet rs = null;
					UpdateStudent up = new UpdateStudent();
					
					if(idField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty id field");
					} else if (nameField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty course field");
					}  else {
						
						sql = "Select * from student_details where id=? and name=?";
					
					
					}
					
					PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
					stmt.setInt(1, Integer.parseInt(idField.getText()) );
					stmt.setString(2, nameField.getText());
					
					rs = stmt.executeQuery();
	                if (rs.next()) {
	                	up.getNameField().setText(rs.getString("name"));;
	                	up.getEmailField().setText(rs.getString("email"));
	                	up.getPhoneNumberField().setText(rs.getString("phone_number"));
	                	up.getAddressField().setText(rs.getString("address"));
	              
	                	frame.setVisible(false);
	                	up.getFrame().setVisible(true);
	                 	
	             
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Wrong id or name");
	                }
	                
	         
	                
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		updateButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		updateButton.setBounds(287, 299, 103, 35);
		frame.getContentPane().add(updateButton);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}

}
