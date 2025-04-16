import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> students = new HashMap<>();
        StudentManager manager = new StudentManager();

        System.out.println(" WELCOME TO THE STUDENT MANAGER SYSTEM ");

        // Step 1: Adding students (First record)
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.println("\nPlease enter the student ID:");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Please enter the student name:");
            String studentName = scanner.nextLine();

            try {
                manager.addStudent(students, studentId, studentName);
                System.out.println(" Student added successfully: ID = " + studentId + ", Name = " + studentName);
            } catch (IllegalArgumentException e) {
                System.out.println(" Error: " + e.getMessage());
            }

            // Ask if the user wants to add more students
            System.out.println("Would you like to add another student? (yes/no)");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                continueAdding = false;
            }
        }

        // Step 2: Show the operation menu
        while (true) {
            System.out.println("""
             What would you like to do?
            \n1.  Add another student
            2.  Search for a student by ID
            3.  Remove a student by ID
            4.  Show all students (sorted by ID)
            5.  Show student with the highest ID
            6.  Show student with the lowest ID
            7.  Exit the program
            """);

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add another student
                    System.out.println("Please enter the student ID:");
                    int newStudentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the student name:");
                    String newStudentName = scanner.nextLine();
                    try {
                        manager.addStudent(students, newStudentId, newStudentName);
                        System.out.println(" Student added successfully: ID = " + newStudentId + ", Name = " + newStudentName);
                    } catch (IllegalArgumentException e) {
                        System.out.println(" Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Search student
                    System.out.println("Current students: " + students);
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchStudent(students, searchId);
                    break;

                case 3:
                    // Remove student
                    if (students.isEmpty()) {
                        System.out.println(" No students to remove.");
                    } else {
                        System.out.println("Current students: " + students);
                        System.out.print("Enter student ID to remove: ");
                        int removeId = scanner.nextInt();
                        manager.removeStudent(students, removeId);
                    }
                    break;

                case 4:
                    // Sort and show students
                    manager.sortStudents(students);
                    break;

                case 5:
                    // Show highest ID
                    manager.findStudentWithHighestId(students);
                    break;

                case 6:
                    // Show lowest ID
                    manager.findStudentWithLowestId(students);
                    break;

                case 7:
                    // Exit the program
                    System.out.println(" Exiting the system. Goodbye!");
                    return;

                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}
