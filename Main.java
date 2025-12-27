
package University.Management.System;

import java.util.Scanner;

public class Main {
   
    
    private static final UniversityService service = new UniversityService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    addProfessor();
                    break;
                case "3":
                    addCourse();
                    break;
                case "4":
                    enrollStudent();
                    break;
                case "5":
                    service.listStudents();
                    break;
                case "6":
                    service.generateReport();
                    break;
                case "0":
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== University Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. Add Professor");
        System.out.println("3. Add Course");
        System.out.println("4. Enroll Student to Course");
        System.out.println("5. List All Students");
        System.out.println("6. Generate Report");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

   private static void addStudent() {
    System.out.print("Enter student ID: ");
    String id = scanner.nextLine();
    System.out.print("Enter student name: ");
    String name = scanner.nextLine();
    System.out.print("Enter student email: ");
    String email = scanner.nextLine();

    Student student = new Student(id, name, email);
    service.addStudent(student);
    System.out.println("Student added with ID: " + student.getId());
}


    private static void addProfessor() {
    System.out.print("Enter professor ID: ");
    String id = scanner.nextLine();
    System.out.print("Enter professor name: ");
    String name = scanner.nextLine();
    System.out.print("Enter professor email: ");
    String email = scanner.nextLine();
    System.out.print("Enter department: ");
    String department = scanner.nextLine();

    Professor professor = new Professor(id, name, email, department);
    service.addProfessor(professor);
    System.out.println("Professor added with ID: " + professor.getId());
}


   private static void addCourse() {
    System.out.print("Enter course ID: ");
    String courseId = scanner.nextLine();
    System.out.print("Enter course name: ");
    String courseName = scanner.nextLine();
    System.out.print("Enter professor ID: ");
    String profId = scanner.nextLine();

    Course course = new Course(courseId, courseName, profId);
    service.addCourse(course);
    System.out.println("Course added with ID: " + course.getCourseId());
}


    private static void enrollStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        try {
            service.enrollStudent(studentId, courseId);
            System.out.println("Student enrolled successfully.");
        } catch (EntityNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
