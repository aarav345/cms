package cms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
	

	private String emailString;
	
	public EmailValidation(String emailString) {
		this.emailString = emailString;
	}
	
	
	
	public int checkEmail() {
		int val = 0;
		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		Pattern pattern = Pattern.compile(regexPattern);   
          
		System.out.println(emailString);
        Matcher matcher = pattern.matcher(emailString);
        
        if(matcher.matches()==true) {
        	val = 1;
        } else {
        	val = 0;
        }
        
        return val;
        
        

	}
	
}
