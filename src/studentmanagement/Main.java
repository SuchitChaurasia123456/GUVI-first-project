import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" Student Management System");
            System.out.println("==============================");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    Student student =
                            new Student(id, name, age, course);

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();

                    manager.searchStudent(searchId);

                    break;

                case 4:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = scanner.nextLine();

                    manager.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse
                    );

                    break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();

                    manager.deleteStudent(deleteId);

                    break;

                case 6:

                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}