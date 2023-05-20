package cms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Report1 {

	private JFrame frame;
	private static String usernamString;
	
	

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
					Report1 window = new Report1(usernamString);
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
	public Report1(String usernameString) {
		this.usernamString = usernameString;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel reportLabel = new JLabel("Select level:");
		reportLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		reportLabel.setBounds(155, 40, 129, 36);
		frame.getContentPane().add(reportLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setBounds(142, 100, 142, 36);
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem("Level 4");
		comboBox.addItem("Level 5");
		comboBox.addItem("Level 6");
		
		JButton reportbtn = new JButton("Report");
		reportbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MyConnection connection = new MyConnection();
				
				DatabaseCreation creation = new DatabaseCreation(connection.getConnection());
				
				String sqlString = "";
				
				try {

					if(comboBox.getSelectedItem().toString().equals("Level 4")) {
						sqlString = "select * from level_4_marks where name= ? ";
						
						
					} else if(comboBox.getSelectedItem().toString().equals("Level 5")) {
						sqlString = "select * from level_5_marks where name= ?";
						
					} else {
						sqlString = "select * from level_6_marks where name= ?";
						
					}
					
					
					
					PreparedStatement stmt = connection.getConnection().prepareStatement(sqlString);
					stmt.setString(1, usernamString);
					
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						if (rs.getString("report").equals("")) {
							JOptionPane.showMessageDialog(frame, "Report not approved by admin");
						} else {
							JOptionPane.showMessageDialog(frame, "Result created.");
							Report report = new Report(usernamString, rs.getString("course"), rs.getString("module1_marks"), rs.getString("module2_marks"),
									rs.getString("module3_marks"), rs.getString("module4_marks"), comboBox.getSelectedItem().toString());
							
							report.getFrame().setVisible(true);
							frame.setVisible(false);
						}
						
					}
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "Student not enrolled...");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		reportbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		reportbtn.setBounds(142, 173, 139, 32);
		frame.getContentPane().add(reportbtn);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
