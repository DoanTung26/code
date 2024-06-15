/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class StudentManager {
      private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize the students array with some predefined data
        initializeStudents();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Find Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort Students by Score");
            System.out.println("7. Compare Students' Scores");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> editStudent();
                case 3 -> deleteStudent();
                case 4 -> findStudent();
                case 5 -> displayAllStudents();
                case 6 -> sortStudentsByScore();
                case 7 -> compareStudentsScores();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void initializeStudents() {
        students.add(new Student("Doan Tung", "tungddbh01121@fpt.com", 100.00));
        students.add(new Student("Tung", "tung123@gmail.com", 78.0));
        students.add(new Student("Quinn", "quinn@gmail.com", 92.0));
    }

    private static void addStudent() {
        System.out.println("Current list of students:");
        displayAllStudents();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter score: ");
        double score = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        students.add(new Student(name, email, score));
        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter email of the student to edit: ");
        String email = scanner.nextLine();

        for (Student student : students) {
            if (student.email.equals(email)) {
                System.out.print("Enter new name: ");
                student.name = scanner.nextLine();
                System.out.print("Enter new score: ");
                student.score = scanner.nextDouble();
                scanner.nextLine();  // Consume newline
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter email of the student to delete: ");
        String email = scanner.nextLine();

        for (Student student : students) {
            if (student.email.equals(email)) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void findStudent() {
        System.out.print("Enter email of the student to find: ");
        String email = scanner.nextLine();

        for (Student student : students) {
            if (student.email.equals(email)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void sortStudentsByScore() {
        Collections.sort(students, (Student s1, Student s2) -> Double.compare(s1.score, s2.score));
        System.out.println("Students sorted by score.");
        displayAllStudents();
    }

    private static void compareStudentsScores() {
        System.out.print("Enter the name of the first student: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter the name of the second student: ");
        String name2 = scanner.nextLine();

        Student student1 = null;
        Student student2 = null;

        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name1)) {
                student1 = student;
            }
            if (student.name.equalsIgnoreCase(name2)) {
                student2 = student;
            }
        }

        if (student1 == null || student2 == null) {
            System.out.println("One or both students not found.");
        } else {
            if (student1.score > student2.score) {
                System.out.println(student1.name + " has a higher score than " + student2.name + ".");
                System.out.println(student1.name + "'s score: " + student1.score);
                System.out.println(student2.name + "'s score: " + student2.score);
            } else if (student1.score < student2.score) {
                System.out.println(student2.name + " has a higher score than " + student1.name + ".");
                System.out.println(student2.name + "'s score: " + student2.score);
                System.out.println(student1.name + "'s score: " + student1.score);
            } else {
                System.out.println(student1.name + " and " + student2.name + " have the same score.");
                System.out.println(student1.name + "'s score: " + student1.score);
                System.out.println(student2.name + "'s score: " + student2.score);
            }
        }
    }
    
}
