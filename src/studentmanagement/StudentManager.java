package studentmanagement;

import java.util.ArrayList;

public class StudentManager {

    // ArrayList to store students
    private ArrayList<Student> students = new ArrayList<>();


    // 1. ADD STUDENT
    public void addStudent(Student student) {

        // Check duplicate ID
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }


    // 2. VIEW ALL STUDENTS
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student student : students) {
            System.out.println(student);
        }
    }


    // 3. SEARCH STUDENT
    public Student searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }


    // 4. UPDATE STUDENT
    public void updateStudent(int id, String name, int age, String course) {

        Student student = searchStudent(id);

        if (student != null) {

            student.setName(name);
            student.setAge(age);
            student.setCourse(course);

            System.out.println("Student updated successfully!");

        } else {

            System.out.println("Student not found!");
        }
    }


    // 5. DELETE STUDENT
    public void deleteStudent(int id) {

        Student student = searchStudent(id);

        if (student != null) {

            students.remove(student);

            System.out.println("Student deleted successfully!");

        } else {

            System.out.println("Student not found!");
        }
    }
}