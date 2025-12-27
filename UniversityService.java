
package University.Management.System;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UniversityService {
    
  
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Professor> professors = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.id, student);
    }

    public void addProfessor(Professor professor) {
        professors.put(professor.id, professor);
    }

    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

   public void enrollStudent(String studentId, String courseId) throws EntityNotFoundException {
    Student student = students.get(studentId);
    Course course = courses.get(courseId);

    if (student == null) {
        throw new EntityNotFoundException("Student with ID " + studentId + " not found.");
    }
    if (course == null) {
        throw new EntityNotFoundException("Course with ID " + courseId + " not found.");
    }

    student.enroll(courseId);
}


    public void listStudents() {
        students.values().forEach(Student::displayInfo);
    }

  public void generateReport() {
    students.values().forEach(new Consumer<Student>() {
        @Override
        public void accept(Student s) {
            System.out.println("Student: " + s.getName());
            for (String courseId : s.getEnrolledCourses()) {
                Course course = courses.get(courseId);
                if (course != null) {
                    Professor prof = professors.get(course.getProfessorId());
                    String profName = (prof != null) ? prof.getName() : "Unknown";
                    System.out.println("  Course: " + course.getName() + " (ID: " + course.getCourseId() + "), Taught by: " + profName);
                } else {
                    System.out.println("  Course ID: " + courseId + " (Details not found)");
                }
            }
        }
    });
}
}
