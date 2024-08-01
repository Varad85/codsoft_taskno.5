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

        if (course.registerStudent(this)) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    // Method to drop a course the student has registered for
    public boolean dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.removeStudent(this);
            return true;
        }
        return false;
    }

    // Validates student ID
    public static boolean isValidStudentID(String studentID) {
        return studentID.matches("s\\d{3}");
    }

    // Validates student name
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]{3,}") && name.replaceAll("[^a-zA-Z]", "").length() >= 3;
    }

    // Checks if another student has the same ID or name
    public boolean hasSameDetails(String studentID, String name) {
        return this.studentID.equals(studentID) || this.name.equalsIgnoreCase(name);
    }
}