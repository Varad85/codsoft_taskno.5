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
}