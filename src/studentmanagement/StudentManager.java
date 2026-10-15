import java.io.*;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;
    private final String FILE_NAME = "students.txt";

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
        loadFromFile();
    }

    // ADD
    public void addStudent(Student student) {

        // Check duplicate ID
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        saveToFile();

        System.out.println("Student added successfully!");
    }

    // VIEW
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n----- Student Records -----");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // SEARCH
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // UPDATE
    public void updateStudent(int id, String name, int age, String course) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(name);
                student.setAge(age);
                student.setCourse(course);

                saveToFile();

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // DELETE
    public void deleteStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                students.remove(student);
                saveToFile();

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // SAVE DATA TO FILE
    private void saveToFile() {

        try {

            FileWriter writer = new FileWriter(FILE_NAME);

            for (Student student : students) {

                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getCourse() +
                                "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving data.");
        }
    }

    // LOAD DATA FROM FILE
    private void loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                Student student =
                        new Student(id, name, age, course);

                students.add(student);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error loading data.");

        } catch (NumberFormatException e) {

            System.out.println("Invalid data in file.");
        }
    }
}