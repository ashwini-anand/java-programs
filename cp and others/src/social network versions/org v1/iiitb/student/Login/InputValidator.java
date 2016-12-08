package org.iiitb.student.Login;

import javax.swing.*;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class InputValidator {
	public static boolean isTextFieldEmpty(JPanel container,JTextField textField,String message,boolean displayMessage)
	{
		boolean empty=false;
		if(textField.getText().trim().length()==0)
		{
			
			empty=true;
			if(displayMessage) JOptionPane.showMessageDialog(container, message);
			textField.requestFocus();
		}
		return empty;
	}
	public static boolean isPasswordandConfPasswordEqual(JPanel container,JTextField pass,JTextField cpass,String  message,boolean displayMessage)
	{
	     boolean equal=false;
	     String a=pass.getText().trim();
	     String b=cpass.getText().trim();
	     if(!(a.equals(b)))
	     {
	    	 equal=true;
	    	 if(displayMessage) JOptionPane.showMessageDialog(container, message);
	    	 pass.setText("");
	    	 cpass.setText("");
	    	 pass.requestFocus();
	     }
	     return equal;
	}
	public static boolean isNotNumber(JPanel container,JTextField textField,String message,boolean displayMessage)
	{    
		boolean num=false;
		Pattern patternMob;
	     Matcher matcherMob;
	     
	     String MOBILE_PATTERN = "\\d{10}";
	     patternMob = Pattern.compile(MOBILE_PATTERN);
	     matcherMob = patternMob.matcher(textField.getText());
	     if(!(matcherMob.matches()))
	     {
	    	 num=true;
	    	 if(displayMessage) JOptionPane.showMessageDialog(container, message);
	    	 textField.setText("");
	    	 textField.requestFocus();
	     }
	     return num;
	}
	public  static boolean isEmailFormat(JPanel container,JTextField textField,String message,boolean displyaMessage)
	{
	    boolean valid=false;
	    Pattern patternEmail;
	    Matcher matcherEmail;
	    
	    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	    
	    patternEmail=Pattern.compile(EMAIL_PATTERN);
	    matcherEmail=patternEmail.matcher(textField.getText());
	    
	    if(!(matcherEmail.matches()))
	    {
	    	valid=true;
	    	if(displyaMessage) JOptionPane.showMessageDialog(container, message);
	    	textField.setText("");
	    	textField.requestFocus();
	    }
	    
	    return valid;
	   
	    
	}

}