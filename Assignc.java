import java.util.Scanner;

class UnitResult {
    String unitCode;
    String unitTitle;
    float a1Mark;
    float a2Mark;
    float examMark;
}

class CourseRecord {
    int studentID;
    String lastName;
    String firstName;
    String courseCode;
    String courseTitle;
    int unitsAttempted;
    float courseAverage;
    UnitResult[] units;
}

public class Assignc {
    private static final int CLASS_SIZE = 50;
    private static final int MAX_SUBJECT = 32;
    private static final int MAX_MARK = 32;

    private static CourseRecord[] studentCourse = new CourseRecord[CLASS_SIZE];
    private static int totalNumStudents = 5;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        populateSampleData();

        int choice;
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    performHEPAAssessment();
                    break;
                case 2:
                    searchStudentInformation();
                    break;
                case 3:
                    inputUpdateStudentInformation();
                    break;
                case 4:
                    inputUpdateUnitInformation();
                    break;
                case 5:
                    displayBestStudentInformation();
                    break;
                case 6:
                    saveStudentUnitInformation();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. HEPA assessment");
        System.out.println("2. Search student information");
        System.out.println("3. Input/update student information");
        System.out.println("4. Input/update unit information");
        System.out.println("5. Display information of best student");
        System.out.println("6. Save student/unit information");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void performHEPAAssessment() {
        System.out.println("\nPerforming HEPA assessment...");

        // Example: Calculate HEPA assessment for each student
        for (int i = 0; i < totalNumStudents; i++) {
            CourseRecord student = studentCourse[i];
            // Calculate HEPA assessment for the student and perform necessary actions
            // ...

            // Example: Print HEPA assessment result
            System.out.println("HEPA assessment result for student " + student.studentID);
            // ...
        }
    }

    private static void searchStudentInformation() {
        System.out.println("\n--- Search Student Information ---");
        System.out.println("1. Search by Student ID");
        System.out.println("2. Search by Name");
        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (searchChoice) {
            case 1:
                searchStudentByID();
                break;
            case 2:
                searchStudentByName();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private static void searchStudentByID() {
        System.out.print("Enter the student ID to search: ");
        int searchID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < totalNumStudents; i++) {
            CourseRecord student = studentCourse[i];
            if (student.studentID == searchID) {
                displayStudentInformation(student);
                return;
            }
        }
        System.out.println("Student with ID " + searchID + " not found.");
    }

    private static void searchStudentByName() {
        System.out.print("Enter the student name to search: ");
        String searchName = scanner.nextLine();

        for (int i = 0; i < totalNumStudents; i++) {
            CourseRecord student = studentCourse[i];
            if (student.lastName.equalsIgnoreCase(searchName) || student.firstName.equalsIgnoreCase(searchName)) {
                displayStudentInformation(student);
                return;
            }
        }
        System.out.println("Student with name \"" + searchName + "\" not found.");
    }

    private static void displayStudentInformation(CourseRecord student) {
        System.out.println("\n--- Student Information ---");
        System.out.println("Student ID: " + student.studentID);
        System.out.println("Name: " + student.firstName + " " + student.lastName);
        System.out.println("Course Code: " + student.courseCode);
        System.out.println("Course Title: " + student.courseTitle);
        System.out.println("Units Attempted: " + student.unitsAttempted);
        System.out.println("Course Average: " + student.courseAverage);
        System.out.println("--- Unit Results ---");
        for (int i = 0; i < student.unitsAttempted; i++) {
            UnitResult unit = student.units[i];
            System.out.println("Unit Code: " + unit.unitCode);
            System.out.println("Unit Title: " + unit.unitTitle);
            System.out.println("A1 Mark: " + unit.a1Mark);
            System.out.println("A2 Mark: " + unit.a2Mark);
            System.out.println("Exam Mark: " + unit.examMark);
        }
        System.out.println("---------------------");
    }

    private static void inputUpdateStudentInformation() {
        // TODO: Implement input/update student information functionality
        System.out.println("Input/update student information is under construction...");
    }

    private static void inputUpdateUnitInformation() {
        // TODO: Implement input/update unit information functionality
        System.out.println("Input/update unit information is under construction...");
    }

    private static void displayBestStudentInformation() {
        // TODO: Implement display best student information functionality
        System.out.println("Display best student information is under construction...");
    }

    private static void saveStudentUnitInformation() {
        // TODO: Implement save student/unit information functionality
        System.out.println("Save student/unit information is under construction...");
    }

    private static void populateSampleData() {
        studentCourse[0] = new CourseRecord();
        studentCourse[0].studentID = 1001;
        studentCourse[0].lastName = "Smith";
        studentCourse[0].firstName = "John";
        studentCourse[0].courseCode = "CSE101";
        studentCourse[0].courseTitle = "Introduction to Computer Science";
        studentCourse[0].unitsAttempted = 4;
        studentCourse[0].courseAverage = 75.6f;
        studentCourse[0].units = new UnitResult[MAX_SUBJECT];

        studentCourse[1] = new CourseRecord();
        studentCourse[1].studentID = 1002;
        studentCourse[1].lastName = "Johnson";
        studentCourse[1].firstName = "Emily";
        studentCourse[1].courseCode = "CSE101";
        studentCourse[1].courseTitle = "Introduction to Computer Science";
        studentCourse[1].unitsAttempted = 3;
        studentCourse[1].courseAverage = 81.2f;
        studentCourse[1].units = new UnitResult[MAX_SUBJECT];

        studentCourse[2] = new CourseRecord();
        studentCourse[2].studentID = 1003;
        studentCourse[2].lastName = "Williams";
        studentCourse[2].firstName = "Michael";
        studentCourse[2].courseCode = "MAT101";
        studentCourse[2].courseTitle = "Mathematics";
        studentCourse[2].unitsAttempted = 2;
        studentCourse[2].courseAverage = 88.9f;
        studentCourse[2].units = new UnitResult[MAX_SUBJECT];

        studentCourse[3] = new CourseRecord();
        studentCourse[3].studentID = 1004;
        studentCourse[3].lastName = "Brown";
        studentCourse[3].firstName = "Emma";
        studentCourse[3].courseCode = "MAT101";
        studentCourse[3].courseTitle = "Mathematics";
        studentCourse[3].unitsAttempted = 3;
        studentCourse[3].courseAverage = 79.5f;
        studentCourse[3].units = new UnitResult[MAX_SUBJECT];

        studentCourse[4] = new CourseRecord();
        studentCourse[4].studentID = 1005;
        studentCourse[4].lastName = "Jones";
        studentCourse[4].firstName = "William";
        studentCourse[4].courseCode = "PHY101";
        studentCourse[4].courseTitle = "Physics";
        studentCourse[4].unitsAttempted = 2;
        studentCourse[4].courseAverage = 92.3f;
        studentCourse[4].units = new UnitResult[MAX_SUBJECT];

        totalNumStudents = 5;
    }
}
