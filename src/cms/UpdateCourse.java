package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCourse {

	private JFrame frame;
	private JTextField moduleField1;
	private JTextField moduleField2;
	private JTextField moduleField3;
	private JTextField moduleField4;
	private JTextField courseField;
	private JTextField optionalField1;
	private JTextField optionalField2;
	private static String level;
	
	
	
	
	

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

	public JTextField getCourseField() {
		return courseField;
	}

	public void setCourseField(JTextField courseField) {
		this.courseField = courseField;
	}
//
//	public JTextField getTutorField1() {
//		return tutorField1;
//	}
//
//	public void setTutorField1(JTextField tutorField1) {
//		this.tutorField1 = tutorField1;
//	}
//
//	public JTextField getTutorField2() {
//		return tutorField2;
//	}
//
//	public void setTutorField2(JTextField tutorField2) {
//		this.tutorField2 = tutorField2;
//	}
//
//	public JTextField getTutorField3() {
//		return tutorField3;
//	}
//
//	public void setTutorField3(JTextField tutorField3) {
//		this.tutorField3 = tutorField3;
//	}
//
//	public JTextField getTutorField4() {
//		return tutorField4;
//	}
//
//	public void setTutorField4(JTextField tutorField4) {
//		this.tutorField4 = tutorField4;
//	}

	public JTextField getOptionalField1() {
		return optionalField1;
	}

	public void setOptionalField1(JTextField optionalField1) {
		this.optionalField1 = optionalField1;
	}

	public JTextField getOptionalField2() {
		return optionalField2;
	}

	public void setOptionalField2(JTextField optionalField2) {
		this.optionalField2 = optionalField2;
	}

//	public JTextField getOptionalTutorField1() {
//		return optionalTutorField1;
//	}
//
//	public void setOptionalTutorField1(JTextField optionalTutorField1) {
//		this.optionalTutorField1 = optionalTutorField1;
//	}
//
//	public JTextField getOptionalTutorField2() {
//		return optionalTutorField2;
//	}
//
//	public void setOptionalTutorField2(JTextField optionalTutorField2) {
//		this.optionalTutorField2 = optionalTutorField2;
//	}

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
					UpdateCourse window = new UpdateCourse(level);
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
	public UpdateCourse(String level) {
		this.level = level;
		
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
			
			JLabel update = new JLabel("Update Course");
			update.setFont(new Font("Times New Roman", Font.BOLD, 22));
			update.setBounds(396, 22, 143, 26);
			frame.getContentPane().add(update);
			
			JLabel courseTitle = new JLabel("Course:");
			courseTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
			courseTitle.setBounds(77, 121, 115, 26);
			frame.getContentPane().add(courseTitle);
			
			JLabel module1 = new JLabel("Module1:");
			module1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			module1.setBounds(77, 182, 115, 26);
			frame.getContentPane().add(module1);
			
			
			
			
			
			JLabel module3 = new JLabel("Module3:");
			module3.setFont(new Font("Times New Roman", Font.BOLD, 18));
			module3.setBounds(77, 288, 115, 26);
			frame.getContentPane().add(module3);
			
			JLabel optionalModule1 = new JLabel("Optional Module1:");
			optionalModule1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			optionalModule1.setBounds(77, 410, 163, 26);
			frame.getContentPane().add(optionalModule1);
			optionalModule1.setVisible(false);
			
			JLabel optionalModule2 = new JLabel("Optional Module2:");
			optionalModule2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			optionalModule2.setBounds(77, 453, 163, 26);
			frame.getContentPane().add(optionalModule2);
			optionalModule2.setVisible(false);
			
			JComboBox tutorField1 = new JComboBox();
			tutorField1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tutorField1.setBounds(634, 182, 231, 26);
			frame.getContentPane().add(tutorField1);
			
			JComboBox tutorField2 = new JComboBox();
			tutorField2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tutorField2.setBounds(634, 235, 231, 26);
			frame.getContentPane().add(tutorField2);
			
			JComboBox tutorField3 = new JComboBox();
			tutorField3.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tutorField3.setBounds(634, 288, 231, 26);
			frame.getContentPane().add(tutorField3);
			
			JComboBox optionalTutorField1 = new JComboBox();
			optionalTutorField1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			optionalTutorField1.setBounds(634, 410, 231, 26);
			frame.getContentPane().add(optionalTutorField1);
			
			JComboBox tutorField4 = new JComboBox();
			tutorField4.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tutorField4.setBounds(634, 343, 231, 26);
			frame.getContentPane().add(tutorField4);
			
			JComboBox optionalTutorField2 = new JComboBox();
			optionalTutorField2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			optionalTutorField2.setBounds(634, 453, 231, 26);
			frame.getContentPane().add(optionalTutorField2);
			
			try {

				MyConnection con = new MyConnection();
				
				Statement stmt = con.getConnection().createStatement();
				
				ResultSet rs = stmt.executeQuery("select name from tutor_details");
				
				while(rs.next()) {
					tutorField1.addItem(rs.getString("name"));
					tutorField2.addItem(rs.getString("name"));
					tutorField3.addItem(rs.getString("name"));
					tutorField4.addItem(rs.getString("name"));
					optionalTutorField1.addItem(rs.getString("name"));
					optionalTutorField2.addItem(rs.getString("name"));
					
				}
			} catch (SQLSyntaxErrorException e) {
				JOptionPane.showMessageDialog(frame, "First add Course and update");
				frame.setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			optionalField1 = new JTextField();
			optionalField1.setColumns(10);
			optionalField1.setBounds(267, 410, 231, 26);
			frame.getContentPane().add(optionalField1);
			optionalField1.setVisible(false);
			
			optionalField2 = new JTextField();
			optionalField2.setColumns(10);
			optionalField2.setBounds(267, 453, 231, 26);
			frame.getContentPane().add(optionalField2);
			optionalField2.setVisible(false);
			
			JLabel optionalTutor1 = new JLabel("Tutor4:");
			optionalTutor1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			optionalTutor1.setBounds(537, 410, 115, 26);
			frame.getContentPane().add(optionalTutor1);
			optionalTutor1.setVisible(false);
			
			JLabel optionalTutor2 = new JLabel("Tutor4:");
			optionalTutor2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			optionalTutor2.setBounds(537, 453, 115, 26);
			frame.getContentPane().add(optionalTutor2);
			optionalTutor2.setVisible(false);
			
			
			if (level.equals("Level_6")) {
				optionalModule1.setVisible(true);
				optionalModule2.setVisible(true);
				optionalField1.setVisible(true);
				optionalField2.setVisible(true);
				optionalTutor1.setVisible(true);
				optionalTutor2.setVisible(true);
				optionalTutorField1.setVisible(true);
				optionalTutorField2.setVisible(true);
			} else {
				optionalModule1.setVisible(false);
				optionalModule2.setVisible(false);
				optionalField1.setVisible(false);
				optionalField2.setVisible(false);
				optionalTutor1.setVisible(false);
				optionalTutor2.setVisible(false);
				optionalTutorField1.setVisible(false);
				optionalTutorField2.setVisible(false);
			}
			
			JLabel module2 = new JLabel("Module2:");
			module2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			module2.setBounds(77, 235, 115, 26);
			frame.getContentPane().add(module2);
			
			JLabel module4 = new JLabel("Module4:");
			module4.setFont(new Font("Times New Roman", Font.BOLD, 18));
			module4.setBounds(77, 343, 115, 26);
			frame.getContentPane().add(module4);
			
			JLabel tutor1 = new JLabel("Tutor1:");
			tutor1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tutor1.setBounds(537, 182, 115, 26);
			frame.getContentPane().add(tutor1);
			
			JLabel tutor2 = new JLabel("Tutor2:");
			tutor2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tutor2.setBounds(537, 235, 115, 26);
			frame.getContentPane().add(tutor2);
			
			JLabel tutor3 = new JLabel("Tutor3:");
			tutor3.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tutor3.setBounds(537, 288, 115, 26);
			frame.getContentPane().add(tutor3);
			
			JLabel tutor4 = new JLabel("Tutor4:");
			tutor4.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tutor4.setBounds(537, 343, 115, 26);
			frame.getContentPane().add(tutor4);
			
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
			
			courseField = new JTextField();
			courseField.setColumns(10);
			courseField.setBounds(171, 121, 231, 26);
			frame.getContentPane().add(courseField);
			courseField.setEditable(false);
			
			JButton resetButton = new JButton("Reset");
			resetButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					List<JTextField> fieldList = new ArrayList<JTextField>();
					fieldList.add(moduleField1);
					fieldList.add(moduleField2);
					fieldList.add(moduleField3);
					fieldList.add(moduleField4);
					fieldList.add(optionalField1);
					fieldList.add(optionalField2);
					for(JTextField field : fieldList) {
					      field.setText("");
					   }
				}
			});
			resetButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
			resetButton.setBounds(644, 517, 103, 35);
			frame.getContentPane().add(resetButton);
			
			JButton AddCourseButton = new JButton("Update");
			AddCourseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MyConnection con = new MyConnection();
					
					DatabaseCreation creation = new DatabaseCreation(con.getConnection());
					
					
					Boolean condition = (moduleField1.getText().equals("")) || (moduleField2.getText().equals("")) || (moduleField3.getText().equals(""))
							|| (moduleField4.getText().equals("")) || (courseField.getText().equals(""));
					
					// create course table in database
					
					if (level.equals("Level_6")) {
						condition = condition || (optionalField1.getText().equals("")) || (optionalField2.getText().equals(""));
						
						if (condition==false) {
							if(creation.tableExist(level)!=1) {
								creation.createCourseTable(level);
							}
							
							creation.updateCourseTable(courseField.getText(), moduleField1.getText()
									, moduleField2.getText(), moduleField3.getText(), moduleField4.getText(), tutorField1.getSelectedItem().toString(),
									tutorField2.getSelectedItem().toString(), tutorField3.getSelectedItem().toString(),
									tutorField4.getSelectedItem().toString(), optionalField1.getText(), 
									optionalField2.getText(), optionalTutorField1.getSelectedItem().toString(), optionalTutorField2.getSelectedItem().toString());
						} else {
							JOptionPane.showMessageDialog(frame, "Empty Fields.");
						}
					} else if (!level.equals("Level_6")) {
						if (condition==false) {
							if(creation.tableExist(level)!=1) {
								creation.createCourseTable(level);
							}
							
							creation.updateCourseTable(level, courseField.getText(), moduleField1.getText()
									,moduleField2.getText(), moduleField3.getText(), moduleField4.getText(), tutorField1.getSelectedItem().toString(),
									tutorField2.getSelectedItem().toString(), tutorField3.getSelectedItem().toString(), tutorField4.getSelectedItem().toString());
						} else {
							JOptionPane.showMessageDialog(frame, "Empty Fields.");
						}
					}
				}
			});
			AddCourseButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
			AddCourseButton.setBounds(787, 517, 103, 35);
			frame.getContentPane().add(AddCourseButton);
			frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			
			
			
		}
	}



