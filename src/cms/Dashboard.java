package cms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import static org.junit.Assert.isArray;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.AlgorithmParametersSpi;

public class Dashboard {

	private JFrame frame;
	private JTextField txtAaravPradhan;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private static String usernameString;
	private static String passwordString;
	private static String modeString;
	private JTextField textField_4;
	private JTable table;
	private JTable tutorTable;
	private JTable studentTable;
	
	
	
	
	
	

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
					Dashboard window = new Dashboard(usernameString, passwordString, modeString);
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
	public Dashboard(String usernameString, String passwordString, String modeString) {
		this.usernameString = usernameString;
		this.passwordString = passwordString;
		this.modeString = modeString;
		initialize();
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 914, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(201, 0, 699, 506);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Dashboard = new JPanel();
		layeredPane.add(Dashboard, "name_691918231132900");
		Dashboard.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(38, 86, 148, 70);
		Dashboard.add(panel);
		panel.setLayout(null);
		
		JLabel courseNumberLabel = new JLabel("");
		courseNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		courseNumberLabel.setBounds(56, 10, 32, 50);
		panel.add(courseNumberLabel);
		
		try {

			MyConnection con = new MyConnection();
			
			Statement stmt = con.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select course from level_4");
			
			int count = 0;
			
			while(rs.next()) {
				count++;
			}
			
			courseNumberLabel.setText(Integer.toString(count));
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (SQLSyntaxErrorException e) {
			JOptionPane.showMessageDialog(frame, "No course added.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(257, 86, 148, 70);
		Dashboard.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel studentsNumberLabel = new JLabel("0");
		studentsNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		studentsNumberLabel.setBounds(55, 10, 32, 50);
		panel_1.add(studentsNumberLabel);
		
		try {

			MyConnection con = new MyConnection();
			
			Statement stmt = con.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select name from student_details");
			
			int count = 0;
			
			while(rs.next()) {
				count++;
			}
			
			studentsNumberLabel.setText(Integer.toString(count));
		} catch (SQLSyntaxErrorException e) {
			JOptionPane.showMessageDialog(frame, "No students added.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(482, 86, 148, 70);
		Dashboard.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel tutorNumberLabel = new JLabel("0");
		tutorNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		tutorNumberLabel.setBounds(54, 10, 32, 50);
		panel_1_1.add(tutorNumberLabel);
		
		try {

			MyConnection con = new MyConnection();
			
			Statement stmt = con.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select name from tutor_details");
			
			int count = 0;
			
			while(rs.next()) {
				count++;
			}
			
			tutorNumberLabel.setText(Integer.toString(count));
		} catch (SQLSyntaxErrorException e) {
			JOptionPane.showMessageDialog(frame, "No tutor added.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_6 = new JLabel("Dashboard");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(26, 10, 96, 32);
		Dashboard.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Total Courses");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6_1.setBounds(36, 52, 118, 32);
		Dashboard.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Total Students");
		lblNewLabel_6_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6_1_1.setBounds(257, 52, 118, 32);
		Dashboard.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("Total Tutors");
		lblNewLabel_6_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6_1_1_1.setBounds(482, 52, 118, 32);
		Dashboard.add(lblNewLabel_6_1_1_1);
		
		JButton tutorProgressButton = new JButton("Add Marks");
		tutorProgressButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMarks addMarks = new AddMarks();
				addMarks.getFrame().setVisible(true);
			}
		});
		tutorProgressButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tutorProgressButton.setBounds(482, 169, 139, 32);
		Dashboard.add(tutorProgressButton);
		if (modeString.equals("Tutor")) {
			tutorProgressButton.setVisible(true);
		} else {
			tutorProgressButton.setVisible(false);
		}
		
		JButton enroll = new JButton("Enroll");
		enroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEnroll add = new AddEnroll(usernameString);
				add.getFrame().setVisible(true);
			}
		});
		enroll.setFont(new Font("Times New Roman", Font.BOLD, 18));
		enroll.setBounds(482, 210, 139, 32);
		Dashboard.add(enroll);
		
		JButton reportbtn = new JButton("Get Report");
		reportbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report1 report1 = new Report1(usernameString);
				report1.getFrame().setVisible(true);
			}
		});
		reportbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		reportbtn.setBounds(482, 252, 139, 32);
		Dashboard.add(reportbtn);
		
		if (modeString.equals("Student")) {
			reportbtn.setVisible(true);
		} else {
			reportbtn.setVisible(false);
		}
		
		
		if (modeString.equals("Student")) {
			enroll.setVisible(true);
		} else {
			enroll.setVisible(false);
		}
		
		JPanel Course = new JPanel();
		layeredPane.add(Course, "name_692076877757700");
		Course.setLayout(null);
		
		JLabel lblNewLabel_6_2 = new JLabel("Course");
		lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6_2.setBounds(26, 10, 96, 32);
		Course.add(lblNewLabel_6_2);
		
		JButton updateButton = new JButton("UPDATE");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCourse1 update = new UpdateCourse1();
				update.getFrame().setVisible(true);
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		updateButton.setBounds(440, 64, 120, 32);
		Course.add(updateButton);
		updateButton.setVisible(false);
		
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourse add = new addCourse();
				add.getFrame().setVisible(true);
			}
		});
		addButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		addButton.setBounds(327, 64, 107, 32);
		Course.add(addButton);
		addButton.setVisible(false);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCourse del = new DeleteCourse();
				del.getFrame().setVisible(true);
			}
		});
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		deleteButton.setBounds(570, 64, 107, 32);
		Course.add(deleteButton);
		deleteButton.setVisible(false);
		
		try {
			
			if(modeString.equals("Admin")) {
				updateButton.setVisible(true);
				addButton.setVisible(true);
				deleteButton.setVisible(true);
			} else {
				updateButton.setVisible(false);
				addButton.setVisible(false);
				deleteButton.setVisible(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 679, 325);
		Course.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JComboBox levelCombo = new JComboBox();
		levelCombo.setFont(new Font("Tahoma", Font.BOLD, 18));
		levelCombo.setBounds(440, 458, 120, 32);
		levelCombo.addItem("Level 4");
		levelCombo.addItem("Level 5");
		levelCombo.addItem("Level 6");
		Course.add(levelCombo);
		
		JButton data = new JButton("Get data");
		data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection connection = new MyConnection();
				try {
					Statement stmt = connection.getConnection().createStatement();
					String sql = "";
					int id;
					String name, module1, module2, module3, module4, tutor1, tutor2, tutor3, tutor4;
					String optionalmodule1, optionalmodule2, optionaltutor1, optionaltutor2;
					
					if(levelCombo.getSelectedItem().toString().equals("Level 4")) {
						sql =  "select * from level_4";
					} else if(levelCombo.getSelectedItem().toString().equals("Level 5")) {
						sql =  "select * from level_5";
					} else {
						sql =  "select * from level_6";
					}
					
					ResultSet rs = stmt.executeQuery(sql);
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i =0; i < cols; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					if(!levelCombo.getSelectedItem().toString().equals("Level 6")) {
						while(rs.next()) {
							id = rs.getInt(1);
							name = rs.getString(2);
							module1 = rs.getString(3);
							module2 = rs.getString(4);
							module3 =rs.getString(5);
							module4 = rs.getString(6);
							tutor1 = rs.getString(7);
							tutor2 = rs.getString(8);
							tutor3 = rs.getString(9);
							tutor4 = rs.getString(10);
							
							String[] row = {Integer.toString(id) ,name, module1, module2, module3, module4, tutor1, tutor2, tutor3, tutor4};
							model.addRow(row);
						}
					} else {
						while(rs.next()) {
							id = rs.getInt(1);
							name = rs.getString(2);
							module1 = rs.getString(3);
							module2 = rs.getString(4);
							module3 =rs.getString(5);
							module4 = rs.getString(6);
							optionalmodule1 = rs.getString(7);
							optionalmodule2 = rs.getString(8);
							tutor1 = rs.getString(9);
							tutor2 = rs.getString(10);
							tutor3 = rs.getString(11);
							tutor4 = rs.getString(12);
							optionaltutor1 = rs.getString(13);
							optionaltutor2 = rs.getString(14);
							
							String[] row = {Integer.toString(id) ,name, module1, module2, module3, module4, optionalmodule1,
									optionalmodule2, tutor1, tutor2, tutor3, tutor4, optionaltutor1, optionaltutor2};
							model.addRow(row);
						}
					}
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "No data added till now");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				try {
					Statement stmt = connection.getConnection().createStatement();
					String sql = "";
					sql =  "select * from tutor_details";
					
					ResultSet rs = stmt.executeQuery(sql);
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tutorTable.getModel();
					
					
					int id;
					String name, module1, module2, module3, module4, email, phone_number, part_time;
					while(rs.next()) {
						id = rs.getInt(1);
						name = rs.getString(2);
						module1 = rs.getString(3);
						module2 = rs.getString(4);
						module3 =rs.getString(5);
						module4 = rs.getString(6);
						email = rs.getString(7);
						phone_number = rs.getString(8);
						part_time = rs.getString(9);
						
						String[] row = {Integer.toString(id) ,name, module1, module2, module3, module4, email, phone_number, part_time};
						model.addRow(row);
					}
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "No data added till now");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		});
		data.setFont(new Font("Tahoma", Font.BOLD, 18));
		data.setBounds(570, 458, 119, 32);
		Course.add(data);
		
		JButton clearCourse = new JButton("Clear");
		clearCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		clearCourse.setFont(new Font("Tahoma", Font.BOLD, 18));
		clearCourse.setBounds(205, 458, 119, 32);
		Course.add(clearCourse);
		
		JPanel Tutors = new JPanel();
		layeredPane.add(Tutors, "name_692293867431000");
		Tutors.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tutors");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(26, 10, 96, 32);
		Tutors.add(lblNewLabel_1);
		
		JButton addTutor = new JButton("ADD");
		addTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTutor add = new AddTutor();
				add.getFrame().setVisible(true);
			}
		});
		addTutor.setFont(new Font("Tahoma", Font.BOLD, 18));
		addTutor.setBounds(332, 78, 107, 32);
		Tutors.add(addTutor);
		
		JButton updateTutor = new JButton("UPDATE");
		updateTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTutor1 up = new UpdateTutor1();
				up.getFrame().setVisible(true);
			}
		});
		updateTutor.setFont(new Font("Tahoma", Font.BOLD, 18));
		updateTutor.setBounds(449, 78, 121, 32);
		Tutors.add(updateTutor);
		
		JButton deleteTutor = new JButton("DELETE");
		deleteTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTutor del = new DeleteTutor();
				del.getFrame().setVisible(true);
			}
		});
		deleteTutor.setFont(new Font("Tahoma", Font.BOLD, 18));
		deleteTutor.setBounds(582, 78, 107, 32);
		Tutors.add(deleteTutor);
		
		try {
			if(modeString.equals("Admin")) {
				addTutor.setVisible(true);
				updateTutor.setVisible(true);
				deleteTutor.setVisible(true);
			} else {
				addTutor.setVisible(false);
				updateTutor.setVisible(false);
				deleteTutor.setVisible(false);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 120, 679, 309);
		Tutors.add(scrollPane_1);
		
		tutorTable = new JTable();
		scrollPane_1.setViewportView(tutorTable);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				DefaultTableModel tableModel = (DefaultTableModel) tutorTable.getModel();
//				String search = textField_3.getText().toLowerCase();
//				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
//				tutorTable.setRowSorter(tr);
//				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(10, 78, 286, 26);
		Tutors.add(textField_4);
		
		JButton dataButton = new JButton("Get Data");
		dataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection connection = new MyConnection();
				try {
					Statement stmt = connection.getConnection().createStatement();
					String sql = "";
					sql =  "select * from tutor_details";
					
					ResultSet rs = stmt.executeQuery(sql);
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tutorTable.getModel();
					
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i =0; i < cols; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					int id;
					String name, module1, module2, module3, module4, email, phone_number, part_time;
					while(rs.next()) {
						id = rs.getInt(1);
						name = rs.getString(2);
						module1 = rs.getString(3);
						module2 = rs.getString(4);
						module3 =rs.getString(5);
						module4 = rs.getString(6);
						email = rs.getString(7);
						phone_number = rs.getString(8);
						part_time = rs.getString(9);
						
						String[] row = {Integer.toString(id) ,name, module1, module2, module3, module4, email, phone_number, part_time};
						model.addRow(row);
					}
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "No data added till now");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		dataButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		dataButton.setBounds(341, 439, 121, 32);
		Tutors.add(dataButton);
		
		JButton clearTable = new JButton("Clear");
		clearTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutorTable.setModel(new DefaultTableModel());
			}
		});
		clearTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		clearTable.setBounds(188, 439, 121, 32);
		Tutors.add(clearTable);
		
		JPanel Students = new JPanel();
		layeredPane.add(Students, "name_692369439421900");
		Students.setLayout(null);
		
		JButton addStudentbtn = new JButton("Add");
		addStudentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent addStudent = new AddStudent();
				addStudent.getFrame().setVisible(true);
			}
		});
		addStudentbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		addStudentbtn.setBounds(334, 76, 107, 32);
		Students.add(addStudentbtn);
		
		JButton updateStudentbtn = new JButton("Update");
		updateStudentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent1 up = new UpdateStudent1();
				up.getFrame().setVisible(true);
			}
		});
		updateStudentbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		updateStudentbtn.setBounds(451, 76, 121, 32);
		Students.add(updateStudentbtn);
		
		JButton deleteStudentbtn = new JButton("Delete");
		deleteStudentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent deleteStudent = new DeleteStudent();
				deleteStudent.getFrame().setVisible(true);
			}
		});
		deleteStudentbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		deleteStudentbtn.setBounds(582, 76, 107, 32);
		Students.add(deleteStudentbtn);
		
		try {
			if(modeString.equals("Admin")) {
				addStudentbtn.setVisible(true);
				updateStudentbtn.setVisible(true);
				deleteStudentbtn.setVisible(true);
			} else {
				addStudentbtn.setVisible(false);
				updateStudentbtn.setVisible(false);
				deleteStudentbtn.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel studentlabel = new JLabel("Students");
		studentlabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		studentlabel.setBounds(10, 10, 96, 32);
		Students.add(studentlabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 134, 679, 298);
		Students.add(scrollPane_2);
		
		studentTable = new JTable();
		scrollPane_2.setViewportView(studentTable);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentTable.setModel(new DefaultTableModel());
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		clearButton.setBounds(228, 440, 107, 32);
		Students.add(clearButton);
		
		JButton getDatabtn = new JButton("Get Data");
		getDatabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection connection = new MyConnection();
				try {
					Statement stmt = connection.getConnection().createStatement();
					String sql = "";
					sql =  "select * from student_details";
					
					ResultSet rs = stmt.executeQuery(sql);
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
					
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i =0; i < cols; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					int id;
					String name, email, phone_number, course, address, level_4, level_5, level_6;
					while(rs.next()) {
						id = rs.getInt(1);
						name = rs.getString(2);
						email = rs.getString(3);
						phone_number = rs.getString(4);
						address = rs.getString(5);
						level_4 = rs.getString(6);
						level_5 = rs.getString(7);
						level_6 = rs.getString(8);
						
						String[] row = {Integer.toString(id) ,name, email, phone_number, address, level_4, level_5, level_6};
						model.addRow(row);
					}
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "No data added till now");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		getDatabtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		getDatabtn.setBounds(361, 442, 121, 32);
		Students.add(getDatabtn);
		
		JPanel Setting = new JPanel();
		layeredPane.add(Setting, "name_692430986271200");
		Setting.setLayout(null);
		
		JLabel lblNewLabel_6_3 = new JLabel("Settings");
		lblNewLabel_6_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6_3.setBounds(26, 10, 96, 32);
		Setting.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("General Profile");
		lblNewLabel_6_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6_1_2.setBounds(26, 52, 128, 32);
		Setting.add(lblNewLabel_6_1_2);
		
		JLabel lblNewLabel_6_1_2_1 = new JLabel("Username:");
		lblNewLabel_6_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1_2_1.setBounds(26, 94, 85, 32);
		Setting.add(lblNewLabel_6_1_2_1);
		
		JLabel lblNewLabel_6_1_2_1_1 = new JLabel("Phone Number:");
		lblNewLabel_6_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1_2_1_1.setBounds(26, 136, 105, 32);
		Setting.add(lblNewLabel_6_1_2_1_1);
		
		JLabel lblNewLabel_6_1_2_1_2 = new JLabel("Email:");
		lblNewLabel_6_1_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1_2_1_2.setBounds(329, 94, 85, 32);
		Setting.add(lblNewLabel_6_1_2_1_2);
		
		JLabel lblNewLabel_6_1_2_1_2_1 = new JLabel("DOB:");
		lblNewLabel_6_1_2_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1_2_1_2_1.setBounds(329, 136, 85, 32);
		Setting.add(lblNewLabel_6_1_2_1_2_1);
		
		txtAaravPradhan = new JTextField();
		txtAaravPradhan.setText("Aarav Pradhan");
		txtAaravPradhan.setEditable(false);
		txtAaravPradhan.setBounds(134, 102, 163, 19);
		Setting.add(txtAaravPradhan);
		txtAaravPradhan.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("9803370278");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(134, 144, 163, 19);
		Setting.add(textField_1);
		
		JTextField email = new JTextField();
		
	    email.setText("aarav@gmail.com");
	    email.setEditable(false);
		email.setColumns(10);
		email.setBounds(391, 102, 163, 19);
		Setting.add(email);
		
		JTextField dob = new JTextField();
		dob.setText("jan 12, 2000");
		dob.setColumns(10);
		dob.setEditable(false);
		dob.setBounds(391, 144, 163, 19);
		Setting.add(dob);
		
		JButton btnNewButton_2_1_2_2 = new JButton("Edit Profile");
		btnNewButton_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_1_2_2.setBounds(26, 176, 111, 32);
		Setting.add(btnNewButton_2_1_2_2);
		
		JLabel lblNewLabel_6_1_2_2 = new JLabel("Security");
		lblNewLabel_6_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6_1_2_2.setBounds(26, 231, 128, 32);
		Setting.add(lblNewLabel_6_1_2_2);
		
		JLabel lblNewLabel_6_1_2_1_3 = new JLabel("Old Password:");
		lblNewLabel_6_1_2_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1_2_1_3.setBounds(26, 273, 105, 32);
		Setting.add(lblNewLabel_6_1_2_1_3);
		
		JLabel lblNewLabel_6_1_2_1_3_1 = new JLabel("New Password:");
		lblNewLabel_6_1_2_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1_2_1_3_1.setBounds(329, 273, 105, 32);
		Setting.add(lblNewLabel_6_1_2_1_3_1);
		
		JButton btnNewButton_2_1_2_2_1 = new JButton("Change Password");
		btnNewButton_2_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_1_2_2_1.setBounds(26, 315, 174, 32);
		Setting.add(btnNewButton_2_1_2_2_1);
		
		textField = new JTextField();
		textField.setBounds(134, 281, 163, 19);
		Setting.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(444, 281, 163, 19);
		Setting.add(textField_2);
		
		JButton btnNewButton_2_1_2_2_1_1 = new JButton("Create Report");
		btnNewButton_2_1_2_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateReport report = new CreateReport();
				report.getFrame().setVisible(true);
			}
		});
		btnNewButton_2_1_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_1_2_2_1_1.setBounds(26, 372, 174, 32);
		Setting.add(btnNewButton_2_1_2_2_1_1);
		
		if (modeString.equals("Admin")) {
			btnNewButton_2_1_2_2_1_1.setVisible(true);
		} else {
			btnNewButton_2_1_2_2_1_1.setVisible(false);
		}
		
		
		JPanel Logout = new JPanel();
		layeredPane.add(Logout, "name_692500323998100");
		Logout.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Do you want to Log Out?");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(184, 66, 362, 141);
		Logout.add(lblNewLabel_5);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login login = new Login();
				login.getFrame().setVisible(true);
			}
		});
		btnYes.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnYes.setBounds(206, 232, 139, 32);
		Logout.add(btnYes);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Dashboard);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(25, 100, 161, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Course);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1.setBounds(25, 150, 161, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Tutors");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(Tutors);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1_1.setBounds(25, 200, 161, 40);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Students");
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Students);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_1_1.setBounds(25, 250, 161, 40);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Settings");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(Setting);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			
		});
		btnNewButton_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1_1_1_1.setBounds(25, 300, 161, 40);
		frame.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Log Out");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Logout);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1_1_1_1_1.setBounds(25, 350, 161, 40);
		frame.getContentPane().add(btnNewButton_1_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(modeString);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(46, 37, 122, 20);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
