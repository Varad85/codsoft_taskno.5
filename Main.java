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
    
        while (true) {
            System.out.println("Course Registration System:");
            System.out.println("1. List Courses");
            System.out.println("2. Register for Course(for enrolled users)");
            System.out.println("3. Drop Course");
            System.out.println("4. New User Enrollment");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // List all courses
                    System.out.println("Available Courses:");
                    for (Course course : courseDatabase.getCourses()) {
                        System.out.println(course.getCourseCode() + ": " + course.getTitle() + " (" + course.getRegisteredStudents().size() + "/" + course.getCapacity() + " slots filled)");
                    }
                    break;

                    case 2:
                    // Register for a course
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.nextLine();
                    Student student = studentDatabase.findStudentByID(studentID);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    Course course = courseDatabase.findCourseByCode(courseCode);
                    if (course == null) {
                        System.out.println("Course not found.");
                        break;
                    }

                    if (student.getRegisteredCourses().contains(course)) {
                        System.out.println("You are already registered for this course.");
                    } else if (student.registerForCourse(course)) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Registration failed. Course may be full or you have reached the limit of 2 subjects.");
                    }
                    break;
                }
        }
    }
}