package cms;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UpdateCourse1 {

	private JFrame frame;
	private JTextField idField;
	private JTextField courseField;
	
	

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
					UpdateCourse1 window = new UpdateCourse1();
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
	public UpdateCourse1() {
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
		
		JLabel updateLabel = new JLabel("Update Course");
		updateLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		updateLabel.setBounds(153, 32, 150, 37);
		frame.getContentPane().add(updateLabel);
		
		JLabel courseTitle = new JLabel("Course:");
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
		
		courseField = new JTextField();
		courseField.setColumns(10);
		courseField.setBounds(162, 167, 212, 25);
		frame.getContentPane().add(courseField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox.setBounds(176, 213, 107, 26);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Level_4");
		comboBox.addItem("Level_5");
		comboBox.addItem("Level_6");
		comboBox.setSelectedItem("Select Level");
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				courseField.setText("");
				
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
					UpdateCourse up = new UpdateCourse(comboBox.getSelectedItem().toString());
					
					if(idField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty id field");
					} else if (courseField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty course field");
					} else if(comboBox.getSelectedItem().toString().equals("Select Level")) {
						JOptionPane.showMessageDialog(frame, "Select level");
					} else {
					
					if(comboBox.getSelectedItem().toString().equals("Level_4")) {
						sql = "Select * from level_4 where id=? and course=?";
						
					} else if(comboBox.getSelectedItem().toString().equals("Level_5")) {
						sql = "Select * from level_5 where id=? and course=?";	
					} else {
						sql = "Select * from level_6 where id=? and course=?";	
					}
					}
					
					PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
					stmt.setInt(1, Integer.parseInt(idField.getText()) );
					stmt.setString(2, courseField.getText());
					
					rs = stmt.executeQuery();
	                if (rs.next()) {
	                	up.getCourseField().setText(rs.getString("course"));;
	                	up.getModuleField1().setText(rs.getString("module1"));
	                	up.getModuleField2().setText(rs.getString("module2"));
	                	up.getModuleField3().setText(rs.getString("module3"));
	                	up.getModuleField4().setText(rs.getString("module4"));
//	                	up.getTutorField1().setText(rs.getString("tutor1"));
//	                	up.getTutorField2().setText(rs.getString("tutor2"));
//	                	up.getTutorField3().setText(rs.getString("tutor3"));
//	                	up.getTutorField4().setText(rs.getString("tutor4"));
	                	
	                	if(comboBox.getSelectedItem().toString().equals("Level_6")) {
	                		up.getOptionalField1().setText(rs.getString("optional1"));
	                		up.getOptionalField2().setText(rs.getString("optional2"));
//	                		up.getOptionalTutorField1().setText(rs.getString("optionaltutor1"));
//	                		up.getOptionalTutorField2().setText(rs.getString("optionaltutor2"));
	                	}
	              
	                	frame.setVisible(false);
	                	up.getFrame().setVisible(true);
	                 	
	             
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Wrong id or course name");
	                }
	                
	         
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "First add course");
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
