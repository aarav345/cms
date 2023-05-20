package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddMarks {

	private JFrame frame;
	private JTextField module1Field;
	private JTextField module2Field;
	private JTextField module3Field;
	private JTextField module4Field;
	
	

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
					AddMarks window = new AddMarks();
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
	public AddMarks() {
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
		
		JLabel addMarksLabel = new JLabel("Enter Marks");
		addMarksLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		addMarksLabel.setBounds(168, 40, 267, 37);
		frame.getContentPane().add(addMarksLabel);
		
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
		comboBox.setBounds(176, 386, 107, 26);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JButton addMarksButton = new JButton("Add");
		addMarksButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		addMarksButton.setBounds(176, 436, 103, 35);
		frame.getContentPane().add(addMarksButton);
		
		JComboBox courseField = new JComboBox();
		courseField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		courseField.setBounds(158, 166, 223, 26);
		frame.getContentPane().add(courseField);
		
		JLabel lblModuleMarks = new JLabel("Module1 marks:");
		lblModuleMarks.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModuleMarks.setBounds(10, 212, 132, 26);
		frame.getContentPane().add(lblModuleMarks);
		
		JLabel lblModuleMarks_1 = new JLabel("Module1 marks:");
		lblModuleMarks_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModuleMarks_1.setBounds(10, 248, 132, 26);
		frame.getContentPane().add(lblModuleMarks_1);
		
		JLabel lblModuleMarks_1_1 = new JLabel("Module1 marks:");
		lblModuleMarks_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModuleMarks_1_1.setBounds(10, 294, 132, 26);
		frame.getContentPane().add(lblModuleMarks_1_1);
		
		JLabel lblModuleMarks_1_1_1 = new JLabel("Module1 marks:");
		lblModuleMarks_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModuleMarks_1_1_1.setBounds(10, 334, 132, 26);
		frame.getContentPane().add(lblModuleMarks_1_1_1);
		
		module1Field = new JTextField();
		module1Field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
				
				
				if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)) {
					
					module1Field.setEditable(true);
				} else {
					module1Field.setEditable(false);
				}
			}
		});
		module1Field.setBounds(158, 211, 223, 26);
		frame.getContentPane().add(module1Field);
		module1Field.setColumns(10);
		
		module2Field = new JTextField();
		module2Field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
				
				
				if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)) {
					
					module2Field.setEditable(true);
				} else {
					module2Field.setEditable(false);
				}
			}
		});
		module2Field.setColumns(10);
		module2Field.setBounds(158, 248, 223, 26);
		frame.getContentPane().add(module2Field);
		
		module3Field = new JTextField();
		module3Field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
				
				
				if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)) {
					
					module3Field.setEditable(true);
				} else {
					module3Field.setEditable(false);
				}
			}
		});
		module3Field.setColumns(10);
		module3Field.setBounds(158, 294, 223, 26);
		frame.getContentPane().add(module3Field);
		
		module4Field = new JTextField();
		module4Field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
				
				
				if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)) {
					
					module4Field.setEditable(true);
				} else {
					module4Field.setEditable(false);
				}
			}
		});
		module4Field.setColumns(10);
		module4Field.setBounds(158, 334, 223, 26);
		frame.getContentPane().add(module4Field);
		
		try {

			MyConnection con = new MyConnection();
			
			Statement stmt = con.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select course from student");
			
			while(rs.next()) {
				
				courseField.addItem(rs.getString("course"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		addMarksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection connection = new MyConnection();
				
				DatabaseCreation creation = new DatabaseCreation(connection.getConnection());

				
				creation.updateMarks(comboBox.getSelectedItem().toString(), nameField.getSelectedItem().toString(),courseField.getSelectedItem().toString(),
						module1Field.getText(), module2Field.getText(), module3Field.getText(), module4Field.getText());
				JOptionPane.showMessageDialog(frame, "Successfully Added marks");
			}	
		});
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}
}
