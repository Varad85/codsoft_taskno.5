import java.util.ArrayList;
import java.util.List;

// Class to represent a course
public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> registeredStudents;

    // Constructor to initialize the course
    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    // Getter methods for course details
    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    // Method to check if there is an available slot for the course
    public boolean hasAvailableSlot() {
        return registeredStudents.size() < capacity;
    }

    // Method to register a student for the course
    public boolean registerStudent(Student student) {
        if (hasAvailableSlot()) {
            registeredStudents.add(student);
            return true;
        }
        return false;
    }
}