/*
 Project: Student Information System
 Author: Tejasri Konidena
 Language: Java
 Description: Console-based student management application
*/


public class ValidationUtils {
	
	
	 public static boolean isValidAge(int age) {
	        return age > 0 && age <= 100;
	    }

	    public static boolean isValidGrade(double grade) {
	        return grade >= 0 && grade <= 100;
	    }

	    public static boolean isValidName(String name) {
	        return name != null && !name.trim().isEmpty();
	    }

	    public static boolean isValidStudentId(String id) {
	        return id != null && !id.trim().isEmpty();
	    }

	    public static boolean isValidContact(String contact) {
	        return contact != null && !contact.trim().isEmpty();
	    }
	    
	    
}
