/*
 Project: Student Information System
 Author: Tejasri Konidena
 Language: Java
 Description: Console-based student management application
*/


import java.io.*;
import java.util.ArrayList;


public class FileHandler {

	
	private static final String FILE_NAME = "students.txt";

    // Save Students to File
    public static void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }

            System.out.println("Students saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Load Students from File
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 5) {

                    String studentId = data[0];
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    double grade = Double.parseDouble(data[3]);
                    String contact = data[4];

                    students.add(
                            new Student(
                                    studentId,
                                    name,
                                    age,
                                    grade,
                                    contact
                            )
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }

        return students;
    }
}
