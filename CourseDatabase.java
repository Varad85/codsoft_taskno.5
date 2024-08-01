import java.util.ArrayList;
import java.util.List;

// Class to manage the course database
public class CourseDatabase {
    private List<Course> courses;

    // Constructor to initialize the course database
    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }

    // Method to add a course to the database
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Method to get a list of all courses
    public List<Course> getCourses() {
        return courses;
    }
}