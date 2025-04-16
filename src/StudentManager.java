import java.util.*;

public class StudentManager {

    // Add student
    public void addStudent(Map<Integer, String> students, int studentId, String name) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Student ID must be positive!");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty!");
        }
        students.put(studentId, name);
    }

    // Sort students by ID
    public void sortStudents(Map<Integer, String> students) {
        if (students.isEmpty()) {
            System.out.println(" No students to display.");
        } else {
            Map<Integer, String> sortedStudents = new TreeMap<>(students);
            System.out.println(" Sorted Students by ID:");
            sortedStudents.forEach((id, name) -> System.out.println("ID = " + id + ", Name = " + name));
        }
    }

    // Search for a student by ID
    public void searchStudent(Map<Integer, String> students, int studentId) {
        if (students.containsKey(studentId)) {
            System.out.println(" Student found: ID = " + studentId + ", Name = " + students.get(studentId));
        } else {
            System.out.println(" Student with ID " + studentId + " not found.");
        }
    }

    // Remove student by ID
    public void removeStudent(Map<Integer, String> students, int studentId) {
        if (students.containsKey(studentId)) {
            students.remove(studentId);
            System.out.println(" Student with ID " + studentId + " has been removed.");
        } else {
            System.out.println(" Student with ID " + studentId + " not found.");
        }
    }

    // Find student with highest ID
    public void findStudentWithHighestId(Map<Integer, String> students) {
        if (students.isEmpty()) {
            System.out.println(" No students available.");
        } else {
            int highestId = Collections.max(students.keySet());
            System.out.println(" Student with highest ID: ID = " + highestId + ", Name = " + students.get(highestId));
        }
    }

    // Find student with lowest ID
    public void findStudentWithLowestId(Map<Integer, String> students) {
        if (students.isEmpty()) {
            System.out.println(" No students available.");
        } else {
            int lowestId = Collections.min(students.keySet());
            System.out.println(" Student with lowest ID: ID = " + lowestId + ", Name = " + students.get(lowestId));
        }
    }
}



