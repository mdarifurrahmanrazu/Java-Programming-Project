
package University.Management.System;

import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<String> enrolledCourses;

    public Student(String id, String name, String email) {
        super(id, name, email);
        this.enrolledCourses = new ArrayList<>();
    }

    public void enroll(String courseId) {
        enrolledCourses.add(courseId);
    }

    @Override
    public void displayInfo() {
    System.out.println("Student ID: " + id);
    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
    System.out.println(); // Add an empty line for spacing between students
}


    public ArrayList<String> getEnrolledCourses() {
    return enrolledCourses;
    }
    public String getName() {
    return name;
    }

    public String getId() {
    return id;
    }
    
}
