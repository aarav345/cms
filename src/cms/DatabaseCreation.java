package cms;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import java.sql.*;

public class DatabaseCreation extends DatabaseAbstract {
	
	private Connection con;
	
	public DatabaseCreation(Connection con) {
		this.con = con;
	}
	
	public int tableExist(String tablename) {
		int val = 0;
		ResultSet rsResultSet;
		try {
			
			
			DatabaseMetaData dbData = con.getMetaData();
			if(tablename=="Admin" || tablename=="Tutor") {
				rsResultSet = dbData.getTables(null, null, "Registration" , null);
			} else {
				rsResultSet = dbData.getTables(null, null, tablename , null);
			}
			
			if(rsResultSet.next()) {
				val = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return val;

		
		
	}

@Override
public void databaseCreation(String tablename) {
		
		try {
			
			String sql;
			
			Statement stmt = con.createStatement();
			if(tablename=="Student") {
				
				sql = "CREATE TABLE Student " +
		                   "(id INTEGER not NULL AUTO_INCREMENT, " +
		                   " name VARCHAR(255) not NULL, " + 
		                   " email VARCHAR(255) not NULL, " + 
		                   " password VARCHAR(255) not NULL, " + 
		                   " dob VARCHAR(255) not NULL, " +
		                   " phoneNumber VARCHAR(20) not NULL, " +
		                   " gender VARCHAR(20) not NULL, " + 
		                   " course VARCHAR(20) not NULL, " + 
		                   " PRIMARY KEY ( id ))"; 
				
				
				System.out.println("Created table Student in given database..."); 
			} else {
				
				sql = "CREATE TABLE REGISTRATION " +
		                   "(id INTEGER not NULL AUTO_INCREMENT, " +
		                   " name VARCHAR(255) not NULL , " + 
		                   " email VARCHAR(255) not NULL, " + 
		                   " password VARCHAR(255) not NULL, " + 
		                   " dob VARCHAR(255) not NULL, " +
		                   " phoneNumber VARCHAR(20) not NULL, " +
		                   " gender VARCHAR(20) not NULL, " + 
		                   " mode VARCHAR(20) not NULL, " + 
		                   " PRIMARY KEY ( id ))"; 
				
	
				System.out.println("Created table Registration in given database..."); 
			}
			
			stmt.executeUpdate(sql);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}


public void insertDataRegister(String name, String email, String dob, String phone, String passwordField, String gender, String mode, String course) {
    try {
    	
    	String sql;
    	if(mode.equals("Student")) {
    		sql = "insert into Student (name, email, password, dob, phoneNumber, gender, course)"
    			    + " values (?, ?, ?, ?, ?, ?, ?)";
    		 PreparedStatement preparedStmt = con.prepareStatement(sql);
    		  preparedStmt.setString (1, name);
    		  preparedStmt.setString (2, email);
            preparedStmt.setString (3, passwordField);
    		  preparedStmt.setString (4, dob);
    		  preparedStmt.setString(5, phone);
    		  preparedStmt.setString (6, gender);
    		  preparedStmt.setString (7, course);
    		  preparedStmt.executeUpdate();
    	} else {
    		sql = "insert into registration (name, email, password, dob, phoneNumber, gender, mode)"
    			    + " values (?, ?, ?, ?, ?, ?, ?)";
    		 PreparedStatement preparedStmt = con.prepareStatement(sql);
    		  preparedStmt.setString (1, name);
    		  preparedStmt.setString (2, email);
            preparedStmt.setString (3, passwordField);
    		  preparedStmt.setString (4, dob);
    		  preparedStmt.setString    (5, phone);
    		  preparedStmt.setString (6, gender);
    		  preparedStmt.setString (7, mode);
    		  preparedStmt.executeUpdate();
    		  
    	}
		con.close();
	    System.out.println("You have successfully Register your account");

		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}

@Override
public void createCourseTable(String level) {
	try {
		
		String sql;
		
		Statement stmt = con.createStatement();
		if(level=="Level_4") {
			
			sql = "CREATE TABLE Level_4 " +
	                   "(id INTEGER not NULL AUTO_INCREMENT, " +
	                   " course VARCHAR(255) not NULL, " + 
	                   " module1 VARCHAR(255) not NULL, " + 
	                   " module2 VARCHAR(255) not NULL, " + 
	                   " module3 VARCHAR(255) not NULL, " +
	                   " module4 VARCHAR(255) not NULL, " +
	                   " tutor1 VARCHAR(255) not NULL, " + 
	                   " tutor2 VARCHAR(255) not NULL, " + 
	                   " tutor3 VARCHAR(255) not NULL, " + 
	                   " tutor4 VARCHAR(255) not NULL, " + 
	                   " PRIMARY KEY ( id ))"; 
			
		} else if(level=="Level_5") {
			
			sql = "CREATE TABLE Level_5 " +
	                   "(id INTEGER not NULL AUTO_INCREMENT, " +
	                   " course VARCHAR(255) not NULL, " + 
	                   " module1 VARCHAR(255) not NULL, " + 
	                   " module2 VARCHAR(255) not NULL, " + 
	                   " module3 VARCHAR(255) not NULL, " +
	                   " module4 VARCHAR(255) not NULL, " +
	                   " tutor1 VARCHAR(255) not NULL, " + 
	                   " tutor2 VARCHAR(255) not NULL, " + 
	                   " tutor3 VARCHAR(255) not NULL, " + 
	                   " tutor4 VARCHAR(255) not NULL, " + 
	                   " PRIMARY KEY ( id ))";
			
			
		} else {
			sql = "CREATE TABLE Level_6 " +
	                   "(id INTEGER not NULL AUTO_INCREMENT, " +
	                   " course VARCHAR(255) not NULL, " + 
	                   " module1 VARCHAR(255) not NULL, " + 
	                   " module2 VARCHAR(255) not NULL, " + 
	                   " module3 VARCHAR(255) not NULL, " +
	                   " module4 VARCHAR(255) not NULL, " +
	                   " optional1 VARCHAR(255) not NULL, " +
	                   " optional2 VARCHAR(255) not NULL, " +
	                   " tutor1 VARCHAR(255) not NULL, " + 
	                   " tutor2 VARCHAR(255) not NULL, " + 
	                   " tutor3 VARCHAR(255) not NULL, " + 
	                   " tutor4 VARCHAR(255) not NULL, " + 
	                   " optionaltutor1 VARCHAR(255) not NULL, " + 
	                   " optionaltutor2 VARCHAR(255) not NULL, " + 
	                   " PRIMARY KEY ( id ))";
			
		}
		
		stmt.executeUpdate(sql);
		System.out.println(level + " table created.....");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}


public void addCourseTable(String level, String course, String module1, String module2, String module3, String module4, String tutor1, String tutor2,
		String tutor3, String tutor4) {
	
	String sql = "";
	try {
		
		if(level=="Level_4") {
			sql = "INSERT INTO level_4 (course, module1, module2, module3, module4, tutor1, tutor2, tutor3, tutor4) VALUES (?,?,?,?,?,?,?,?,?)";
		} else {
			sql = "INSERT INTO level_5 (course, module1, module2, module3, module4, tutor1, tutor2, tutor3, tutor4) VALUES (?,?,?,?,?,?,?,?,?)";
		}
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, course);
		stmt.setString(2, module1);
		stmt.setString(3, module2);
		stmt.setString(4, module3);
		stmt.setString(5, module4);
		stmt.setString(6, tutor1);
		stmt.setString(7, tutor2);
		stmt.setString(8, tutor3);
		stmt.setString(9, tutor4);
		stmt.executeUpdate();
		con.close();
		System.out.println(level + " added in table.");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}


public void addCourseTable(String course, String module1, String module2, String module3, String module4, String tutor1, String tutor2,
		String tutor3, String tutor4, String optionalmodule1, String optionalModule2, String optionalTutor1, String optionalTutor2) {
	
	try {
		String sql= "INSERT INTO level_6(course, module1, module2, module3, module4, optional1, optional2, tutor1, tutor2, tutor3, tutor4, optionaltutor1, optionaltutor2) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, course);
		stmt.setString(2, module1);
		stmt.setString(3, module2);
		stmt.setString(4, module3);
		stmt.setString(5, module4);
		stmt.setString(6, optionalmodule1);
		stmt.setString(7,optionalModule2);
		stmt.setString(8, tutor1);
		stmt.setString(9, tutor2);
		stmt.setString(10, tutor3);
		stmt.setString(11, tutor4);
		stmt.setString(12, optionalTutor1);
		stmt.setString(13, optionalTutor2);
		stmt.executeUpdate();
		con.close();
		System.out.println("added in table level_6");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}


public void updateCourseTable(String level, String course, String module1, String module2, String module3, String module4, String tutor1, String tutor2,
		String tutor3, String tutor4) {
	String sql="";
	try {
		if(level=="Level_4") {
			sql = "update level_4 set module1=?,module2=?, module3=?, module4=?, tutor1=?, tutor2=?, tutor3=?, tutor4=? where course=?";
		} else {
			sql = "update level_5 set module1=?,module2=?, module3=?, module4=?, tutor1=?, tutor2=?, tutor3=?, tutor4=? where course=?";
		}
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, module1);
		stmt.setString(2, module2);
		stmt.setString(3, module3);
		stmt.setString(4, module4);
		stmt.setString(5, tutor1);
		stmt.setString(6, tutor2);
		stmt.setString(7, tutor3);
		stmt.setString(8, tutor4);
		stmt.setString(9, course);
		stmt.executeUpdate();
		con.close();
		System.out.println(level + " updated in table.");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}


public void updateCourseTable(String course, String module1, String module2, String module3, String module4, String tutor1, String tutor2,
		String tutor3, String tutor4, String optionalmodule1, String optionalModule2, String optionalTutor1, String optionalTutor2) {
	try {
		
		String sql= "update level_6 set module1=?,module2=?, module3=?, module4=?, optional1=?, optional2=?"
				+ " tutor1=?, tutor2=?, tutor3=?, tutor4=?, optionaltutor1=?, optionaltutor2=? where course=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, module1);
		stmt.setString(2, module2);
		stmt.setString(3, module3);
		stmt.setString(4, module4);
		stmt.setString(5, optionalmodule1);
		stmt.setString(6,optionalModule2);
		stmt.setString(7, tutor1);
		stmt.setString(8, tutor2);
		stmt.setString(9, tutor3);
		stmt.setString(10, tutor4);
		stmt.setString(11, optionalTutor1);
		stmt.setString(12, optionalTutor2);
		stmt.setString(13, course);
		stmt.executeUpdate();
		con.close();
		System.out.println("updated in table level_6");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}


@Override
// database operations for tutor
public void createTutorTable() {
	// TODO Auto-generated method stub
	
	
	try {
		String sql="";
		Statement stmt = con.createStatement();
		sql = "CREATE TABLE tutor_details " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " name VARCHAR(255) not NULL, " + 
                " module1 VARCHAR(255) , " + 
                " module2 VARCHAR(255) , " + 
                " module3 VARCHAR(255) , " +
                " module4 VARCHAR(255) , " +
                " email VARCHAR(255) not NULL, " + 
                " phone_number VARCHAR(255) not NULL, " + 
                " part_time VARCHAR(20) not NULL, " +
                " PRIMARY KEY ( id ))";
		stmt.executeUpdate(sql);
		System.out.println("tutor_details table created.");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void addTutorTable(String name, String module1, String module2, String module3, String module4, String email, 
		String phone_number, String part_time) {
	
	try {
		String sql= "INSERT INTO tutor_details(name, module1, module2, module3, module4, email, phone_number, part_time) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, module1);
		stmt.setString(3, module2);
		stmt.setString(4, module3);
		stmt.setString(5, module4);
		stmt.setString(6, email);
		stmt.setString(7, phone_number);
		stmt.setString(8, part_time);
		
		stmt.executeUpdate();
		con.close();
		System.out.println("added in table tutor_details");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void updateTutorTable(String name, String module1, String module2, String module3, String module4, String email, 
		String phone_number, String part_time) {
	
	try {
		String sql= "update tutor_details set module1=?,module2=?, module3=?, module4=?, email=?, phone_number=?, part_time=?"
				+ " where name=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, module1);
		stmt.setString(2, module2);
		stmt.setString(3, module3);
		stmt.setString(4, module4);
		stmt.setString(5, email);
		stmt.setString(6,phone_number);
		stmt.setString(7, part_time);
		stmt.setString(8, name);
		stmt.executeUpdate();
		con.close();
		System.out.println("Updated details in tutor_details.");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}


@Override
public void createStudentTable() {
	try {
		String sql="";
		Statement stmt = con.createStatement();
		sql = "CREATE TABLE Student_details " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " name VARCHAR(255) not NULL, " + 
                " email VARCHAR(255) not NULL, " + 
                " phone_number VARCHAR(255) not NULL, " + 
                " course VARCHAR(255), " + 
                " address VARCHAR(255) not NULL, " +
                "level_4 VARCHAR(50), " +
                "level_5 VARCHAR(50), " +
                "level_6 VARCHAR(50), " +
                " PRIMARY KEY ( id ))";
		stmt.executeUpdate(sql);
		System.out.println("Student_details table created.");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void addStudentTable(String name, String email, String phonenumber, String course, String address,
		String level_4) {
	try {
		String sql= "INSERT INTO Student_details(name, email, phone_number, course, address, level_4)"
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, email);
		stmt.setString(3, phonenumber);
		stmt.setString(4, course);
		stmt.setString(5, address);
		stmt.setString(6, level_4);
//		stmt.setString(7, level_5);
//		stmt.setString(8, level_6);
		
		stmt.executeUpdate();
		con.close();
		System.out.println("added in table Student_details");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}


public void updateStudentTable(String name, String email, String phonenumber, String course, String address,
		String level_4, String level_5, String level_6) {
	
	try {
		String sql= "update student_details set email=?,phone_number=?, course=?, address=?, level_4=?, level_5=?, level_6=?"
				+ " where name=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, phonenumber);
		stmt.setString(3, course);
		stmt.setString(4, address);
		stmt.setString(5, level_4);
		stmt.setString(6, level_5);
		stmt.setString(7, level_6);
		stmt.setString(8, name);
		stmt.executeUpdate();
		con.close();
		System.out.println("Updated details in student_details.");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}






@Override
public void createMarksTable(String level) {
	
	try {
		String sql="";
		Statement stmt = con.createStatement();
		
		if(level.equals("Level 4")) {
			
			sql = "CREATE TABLE level_4_marks " +
	                "(id INTEGER not NULL AUTO_INCREMENT, " +
	                " name VARCHAR(255) not NULL, " + 
	                "course VARCHAR(255) not NULL," +
	                " module1_marks VARCHAR(255), " + 
	                " module2_marks VARCHAR(255), " + 
	                " module3_marks VARCHAR(255), " + 
	                " module4_marks VARCHAR(255), " + 
	                " report VARCHAR(255), " + 
	                " PRIMARY KEY ( id ))";
			
		} else if(level.equals("Level 5")) {
			sql = "CREATE TABLE level_5_marks " +
	                "(id INTEGER not NULL AUTO_INCREMENT, " +
	                " name VARCHAR(255) not NULL, " + 
	                "course VARCHAR(255) not NULL," +
	                " module1_marks VARCHAR(255), " + 
	                " module2_marks VARCHAR(255), " + 
	                " module3_marks VARCHAR(255), " + 
	                " module4_marks VARCHAR(255), " + 
	                " report VARCHAR(255), " + 
	                " PRIMARY KEY ( id ))";
		} else {
			sql = "CREATE TABLE level_6_marks " +
	                "(id INTEGER not NULL AUTO_INCREMENT, " +
	                " name VARCHAR(255) not NULL, " + 
	                "course VARCHAR(255) not NULL," +
	                " module1 VARCHAR(255), " + 
	                " module2 VARCHAR(255), " + 
	                " module3 VARCHAR(255), " + 
	                " module4 VARCHAR(255), " + 
	                " module1_marks VARCHAR(255), " +
	                " module2_marks VARCHAR(255), " +
	                " module3_marks VARCHAR(255), " +
	                " module4_marks VARCHAR(255), " +
	                " report VARCHAR(255), " + 
	                " PRIMARY KEY ( id ))";
		}
		
		
		stmt.executeUpdate(sql);
		System.out.println(level + "marks table created.");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}


public void addMarks(String name, String course, String moulde1_marks,
		String moulde2_marks, String moulde3_marks, String moulde4_marks, String report, String level) {
	try {
		
		String sql = "";
		
		if(level.equals("Level 4")) {
			sql= "INSERT INTO level_4_marks(name, course, module1_marks, module2_marks, module3_marks, module4_marks, report)"
					+ "VALUES (?,?,?,?,?,?,?)";
		} else if(level.equals("Level 5")) {
			sql= "INSERT INTO level_5_marks(name, course, module1_marks, module2_marks, module3_marks, module4_marks, report)"
					+ "VALUES (?,?,?,?,?,?,?)";
		}
		
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, course);
		stmt.setString(3, moulde1_marks);
		stmt.setString(4, moulde2_marks);
		stmt.setString(5, moulde3_marks);
		stmt.setString(6, moulde4_marks);
		stmt.setString(7, report);

		stmt.executeUpdate();
		con.close();
		System.out.println("marks added in database.");
		JOptionPane.showMessageDialog(null, "Successfully enrolled");
		
	} catch (SQLIntegrityConstraintViolationException e1) {
		JOptionPane.showMessageDialog(null, "info not added by admin.");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void addMarks(String name, String course, String moulde1_marks,
		String moulde2_marks, String moulde3_marks, String moulde4_marks,
		String module1, String module2, String module3, String module4, String report) {
	try {
		String sql = "INSERT INTO level_6_marks(name, course, module1, module2, module3, module4, module1_marks, module2_marks, module3_marks, module4_marks, report)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, course);
		stmt.setString(3, module1);
		stmt.setString(4, module2);
		stmt.setString(5, module3);
		stmt.setString(6, module4);
		stmt.setString(7, moulde1_marks);
		stmt.setString(8, moulde2_marks);
		stmt.setString(9, moulde3_marks);
		stmt.setString(10, moulde4_marks);
		stmt.setString(11, report);
		
		
		stmt.executeUpdate();
		con.close();
		System.out.println("marks addded in database");
		JOptionPane.showMessageDialog(null, "Successfully enrolled");
	
	} catch (SQLIntegrityConstraintViolationException e1) {
		JOptionPane.showMessageDialog(null, "info not added by admin.");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void updateMarks(String level, String name, String course, String module1marks, String module2marks, String module3marks, String module4marks ) {
	
	try {
		
		String sql;
		
		if (level.equals("Level 4")) {
				sql= "update level_4_marks set module1_marks=?, module2_marks=?, module3_marks=?, module4_marks=?"
						+ " where name=? and course = ?";
		} else if (level.equals("Level 5")) {
			sql= "update level_5_marks set module1_marks=?, module2_marks=?, module3_marks=?, module4_marks=?"
					+ " where name=? and course = ?";
		} else  
		{
			sql= "update level_6_marks set module1_marks=?, module2_marks=?, module3_marks=?, module4_marks=?"
					+" where name=? and course = ?";
		}
		
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, module1marks);
		stmt.setString(2, module2marks);
		stmt.setString(3, module3marks);
		stmt.setString(4, module4marks);
		stmt.setString(5, name);
		stmt.setString(6, course);
		stmt.executeUpdate();
		con.close();
		System.out.println("Updated details in marks table");
	}catch (SQLSyntaxErrorException e) {
		AddMarks add = new AddMarks();
		JOptionPane.showMessageDialog(add.getFrame(), "Student not enrolled yet.....");
	} catch (Exception e) {
		e.printStackTrace();
	}

	
}








}



