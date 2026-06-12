
/*
 Project: Student Information System
 Author: Tejasri Konidena
 Language: Java
 Description: Console-based student management application
*/


import java.util.ArrayList;
import java.util.Scanner;

public class StudentInformationSystem {

	private static Scanner scanner = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        // Load saved data
        manager.setStudents(FileHandler.loadStudents());

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("   STUDENT INFORMATION SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        manager.viewAllStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        FileHandler.saveStudents(manager.getStudents());
                        break;

                    case 7:
                        FileHandler.saveStudents(manager.getStudents());
                        System.out.println("\nData saved successfully.");
                        System.out.println("Thank you for using the system!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                choice = 0;
            }

        } while (choice != 7);

        scanner.close();
    }

    // =============================
    // ADD STUDENT
    // =============================
    private static void addStudent() {

        System.out.println("\n--- Add Student ---");

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        if (!ValidationUtils.isValidStudentId(id)) {
            System.out.println("Invalid Student ID!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        if (!ValidationUtils.isValidName(name)) {
            System.out.println("Invalid Name!");
            return;
        }

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        if (!ValidationUtils.isValidAge(age)) {
            System.out.println("Invalid Age!");
            return;
        }

        System.out.print("Enter Grade (0-100): ");
        double grade = Double.parseDouble(scanner.nextLine());

        if (!ValidationUtils.isValidGrade(grade)) {
            System.out.println("Invalid Grade!");
            return;
        }

        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        if (!ValidationUtils.isValidContact(contact)) {
            System.out.println("Invalid Contact!");
            return;
        }

        Student student =
                new Student(id, name, age, grade, contact);

        if (manager.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student ID already exists!");
        }
    }

    // =============================
    // SEARCH STUDENT
    // =============================
    private static void searchStudent() {

        System.out.println("\n1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.print("Choose option: ");

        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {

            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();

            Student student = manager.searchById(id);

            if (student != null) {
                student.displayStudent();
            } else {
                System.out.println("Student not found!");
            }

        } else if (option == 2) {

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            ArrayList<Student> result =
                    manager.searchByName(name);

            if (result.isEmpty()) {
                System.out.println("No students found!");
            } else {
                for (Student s : result) {
                    s.displayStudent();
                }
            }
        }
    }

    // =============================
    // UPDATE STUDENT
    // =============================
    private static void updateStudent() {

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = manager.searchById(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter New Grade: ");
        double grade = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter New Contact: ");
        String contact = scanner.nextLine();

        boolean updated =
                manager.updateStudent(
                        id,
                        name,
                        age,
                        grade,
                        contact
                );

        if (updated) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Update failed!");
        }
    }

    // =============================
    // DELETE STUDENT
    // =============================
    private static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        if (manager.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    
}
