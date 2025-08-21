package org.example;
import dao.StudentDAO;
import inputHelper.StudentReader;

import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(flag) {
            System.out.println("Welcome to the Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. View all students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            try {
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                sc.nextLine(); // Clear the invalid input
            }

            if (choice == 1) {
                // add student
                String name = StudentReader.readStudentName();
                String gender = StudentReader.readStudentGender();
                int age = StudentReader.readStudentAge();
                dao.StudentDAO studentDAO = new dao.StudentDAO();
                boolean result = studentDAO.addStudent(name, age, gender);
                if (result) {
                    System.out.println("Student added successfully.");
                } else {
                    System.out.println("Failed to add student.");
                }
            }
            else if (choice == 2) {
                // view student by name
                dao.StudentDAO studentDAO = new StudentDAO();
                String name = StudentReader.readStudentName();
                List<dto.Student> studentList = studentDAO.retrieveStudentByName(name);
                if (studentList.isEmpty()) {
                    System.out.println("No students found with the name: " + name);
                } else {
                    System.out.println("Students found:");
                    for (dto.Student student : studentList) {
                        System.out.printf("Name: %s, Age: %d, Gender: %s%n",
                                          student.getName(),
                                          student.getAge(),
                                          student.getGender());
                }
            }

        }
            else if (choice == 3) {
                dao.StudentDAO studentDAO = new StudentDAO();
                List<dto.Student> studentList = studentDAO.retrieveStudent();
                for (dto.Student student : studentList) {
                    System.out.printf("Name: %s, Age: %d, Gender: %s%n",
                            student.getName(),
                            student.getAge(),
                            student.getGender());
                }
            }
            else if (choice == 4) {
                // update student age
                dao.StudentDAO studentDAO = new StudentDAO();
                int age = StudentReader.readStudentAge();
                String name = StudentReader.readStudentName();
                String gender = StudentReader.readStudentGender();
                studentDAO.updateStudentAge(name, age, gender);
            }
            else if (choice == 5) {
                // delete student
                dao.StudentDAO studentDAO = new StudentDAO();
                String name = StudentReader.readStudentName();
                String gender = StudentReader.readStudentGender();
                studentDAO.deleteStudent(name, gender);
            }
            else if (choice == 6) {
                System.out.println("Exiting the system. Goodbye!");
                flag = false;
                break;
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}