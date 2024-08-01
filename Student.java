//import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    // Constructor to initialize the student
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
    // Getter methods for student details
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerForCourse(Course course) {
        if (registeredCourses.size() >= 2) {
            System.out.println("Sorry, you have reached the limit. You can select a maximum of 2 subjects.");
            return false;
        }
    }
}