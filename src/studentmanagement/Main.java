package studentmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice;

            // Check whether user entered a number
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                // =========================
                // ADD STUDENT
                // =========================
                case 1:

                    System.out.println("\n--- Add Student ---");

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course Name: ");
                    String course = scanner.nextLine();

                    Student newStudent =
                            new Student(id, name, age, course);

                    manager.addStudent(newStudent);

                    break;


                // =========================
                // VIEW STUDENTS
                // =========================
                case 2:

                    manager.viewStudents();

                    break;


                // =========================
                // SEARCH STUDENT
                // =========================
                case 3:

                    System.out.println("\n--- Search Student ---");

                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    Student foundStudent =
                            manager.searchStudent(searchId);

                    if (foundStudent != null) {

                        System.out.println("\nStudent Found:");
                        System.out.println(foundStudent);

                    } else {

                        System.out.println("Student not found!");
                    }

                    break;


                // =========================
                // UPDATE STUDENT
                // =========================
                case 4:

                    System.out.println("\n--- Update Student ---");

                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    Student existingStudent =
                            manager.searchStudent(updateId);

                    if (existingStudent == null) {

                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    manager.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse
                    );

                    break;


                // =========================
                // DELETE STUDENT
                // =========================
                case 5:

                    System.out.println("\n--- Delete Student ---");

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    manager.deleteStudent(deleteId);

                    break;


                // =========================
                // EXIT
                // =========================
                case 6:

                    System.out.println("\nThank you!");
                    System.out.println("Student Management System closed.");

                    scanner.close();

                    return;


                // =========================
                // INVALID OPTION
                // =========================
                default:

                    System.out.println(
                            "Invalid choice! Please select 1 to 6."
                    );
            }
        }
    }
}