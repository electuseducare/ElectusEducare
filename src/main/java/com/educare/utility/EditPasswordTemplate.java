package com.educare.utility;

public class EditPasswordTemplate {

	
	public static String updatPasswordTemplate()
	{
		String response="Student Name : <Lname> <Fname>,\n"
				+ "User Name : <Uname> and Student Id : <sid> has changed the Password to <pwd> \n\n\n"
				+ " \n\n\n" 
				+ " \n\n\n" 
			    + " Thanks and Regards,\n"
				+ " <school>. \n\n\n";
				
		return response;
		
	}
	public static String updatPassword()
	{
		String response="Your Login Password is : <password> \n"
				+ " \n\n\n" 
				+ " \n\n\n" 
				+ " Thanks and Regards,\n"
				+ " <school>. \n\n\n";
		
		return response;
		
	}
	
	public static String updatPasswordProfile()
	{
		String response="Student Name : <lname> <name>,\n"
				+ "Student Id : <sid> and User Id : <uid>  has changed the Password to <pwd> \n\n\n"
				+ " \n\n\n" 
				+ " \n\n\n" 
				+ " Thanks and Regards,\n"
				+ " <school>. \n\n\n";
		
		return response;
		
	}
	
}
