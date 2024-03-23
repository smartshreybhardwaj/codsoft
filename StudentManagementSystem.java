 import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;
    private String department;

    public Student(String id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public void display() {
        System.out.println("ID: " + id + "\tName: " + name + "\tAge: " + age + "\tDepartment: " + department);
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.next();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student department: ");
        String department = scanner.next();

        Student student = new Student(id, name, age, department);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of Students:");
            for (Student student : students) {
                student.display();
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String id = scanner.next();
        boolean found = false;

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.print("Enter updated name: ");
                String name = scanner.next();
                System.out.print("Enter updated age: ");
                int age = scanner.nextInt();
                System.out.print("Enter updated department: ");
                String department = scanner.next();

                student = new Student(id, name, age, department);
                found = true;
                System.out.println("Student details updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.next();
        boolean removed = false;

        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                removed = true;
                System.out.println("Student with ID " + id + " deleted successfully.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}

