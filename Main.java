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

                    case 3:
                    // Drop a course
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextLine();
                    student = studentDatabase.findStudentByID(studentID);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter course code: ");
                    courseCode = scanner.nextLine();
                    course = courseDatabase.findCourseByCode(courseCode);
                    if (course == null) {
                        System.out.println("Course not found.");
                        break;
                    }

                    if (student.dropCourse(course)) {
                        System.out.println("Course dropped successfully.");
                    } else {
                        System.out.println("Failed to drop course. You might not be registered for this course.");
                    }
                    break;

                    case 4:
                    // New user registration
                    System.out.print("Enter new student ID: ");
                    String newStudentID = scanner.nextLine();
                    if (!Student.isValidStudentID(newStudentID)) {
                        System.out.println("Invalid student ID. It should start with 's' followed by exactly 3 digits.");
                        break;
                    }

                    System.out.print("Enter new student name: ");
                    String newStudentName = scanner.nextLine();
                    if (!Student.isValidName(newStudentName)) {
                        System.out.println("Invalid name. It should contain only alphabets and spaces, and at least 3 alphabets.");
                        break;
                    }

                    if (studentDatabase.isStudentRegistered(newStudentID, newStudentName)) {
                        System.out.println("You are already enrolled with us.");
                    } else {
                        Student newStudent = new Student(newStudentID, newStudentName);
                        studentDatabase.addStudent(newStudent);

                        System.out.print("Enrollment successful. Now enter course code to register: ");
                        String newCourseCode = scanner.nextLine();
                        Course newCourse = courseDatabase.findCourseByCode(newCourseCode);

                        if (newCourse == null) {
                            System.out.println("Course not found.");
                        } else if (newStudent.registerForCourse(newCourse)) {
                            System.out.println("Registration successful.");
                        } else {
                            System.out.println("Registration failed. Course may be full or you have reached the limit of 2 subjects.");
                        }
                    }
                    break;

                }
        }
    }
}