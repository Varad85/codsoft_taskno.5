import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();
        Scanner scanner = new Scanner(System.in);

        // Adding sample courses to the course database
        courseDatabase.addCourse(new Course("CS101", "Introduction to Computer Science", "Basic concepts of computer science", 10, "Mon 9-11AM"));
        courseDatabase.addCourse(new Course("CS102", "Data Structures", "Introduction to data structures", 10, "Wed 9-11AM"));
        courseDatabase.addCourse(new Course("CS103", "Algorithms", "Introduction to algorithms", 10, "Fri 9-11AM"));
        courseDatabase.addCourse(new Course("CS104", "Operating Systems", "Introduction to operating systems", 10, "Mon 1-3PM"));
        courseDatabase.addCourse(new Course("CS105", "Database Systems", "Introduction to database systems", 10, "Wed 1-3PM"));
    }
}