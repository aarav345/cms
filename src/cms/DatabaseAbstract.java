package cms;

public abstract class DatabaseAbstract {

	public abstract void databaseCreation(String table);
	
	public abstract void insertDataRegister(String name, String email, String dob, String phone, String passwordField, String gender, String mode, String course);
	
	public abstract void createCourseTable(String level);	
	
	public abstract void createTutorTable();
	
	public abstract void createStudentTable();
	
	public abstract void createMarksTable(String level);


}
