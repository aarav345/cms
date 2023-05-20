package cms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.w3c.dom.css.CSSStyleDeclaration;

import java.awt.Font;

public class Report {

	private JFrame frame;
	private static String nameString;
	private static String courseString;
	private static String module1String;
	private static String module2String;
	private static String module3String;
	private static String module4String;
	private static String levelString;
	
	
	

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
					Report window = new Report(nameString, courseString, module1String, module2String, module3String, module4String, levelString);
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
	public Report(String nameString, String courseString, String module1String, String module2String, String module3String, String module4String,
			String levelString) {
		this.nameString = nameString;
		this.courseString = courseString;
		this.module1String = module1String;
		this.module2String = module2String;
		this.module3String = module3String;
		this.module4String = module4String;
		this.levelString = levelString;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 514, 521);
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marks Sheet");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(154, 39, 130, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 18));
		name.setBounds(97, 110, 61, 22);
		frame.getContentPane().add(name);
		
		JLabel nameLabel = new JLabel("New label");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		nameLabel.setBounds(189, 110, 141, 22);
		frame.getContentPane().add(nameLabel);
		nameLabel.setText(nameString);
		
		JLabel courseLabel = new JLabel("New label");
		courseLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		courseLabel.setBounds(189, 152, 141, 23);
		frame.getContentPane().add(courseLabel);
		courseLabel.setText(courseString);
		
		JLabel module1Label = new JLabel("New label");
		module1Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		module1Label.setBounds(189, 185, 156, 22);
		frame.getContentPane().add(module1Label);
		module1Label.setText(module1String);
		
		
		JLabel module2Label = new JLabel("New label");
		module2Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		module2Label.setBounds(189, 222, 141, 22);
		frame.getContentPane().add(module2Label);
		module2Label.setText(module2String);
		
		JLabel module3Label = new JLabel("New label");
		module3Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		module3Label.setBounds(189, 258, 123, 28);
		frame.getContentPane().add(module3Label);
		module3Label.setText(module3String);
		
		JLabel module4Label = new JLabel("New label");
		module4Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		module4Label.setBounds(189, 296, 141, 29);
		frame.getContentPane().add(module4Label);
		module4Label.setText(module4String);
		
		JLabel course = new JLabel("Course:");
		course.setFont(new Font("Tahoma", Font.BOLD, 18));
		course.setBounds(97, 152, 77, 22);
		frame.getContentPane().add(course);
		
		JLabel module1 = new JLabel("Module1:");
		module1.setFont(new Font("Tahoma", Font.BOLD, 18));
		module1.setBounds(77, 189, 97, 22);
		frame.getContentPane().add(module1);
		
		JLabel module2 = new JLabel("Module2:");
		module2.setFont(new Font("Tahoma", Font.BOLD, 18));
		module2.setBounds(77, 222, 97, 22);
		frame.getContentPane().add(module2);
		
		JLabel module3 = new JLabel("Module3:");
		module3.setFont(new Font("Tahoma", Font.BOLD, 18));
		module3.setBounds(77, 261, 97, 22);
		frame.getContentPane().add(module3);
		
		JLabel module4 = new JLabel("Module4:");
		module4.setFont(new Font("Tahoma", Font.BOLD, 18));
		module4.setBounds(77, 304, 97, 22);
		frame.getContentPane().add(module4);
		
		JLabel level = new JLabel("Module4:");
		level.setFont(new Font("Tahoma", Font.BOLD, 18));
		level.setBounds(154, 366, 97, 22);
		frame.getContentPane().add(level);
		level.setText(levelString);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		System.out.println(nameString);
	}

}
