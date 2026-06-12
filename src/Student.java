/*
 Project: Student Information System
 Author: Tejasri Konidena
 Language: Java
 Description: Console-based student management application
*/


public class Student {

	private String studentId;
	private String name;
	private int age;
	private double grade;
	private String contact;
	
	public Student(String studentId, String name, int age, double grade, String contact) {
		
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.contact = contact;
	}
	
	// Getter & Setter Methods
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	// Display student details
    public void displayStudent() {
        System.out.println("\n--------------------------------");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Grade      : " + grade);
        System.out.println("Contact    : " + contact);
        System.out.println("--------------------------------");
    }

    // Save to file format
    @Override
    public String toString() {
        return studentId + "," + name + "," + age + "," + grade + "," + contact;
    }
}
