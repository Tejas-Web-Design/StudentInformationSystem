/*
 Project: Student Information System
 Author: Tejasri Konidena
 Language: Java
 Description: Console-based student management application
*/


import java.util.ArrayList;

public class StudentManager {

	private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add Student
    public boolean addStudent(Student student) {

        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(student.getStudentId())) {
                return false; // Duplicate ID
            }
        }

        students.add(student);
        return true;
    }

    // View All Students
    public void viewAllStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records found.");
            return;
        }

        System.out.println("\n================================================================================");
        System.out.printf("%-10s %-20s %-8s %-10s %-20s%n",
                "ID", "NAME", "AGE", "GRADE", "CONTACT");
        System.out.println("================================================================================");

        for (Student s : students) {
            System.out.printf("%-10s %-20s %-8d %-10.2f %-20s%n",
                    s.getStudentId(),
                    s.getName(),
                    s.getAge(),
                    s.getGrade(),
                    s.getContact());
        }

        System.out.println("================================================================================");
    }

    // Search By ID
    public Student searchById(String studentId) {

        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                return s;
            }
        }

        return null;
    }

    // Search By Name
    public ArrayList<Student> searchByName(String name) {

        ArrayList<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }

        return result;
    }

    // Update Student
    public boolean updateStudent(String studentId,
                                 String name,
                                 int age,
                                 double grade,
                                 String contact) {

        Student student = searchById(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);
        student.setContact(contact);

        return true;
    }

    // Delete Student
    public boolean deleteStudent(String studentId) {

        Student student = searchById(studentId);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    // Get Student List
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Set Student List
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
	
}
