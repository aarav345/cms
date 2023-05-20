package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateReport {

	private JFrame frame;
	
	

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
					CreateReport window = new CreateReport();
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
	public CreateReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel reportLabel = new JLabel("Create Report");
		reportLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		reportLabel.setBounds(168, 40, 146, 37);
		frame.getContentPane().add(reportLabel);
		
		JLabel courseTitle = new JLabel("Course:");
		courseTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		courseTitle.setBounds(77, 166, 115, 26);
		frame.getContentPane().add(courseTitle);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		nameLabel.setBounds(85, 119, 84, 26);
		frame.getContentPane().add(nameLabel);
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox.setBounds(186, 213, 107, 26);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Level 4");
		comboBox.addItem("Level 5");
		comboBox.addItem("Level 6");
		comboBox.setSelectedItem("Select Level");
		
		JComboBox nameField = new JComboBox();
		nameField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		nameField.setBounds(158, 119, 223, 26);
		frame.getContentPane().add(nameField);
		
		try {

			MyConnection con = new MyConnection();
			
			Statement stmt = con.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select name from student");
			
			while(rs.next()) {
				nameField.addItem(rs.getString("name"));
			}
		} catch (SQLSyntaxErrorException e1) {
			JOptionPane.showMessageDialog(frame, "No students added");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JButton addMarksButton = new JButton("Add");
		addMarksButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		addMarksButton.setBounds(190, 261, 103, 35);
		frame.getContentPane().add(addMarksButton);
		
		JComboBox courseField = new JComboBox();
		courseField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		courseField.setBounds(158, 166, 223, 26);
		frame.getContentPane().add(courseField);
		
		
		
		try {

			MyConnection con = new MyConnection();
			
			Statement stmt = con.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select course from student");
			
			while(rs.next()) {
				
				courseField.addItem(rs.getString("course"));
				
			}
		} catch (SQLSyntaxErrorException e1) {
			JOptionPane.showMessageDialog(frame, "No course added");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		addMarksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection connection = new MyConnection();
				
				DatabaseCreation creation = new DatabaseCreation(connection.getConnection());
				
				String sqlString = "";
				String updateString = "";
				
				try {

					if(comboBox.getSelectedItem().toString().equals("Level 4")) {
						sqlString = "select * from level_4_marks ";
						updateString = " update level_4_marks set report = ? where name= ? and course = ?";
						
					} else if(comboBox.getSelectedItem().toString().equals("Level 5")) {
						sqlString = "select * from level_5_marks ";
						updateString = " update level_5_marks set report = ? where name= ? and course = ?";
					} else {
						sqlString = "select * from level_6_marks ";
						updateString = " update level_6_marks set report = ? where name= ? and course = ?";
					}
					
					Statement stmt = connection.getConnection().createStatement();
					
					ResultSet rs = stmt.executeQuery(sqlString);
					
					while(rs.next()) {
						
						if (rs.getString("module1_marks").equals("") || rs.getString("module2_marks").equals("") || rs.getString("module3_marks").equals("")
								|| rs.getString("module4_marks").equals("")) {
							JOptionPane.showMessageDialog(frame, "Marks not added by tutor....");
						} else {
							PreparedStatement stmt1 = connection.getConnection().prepareStatement(updateString);
							stmt1.setString(1, "1");
							stmt1.setString(2, nameField.getSelectedItem().toString());
							stmt1.setString(3, courseField.getSelectedItem().toString());
							stmt1.executeUpdate();
							JOptionPane.showMessageDialog(frame, "Result created.");
						}
						
					}
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "Student not enrolled...");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
				
				
			
			
			}	
		});
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}

}
