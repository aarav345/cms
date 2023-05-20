package cms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLSyntaxErrorException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteTutor {

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
					DeleteTutor window = new DeleteTutor();
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
	public DeleteTutor() {
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
		
		JLabel deleteLabel = new JLabel("Delete Tutor");
		deleteLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		deleteLabel.setBounds(153, 32, 150, 37);
		frame.getContentPane().add(deleteLabel);
		
		JLabel namelabel = new JLabel("Tutor name:");
		namelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		namelabel.setBounds(39, 164, 115, 26);
		frame.getContentPane().add(namelabel);
		
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
					
					
					if(idField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty id field");
					} else if (courseField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Empty course field");
					} else {
						sql = "Delete from tutor_details where id=? and name=?";
				
					}
					
					PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
					stmt.setInt(1, Integer.parseInt(idField.getText()) );
					stmt.setString(2, courseField.getText());
					
					rs = stmt.executeUpdate();
					if(rs==1) {
						JOptionPane.showMessageDialog(frame, "Deleted tutor from tutor_details");
					} else {
						JOptionPane.showMessageDialog(frame, "Data not found..");
					}
	                
	                
	         
				} catch (SQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(frame, "First add tutor and delete.");
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
