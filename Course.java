
package University.Management.System;

public class Course {

    private String courseId;
    private String name;
    private String professorId;

    public Course(String courseId, String name, String professorId) {
        this.courseId = courseId;
        this.name = name;
        this.professorId = professorId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getProfessorId() {
        return professorId;
    }

    public String getName() {
        return name;
    }
    public void addCourse(Course course) {
    course.put(course.getCourseId(), course);  
}

    private void put(String courseId, Course course) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}





