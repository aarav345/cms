package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class DeleteCourse {

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
					DeleteCourse window = new DeleteCourse();
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
	public DeleteCourse() {
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
		
		JLabel deleteLabel = new JLabel("Delete Course");
		deleteLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		deleteLabel.setBounds(153, 32, 150, 37);
		frame.getContentPane().add(deleteLabel);
		
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
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MyConnection connection = new MyConnection();
					
					String sql = "";
					int rs = 0;
					UpdateCourse up = new UpdateCourse(comboBox.getSelectedItem().toString());
					
					if(idField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty id field");
					} else if (courseField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty course field");
					} else if(comboBox.getSelectedItem().toString().equals("Select Level")) {
						JOptionPane.showMessageDialog(frame, "Select level");
					} else {
					
					if(comboBox.getSelectedItem().toString().equals("Level_4")) {
						sql = "Delete from level_4 where id=? and course=?";
						
					} else if(comboBox.getSelectedItem().toString().equals("Level_5")) {
						sql = "Delete from level_5 where id=? and course=?";	
					} else {
						sql = "Delete from level_6 where id=? and course=?";	
					}
					}
					
					PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
					stmt.setInt(1, Integer.parseInt(idField.getText()) );
					stmt.setString(2, courseField.getText());
					
					rs = stmt.executeUpdate();
					if(rs==1) {
						JOptionPane.showMessageDialog(frame, "Deleted Course from " + comboBox.getSelectedItem().toString());
					} else {
						JOptionPane.showMessageDialog(frame, "Data not found..");
					}
	                
	                
	         
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "First add course and delete");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		deleteButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		deleteButton.setBounds(287, 299, 103, 35);
		frame.getContentPane().add(deleteButton);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}

}
