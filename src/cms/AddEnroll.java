package cms;

import static org.junit.Assert.isArray;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper.Range;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddEnroll {

	private JFrame frame;
	private static String nameString;
	private String course;
	
	

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
					AddEnroll window = new AddEnroll(nameString);
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
	public AddEnroll(String nameString) {
		this.nameString = nameString;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 452);
		
		frame.getContentPane().setLayout(null);
		
		JLabel selectmodulelabel = new JLabel("Select Module for Level 6");
		selectmodulelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		selectmodulelabel.setBounds(132, 162, 224, 39);
		frame.getContentPane().add(selectmodulelabel);
		
		JComboBox module1combo = new JComboBox();
		module1combo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		module1combo.setBounds(25, 224, 187, 30);
		frame.getContentPane().add(module1combo);
		
		JComboBox module2combo = new JComboBox();
		module2combo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		module2combo.setBounds(240, 224, 187, 30);
		frame.getContentPane().add(module2combo);
		
		JComboBox module3combo = new JComboBox();
		module3combo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		module3combo.setBounds(25, 277, 187, 30);
		frame.getContentPane().add(module3combo);
		
		JComboBox module4combo = new JComboBox();
		module4combo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		module4combo.setBounds(240, 277, 187, 30);
		frame.getContentPane().add(module4combo);
		
		JButton enrollBtn = new JButton("Enroll");
		enrollBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		enrollBtn.setBounds(155, 340, 139, 32);
		frame.getContentPane().add(enrollBtn);
		
		JLabel enrollLabel = new JLabel("Enroll Student");
		enrollLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		enrollLabel.setBounds(173, 29, 142, 39);
		frame.getContentPane().add(enrollLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals("Level 6")) {
					selectmodulelabel.setVisible(true);
					module1combo.setVisible(true);
					module2combo.setVisible(true);
					module3combo.setVisible(true);
					module4combo.setVisible(true);
					
				} else {
					selectmodulelabel.setVisible(false);
					module1combo.setVisible(false);
					module2combo.setVisible(false);
					module3combo.setVisible(false);
					module4combo.setVisible(false);
				}
				
			}
		});
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox.setBounds(198, 114, 187, 30);
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem("Level 4");
		
		
		
		JLabel levelLabel = new JLabel("Level:");
		levelLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		levelLabel.setBounds(122, 108, 142, 39);
		frame.getContentPane().add(levelLabel);
		
		try {

			MyConnection con = new MyConnection();
			
			String sql1 = "select course from student where name = ?" ;
			
			
			PreparedStatement stmt = con.getConnection().prepareStatement(sql1);

			stmt.setString(1, nameString);
			
			ResultSet rs1 = stmt.executeQuery();
			
			
			
			while(rs1.next()) {
				String sql2 = "select module1, module2, module3, module4, optional1, optional2  from level_6 where course = ?";
				
				PreparedStatement stmt1 = con.getConnection().prepareStatement(sql2);
				stmt1.setString(1, rs1.getString("course"));

				ResultSet rs = stmt1.executeQuery();
				
				while(rs.next()) {
					for(int i = 1; i <= 6 ; i++) {
						module1combo.addItem(rs.getString(i));
						module2combo.addItem(rs.getString(i));
						module3combo.addItem(rs.getString(i));
						module4combo.addItem(rs.getString(i));
					}
						
				}
				
				System.out.println(rs1.getString("course"));
				course = rs1.getString("course");
				
			}
		} catch (SQLSyntaxErrorException e1) {
			JOptionPane.showMessageDialog(frame, "all three level of course not created.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
            MyConnection con = new MyConnection();
			
			String sql1 = "select level_4, level_5 from student_details where name = ? and course = ?" ;
			
			
			PreparedStatement stmt = con.getConnection().prepareStatement(sql1);

			stmt.setString(1, nameString);
			stmt.setString(2, course);
			ResultSet rsResultSet = stmt.executeQuery();
			
			while(rsResultSet.next()) {
				if (rsResultSet.getString("level_4").equals("Pass")) {
					comboBox.addItem("Level 5");
				}
				
				if(rsResultSet.getString("level_5")==null) {
					comboBox.removeItem("Level 6");
				}
				
				else if(rsResultSet.getString("level_5").equals("Pass") ) {
					comboBox.addItem("Level 6");
				} 
				
			}
			
		} catch (SQLSyntaxErrorException e1) {
			JOptionPane.showMessageDialog(frame, "Not added info by admin.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		enrollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MyConnection con = new MyConnection();
                DatabaseCreation creation = new DatabaseCreation(con.getConnection());
                
                try {
                	
                	String sql1 = "";
                	
                	
                	if(comboBox.getSelectedItem().toString().equals("Level 6")) {
                		if(creation.tableExist("level_6_marks")!=1) {
    						creation.createMarksTable(comboBox.getSelectedItem().toString());
    					}
                		sql1 = "select * from level_6_marks where name = ? and course = ?" ;
                		
                	} else if (comboBox.getSelectedItem().toString().equals("Level 4")) {
                		if(creation.tableExist("level_4_marks")!=1) {
    						creation.createMarksTable(comboBox.getSelectedItem().toString());
    					}
                		sql1 = "select * from level_4_marks where name = ? and course = ?" ;
                	} else {
                		if(creation.tableExist("level_5_marks")!=1) {
    						creation.createMarksTable(comboBox.getSelectedItem().toString());
    					}
                		sql1 = "select * from level_5_marks where name = ? and course = ?" ;
                	}
        			
        			
        			PreparedStatement stmt = con.getConnection().prepareStatement(sql1);

        			stmt.setString(1, nameString);
        			stmt.setString(2, course);
        			ResultSet rsResultSet = stmt.executeQuery();
        			System.out.println("Hello");
        			System.out.println(rsResultSet.next());
        			
        			if(rsResultSet.next()==true) {
        				if(rsResultSet.getString("name").equals(nameString) && rsResultSet.getString("course").equals(course)) {
        					JOptionPane.showMessageDialog(frame, "Already enrolled...");
        				} else {
        					if(comboBox.getSelectedItem().toString().equals("Level 6")) {
        						
        						creation.addMarks(nameString, course, "",
        								"", "", "", module1combo.getSelectedItem().toString(), module2combo.getSelectedItem().toString(),
        								module3combo.getSelectedItem().toString(), module4combo.getSelectedItem().toString(), "");
        						
        						
        						
        					} else if(comboBox.getSelectedItem().toString().equals("Level 4")) {
        						
        						
        						creation.addMarks(nameString, course, "", "",  "", "", "", comboBox.getSelectedItem().toString());
        						
        					} else {
        						
        						
        						creation.addMarks(nameString, course, "", "",  "", "", "", comboBox.getSelectedItem().toString());
        						JOptionPane.showMessageDialog(frame, "Successfully enrolled");
        					}
        				}
        			} else if(rsResultSet.next()==false) {
        				if(comboBox.getSelectedItem().toString().equals("Level 6")) {
    						
    						creation.addMarks(nameString, course, "",
    								"", "", "", module1combo.getSelectedItem().toString(), module2combo.getSelectedItem().toString(),
    								module3combo.getSelectedItem().toString(), module4combo.getSelectedItem().toString(), "");

    						
    						
    					} else if(comboBox.getSelectedItem().toString().equals("Level 4")) {
    						
    						
    						creation.addMarks(nameString, course, "", "",  "", "", "", comboBox.getSelectedItem().toString());
    					} else {
    						
    						
    						creation.addMarks(nameString, course, "", "",  "", "", "", comboBox.getSelectedItem().toString());

    					}
        			}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
				
				
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	

}
